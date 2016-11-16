package residuosquimicos

public enum NomesDeDepartamentos {
    //Departamentos CB
    DEPARTAMENTO_DE_ANTIBIOTICOS("Departamento de Antibióticos"),
    DEPARTAMENTO_DE_ANATOMIA("Departamento de Anatomia Humana"),
    DEPARTAMENTO_DE_BIOFISICA_RADIOLOGIA("Departamento de Biofísica Radiologia"),
    DEPARTAMENTO_DE_BIOQUIMICA("Departamento de Bioquímica"),
    DEPARTAMENTO_DE_BOTANICA("Departamento de Botânica"),
    DEPARTAMENTO_DE_FISIOLOGIA_E_FARMACOLOGIA("Departamento de Fisiologia e Farmacologia"),
    DEPARTAMENTO_DE_GENETICA("Departamento de Genética"),
    DEPARTAMENTO_DE_MICOLOGIA("Departamento de Micologia"),
    DEPARTAMENTO_DE_ZOOLOGIA("Departamento de Zoologia"),
    LABORATORIO_CENTRAL("Laboratório Central - CB"),

    //Departamentos CCS
    DEPARTAMENTO_DE_CIENCIAS_FARMACEUTICAS("Departamento de Ciências Farmacêuticas"),
    DEPARTAMENTO_DE_CIRURGIA("Departamento de Cirurgia"),
    DEPARTAMENTO_DE_CLINICA_ODONTOLOGIA_PREVENTIVA("Departamento  de Clínica Odontologica Preventiva"),
    DEPARTAMENTO_DE_EDUCACAO_FISICA("Departamento de Educação Física"),
    DEPARTAMENTO_DE_ENFERMAGEM("Departamento de Enfermagem"),
    DEPARTAMENTO_DE_FISIOTERAPIA("Departamento de Fisioterapia"),
    DEPARTAMENTO_DE_FONODIAULOGIA("Departamento de Fonodiaulogia"),
    DEPARTAMENTO_MATERNO_INFANTIL("Departamento Materno Infantil"),
    DEPARTAMENTO_DE_MEDICINA_CLINICA("Departamento de Medicina Clínica"),
    DEPARTAMENTO_DE_MEDICINA_SOCIAL("Departamento de Medicina Social"),
    DEPARTAMENTO_DE_MEDICINA_TROPICAL("Departamento de Medicina Tropical"),
    DEPARTAMENTO_DE_NUTRICAO("Departamento de Nutrição"),
    DEPARTAMENTO_DE_PATOLOGIA("Departamento de Patologia"),
    DEPARTAMENTO_DE_PROTESES_E_CIRURGIA_BUCOFACIAL("Departamento de Prótese e Cirurgia Bucofacial"),

    //Departamentos CTG
            DEPARTAMENTO_DE_ENGENHARIA_CARTOGRAFICA("Departamento de Engenharia Cartográfica"),
    DEPARTAMENTO_DE_ENGENHARIA_CIVIL("Departamento de Engenharia Civil"),
    DEPARTAMENTO_DE_ENGENHARIA_MECANICA("Departamento de Engenharia Mecânica"),
    DEPARTAMENTO_DE_ENGENHARIA_QUIMICA("Departamento de Engenharia Química"),
    DEPARTAMENTO_DE_ENGENHARIA_DE_PRODUCAO("Departamento de Engenharia de Produção"),
    DEPARTAMENTO_DE_ELETRONICOS_E_SISTEMAS("Departamento de Eletrônicos e Sistemas"),
    DEPARTAMENTO_DE_ENGENHARIA_DE_MINAS("Departamento de Engenharia de Minas"),
    DEPARTAMENTO_DE_ENERGIA_NUCLEAR("Departamento de Energia Nuclear"),
    DEPARTAMENTO_DE_OCEANOGRAFIA("Departamento de Oceanografia"),
    DEPARTAMENTO_DE_GEOLOGIA("Departamento de Geologia"),

    //Departamentos CCEN
    DEPARTAMENTO_DE_FISICA("Departamento de Física"),
    DEPARTAMENTO_DE_QUIMICA_FUNDAMENTAL("Departamento de Química Fundamental"),

    //Departamentos CE
    COLEGIO_DE_APLICACAO("Colégio de Aplicação"),

    //Laboratorios Independentes
    DINE_POSITIVA("DINE Positiva"),
    LIKA("LIKA")

    public String value

    NomesDeDepartamentos(String value){
        this.value = value
    }

    String toString() { value }
    String getKey() { name() }

}