package usuario;

public class Banimento {
    private String razao;
    private Usuario usuarioAdmin;

    public Banimento(String razao, Usuario usuarioAdmin){
        this.razao = razao;
        this.usuarioAdmin = usuarioAdmin;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }
}
