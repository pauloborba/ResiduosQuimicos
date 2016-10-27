package residuosquimicos

class StatusController {
    def index() { }

    def resumoSistema(){
        def statusGeral = "A UFPE não possui quantidade de residuos suficiente para licitação"

        if(eNecessarioColeta()){
            statusGeral = "Uma licitaçao é necessaria para recolher os Residuos nos Laboratorios"
        }
        [statusGeral:statusGeral, susse:"chatuba da mesquita, testando"]
    }

    def estatisticas(){

    }

    def eNecessarioColeta(){
        double pesoAgregado = 0
        Residuo.all.each {pesoAgregado+= it.peso}
        pesoAgregado >= 7500
    }
}
