package pages

import geb.Page
import residuosquimicos.Laboratorio
import steps.InternationalizationHelper

class CreateResiduoPage extends Page{
    static url = "/ResiduosQuimicos/residuo/create/"
    static at = {
        InternationalizationHelper helper = InternationalizationHelper.instance
        String residuoLab = "Residuo" //code.label
        String createResiduoTitleList = helper.getMessage("default.create.label", residuoLab)
        title ==~ createResiduoTitleList
    }

    def createResiduo(String nomeResiduo, String pesoResiduo, String nomeLaboratorio){
        $('input#nome').value(nomeResiduo)
        //composição não é relevante para o teste
        $('input#composicao').value("Padrão")
        $('input#peso').value(pesoResiduo)
        println nomeLaboratorio
        println Laboratorio.findByNomeLaboratorio(nomeLaboratorio).id
        $('select#laboratorio').value(Laboratorio.findByNomeLaboratorio(nomeLaboratorio).id)
        //pessoa geradora não é relevante para o teste
        $('#create-residuo input#pessoaGerador').value("None")
        $('#create-residuo input#create').click()
    }
}


