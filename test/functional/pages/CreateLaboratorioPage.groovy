package pages

import geb.Page
import steps.InternationalizationHelper

class CreateLaboratorioPage extends Page {
    static url = "/ResiduosQuimicos/laboratorio/create"
    static at = {
        InternationalizationHelper helper = InternationalizationHelper.instance
        String labelLab = "Laboratorio" //code.label
        String createLabTitleList = helper.getMessage("default.create.label", labelLab)
        title ==~ createLabTitleList
    }

    def createLab( String nomeLab, String nomeDep, String nomeCentro){
        $('select#nomeCentro').value(nomeCentro)
        $('select#nomeDepartamento').value(nomeDep)
        $('select#nomeLaboratorio').value(nomeLab)
        //nome do responsável é obrigatório mas não impacta no teste, setarei um nome qualquer
        $('#create-laboratorio input#responsavel').value("João Carlos")
        $('#create-laboratorio input#create').click()
    }

}