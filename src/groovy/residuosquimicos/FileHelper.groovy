package residuosquimicos

class FileHelper {
    public static String absolutPathRoot = System.properties['base.dir']+"/grails-app/conf/laboratorios/laboratoriosDoSistema"
    public static File file = new File(absolutPathRoot)

    public static void criarLaboratorio(String nomeLaboratorio){
        file.text +="\n"+nomeLaboratorio
    }

    public static String[] retrieveLaboratorios(){
        String[] nomesLaboratorios = file.text.split("\n")
        return nomesLaboratorios
    }
}