package menu.register;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RegisterMenu {

    private RegisterActor registerActor;
    private RegisterDirector registerDirector;
    private RegisterMovie registerMovie;
    private Scanner scanner;

    public MenuCadastro() {
        registerActor = new RegisterActor();
        registerDirector = new RegisterDirector();
        registerMovie = new RegisterMovie();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n--- Menu de Cadastro ---");
            System.out.println("1. Cadastrar Ator");
            System.out.println("2. Cadastrar Diretor");
            System.out.println("3. Cadastrar Filme");
            System.out.println("4. Sair");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    RegisterActor.catalogActor(scanner);
                    break;
                case 2:
                    RegisterDirector.catalogDirector(scanner);
                    break;
                case 3:
                    RegisterMovie.catalogMovie(scanner);
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
        RegisterMenu menu = new RegisterMenu();
        menu.showMenu();
    }

}
