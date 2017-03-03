Feature: Operar com laboratorios disponíveis no sistema.
  As an usuário do tipo Facilitador logado no sistema
  I want to realizar operações com os laboratórios cadastrados
  so that i possa realizar cadastramento de resíduos no sistema
#CONTROLLER
  Scenario: Solicitação de acesso a laboratórios por usuário do tipo Facilitador
    Given "Pedro" não possui associação a nenhum laboratório cadastrado
    And os laboratórios "Laboratório de Etnofarmacologia Aplicada - LEA" e "Laboratório de Microbiologial Industrial e Ambiental - LAMAI" do centro "CB" e dept "DEPARTAMENTO_DE_ANTIBIOTICOS" estão disponíveis para associação
    When Eu solicito a associação de "Pedro" ao Laboratório "Laboratório de Etnofarmacologia Aplicada - LEA"
    Then o laboratório "Laboratório de Etnofarmacologia Aplicada - LEA" não pode receber mais solicitações

  Scenario: Aprovação de acesso a laboratório para um usuário do tipo Facilitador
    Given "Fatima" é um usuário do tipo administrador do sistema
    And Existe uma solicitação de acesso ao laboratório "Laboratório de Etnofarmacologia Aplicada - LEA" do centro "CB" e dept "DEPARTAMENTO_DE_ANTIBIOTICOS" feita pelo usuário Facilitador "Roger"
    When "Fatima" realiza a operação de concessão de acesso ao laboratório "Laboratório de Etnofarmacologia Aplicada - LEA" para "Roger"
    Then "Roger" passa a ficar associado ao laboratório "Laboratório de Etnofarmacologia Aplicada - LEA"
    And "Roger" não pode mais solicitar acesso a laboratórios
#GUI
  @ignore
  Scenario: Confirmação de solicitação de acesso a laboratório para usuário Facilitador
    Given eu criei o usuário do tipo facilitador "Marcos"
    And eu criei o laboratório "Laboratório de Anatomia E" do centro "CB" e dept "DEPARTAMENTO_DE_ANTIBIOTICOS" sem associações
    When eu tento associar "Marcos" ao laboratório "Laboratório de Anatomia E"
    Then eu posso ver uma mensagem de confirmação indicando a solicitação de "Marcos"

  Scenario: Tentativa de associação de usuário Administrador a laboratório
    Given eu criei o usuário do tipo administrador "Maria"
    When eu tento criar o laboratório "Laboratório de Anatomia E" do centro "CB" e dept "DEPARTAMENTO_DE_ANTIBIOTICOS" associado a "Maria"
    Then eu posso ver uma mensagem de erro indicando que "Maria" é um administrador