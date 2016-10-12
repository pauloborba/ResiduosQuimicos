package residuosquimicos

class Laboratorio {
    String nomeCentro
    String nomeDepartamento
    String nomeLaboratorio
    String responsavel
    static hasMany = [residuos:Residuo]

    static constraints = {
        nomeCentro blank: false, nullable: false
        nomeDepartamento blank: false, nullable: false
        nomeLaboratorio blank: false, nullable: false
        responsavel blank: false, nullable: false
    }
}
