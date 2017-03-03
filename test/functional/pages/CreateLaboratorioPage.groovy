package pages

import geb.Page
import residuosquimicos.Usuario
import steps.InternationalizationHelper

class CreateLaboratorioPage extends Page {
    static url = "/ResiduosQuimicos/laboratorio/create"
    static at = {
        InternationalizationHelper helper = InternationalizationHelper.instance
        String labelLab = "Laboratorio"
        String createLabTitleList = helper.getMessage("default.create.label", labelLab)
        title ==~ createLabTitleList
    }

    def createLab( String nomeLab, String nomeDep, String nomeCentro){
        $('select#nomeCentro').value(nomeCentro)
        $('select#nomeDepartamento').value(nomeDep)
        $('select#nomeLaboratorio').value(nomeLab)
        $('#create-laboratorio input#create').click()
    }

    def createLabAssociado(String nomeLab, String nomeDep, String nomeCentro, String nomeUsuario)
    {
        $('select#nomeCentro').value(nomeCentro)
        $('select#nomeDepartamento').value(nomeDep)
        $('select#nomeLaboratorio').value(nomeLab)
        $('select#responsavel').value(Usuario.findByNome(nomeUsuario).id)
        $('#create-laboratorio input#create').click()
    }

    boolean existeMensagemDeErroUsuarioAdministrador(String admin)
    {
        $("div", class: "message").text().contains(admin)
    }
}