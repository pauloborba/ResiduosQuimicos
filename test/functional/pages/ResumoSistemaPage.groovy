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
        InternationalizationHelper helper = InternationalizationHelper.instance
        String messageNaoPossuiLab= helper.getMessage("message.title.resumoSistema.naoPossuiLab")
        $('div#resumo-content label#errorMessage').text() ==~ messageNaoPossuiLab
    }

    boolean hasMessageLicitacaoNecessaria(){
        InternationalizationHelper helper = InternationalizationHelper.instance
        String messageLicitacao = helper.getMessage("message.title.statusGeral.positive")
        $('textField#status-message').text() ==~ messageLicitacao
    }

    //verifica se existe uma linha na tabela correspondente as informações passadas como parâmetro
    boolean hasLinhaNaTabela(String nomeResiduo, String peso, String nomeLaboratorio){
        def rows = $('table#table-residuos').find('tbody').find('tr')

        def test = rows.find {row ->
            $(row).find('th').eq(0).text() == nomeLaboratorio &&
            $(row).find('td').eq(0).text() == nomeResiduo &&
            Double.parseDouble($(row).find('td').eq(1).text()) == Double.parseDouble(peso)
        }
        return test != null
    }
}
