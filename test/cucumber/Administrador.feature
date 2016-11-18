Feature: Administrador do sistema
  As um usuário administrador cadastrado no sistema
  I quero ser capaz de ter uma visão geral do sistema, gerar relatórios, adicionar e remover usuários
  So that eu possa ter um controle do sistema e gerar licitações quando for necessário

  #GUI
  Scenario: gerar lista de laboratórios com resíduos a ser coletado (positivo)
    Given eu criei o laboratório "LABORATORIO_DE_ENFERMAGEM" no departamento "DEPARTAMENTO_DE_ENFERMAGEM" e centro "CCS"
    And eu criei o laboratório "LABORATORIO_DE_BIOTECNOLOGIA_BIOQUIMICA" no departamento "DEPARTAMENTO_DE_BIOQUIMICA" e centro "CB"
    And eu criei o resíduo "Descartáveis em geral" com peso "4000,0" associado ao laboratório "LABORATORIO_DE_ENFERMAGEM"
    And eu criei o resíduo "Compostos químicos" com peso "3700,0" associado ao laboratório "LABORATORIO_DE_BIOTECNOLOGIA_BIOQUIMICA"
    When eu vou para a página de resumo do sistema
    Then eu devo visualizar o resíduo "Descartáveis em geral" com peso "4000" associado ao laboratório "LABORATORIO_DE_ENFERMAGEM"
    And eu devo visualizar o resíduo "Compostos químicos" com peso "3700" associado ao laboratório "LABORATORIO_DE_BIOTECNOLOGIA_BIOQUIMICA"

  Scenario: gerar lista de laboratórios com resíduos a ser coletado (negativo)
    Given o sistema não possui nenhum laboratório cadastrado
    When eu vou para a página de resumo do sistema
    Then eu devo visualizar uma mensagem de erro informando que a UFPE não possui laboratórios

  Scenario: verificar necessidade de coleta de resíduos na UFPE
    Given eu criei o laboratório "LABORATORIO_DE_ENFERMAGEM" no departamento "DEPARTAMENTO_DE_ENFERMAGEM" e centro "CCS"
    And eu criei o laboratório "LABORATORIO_DE_BIOTECNOLOGIA_BIOQUIMICA" no departamento "DEPARTAMENTO_DE_BIOQUIMICA" e centro "CB"
    And eu criei o resíduo "Descartáveis em geral" com peso "4000,0" associado ao laboratório "LABORATORIO_DE_ENFERMAGEM"
    And eu criei o resíduo "Compostos químicos" com peso "3700,0" associado ao laboratório "LABORATORIO_DE_BIOTECNOLOGIA_BIOQUIMICA"
    When eu vou para a página de resumo do sistema
    Then eu devo visualizar uma mensagem informando que é necessário fazer uma licitação

  Scenario: buscar pelo laboratório com maior geração de resíduos
    Given eu criei o laboratório "LABORATORIO_DE_ENFERMAGEM" no departamento "DEPARTAMENTO_DE_ENFERMAGEM" e centro "CCS"
    And eu criei o laboratório "LABORATORIO_DE_BIOTECNOLOGIA_BIOQUIMICA" no departamento "DEPARTAMENTO_DE_BIOQUIMICA" e centro "CB"
    And eu criei o resíduo "Descartáveis em geral" com peso "4000,0" associado ao laboratório "LABORATORIO_DE_ENFERMAGEM"
   And eu criei o resíduo "Compostos químicos" com peso "3700,0" associado ao laboratório "LABORATORIO_DE_BIOTECNOLOGIA_BIOQUIMICA"
    When eu vou para a página de estatísticas
    Then eu devo visualizar que o laboratório "LABORATORIO_DE_ENFERMAGEM" é o maior gerador de resíduos

#CONTROLLER
  Scenario: buscar percentual de laboratórios com resíduos cadastrados
    Given o sistema possui o laboratório "LABORATORIO_DE_ENFERMAGEM" com departamento "DEPARTAMENTO_DE_ENFERMAGEM" e centro "CCS" sem resíduos associados cadastrado
    And o sistema possui o laboratório "LABORATORIO_DE_BIOTECNOLOGIA_BIOQUIMICA" com departamento "DEPARTAMENTO_DE_BIOQUIMICA" e centro "CB" sem resíduos associados cadastrado
    And o sistema possui o resíduo "Compostos químicos" com peso "300,0" associado ao laboratório "LABORATORIO_DE_ENFERMAGEM"
    When eu tento verificar o percentual de laboratorios com resíduos cadastrado
    Then o percentual retornado pelo sistema será "50" por cento