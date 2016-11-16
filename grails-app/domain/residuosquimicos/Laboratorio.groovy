package residuosquimicos


class Laboratorio {
    NomesDeCentros nomeCentro
    NomesDeDepartamentos nomeDepartamento
    NomesDeLaboratorios nomeLaboratorio
    Usuario solicitante
    Usuario responsavel
    static hasMany = [residuos:Residuo]

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
}
