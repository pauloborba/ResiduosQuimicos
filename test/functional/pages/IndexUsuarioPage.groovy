package pages

import geb.Page
import steps.InternationalizationHelper

class IndexUsuarioPage extends Page{
    static url = "/ResiduosQuimicos/usuario/index/"
    static at = {
        InternationalizationHelper helper = InternationalizationHelper.instance
        String labelIndexUsuario = "Usuario"
        String indexUsuario = helper.getMessage("default.list.label", labelIndexUsuario)
        title ==~ indexUsuario
    }

    def procuraNomeUsuario(String nome)
    {
        $("a", text: nome).click()
    }

}
