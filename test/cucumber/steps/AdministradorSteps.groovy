package cucumber.steps

import cucumber.api.PendingException
import pages.ResumoSistemaPage
import pages.ShowLaboratorioPage

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

Given(~/^o sistema não possui nenhum laboratório cadastrado$/) { ->
    to ShowLaboratorioPage
    at ShowLaboratorioPage
    assert page.naoPossuiLaboratorio()
}
When(~/^eu vou para a página de resumo do sistema$/) { ->
    to ResumoSistemaPage
    at ResumoSistemaPage
}
Then(~/^eu devo visualizar uma mensagem de erro informando que a UFPE não possui laboratórios$/) { ->
   at ResumoSistemaPage
   assert page.hasErrorMessageLaboratorioNaoCadastrado()
}