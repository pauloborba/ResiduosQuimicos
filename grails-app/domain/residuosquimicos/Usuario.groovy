package residuosquimicos

class Usuario {
    String nome
    String senha
    TiposDeUsuario tipo
    boolean associado
    String ramal
    String email

    static constraints = {
        nome nullable: false, blank: false
        senha nullable: false, blank: false
    }
    Usuario(String nome, String email, String senha)
    {
        this.nome = nome
        this.email = email
        this.senha = senha
        this.associado = false
    }
}
