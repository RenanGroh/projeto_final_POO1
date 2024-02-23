package menu;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuCadastro {

    public static void menuCadastro() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n======= MENU DE CADASTRO =======");
            System.out.println("1 - Cadastrar Filme");
            System.out.println("2 - Cadastrar Ator");
            System.out.println("3 - Cadastrar Diretor");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o título do filme:");
                    String titulo = scanner.nextLine();
                    System.out.println("Digite a sinopse do filme:");
                    String sinopse = scanner.nextLine();

                    System.out.println("Escolha o gênero do filme:");
                    Enums.Genero[] generos = Enums.Genero.values();
                    for (int i = 0; i < generos.length; i++) {
                        System.out.println((i + 1) + " - " + generos[i]);
                    }
                    System.out.print("Escolha uma opção: ");
                    int escolhaGenero = scanner.nextInt();
                    Enums.Genero generoEscolhido = generos[escolhaGenero - 1];

                    System.out.println("Escolha a classificação indicativa do filme:");
                    Enums.ClassificacaoIndicativa[] classificacaoIndicativas = Enums.ClassificacaoIndicativa.values();
                    for (int i = 0; i < classificacaoIndicativas.length; i++) {
                        System.out.println((i + 1) + " - " + classificacaoIndicativas[i]);
                    }
                    System.out.print("Escolha uma opção: ");
                    int escolhaClassificacao = scanner.nextInt();
                    Enums.ClassificacaoIndicativa classificacaoEscolhida = classificacaoIndicativas[escolhaClassificacao - 1];

                    System.out.println("Escolha a avaliação do filme:");
                    Enums.AvaliacaoFilme[] avaliacaoFilmes = Enums.AvaliacaoFilme.values();
                    for (int i = 0; i < avaliacaoFilmes.length; i++) {
                        System.out.println((i + 1) + " - " + avaliacaoFilmes[i]);
                    }
                    System.out.print("Escolha uma opção: ");
                    int escolhaAvaliacao = scanner.nextInt();
                    Enums.AvaliacaoFilme avaliacaoEscolhida = avaliacaoFilmes[escolhaAvaliacao - 1];


                    System.out.println("Escolha a duração do filme:");
                    Enums.Duracao[] duracaoFilmes = Enums.Duracao.values();
                    for (int i = 0; i < duracaoFilmes.length; i++) {
                        System.out.println((i + 1) + " - " + duracaoFilmes[i]);
                    }
                    System.out.print("Escolha uma opção: ");
                    int escolhaDuracao = scanner.nextInt();
                    Enums.Duracao duracaoEscolhida = duracaoFilmes[escolhaDuracao - 1];
                    scanner.nextLine();

                    System.out.println("Informe a data de lançamento do filme (formato: AAAA-MM-DD):");
                    String dataLancamentoStr = scanner.nextLine();

                    LocalDate dataLancamento = LocalDate.parse(dataLancamentoStr);


                    FilmeController.cadastrarFilme(titulo, sinopse, generoEscolhido, classificacaoEscolhida, avaliacaoEscolhida, duracaoEscolhida, dataLancamento);
                    break;
                case 2:
                    System.out.println("Digite o nome do ator:");
                    String nomeAtor = scanner.nextLine();
                    System.out.println("Digite a idade do ator:");
                    int idadeAtor = scanner.nextInt();
                    AtorController.adicionarAtorSistema(nomeAtor, idadeAtor);
                    break;
                case 3:
                    System.out.print("Nome do diretor: ");
                    String nomeDiretor = scanner.nextLine();
                    System.out.print("Idade do diretor: ");
                    int idadeDiretor = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Escolha a área do diretor:");
                    exibirAreasDiretor();
                    int escolhaArea = scanner.nextInt();
                    scanner.nextLine();
                    Enums.AreaDiretor areaDiretor = Enums.AreaDiretor.values()[escolhaArea - 1];
                    DiretorController.adicionarDiretor(nomeDiretor, idadeDiretor, areaDiretor);
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    return;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

}
