package usuario;

public class UsuarioPremium extends Usuario {

    public UsuarioPremium(String nome, String senha, String email) {
        super(nome, senha, email);
    }

    @Override
    public String getTipoUsuario() {
        return "premium";
    }
}
