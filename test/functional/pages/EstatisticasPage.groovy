package pages

import geb.Page
import residuosquimicos.Laboratorio
import steps.InternationalizationHelper
import src.groovy.LaboratorioList

class EstatisticasPage extends Page{
    static url = "/ResiduosQuimicos/status/estatisticas/"
    static at = {
        InternationalizationHelper helper = InternationalizationHelper.instance
        String estatisticasTitleList = helper.getMessage("default.title.page.estatisticas")
        title ==~ estatisticasTitleList
    }

    boolean eOmaiorGerador(String nomeLab){
        def lab = Laboratorio.findByNomeLaboratorio(nomeLab)
        $('textField#maiorGerador-message').text() == "O laboratório que mais gerou resíduos é o "+lab.nomeLaboratorio+", que é do departamento "+lab.nomeDepartamento+" e do Centro "+lab.nomeCentro
    }


}
