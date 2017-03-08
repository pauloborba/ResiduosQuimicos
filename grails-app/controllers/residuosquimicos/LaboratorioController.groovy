package residuosquimicos



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LaboratorioController {


    /**
     * método setFacilitador --> aprova uma solicitacao de acesso a laboratorio feita por um facilitador
     * @param adm
     * nome do administrador que aprovou
     * @param lab
     * laboratorio associado ao facilitador
     * @param fac
     * facilitador que teve solicitacao aprovada
     */
    def setFacilitador(Usuario adm, Laboratorio lab, Usuario fac)
    {
        //aprovar caso facilitador esteja desvinculado a laboratorios:
        if(!fac.associado)
        {
            lab.setResponsavel(fac)
            fac.setAssociado(true)
        }
        else return false
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Laboratorio.list(params), model:[laboratorioInstanceCount: Laboratorio.count()]
    }

    def show(Laboratorio laboratorioInstance) {
        respond laboratorioInstance
    }

    def create() {
        respond new Laboratorio(params)
    }

    @Transactional
    def save(Laboratorio laboratorioInstance) {
        if (laboratorioInstance == null) {
            notFound()
            return
        }

        if (laboratorioInstance.hasErrors()) {
            respond laboratorioInstance.errors, view:'create'
            return
        }

        //#if SolicitacaoDeAcesso
        //verificando validade de usuario
        if(laboratorioInstance.responsavel != null)
        {
            if (laboratorioInstance.tipoUsuarioResponsavel() == TiposDeUsuario.ADMIN ||
                    laboratorioInstance.tipoUsuarioSolicitante() == TiposDeUsuario.ADMIN)
            {
                flash.message = message(code: 'message.title.associacao.error', args: [laboratorioInstance.getNomeResponsavel()])
                /*
                flash.message = "ERRO: não é possível associar laboratório a usuários administradores. " +
                        "Tentativa com usuário administrador: " + laboratorioInstance.responsavel.nome
                        */
                redirect(action: "create")
                return
            }
        }
        //#end

        laboratorioInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'laboratorio.label', default: 'Laboratorio'), laboratorioInstance.id])
                redirect laboratorioInstance
            }
            '*' { respond laboratorioInstance, [status: CREATED] }
        }
    }

    def edit(Laboratorio laboratorioInstance) {
        respond laboratorioInstance
    }

    @Transactional
    def update(Laboratorio laboratorioInstance) {
        if (laboratorioInstance == null) {
            notFound()
            return
        }

        if (laboratorioInstance.hasErrors()) {
            respond laboratorioInstance.errors, view:'edit'
            return
        }

        laboratorioInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Laboratorio.label', default: 'Laboratorio'), laboratorioInstance.id])
                redirect laboratorioInstance
            }
            '*'{ respond laboratorioInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Laboratorio laboratorioInstance) {

        if (laboratorioInstance == null) {
            notFound()
            return
        }

        laboratorioInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Laboratorio.label', default: 'Laboratorio'), laboratorioInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'laboratorio.label', default: 'Laboratorio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def registrarNovoLaboratorio(){
    }

    def saveNameFile(){
        FileHelper.criarLaboratorio(params.nomeLaboratorio)
        flash.message = message(code:"message.registerLaboratorySuccess")
        redirect action: 'create', controller: 'laboratorio'
    }
}
