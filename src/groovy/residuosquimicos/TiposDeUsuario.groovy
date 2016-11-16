package residuosquimicos

public enum TiposDeUsuario {
    FAC("Facilitador"),
    ADMIN("Administrador")
    public String value

    TiposDeUsuario(String value){
        this.value = value
    }

    String toString() { value }
    String getKey() { name() }

}