package pages

import geb.Page
import steps.InternationalizationHelper

class ShowUserPage extends Page{
    static url = "/ResiduosQuimicos/usuario/show/"
    static at = {
        InternationalizationHelper helper = InternationalizationHelper.instance
        String labelShowUsuario = "Usuario"
        String pageShowUsuario = helper.getMessage("default.show.label", labelShowUsuario)
        title ==~ pageShowUsuario
    }

    def solicitarButtonClick()
    {
        $("a", class: "btnsolicitar").click()
    }

}
