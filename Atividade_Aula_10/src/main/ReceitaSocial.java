package main;

import usuario.Usuario;
import usuario.UsuarioAdmin;
import usuario.UsuarioPremium;
import postagem.Receita;
import postagem.Comentario;

import java.util.LinkedList;

public class ReceitaSocial {

    private LinkedList<Comentario> listaComentarios = new LinkedList<>();
    private LinkedList<Receita> listaReceitas = new LinkedList<>();
    private LinkedList<Usuario> listaUsuarios = new LinkedList<>();
    private Usuario usuario;

    public LinkedList<Receita> getListaUsuarioReceita() {
        return listaReceitas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void adicionarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public boolean login(String email, String senha) {
        for (Usuario u : listaUsuarios) {
            if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                usuario = u;
                return true;
            }
        }
        return false;
    }

    public void deslogar() {
        usuario = null;
    }

    public void criarReceita(String conteudo, Usuario usuario) {
        Receita receita = new Receita(conteudo, usuario);
        listaReceitas.add(receita);
    }

    public void criarReceita(String conteudo) {
        if (usuario != null) {
            Receita receita = new Receita(conteudo, usuario);
            listaReceitas.add(receita);
        } else {
            System.out.println("Você precisa estar logado para adicionar uma receita.");
        }
    }

    public boolean adicionarCurtida(int numeroReceita) {
        for (Receita receita : listaReceitas) {
            if (receita.getNumero() == numeroReceita) {
                receita.curtir();
                return true;
            }
        }
        return false;
    }

    public boolean imprimirReceitas(int numeroReceita) {
        for (Receita receita : listaReceitas) {
            if (receita.getNumero() == numeroReceita) {
                System.out.println(receita);
                return true;
            }
        }
        return false;
    }

    public void comentarReceita(int numeroReceita, String conteudoComentario) {
        for (Receita receita : listaReceitas) {
            if (receita.getNumero() == numeroReceita) {
                Comentario comentario = new Comentario(conteudoComentario, receita, usuario);
                receita.comentar(comentario);
                listaComentarios.add(comentario);
                return;
            }
        }
        System.out.println("Receita não encontrada.");
    }

    public boolean imprimirReceitas() {
        for (Receita receita : listaReceitas) {
            System.out.println(receita);
        }
        return true;
    }

    public boolean imprimirComentarios(int numeroReceita) {
        for (Receita receita : listaReceitas) {
            if (receita.getNumero() == numeroReceita) {
                for (Comentario comentario : receita.getListaComentario()) {
                    System.out.println(comentario);
                }
                return true;
            }
        }
        return false;
    }

    public boolean isAdmin() {
        return usuario != null && usuario.getTipoUsuario().equals("admin");
    }

    public void imprimirUsuarios() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("Não há usuários cadastrados.");
        } else {
            System.out.println("Lista de usuários:");
            for (Usuario u : listaUsuarios) {
                System.out.println(u);
            }
        }
    }

    public boolean imprimirUsuarios(int idUsuario) {
        for (Usuario u : listaUsuarios) {
            if (u.getId() == idUsuario) {
                System.out.println(u);
                return true;
            }
        }
        return false;
    }

    public void banirUsuario(int idUsuario, String razao) {
        Usuario usuarioBanido = null;
        for (Usuario u : listaUsuarios) {
            if (u.getId() == idUsuario) {
                usuarioBanido = u;
                break;
            }
        }
        if (usuarioBanido != null) {
            listaUsuarios.remove(usuarioBanido);
            System.out.println("Usuário banido com sucesso. Razão: " + razao);
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public void deletarReceita(int numeroReceita) {
        Receita receitaParaDeletar = null;
        for (Receita receita : listaReceitas) {
            if (receita.getNumero() == numeroReceita) {
                receitaParaDeletar = receita;
                break;
            }
        }
        if (receitaParaDeletar != null) {
            listaReceitas.remove(receitaParaDeletar);
            System.out.println("Receita excluída com sucesso.");
        } else {
            System.out.println("Receita não encontrada.");
        }
    }

    // Método para criar um novo usuário
    public void criarUsuario(String nome, String senha, String email, boolean premium) {
        Usuario novoUsuario;
        if (premium) {
            novoUsuario = new UsuarioPremium(nome, senha, email);
        } else {
            novoUsuario = new Usuario(nome, senha, email);
        }
        listaUsuarios.add(novoUsuario);
        System.out.println("Usuário criado com sucesso.");
    }
}
