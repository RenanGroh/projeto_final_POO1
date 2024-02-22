package menu.cadastro;

import pessoa.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CadastroAtor {

    private static Map<String, Ator> atores;

    Scanner scanner;

    public CadastroAtor() {
        this.atores = new HashMap<>();
    }

    public static void cadastrarAtor(Scanner scanner) {
        Ator ator = new Ator();

        if (!verificarExistencia(ator)) {


            System.out.println("Entre o nome do ator:");
            String name = scanner.nextLine();

            System.out.println("Entre a identidade do ator:");
            String identidade = scanner.nextLine();

            System.out.println("Entre a idade do ator:");
            int idade = Integer.parseInt(scanner.nextLine());

            ator.setNome(name);
            ator.setIdentidade(identidade);
            ator.setIdade(idade);

            System.out.println("Ator cadastrado com sucesso.");
        } else {
            System.out.println("Ator já cadastrado.");
        }
    }

    // metodos
    private static boolean verificarExistencia(Ator ator) {
        return atores.containsKey(ator.getIdentidade());
    }


}
