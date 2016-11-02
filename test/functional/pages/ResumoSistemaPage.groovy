package pages

import geb.Page
import steps.InternationalizationHelper

class ResumoSistemaPage extends Page{
    static url = "/ResiduosQuimicos/status/resumoSistema/"
    static at = {
        InternationalizationHelper helper = InternationalizationHelper.instance
        String resumoSistemaTitleList = helper.getMessage("default.title.page.resumoSistema")
        title ==~ resumoSistemaTitleList
    }

    boolean hasErrorMessageLaboratorioNaoCadastrado(){
        $('div#resumo-content label#errorMessage').text() == "O sistema ainda não possui labóratorios para exibir ou os laboratórios não possuem resíduos cadastrados"
    }

    boolean hasMessageLicitacaoNecessaria(){
        $('textField#status-message').text() == "Uma licitaçao é necessaria para recolher os Residuos nos Laboratorios"
    }
}
