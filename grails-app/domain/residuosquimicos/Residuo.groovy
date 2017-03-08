package residuosquimicos

class Residuo {
    String nome
    String descricao
    double peso
    Date dataCadastro
    static belongsTo = [laboratorio:Laboratorio]

    static constraints = {
        nome blank:false, nullable: false
        descricao blank:false, nullable: false
        peso nullable: false
        dataCadastro nullable:false
        laboratorio nullable:false
    }

}
