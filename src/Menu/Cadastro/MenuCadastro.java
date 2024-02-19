package Menu.Cadastro;

import Menu.Cadastro.*;

import java.util.Scanner;

public class MenuCadastro {

    private CadastroAtor cadastroAtor;
    private CadastroFilme cadastroFilme;
    private CadastroDiretor cadastroDiretor;
    private Scanner scanner;

    public MenuCadastro() {
        cadastroAtor = new CadastroAtor();
        cadastroFilme = new CadastroFilme();
        //cadastroDiretor = new CadastroDiretor();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n--- Menu de Cadastro ---");
            System.out.println("1. Cadastrar Ator");
            System.out.println("2. Cadastrar Diretor");
            System.out.println("3. Cadastrar Filme");
            System.out.println("4. Sair");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    CadastroAtor.cadastrarAtor(scanner);
                    break;
                case 2:
                    // chamar cadastro do diretor
                    break;
                case 3:
                    // chamar cadastro do filme
                    break;
                case 4:
                    System.out.println("Saindo no menu.");
                    return;
                default:
                    System.out.println("Opção invalida");
            }
        }
    }

    public static void main(String[] args) {
        MenuCadastro menu = new MenuCadastro();
        menu.mostrarMenu();
    }

}
