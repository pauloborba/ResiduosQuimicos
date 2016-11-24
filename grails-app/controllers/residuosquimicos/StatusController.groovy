package residuosquimicos

class StatusController {
    def index() { }

    def resumoSistema(){
        [necessarioColeta:AuxiliarMethodHelper.eNecessarioColeta(), laboratorios:Laboratorio.all.findAll {!it.residuos.isEmpty()}]
    }

    def estatisticas(){
        [percentualResiduo:percentagemLaboratoriosResiduos(), maiorGeradorDeResiduos:AuxiliarMethodHelper.maiorLaboratorioGeradorDeResiduos()]
    }

    def percentagemLaboratoriosResiduos (){
        double laboratoriosComResiduos = 0
        double totalLaboratorios = Laboratorio.all.size()

        if(totalLaboratorios != 0) {
            Laboratorio.all.each { laboratorio ->
                if (!laboratorio.residuos.isEmpty()) {
                    laboratoriosComResiduos += 1
                }
            }

            def percentual = laboratoriosComResiduos / totalLaboratorios
            return (percentual * 100)
        }
        return 0
    }
}
