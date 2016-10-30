Feature: usuário administrador do sistema
  As um usuário administrador cadastrado no sistema
  I quero ser capaz de ter uma visão geral do sistema, gerar relatórios, adicionar e remover usuários
  So that eu possa ter um controle do sistema e gerar licitações quando for necessário

  Scenario: gerar lista de laboratórios com resíduos a ser coletado (positivo)
    Given eu crei o Laboratório "Laboratório de Enfermagem" no Departamento "Departamento de Enfermagem" e centro "Centro de Ciências da Saúde"
    And eu criei o Laboratório "Laboratório de Biotecnologia" no Departamento "Laboratório de Biotecnologia" e centro "Centro de Biociências"
    And eu criei o Residuo "Descartáveis em Geral" com peso "3000" associado ao laboratório "Laboratório de Enfermagem"
    And eu criei o Residuo "Compostos químicos" com peso "3700" associado ao laboratório "Laboratório de Biotecnologia"
    When eu vou para a página de resumo do sistema
    Then eu devo visualizar os residuos "Descartáveis em Geral" com peso "3000" e "Compostos químicos" com peso "3700" na tabela de resumo do sistema


  Scenario: gerar lista de laboratórios com resíduos a ser coletado (negativo)
    Given o sistema não possui nenhum laboratório cadastrado
    When eu vou para a página de resumo do sistema
    Then eu devo visualizar uma mensagem de erro


  Scenario: verificar necessidade de coleta de resíduos na UFPE
    Given eu crei o Laboratório "Laboratório de Enfermagem" no Departamento "Departamento de Enfermagem" e centro "Centro de Ciências da Saúde"
    And eu criei o Laboratório "Laboratório de Biotecnologia" no Departamento "Laboratório de Biotecnologia" e centro "Centro de Biociências"
    And eu criei o Residuo "Descartáveis em Geral" com peso "3000" associado ao laboratório "Laboratório de Enfermagem"
    And eu criei o Residuo "Compostos químicos" com peso "3700" associado ao laboratório "Laboratório de Biotecnologia"
    When eu vou para a página de resumo do sistema
    Then eu devo visualizar uma mensagem informando que é necessário fazer uma licitação

  Scenario: buscar maior pelo laboratório com maior geração de resíduos
    Given eu crei o Laboratório "Laboratório de Enfermagem" no Departamento "Departamento de Enfermagem" e centro "Centro de Ciências da Saúde"
    And eu criei o Laboratório "Laboratório de Biotecnologia" no Departamento "Laboratório de Biotecnologia" e centro "Centro de Biociências"
    And eu criei o Residuo "Descartáveis em Geral" com peso "3000" associado ao laboratório "Laboratório de Enfermagem"
    And eu criei o Residuo "Compostos químicos" com peso "3700" associado ao laboratório "Laboratório de Biotecnologia"
    When eu vou para a página de estatísticas
    Then eu devo visualizar que o Laboratório "Laboratório de Biotecnologia" é o maior gerador de resíduos


  Scenario: buscar percentual de Laboratorios com resíduos cadastrados
    Given o sistema possui o laboratorio "Laboratório de Enfermagem" cadastrado
    And o sistema possui o laboratorio "Laboratório de Biotecnologia" cadastrado
    And apenas o laboratório "Laboratorio de Enfermagem" possui Residuos cadastrados
    When eu tento verificar o percentual de laboratorios com Residuos
    Then o percentual retornado pelo sistema será "50" por cento