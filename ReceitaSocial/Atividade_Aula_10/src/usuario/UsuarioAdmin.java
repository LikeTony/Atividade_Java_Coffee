package usuario;

public class UsuarioAdmin extends Usuario {

    public UsuarioAdmin(String nome, String senha, String email) {
        super(nome, senha, email);
    }

    @Override
    public String getTipoUsuario() {
        return "admin";
    }
}
