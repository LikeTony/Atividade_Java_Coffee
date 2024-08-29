package main;

import usuario.Usuario;
import usuario.UsuarioAdmin;
import usuario.UsuarioPremium;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        ReceitaSocial receitaSocial = new ReceitaSocial();
        Scanner scanner = new Scanner(System.in);

        // Definindo os usuários com nomes e e-mails realistas
        Usuario usuario1 = new UsuarioPremium("Carlos Oliveira", "senha1", "carlos.oliveira@gmail.com");
        Usuario usuario2 = new Usuario("Ana Silva", "senha2", "ana.silva@gmail.com");
        Usuario usuario3 = new UsuarioPremium("João Souza", "senha3", "joao.souza@gmail.com");
        Usuario usuario4 = new Usuario("Mariana Costa", "senha4", "mariana.costa@gmail.com");
        Usuario usuario5 = new UsuarioPremium("Pedro Santos", "senha5", "pedro.santos@gmail.com");
        Usuario admin = new UsuarioAdmin("Admin User", "admin", "admin");

        receitaSocial.adicionarUsuario(usuario1);
        receitaSocial.adicionarUsuario(usuario2);
        receitaSocial.adicionarUsuario(usuario3);
        receitaSocial.adicionarUsuario(usuario4);
        receitaSocial.adicionarUsuario(usuario5);
        receitaSocial.adicionarUsuario(admin);

        receitaSocial.criarReceita("Experimentei uma nova receita de lasanha e ficou sensacional! Alguém já testou?", usuario1);
        receitaSocial.criarReceita("Preparei um bolo de chocolate hoje e vou compartilhar a receita com vocês!", usuario1);
        receitaSocial.criarReceita("Preciso de uma receita de salada fresca para o jantar. Alguma sugestão?", usuario1);

        receitaSocial.criarReceita("Café da manhã saudável é o melhor começo para o dia. Qual é o seu prato matinal preferido?", usuario2);
        receitaSocial.criarReceita("Comemorei o aniversário de um amigo com um bolo especial. Veja a receita aqui!", usuario2);
        receitaSocial.criarReceita("Refletindo sobre como as dietas afetam nossa saúde. O que você acha? Elas ajudam ou atrapalham?", usuario2);

        receitaSocial.criarReceita("Estou empolgado para o almoço com uma receita nova de massa. Alguém mais está testando algo novo?", usuario3);
        receitaSocial.criarReceita("O jantar de hoje foi um sucesso! Compartilho a receita e as fotos do prato.", usuario3);
        receitaSocial.criarReceita("Estou fazendo uma maratona de receitas de sobremesas. Quais são as suas favoritas?", usuario3);

        receitaSocial.criarReceita("Preparei uma sopa caseira deliciosa hoje. Alguma dica para melhorar a receita?", usuario4);
        receitaSocial.criarReceita("Estou fazendo um curso de culinária e estou animado para mostrar minhas novas receitas!", usuario4);
        receitaSocial.criarReceita("Sou apaixonado por chás! Alguma recomendação de misturas especiais?", usuario4);

        receitaSocial.criarReceita("Lendo um livro sobre técnicas avançadas de cozinha. Alguém mais se interessa por isso?", usuario5);
        receitaSocial.criarReceita("Pensando em começar a fazer pão caseiro. Alguma receita fácil para iniciantes?", usuario5);
        receitaSocial.criarReceita("Frase do dia: 'A culinária é uma forma de arte, e cada prato é uma nova criação.'", usuario5);

        boolean repetir = true;

        do {

            String opcao;

            if (receitaSocial.getUsuario() == null) {
                String resp;
                System.out.println("Nenhum usuário logado. Deseja criar um novo perfil ou fazer login?\n[1]Criar novo perfil [2]Fazer login [3]Sair");
                resp = scanner.nextLine();

                switch (resp) {
                    case "1":
                        cadastrarUsuario(scanner, receitaSocial);
                        break;

                    case "2":
                        loginUsuario(scanner, receitaSocial);
                        break;

                    default:
                        repetir = false;
                }

            } else if (repetir) {

                System.out.println("[1]Ver todas as receitas");
                System.out.println("[2]Adicionar nova receita");
                System.out.println("[3]Curtir uma receita");
                System.out.println("[4]Ver comentários em uma receita");
                System.out.println("[5]Comentar em uma receita");
                System.out.println("[6]Sair da conta");
                if (receitaSocial.getUsuario().getTipoUsuario().equals("admin")) {
                    System.out.println("[usr]Listar todos os usuários");
                    System.out.println("[del]Excluir uma receita");
                    System.out.println("[ban]Banir um usuário");
                }

                opcao = scanner.nextLine();

                switch (opcao) {
                    case "1":
                        receitaSocial.imprimirReceitas();
                        break;

                    case "2":
                        System.out.println("Digite o conteúdo da sua receita:");
                        receitaSocial.criarReceita(scanner.nextLine());
                        break;

                    case "3":
                        System.out.println("Informe o número da receita que você deseja curtir: ");
                        if (receitaSocial.adicionarCurtida(scanner.nextInt())) {
                            System.out.println("Receita curtida com sucesso!");
                        } else {
                            System.out.println("Receita não encontrada.");
                        }
                        scanner.nextLine();
                        break;

                    case "4":
                        System.out.println("Informe o número da receita para ver os comentários: ");
                        if (!receitaSocial.imprimirComentarios(scanner.nextInt())) {
                            System.out.println("Receita não encontrada.");
                        }
                        scanner.nextLine();
                        break;

                    case "5":
                        System.out.println("Informe o número da receita onde deseja comentar: ");
                        int numeroReceita = scanner.nextInt();
                        scanner.nextLine();

                        if (!receitaSocial.imprimirReceitas(numeroReceita)) {
                            System.out.println("Receita não encontrada.");
                        }

                        System.out.println("Digite seu comentário:");
                        receitaSocial.comentarReceita(numeroReceita, scanner.nextLine());
                        break;

                    case "usr":
                        if (receitaSocial.isAdmin()) {
                            receitaSocial.imprimirUsuarios();
                        }
                        break;

                    case "ban":
                        if (receitaSocial.isAdmin()) {
                            String razao;
                            int idUsuario;
                            System.out.println("Informe o ID do usuário a ser banido: ");
                            idUsuario = scanner.nextInt();
                            scanner.nextLine();
                            if (!receitaSocial.imprimirUsuarios(idUsuario)) {
                                System.out.println("Usuário não encontrado.");
                                break;
                            }

                            System.out.println("Informe a razão do banimento: ");
                            razao = scanner.nextLine();

                            receitaSocial.banirUsuario(idUsuario, razao);
                            System.out.println("Usuário banido com sucesso.");
                        }
                        break;

                    case "del":
                        if (receitaSocial.isAdmin()) {
                            int numeroReceitaDel;

                            System.out.println("Informe o número da receita que deseja excluir:");
                            numeroReceitaDel = scanner.nextInt();
                            scanner.nextLine();
                            if (!receitaSocial.imprimirReceitas(numeroReceitaDel)) {
                                System.out.println("Receita não encontrada.");
                                break;
                            }
                            System.out.println("Tem certeza de que deseja excluir esta receita? [1]Sim [2]Não");
                            if (scanner.nextLine().equals("1")) {
                                receitaSocial.deletarReceita(numeroReceitaDel);
                                System.out.println("Receita excluída.");
                            }
                        }
                        break;

                    default:
                        if (opcao.equals("6")) {
                            receitaSocial.deslogar();
                            System.out.println("Você foi desconectado.");
                        }
                        break;
                }
            }

        } while (repetir);

    }

    private static void loginUsuario(Scanner scanner, ReceitaSocial receitaSocial) {
        boolean repetir = true;
        while (repetir) {
            String email, senha;

            System.out.println("Por favor, informe suas credenciais:");
            System.out.println("Digite seu email: ");
            email = scanner.nextLine();
            System.out.println("Digite sua senha: ");
            senha = scanner.nextLine();

            if (receitaSocial.login(email, senha)) {
                System.out.println("Login realizado com sucesso!");
                return;
            } else {
                System.out.println("Não foi possível realizar o login. Verifique suas credenciais e tente novamente.\n[1]Tentar novamente [2]Cancelar");
                String resp = scanner.nextLine();
                if (resp.equals("2")) {
                    repetir = false;
                    break;
                }
            }
        }
    }

    private static void cadastrarUsuario(Scanner scanner, ReceitaSocial receitaSocial) {
        String nome, senha, email;
        boolean tipoPremium = false;

        System.out.println("Para criar um novo perfil, por favor, informe os seguintes dados:");
        System.out.println("Nome: ");
        nome = scanner.nextLine();
        System.out.println("Email: ");
        email = scanner.nextLine();
        System.out.println("Senha: ");
        senha = scanner.nextLine();

        System.out.println("Gostaria de assinar o plano premium por R$20/mês e obter mais visibilidade? [1]Sim [2]Não");

        if (scanner.nextInt() == 1) {
            tipoPremium = true;
        }
        scanner.nextLine();

        receitaSocial.criarUsuario(nome, senha, email, tipoPremium);
    }
}
