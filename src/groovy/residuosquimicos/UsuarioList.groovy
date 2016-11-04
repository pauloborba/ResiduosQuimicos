package residuosquimicos

public enum UsuarioList {
    FAC("Facilitador"),
    ADMIN("Administrador")
    public String value

    UsuarioList(String value){
        this.value = value
    }

    String toString() { value }
    String getKey() { name() }

}