package residuosquimicos

class Residuo {
    String nome
    String composicao
    double peso
    String pessoaGerador
    Date dataCadastro
    static belongsTo = [laboratorio:Laboratorio]

    static constraints = {
        nome blank:false, nullable: false
        composicao blank:false, nullable: false
        peso nullable: false
        dataCadastro nullable:false
        laboratorio nullable:false
    }

}
