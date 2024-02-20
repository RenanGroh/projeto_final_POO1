package Menu.Cadastro;

import Pessoa.Ator;
import Pessoa.Diretor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CadastroDiretor {

    private static Map<String, Diretor> diretores;


    public CadastroDiretor() {
        this.diretores = new HashMap<>();
    }

    public static void cadastrarDiretor(Scanner scanner) {
        Diretor diretor = new Diretor();

        if (!verificarExistencia(diretor)) {


            System.out.println("Entre o nome do diretor:");
            String name = scanner.nextLine();

            System.out.println("Entre a area do diretor:");
            String area = scanner.nextLine();

            System.out.println("Entre a idade do diretor:");
            int idade = Integer.parseInt(scanner.nextLine());

            diretor.setNome(name);
            diretor.setArea(area);
            diretor.setIdade(idade);

            System.out.println("diretor cadastrado com sucesso.");
        } else {
            System.out.println("diretor já cadastrado.");
        }
    }

    // metodos
    private static boolean verificarExistencia(Diretor diretor ) {
        return diretores.containsKey(diretor.getNome());
    }

}
