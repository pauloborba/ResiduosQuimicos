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
        $('div#resumo-content label#errorMessage').text() == "O sistema ainda não possui laboratorios para exibir ou os laboratórios cadastrados não possuem resíduos cadastrados"
        //mudar para internacionalizado
    }
}
