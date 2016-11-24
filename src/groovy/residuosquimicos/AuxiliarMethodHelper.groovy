package residuosquimicos

class AuxiliarMethodHelper {

    static def eNecessarioColeta(){
        double pesoAgregado = 0
        Residuo.all.each {pesoAgregado+= it.peso}
        pesoAgregado >= 7500
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
