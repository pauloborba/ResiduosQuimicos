package pages

import geb.Page
import steps.InternationalizationHelper

class OverviewUsuarioPage extends Page{
    static url = "/ResiduosQuimicos/usuario/overview/"
    static at = {
        InternationalizationHelper helper = InternationalizationHelper.instance
        String overviewUsuario = helper.getMessage("default.title.page.overviewUsuario")
        title ==~ overviewUsuario
    }

    def selecionaLab(String lab){
        if($("a", class:"btn").text().contains(lab))
        {
            $("a", class: "btn").click()
        }
    }

    boolean existeMensagemDeConfirmacao(String str)
    {
        $("div", class: "message").text().contains(str)
    }
}
