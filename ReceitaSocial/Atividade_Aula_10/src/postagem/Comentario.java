package postagem;

import usuario.Usuario;

public class Comentario {

    private String conteudo;
    private Receita receita;
    private Usuario autor;

    public Comentario(String conteudo, Receita receita, Usuario autor) {
        this.conteudo = conteudo;
        this.receita = receita;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Comentário de " + autor.getNome() + ": " + conteudo;
    }
}
