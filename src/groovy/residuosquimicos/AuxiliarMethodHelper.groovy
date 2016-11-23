package residuosquimicos

class AuxiliarMethodHelper {

    static def eNecessarioColeta(){
        double pesoAgregado = 0
        Residuo.all.each {pesoAgregado+= it.peso}
        pesoAgregado >= 7500
    }

    static def percentagemLaboratoriosResiduos (){
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

    static def maiorLaboratorioGeradorDeResiduos(){
        if(!Laboratorio.all.empty){
            Laboratorio maiorGerador = Laboratorio.all.get(0)
            Laboratorio.all.each { laboratorio ->
                def pesoCurrentLab = maiorGerador.pesoResiduosAgregadosAoLaboratorio()
                def pesoCandidato = laboratorio.pesoResiduosAgregadosAoLaboratorio()

                if(pesoCandidato>pesoCurrentLab){
                    maiorGerador = laboratorio
                }
            }
            return maiorGerador
        }
    }
}
