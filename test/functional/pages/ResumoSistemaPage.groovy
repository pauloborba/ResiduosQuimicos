package pages

import geb.Page
import steps.InternationalizationHelper
import src.groovy.LaboratorioList

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
        $('textField#status-message').text() == "Uma licitaçao é necessaria para recolher os resíduos nos Laboratorios"
    }

    //verifica se existe uma linha na tabela correspondente as informações passadas como parâmetro
    boolean hasLinhaNaTabela(String nomeResiduo, String peso, String nomeLaboratorio){

        def rows = $('table#table-residuos').find('tbody').find('tr')

        def test = rows.find {row ->
            $(row).find('th').eq(0).text() == LaboratorioList.valueOf(LaboratorioList.class, nomeLaboratorio).value &&
            $(row).find('td').eq(0).text() == nomeResiduo &&
            Double.parseDouble($(row).find('td').eq(1).text()) == Double.parseDouble(peso)
        }
        return test != null
    }
}
