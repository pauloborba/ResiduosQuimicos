package residuosquimicos
import src.groovy.CentroList
import src.groovy.DepartamentoList
import src.groovy.LaboratorioList

class Laboratorio {
    CentroList nomeCentro
    DepartamentoList nomeDepartamento
    LaboratorioList nomeLaboratorio
    Usuario solicitante
    Usuario responsavel
    boolean solicitado
    static hasMany = [residuos:Residuo]

    static constraints = {
        nomeCentro blank: false, nullable: false
        nomeDepartamento blank: false, nullable: false
        nomeLaboratorio blank: false, nullable: false
        solicitante nullable:true
        responsavel nullable:true
    }
}
