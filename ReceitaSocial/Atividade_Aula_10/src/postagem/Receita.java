package postagem;
import java.util.LinkedList;
import usuario.Usuario;

public class Receita {

    private static int contador = 0;
    private int numero;
    private String conteudo;
    private Usuario autor;
    private int curtidas;
    private LinkedList<Comentario> listaComentario = new LinkedList<>();

    public Receita(String conteudo, Usuario autor) {
        this.numero = ++contador;
        this.conteudo = conteudo;
        this.autor = autor;
        this.curtidas = 0;
    }

    public int getNumero() {
        return numero;
    }

    public void curtir() {
        curtidas++;
    }

    public void comentar(Comentario comentario) {
        listaComentario.add(comentario);
    }

    public LinkedList<Comentario> getListaComentario() {
        return listaComentario;
    }

    @Override
    public String toString() {
        return "Receita #" + numero + "\nAutor: " + autor.getNome() + "\nConteúdo: " + conteudo + "\nCurtidas: " + curtidas;
    }
}
