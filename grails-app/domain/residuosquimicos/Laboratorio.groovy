package residuosquimicos


class Laboratorio {
    NomesDeCentros nomeCentro
    NomesDeDepartamentos nomeDepartamento
    //alter
    String nomeLaboratorio
    Usuario solicitante
    Usuario responsavel
    static hasMany = [residuos:Residuo]

    static mapping = {
        residuos cascade: 'all-delete-orphan'
    }

    static constraints = {
        nomeCentro blank: false, nullable: false
        nomeDepartamento blank: false, nullable: false
        nomeLaboratorio blank: false, nullable: false
        solicitante nullable:true
        responsavel nullable:true
    }

    Laboratorio() {
        residuos = []
    }

    def pesoResiduosAgregadosAoLaboratorio(){
        double pesoAgregado = 0
        residuos.each {pesoAgregado+=it.peso}
        pesoAgregado
    }

    /**
     * metodo estaSolicitado()
     * @return
     * um boolean informando se o laboratório está solicitado ou não
     */
    def boolean estaSolicitado()
    {
        return this.solicitante
    }
    /**
     * metodo tipoUsuarioSolicitante
     * informa o tipo do usuario solicitando o lab
     * @return tipo usuario solicitante
     */
    def tipoUsuarioSolicitante()
    {
        return this.solicitante.tipo
    }
    /**
     * metodo tipoUsuarioResponsavel
     * informa o tipo do usuario responsavel pelo lab
     * @return tipo usuario responsavel
     */
    def tipoUsuarioResponsavel()
    {
        return this.responsavel.tipo
    }
    /**
     * metodo equalsSolicitante
     * verifica se o usuario solicitante é o que foi recebido como parametro
     */
    def equalsSolicitante(Usuario fac)
    {
        return fac == this.solicitante
    }
    /**
     * metodo equalsResponsavel
     * verifica se o usuario responsavel é aquele passado como parametro
     */
    def equalsResponsavel(Usuario fac)
    {
        return fac == this.responsavel
    }
    /**
     * metodo getNomeResponsavel
     * @return nome do responsavel pelo lab
     */
    def getNomeResponsavel()
    {
        return this.responsavel.nome
    }
}
