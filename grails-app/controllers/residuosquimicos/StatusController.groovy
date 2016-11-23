package residuosquimicos

class StatusController {
    def index() { }

    def resumoSistema(){
        [necessarioColeta:AuxiliarMethodHelper.eNecessarioColeta(), laboratorios:Laboratorio.all.findAll {!it.residuos.isEmpty()}]
    }

    def estatisticas(){
        [percentualResiduo:AuxiliarMethodHelper.percentagemLaboratoriosResiduos(), maiorGeradorDeResiduos:AuxiliarMethodHelper.maiorLaboratorioGeradorDeResiduos()]
    }
}
