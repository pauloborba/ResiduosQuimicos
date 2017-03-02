//import cucumber.api.PendingException
/*import pages.CreateUserPage
import pages.IndexUsuarioPage
import pages.OverviewUsuarioPage
import pages.ShowUserPage*/
import residuosquimicos.Laboratorio
import residuosquimicos.LaboratorioController
import residuosquimicos.Usuario
import residuosquimicos.UsuarioController
import residuosquimicos.TiposDeUsuario
import pages.CreateLaboratorioPage
//import pages.IndexLaboratorioPage
import pages.ShowLaboratorioPage
//import pages.ResumoSistemaPage
/**
 * Created by brgccf on 11/5/2016.
 */
//import cucumber.api.groovy.EN.*
this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

//CONTROLLER SCENARIOS
Given(~/^"([^"]*)" não possui associação a nenhum laboratório cadastrado$/) { String fac ->
    UsuarioController controlador = new UsuarioController()
    criarUsuarioFacilitador(fac, controlador)
    Usuario facilitador = Usuario.findByNome(fac)
    assert facilitador.isFacilitador()
    assert !(facilitador.getAssociado())
}

And(~/^os laboratórios "([^"]*)" e "([^"]*)" do centro "([^"]*)" e dept "([^"]*)" estão disponíveis para associação$/) {
    String labA, String labB, String centro, String depta ->
        criarLaboratorio(labA, depta, centro)
        criarLaboratorio(labB, depta, centro)
        Laboratorio A = Laboratorio.findByNomeLaboratorio(labA)
        Laboratorio B = Laboratorio.findByNomeLaboratorio(labB)
        assert !(A.estaSolicitado())
        assert !(B.estaSolicitado())
}

When(~/^Eu solicito a associação de "([^"]*)" ao Laboratório "([^"]*)"$/) { String fac, String labA ->
    def controlador = new UsuarioController()
    Usuario facilitador = Usuario.findByNome(fac)
    assert facilitador.isFacilitador()
    Laboratorio A = Laboratorio.findByNomeLaboratorio(labA)
    controlador.solicitarAssociacao(A, facilitador)
}
Then(~/^o laboratório "([^"]*)" não pode receber mais solicitações$/) { String lab ->
    Laboratorio A = Laboratorio.findByNomeLaboratorio(lab)
    assert !tentarSolicitacaoLab(A)
}

//testar parametros

def tentarSolicitacaoLab(Laboratorio lab)
{
    def controlador = new UsuarioController()
    Usuario aleatorio = new Usuario([nome: "aleatorio", senha: "senhaale", tipo: TiposDeUsuario.FAC,
                                     associado: false, ramal: "1111", email: "aleatorio@ufpe.br"])
    return controlador.solicitarAssociacao(lab, aleatorio)
}

def criarUsuarioFacilitador(String nome, UsuarioController controlador)
{
    Usuario userFac = new Usuario([nome :nome, senha:"senhafac", tipo: TiposDeUsuario.FAC, associado: false, ramal: "1234",
                                   email: "email@ufpe.br"])
    controlador.save(userFac)
    controlador.response.reset()

}

def criarUsuarioAdministrador(String nome, UsuarioController controlador)
{
    Usuario userAdm = new Usuario([nome :nome, senha: "senhaadm", tipo: TiposDeUsuario.ADMIN, associado: false, ramal: "4321",
                                   email: "emailadmin@ufpe.br"])
    controlador.save(userAdm)
    controlador.response.reset()
}

def criarLaboratorio(String nomeLab, String nomeDep, String nomeCentro){
    def lab = new Laboratorio([nomeCentro:nomeCentro, nomeDepartamento:nomeDep, nomeLaboratorio:nomeLab, solicitante: null,
                               responsavel:null])
    def controlador = new LaboratorioController()
    controlador.save(lab)
    controlador.response.reset()
}



Given(~/^"([^"]*)" é um usuário do tipo administrador do sistema$/) { String user ->
    UsuarioController controlador = new UsuarioController()
    criarUsuarioAdministrador(user, controlador)
    Usuario adm = Usuario.findByNome(user)
    assert adm.isAdmin()

}
And(~/^Existe uma solicitação de acesso ao laboratório "([^"]*)" do centro "([^"]*)" e dept "([^"]*)" feita pelo usuário Facilitador "([^"]*)"$/)
        { String lea, String centro, String depta, String fac ->
            UsuarioController controlador = new UsuarioController()
            criarUsuarioFacilitador(fac, controlador)
            Usuario facilitador = Usuario.findByNome(fac)
            assert facilitador.isFacilitador()
            criarLaboratorio(lea, depta, centro)
            Laboratorio labSolicitado = Laboratorio.findByNomeLaboratorio(lea)
            controlador.solicitarAssociacao(labSolicitado, facilitador)
            assert labSolicitado.estaSolicitado()
            assert labSolicitado.equalsSolicitante(facilitador)
        }

When(~/^"([^"]*)" realiza a operação de concessão de acesso ao laboratório "([^"]*)" para "([^"]*)"$/)
        { String adm, String lab, String fac ->
            def controlador = new LaboratorioController()
            Laboratorio labConcedido = Laboratorio.findByNomeLaboratorio(lab)
            Usuario admin = Usuario.findByNome(adm)
            assert admin.isAdmin()
            Usuario facilitador = Usuario.findByNome(fac)
            assert facilitador.isFacilitador()
            controlador.setFacilitador(admin, labConcedido, facilitador)

        }
Then(~/^"([^"]*)" passa a ficar associado ao laboratório "([^"]*)"$/)
        { String fac, String lab ->
            Laboratorio labAssociado = Laboratorio.findByNomeLaboratorio(lab)
            Usuario facilitador = Usuario.findByNome(fac)
            assert labAssociado.equalsResponsavel(facilitador)
        }

And(~/^"([^"]*)" não pode mais solicitar acesso a laboratórios$/) { String fac ->
    Usuario facilitador = Usuario.findByNome(fac)
    assert !tentarSolicitarAcesso(facilitador)
}

def tentarSolicitarAcesso(Usuario fac)
{
    def centro = "Centro de Tecnologia e Geociências"
    def dept = "Departamento de Geologia"
    def lab = "teste"
    def controlador = new UsuarioController()
    Laboratorio aleatorio = new Laboratorio([nomeCentro:centro, nomeDepartamento:dept,
                                             nomeLaboratorio:lab, solicitante: null,
                                             responsavel:null])
    return controlador.solicitarAssociacao(aleatorio, fac)
}

//GUI SCENARIOS
//testar parametros

def createLaboratorioAndCheck(String nomeLab, String nomeDep, String nomeCentro){
    to CreateLaboratorioPage
    at CreateLaboratorioPage
    page.createLab(nomeLab, nomeDep, nomeCentro)
    at ShowLaboratorioPage
}
def createLaboratorioAssociado(String nomeLab, String nomeDep, String nomeCentro, String nomeUsuario)
{
    to CreateLaboratorioPage
    at CreateLaboratorioPage
    page.createLabAssociado(nomeLab, nomeDep, nomeCentro, nomeUsuario)
}
def createUsuario(String nome, TiposDeUsuario tipo)
{
    to CreateUserPage
    at CreateUserPage
    page.criarUsuario(nome, tipo)
}

Given(~/^eu criei o usuário do tipo administrador "([^"]*)"$/) { String adm ->
    createUsuario(adm, TiposDeUsuario.ADMIN)
}

When(~/^eu tento criar o laboratório "([^"]*)" do centro "([^"]*)" e dept "([^"]*)" associado a "([^"]*)"$/) {
    String lab, String centro, String dept, String adm ->
    createLaboratorioAssociado(lab, dept, centro, adm)
}
Then(~/^eu posso ver uma mensagem de erro indicando que "([^"]*)" é um administrador$/) { String adm ->
    assert page.existeMensagemDeErroUsuarioAdministrador(adm)
}

Given(~/^eu criei o usuário do tipo facilitador "([^"]*)"$/) { String fac ->
    createUsuario(fac, TiposDeUsuario.FAC)
}
And(~/^eu criei o laboratório "([^"]*)" do centro "([^"]*)" e dept "([^"]*)" sem associações$/) {
    String lab, String centro, String dept ->
        createLaboratorioAndCheck(lab, dept, centro)
}

When(~/^eu tento associar "([^"]*)" ao laboratório "([^"]*)"$/) { String fac, String lab ->
    to IndexUsuarioPage
    at IndexUsuarioPage
    page.procuraNomeUsuario(fac)
    at ShowUserPage
    page.solicitarButtonClick()
    at OverviewUsuarioPage
    page.selecionaLab(lab)
}

Then(~/^eu posso ver uma mensagem de confirmação indicando a solicitação de "([^"]*)"$/) {
    String fac ->
    at OverviewUsuarioPage
        assert page.existeMensagemDeConfirmacao(fac)
}
