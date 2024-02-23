package menu;

import database.database;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuEdicao {

    public static void menuEdicao() {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n======= MENU DE EDIÇÃO =======");
            System.out.println("1 - Editar diretores");
            System.out.println("2 - Editar atores");
            System.out.println("3 - Editar filmes");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuEditarDiretor();
                    break;

                case 2:
                    menuEditarAtor();
                    break;

                case 3:
                    menuEditarFilme();
                    break;

                case 0:
                    System.out.println("Voltando ao Menu de Edição...");
                    return;

                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }


        } while (opcao != 0);

        scanner.close();

    }

    public static void menuEditarDiretor() {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n======= MENU DE EDIÇÃO DE DIRETORES =======");
            System.out.println("1 - Associar diretor a filme");
            System.out.println("2 - Desassociar diretor a filme");
            System.out.println("3 - Remover diretor do sistema");
            System.out.println("4 - Editar diretor existente");
            System.out.println("0 - Voltar ao Menu de Edição");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    ArrayList<Diretor> diretores = database.getListaDiretores();
                    if (diretores.isEmpty()) {
                        System.out.println("Nenhum diretor cadastrado.");
                        break;
                    }

                    for (int i = 0; i < diretores.size(); i++) {
                        System.out.println((i + 1) + " - " + diretores.get(i).getNome());
                    }

                    try {

                        System.out.print("Selecione o número do diretor: ");
                        int numeroDiretor = scanner.nextInt();
                        scanner.nextLine();


                        if (numeroDiretor < 1 || numeroDiretor > diretores.size()) {
                            throw new IllegalArgumentException("Número de diretor inválido.");
                        }


                        Diretor diretorSelecionado = diretores.get(numeroDiretor - 1);


                        ArrayList<Filme> filmes = database.getListaFilmes();
                        if (filmes.isEmpty()) {
                            System.out.println("Nenhum filme cadastrado.");
                            break;
                        }

                        System.out.println("Filmes existentes:");
                        for (int i = 0; i < filmes.size(); i++) {
                            System.out.println((i + 1) + " - " + filmes.get(i).getTitulo());
                        }


                        System.out.print("Selecione o número do filme: ");
                        int numeroFilme = scanner.nextInt();
                        scanner.nextLine();


                        if (numeroFilme < 1 || numeroFilme > filmes.size()) {
                            throw new IllegalArgumentException("Número de filme inválido.");
                        }


                        Filme filmeSelecionado = filmes.get(numeroFilme - 1);


                        DiretorController.associarDiretorAFilme(diretorSelecionado, filmeSelecionado);

                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                        scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;


                case 2:

                    ArrayList<Filme> filmesList = database.getListaFilmes();
                    if (filmesList.isEmpty()) {
                        System.out.println("Nenhum filme cadastrado.");
                        break;
                    }


                    System.out.println("Filmes existentes:");
                    for (int i = 0; i < filmesList.size(); i++) {
                        System.out.println((i + 1) + " - " + filmesList.get(i).getTitulo());
                    }

                    try {

                        System.out.print("Selecione o número do filme: ");
                        int numFilmeDesassociar = scanner.nextInt();
                        scanner.nextLine();


                        if (numFilmeDesassociar < 1 || numFilmeDesassociar > filmesList.size()) {
                            throw new IllegalArgumentException("Número de filme inválido.");
                        }


                        Filme filmeDesassociar = filmesList.get(numFilmeDesassociar - 1);


                        ArrayList<Diretor> diretoresAssociados = filmeDesassociar.getDiretores();
                        if (diretoresAssociados.isEmpty()) {
                            System.out.println("Este filme não possui diretores associados.");
                            break;
                        }


                        System.out.println("Diretores associados a \"" + filmeDesassociar.getTitulo() + "\":");
                        for (int i = 0; i < diretoresAssociados.size(); i++) {
                            System.out.println((i + 1) + " - " + diretoresAssociados.get(i).getNome());
                        }


                        System.out.print("Selecione o número do diretor para desassociar: ");
                        int numDiretorDesassociar = scanner.nextInt();
                        scanner.nextLine();


                        if (numDiretorDesassociar < 1 || numDiretorDesassociar > diretoresAssociados.size()) {
                            throw new IllegalArgumentException("Número de diretor inválido.");
                        }


                        Diretor diretorDesassociar = diretoresAssociados.get(numDiretorDesassociar - 1);


                        DiretorController.desassociarDiretorAFilme(diretorDesassociar, filmeDesassociar);
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                        scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;


                case 3:

                    ArrayList<Diretor> diretoresList = database.getListaDiretores();
                    if (diretoresList.isEmpty()) {
                        System.out.println("Nenhum diretor cadastrado.");
                        break;
                    }


                    System.out.println("Diretores existentes:");
                    for (int i = 0; i < diretoresList.size(); i++) {
                        System.out.println((i + 1) + " - " + diretoresList.get(i).getNome());
                    }

                    try {

                        System.out.print("Selecione o número do diretor para remover: ");
                        int numDiretorRemover = scanner.nextInt();
                        scanner.nextLine();


                        if (numDiretorRemover < 1 || numDiretorRemover > diretoresList.size()) {
                            throw new IllegalArgumentException("Número de diretor inválido.");
                        }


                        Diretor diretorRemover = diretoresList.get(numDiretorRemover - 1);


                        DiretorController.removerDiretorSistema(diretorRemover);

                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                        scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:

                    ArrayList<Diretor> diretoresListEditar = database.getListaDiretores();
                    if (diretoresListEditar.isEmpty()) {
                        System.out.println("Nenhum diretor cadastrado.");
                        break;
                    }


                    System.out.println("Diretores existentes:");
                    for (int i = 0; i < diretoresListEditar.size(); i++) {
                        System.out.println((i + 1) + " - " + diretoresListEditar.get(i).getNome());
                    }

                    try {

                        System.out.print("Selecione o número do diretor para editar: ");
                        int numDiretorEditar = scanner.nextInt();
                        scanner.nextLine();


                        if (numDiretorEditar < 1 || numDiretorEditar > diretoresListEditar.size()) {
                            throw new IllegalArgumentException("Número de diretor inválido.");
                        }


                        Diretor diretorEditar = diretoresListEditar.get(numDiretorEditar - 1);


                        System.out.println("Digite os novos dados do diretor:");

                        System.out.print("Nome: ");
                        String novoNome = scanner.nextLine();

                        System.out.print("Idade: ");
                        int novaIdade = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Áreas disponíveis:");
                        for (int i = 0; i < Enums.AreaDiretor.values().length; i++) {
                            System.out.println((i + 1) + " - " + Enums.AreaDiretor.values()[i]);
                        }


                        System.out.print("Escolha o número da área desejada: ");


                        int opcaoArea = scanner.nextInt();
                        scanner.nextLine();


                        if (opcaoArea < 1 || opcaoArea > Enums.AreaDiretor.values().length) {
                            throw new IllegalArgumentException("Opção inválida. Por favor, escolha uma área válida.");
                        }


                        Enums.AreaDiretor novaArea = Enums.AreaDiretor.values()[opcaoArea - 1];


                        DiretorController.editarDiretor(diretorEditar, novoNome, novaIdade, novaArea);

                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                        scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Voltando ao Menu de Edição...");
                    return;

                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }

        } while (opcao != 0);


    }

    public static void menuEditarAtor() {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n======= MENU DE EDIÇÃO DE ATORES =======");
            System.out.println("1 - Associar ator a filme");
            System.out.println("2 - Desassociar ator a filme");
            System.out.println("3 - Remover ator do sistema");
            System.out.println("4 - Editar ator existente");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:

                    ArrayList<Ator> atoresListAssociar = database.getListaAtores();
                    if (atoresListAssociar.isEmpty()) {
                        System.out.println("Nenhum ator cadastrado.");
                        break;
                    }


                    System.out.println("Atores existentes:");
                    for (int i = 0; i < atoresListAssociar.size(); i++) {
                        System.out.println((i + 1) + " - " + atoresListAssociar.get(i).getNome());
                    }

                    try {

                        System.out.print("Selecione o número do ator para associar ao filme: ");
                        int numAtorAssociar = scanner.nextInt();
                        scanner.nextLine();


                        if (numAtorAssociar < 1 || numAtorAssociar > atoresListAssociar.size()) {
                            throw new IllegalArgumentException("Número de ator inválido.");
                        }


                        Ator atorAssociar = atoresListAssociar.get(numAtorAssociar - 1);


                        ArrayList<Filme> filmesListAssociar = database.getListaFilmes();
                        System.out.println("Filmes existentes:");
                        for (int i = 0; i < filmesListAssociar.size(); i++) {
                            System.out.println((i + 1) + " - " + filmesListAssociar.get(i).getTitulo());
                        }


                        System.out.print("Selecione o número do filme para associar ao ator: ");
                        int numFilmeAssociar = scanner.nextInt();
                        scanner.nextLine();


                        if (numFilmeAssociar < 1 || numFilmeAssociar > filmesListAssociar.size()) {
                            throw new IllegalArgumentException("Número de filme inválido.");
                        }


                        Filme filmeAssociar = filmesListAssociar.get(numFilmeAssociar - 1);


                        AtorController.associarAtorAFilme(atorAssociar, filmeAssociar);

                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                        scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:


                    ArrayList<Ator> atoresListDesassociar = database.getListaAtores();
                    if (atoresListDesassociar.isEmpty()) {
                        System.out.println("Nenhum ator cadastrado.");
                        break;
                    }

                    System.out.println("Atores existentes:");
                    for (int i = 0; i < atoresListDesassociar.size(); i++) {
                        System.out.println((i + 1) + " - " + atoresListDesassociar.get(i).getNome());
                    }

                    try {
                        System.out.print("Selecione o número do ator para desassociar: ");
                        int numAtorDesassociar = scanner.nextInt();
                        scanner.nextLine();

                        if (numAtorDesassociar < 1 || numAtorDesassociar > atoresListDesassociar.size()) {
                            throw new IllegalArgumentException("Número de ator inválido.");
                        }

                        Ator atorDesassociar = atoresListDesassociar.get(numAtorDesassociar - 1);

                        ArrayList<Filme> filmesListDesassociar = database.getListaFilmes();
                        System.out.println("Filmes existentes:");
                        for (int i = 0; i < filmesListDesassociar.size(); i++) {
                            System.out.println((i + 1) + " - " + filmesListDesassociar.get(i).getTitulo());
                        }

                        System.out.print("Selecione o número do filme para desassociar o ator: ");
                        int numFilmeDesassociar = scanner.nextInt();
                        scanner.nextLine();

                        if (numFilmeDesassociar < 1 || numFilmeDesassociar > filmesListDesassociar.size()) {
                            throw new IllegalArgumentException("Número de filme inválido.");
                        }

                        Filme filmeDesassociar = filmesListDesassociar.get(numFilmeDesassociar - 1);

                        AtorController.desassociarAtorAFilme(atorDesassociar, filmeDesassociar);

                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                        scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:


                    ArrayList<Ator> atoresListRemover = database.getListaAtores();
                    if (atoresListRemover.isEmpty()) {
                        System.out.println("Nenhum ator cadastrado.");
                        break;
                    }


                    System.out.println("Atores existentes:");
                    for (int i = 0; i < atoresListRemover.size(); i++) {
                        System.out.println((i + 1) + " - " + atoresListRemover.get(i).getNome());
                    }

                    try {

                        System.out.print("Selecione o número do ator para remover: ");
                        int numAtorRemover = scanner.nextInt();
                        scanner.nextLine();


                        if (numAtorRemover < 1 || numAtorRemover > atoresListRemover.size()) {
                            throw new IllegalArgumentException("Número de ator inválido.");
                        }


                        Ator atorRemover = atoresListRemover.get(numAtorRemover - 1);


                        AtorController.removerAtorSistema(atorRemover);

                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                        scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:

                    ArrayList<Ator> atoresListEditar = database.getListaAtores();
                    if (atoresListEditar.isEmpty()) {
                        System.out.println("Nenhum ator cadastrado.");
                        break;
                    }

                    System.out.println("Atores existentes:");
                    for (int i = 0; i < atoresListEditar.size(); i++) {
                        System.out.println((i + 1) + " - " + atoresListEditar.get(i).getNome());
                    }

                    try {
                        System.out.print("Selecione o número do ator para editar: ");
                        int numAtorEditar = scanner.nextInt();
                        scanner.nextLine();

                        if (numAtorEditar < 1 || numAtorEditar > atoresListEditar.size()) {
                            throw new IllegalArgumentException("Número de ator inválido.");
                        }

                        Ator atorEditar = atoresListEditar.get(numAtorEditar - 1);

                        System.out.print("Novo nome do ator: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Nova idade do ator: ");
                        int novaIdade = scanner.nextInt();
                        scanner.nextLine();

                        AtorController.editarAtor(atorEditar, novoNome, novaIdade);
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, insira um número inteiro para a idade.");
                        scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Voltando ao Menu de Edição...");
                    return;

                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");

            }

        } while (opcao != 0);



    }

    public static void menuEditarFilme() {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n======= MENU DE EDIÇÃO DE FILMES =======");
            System.out.println("1 - Remover filme do sistema");
            System.out.println("2 - Editar filme existente");
            System.out.println("0 - Voltar ao menu de edição");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:

                    ArrayList<Filme> filmesListRemover = database.getListaFilmes();
                    if (filmesListRemover.isEmpty()) {
                        System.out.println("Nenhum filme cadastrado.");
                        break;
                    }

                    System.out.println("Filmes existentes:");
                    for (int i = 0; i < filmesListRemover.size(); i++) {
                        System.out.println((i + 1) + " - " + filmesListRemover.get(i).getTitulo());
                    }

                    try {
                        System.out.print("Selecione o número do filme para remover: ");
                        int numFilmeRemover = scanner.nextInt();
                        scanner.nextLine();

                        if (numFilmeRemover < 1 || numFilmeRemover > filmesListRemover.size()) {
                            throw new IllegalArgumentException("Número de filme inválido.");
                        }

                        Filme filmeRemover = filmesListRemover.get(numFilmeRemover - 1);
                        FilmeController.removerFilme(filmeRemover);

                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                        scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    ArrayList<Filme> filmesListEditar = database.getListaFilmes();
                    if (filmesListEditar.isEmpty()) {
                        System.out.println("Nenhum filme cadastrado.");
                        break;
                    }

                    System.out.println("Filmes existentes:");
                    for (int i = 0; i < filmesListEditar.size(); i++) {
                        System.out.println((i + 1) + " - " + filmesListEditar.get(i).getTitulo());
                    }

                    try {

                        System.out.print("Selecione o número do filme para editar: ");
                        int numFilmeEditar = scanner.nextInt();
                        scanner.nextLine();

                        if (numFilmeEditar < 1 || numFilmeEditar > filmesListEditar.size()) {
                            throw new IllegalArgumentException("Número de filme inválido.");
                        }

                        Filme filmeEditar = filmesListEditar.get(numFilmeEditar - 1);

                        System.out.print("Novo título do filme: ");
                        String novoTitulo = scanner.nextLine();

                        System.out.print("Nova sinopse do filme: ");
                        String novaSinopse = scanner.nextLine();

                        System.out.println("Gêneros disponíveis:");
                        Enums.Genero[] generos = Enums.Genero.values();
                        for (int i = 0; i < generos.length; i++) {
                            System.out.println((i + 1) + " - " + generos[i]);
                        }
                        System.out.print("Escolha o número do novo gênero do filme: ");
                        int opcaoGenero = scanner.nextInt();
                        scanner.nextLine();
                        if (opcaoGenero < 1 || opcaoGenero > generos.length) {
                            throw new IllegalArgumentException("Opção de gênero inválida.");
                        }
                        Enums.Genero novoGenero = generos[opcaoGenero - 1];

                        System.out.println("Classificações indicativas disponíveis:");
                        Enums.ClassificacaoIndicativa[] classificacoes = Enums.ClassificacaoIndicativa.values();
                        for (int i = 0; i < classificacoes.length; i++) {
                            System.out.println((i + 1) + " - " + classificacoes[i]);
                        }
                        System.out.print("Escolha o número da nova classificação indicativa do filme: ");
                        int opcaoClassificacao = scanner.nextInt();
                        scanner.nextLine();
                        if (opcaoClassificacao < 1 || opcaoClassificacao > classificacoes.length) {
                            throw new IllegalArgumentException("Opção de classificação indicativa inválida.");
                        }
                        Enums.ClassificacaoIndicativa novaClassificacao = classificacoes[opcaoClassificacao - 1];

                        System.out.println("Avaliações disponíveis:");
                        Enums.AvaliacaoFilme[] avaliacoes = Enums.AvaliacaoFilme.values();
                        for (int i = 0; i < avaliacoes.length; i++) {
                            System.out.println((i + 1) + " - " + avaliacoes[i]);
                        }
                        System.out.print("Escolha o número da nova avaliação do filme: ");
                        int opcaoAvaliacao = scanner.nextInt();
                        scanner.nextLine();
                        if (opcaoAvaliacao < 1 || opcaoAvaliacao > avaliacoes.length) {
                            throw new IllegalArgumentException("Opção de avaliação inválida.");
                        }
                        Enums.AvaliacaoFilme novaAvaliacao = avaliacoes[opcaoAvaliacao - 1];

                        System.out.println("Durações disponíveis:");
                        Enums.Duracao[] duracoes = Enums.Duracao.values();
                        for (int i = 0; i < duracoes.length; i++) {
                            System.out.println((i + 1) + " - " + duracoes[i]);
                        }
                        System.out.print("Escolha o número da nova duração do filme: ");
                        int opcaoDuracao = scanner.nextInt();
                        scanner.nextLine();
                        if (opcaoDuracao < 1 || opcaoDuracao > duracoes.length) {
                            throw new IllegalArgumentException("Opção de duração inválida.");
                        }
                        Enums.Duracao novaDuracao = duracoes[opcaoDuracao - 1];


                        System.out.print("Nova data de lançamento do filme (AAAA-MM-DD): ");
                        LocalDate novaDataDeLancamento = LocalDate.parse(scanner.nextLine());


                        FilmeController.editarFilme(filmeEditar, novoTitulo, novaSinopse, novoGenero, novaClassificacao, novaAvaliacao, novaDuracao, novaDataDeLancamento);
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                        scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de data inválido. Por favor, insira a data no formato correto (AAAA-MM-DD).");
                    }
                    break;

                case 0:
                    System.out.println("Voltando ao Menu de Edição...");
                    return;

                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");

            }

        } while (opcao != 0);

    }

}
