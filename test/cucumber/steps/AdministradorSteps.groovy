package cucumber.steps

import cucumber.api.PendingException
import pages.CreateLaboratorioPage
import pages.CreateResiduoPage
import pages.EstatisticasPage
import pages.IndexLaboratorioPage
import pages.ResumoSistemaPage
import pages.ShowLaboratorioPage
import pages.ShowResiduoPage
import residuosquimicos.Laboratorio
import residuosquimicos.LaboratorioController
import residuosquimicos.Residuo
import residuosquimicos.ResiduoController
import residuosquimicos.StatusController

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

Given(~/^o sistema não possui nenhum laboratório cadastrado$/) { ->
    to IndexLaboratorioPage
    at IndexLaboratorioPage
    assert page.naoPossuiLaboratorio()
}
When(~/^eu vou para a página de resumo do sistema$/) { ->
    to ResumoSistemaPage
    at ResumoSistemaPage
}
Then(~/^eu devo visualizar uma mensagem de erro informando que o sistema não possui laboratórios$/) { ->
   assert page.hasErrorMessageLaboratorioNaoCadastrado()
}

Given(~/^eu criei o laboratório "([^"]*)" no departamento "([^"]*)" e centro "([^"]*)"$/) { String nomeLab, String nomeDep, String nomeCentro ->
    to CreateLaboratorioPage
    at CreateLaboratorioPage
    page.createLab(nomeLab, nomeDep, nomeCentro)
    at ShowLaboratorioPage
}

And(~/^eu criei o resíduo "([^"]*)" com peso "([^"]*)" associado ao laboratório "([^"]*)"$/) { String nomeResiduo, String pesoResiduo, String nomeLaboratorio ->
    to CreateResiduoPage
    at CreateResiduoPage
    page.createResiduo(nomeResiduo, pesoResiduo, nomeLaboratorio)
    at ShowResiduoPage
}
Then(~/^eu devo visualizar uma mensagem informando que é necessário fazer uma licitação$/) { ->
   at ResumoSistemaPage
    assert page.hasMessageLicitacaoNecessaria()
}

Then(~/^eu devo visualizar o resíduo "([^"]*)" com peso "([^"]*)" associado ao laboratório "([^"]*)"$/) { String nomeResiduo, String peso, String nomeLaboratorio ->
    at ResumoSistemaPage
    assert page.hasLinhaNaTabela(nomeResiduo, peso, nomeLaboratorio)
}

When(~/^eu vou para a página de estatísticas$/) { ->
    to EstatisticasPage
    at EstatisticasPage
}
Then(~/^eu devo visualizar que o laboratório "([^"]*)" é o maior gerador de resíduos$/) { String nomeLab ->
    at EstatisticasPage
    assert page.eOmaiorGerador(nomeLab)
}


//Controller Scenario Steps
Given(~/^o sistema possui o laboratório "([^"]*)" com departamento "([^"]*)" e centro "([^"]*)" sem resíduos associados cadastrado$/) { String nomeLab, String nomeDep, String nomeCentro ->
    criarLaboratorio(nomeLab, nomeDep, nomeCentro)
    assert Laboratorio.findByNomeLaboratorio(nomeLab) != null
}


def criarLaboratorio(String nomeLab, String nomeDep, String nomeCentro){
    def lab = new Laboratorio([nomeCentro:nomeCentro, nomeDepartamento:nomeDep, nomeLaboratorio:nomeLab, solicitante: null, responsavel:null, solicitado:false])

    def controlador = new LaboratorioController()
    controlador.save(lab)
    controlador.response.reset()
}

And(~/^o sistema possui o resíduo "([^"]*)" com peso "([^"]*)" associado ao laboratório "([^"]*)"$/) { String nomeResiduo, double peso, String nomeLab ->
    criarResiduo(nomeResiduo, peso, nomeLab)
    assert !Laboratorio.findByNomeLaboratorio(nomeLab).residuos.empty
}

def criarResiduo(String nomeResiduo, double peso, String nomeLab){
    def controlador = new ResiduoController()
    controlador.save(new Residuo([nome:nomeResiduo, composicao:"None", peso:peso, pessoaGerador:"None", dataCadastro:new Date(), laboratorio:Laboratorio.findByNomeLaboratorio(nomeLab)]))
    controlador.response.reset()
}

double percentagemlaboratorio = 0.0
When(~/^eu tento verificar o percentual de laboratorios com resíduos cadastrado$/) { ->
    def statusController = new StatusController()
    percentagemlaboratorio = statusController.percentagemLaboratoriosResiduos()
}
Then(~/^o percentual retornado pelo sistema será "([^"]*)" por cento$/) { double percentagem ->
    assert percentagemlaboratorio == percentagem
}