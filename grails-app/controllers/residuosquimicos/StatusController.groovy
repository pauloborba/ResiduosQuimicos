package residuosquimicos

class StatusController {
    def index() { }

    def resumoSistema(){
        def statusGeral = "A UFPE não possui quantidade de residuos suficiente para licitação"

        if(eNecessarioColeta()){
            statusGeral = "Uma licitaçao é necessaria para recolher os Residuos nos Laboratorios"
        }
        println Laboratorio.all.findAll {!it.residuos.isEmpty()}
        [statusGeral:statusGeral, laboratorios:Laboratorio.all.findAll {!it.residuos.isEmpty()}]
    }

    def estatisticas(){
        [percentualResiduo:percentagemLaboratoriosResiduos(), maiorGeradorDeResiduos:maiorLaboratorioGeradorDeResiduos()]
    }

    def eNecessarioColeta(){
        double pesoAgregado = 0
        Residuo.all.each {pesoAgregado+= it.peso}
        pesoAgregado >= 7500
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
            println percentual*100
            return (percentual * 100)
        }
        return 0
    }

    def maiorLaboratorioGeradorDeResiduos(){
        if(!Laboratorio.all.empty){
            Laboratorio maiorGerador = Laboratorio.all.get(0)
            Laboratorio.all.each { laboratorio ->
                double pesoCurrentLab= 0, pesoCandidato = 0;

                maiorGerador.residuos.each {pesoCurrentLab+= it.peso}
                laboratorio.residuos.each {pesoCandidato+=it.peso}
                if(pesoCandidato>pesoCurrentLab){
                    maiorGerador = laboratorio
                }
            }
            return maiorGerador
        }
    }

}
