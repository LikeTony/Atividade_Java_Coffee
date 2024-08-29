package usuario;

public class Usuario {

    private String nome;
    private String senha;
    private String email;
    private int id;
    private static int contador = 0;

    public Usuario(String nome, String senha, String email) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.id = ++contador;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getId() {
        return id;
    }

    public String getTipoUsuario() {
        return "comum";
    }

    @Override
    public String toString() {
        return "Usuário: " + nome + " (ID: " + id + ")";
    }
}
