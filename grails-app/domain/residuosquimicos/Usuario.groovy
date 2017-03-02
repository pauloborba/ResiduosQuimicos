package residuosquimicos
/**
 * Classe Usuario: entidade para diferenciar os tipos de usuários e permitir
 * flexibilidade de acesso ao sistema.
 */
class Usuario {
    String nome
    String senha

    TiposDeUsuario tipo
    boolean associado
    String ramal //ramal para contato com o usuario
    String email //email de acesso ao sistema

    static constraints = {
        nome nullable: false, blank: false
        senha nullable: false, blank: false
    }

    def isFacilitador()
    {
        return (this.tipo == TiposDeUsuario.FAC)
    }

    def isAdmin()
    {
        return this.tipo == TiposDeUsuario.ADMIN
    }

}
