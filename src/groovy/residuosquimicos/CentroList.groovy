package residuosquimicos

public enum CentroList {
    CB("Centro de Biociências"),
    CCS("Centro de Ciências da Saúde"),
    CTG("Centro de Tecnologia e Geociências"),
    CCEN("Centro de Ciências Exatas e da Natureza"),
    LABORATORIOS_INDEPENDENTES("Laboratórios Independentes"),
    CE("Centro de Educação")
    public String value

    CentroList(String value){
        this.value = value
    }

    String toString() { value }
    String getKey() { name() }

}