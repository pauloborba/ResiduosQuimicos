package pages

import geb.Page
import residuosquimicos.Laboratorio
import steps.InternationalizationHelper

class CreateResiduoPage extends Page{
    static url = "/ResiduosQuimicos/residuo/create/"
    static at = {
        InternationalizationHelper helper = InternationalizationHelper.instance
        String residuoLab = "Residuo"
        String createResiduoTitleList = helper.getMessage("default.create.label", residuoLab)
        title ==~ createResiduoTitleList
    }

    def createResiduo(String nomeResiduo, String pesoResiduo, String nomeLaboratorio){
        $('input#nome').value(nomeResiduo)
        $('input#descricao').value("Padrão")
        $('input#peso').value(pesoResiduo)
        $('select#laboratorio').value(Laboratorio.findByNomeLaboratorio(nomeLaboratorio).id)
        $('#create-residuo input#create').click()
    }
}


