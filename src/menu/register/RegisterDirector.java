package menu.register;


import util.EnumTipoDiretor;

import java.util.ArrayList;
import java.util.Scanner;

public class RegisterDirector {

    private List<Diretor> diretores;

    public RegisterDirector() {
        diretores = new ArrayList<>();
    }

    public void catalogDirector(Scanner scanner) {
        System.out.println("Cadastro de Diretor");

        System.out.print("Nome do Diretor: ");
        String nome = scanner.nextLine();

        if (diretorJaCadastrado(nome)) {
            System.out.println("Um diretor com este nome já foi cadastrado.");
            return;
        }

        EnumTipoDiretor tipo = escolherTipoDiretor(scanner);

        Diretor diretor = new Diretor(nome, tipo);
        diretores.add(diretor);

        System.out.println("Diretor cadastrado com sucesso!");
    }

    private boolean diretorJaCadastrado(String nome) {
        return diretores.stream().anyMatch(diretor -> diretor.getNome().equalsIgnoreCase(nome));
    }

    private EnumTipoDiretor escolherTipoDiretor(Scanner scanner) {
        EnumTipoDiretor tipo = null;

        while (tipo == null) {
            System.out.println("Escolha o tipo de diretor:");
            for (EnumTipoDiretor tp : EnumTipoDiretor.values()) {
                System.out.println(tp.name());
            }

            String escolha = scanner.nextLine();
            try {
                tipo = EnumTipoDiretor.valueOf(escolha.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de diretor inválido. Por favor, tente novamente.");
            }
        }

        return tipo;

    }

    public Diretor buscarDiretor(String nome) {
        for (Diretor diretor : diretores) {
            if (diretor.getNome().equalsIgnoreCase(nome)) {
                return diretor;
            }
        }
        return null; // Retorna null se o diretor não for encontrado
    }
}