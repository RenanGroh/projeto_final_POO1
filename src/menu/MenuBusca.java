package menu;

import controller.AtorController;
import controller.DiretorController;
import controller.FilmeController;
import database.database;
import models.Filme;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuBusca {

    public static void menuBusca() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n======= MENU DE BUSCA =======");
            System.out.println("1 - Buscar Todos os Filmes");
            System.out.println("2 - Buscar Todos os Atores");
            System.out.println("3 - Buscar Todos os Diretores");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    ArrayList<String> nomesFilmes = FilmeController.buscarNomesFilmes();
                    if (nomesFilmes.isEmpty()) {
                        System.out.println("Nenhum filme cadastrado.");
                    } else {
                        System.out.println("Selecione o filme:");
                        for (int i = 0; i < nomesFilmes.size(); i++) {
                            System.out.println((i + 1) + " - " + nomesFilmes.get(i));
                        }
                        System.out.print("Escolha o número do filme para ver os detalhes: ");
                        try {
                            int escolha = scanner.nextInt();
                            scanner.nextLine();
                            if (escolha >= 1 && escolha <= nomesFilmes.size()) {

                                String nomeFilmeSelecionado = nomesFilmes.get(escolha - 1);

                                Filme filmeSelecionado = database.getListaFilmes().stream()
                                        .filter(filme -> filme.getTitulo().equals(nomeFilmeSelecionado))
                                        .findFirst()
                                        .orElse(null);
                                if (filmeSelecionado != null) {
                                    System.out.println(filmeSelecionado);
                                } else {
                                    System.out.println("Filme não encontrado.");
                                }
                            } else {
                                System.out.println("Opção inválida. Escolha um número válido.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, insira um número.");
                            scanner.nextLine();
                        }
                        break;
                    }
                    break;
                case 2:
                    AtorController.buscarTodosOsAtores();
                    break;
                case 3:
                    DiretorController.buscarTodosDiretores();
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
