package Menu.Cadastro;

import Filme.Filme;
import Pessoa.Diretor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CadastroFilme {

    private static Map<String, Filme> filmes;

    public CadastroFilme() {
        this.filmes = new HashMap<>();
    }

    public static void cadastrarFilme(Scanner scanner) {
        Filme filme = new Filme();

        if (!verificarExistencia(filme)) {


            System.out.println("Entre o Titulo:");
            String name = scanner.nextLine();

            System.out.println("Entre a sinopse:");
            String sinopse = scanner.nextLine();

            System.out.println("Entre a Origem:");
            String origem = scanner.nextLine();

            System.out.println("Entre os generos:");
            String generos = scanner.nextLine();

            System.out.println("Entre a avaliacao:");
            double avaliacao = Double.parseDouble(scanner.nextLine());

            System.out.println("Entre a duraçao:");
            String duracao = scanner.nextLine();

            System.out.println("Entre o ano:");
            String ano = scanner.nextLine();

            filme.setTitulo(name);
            filme.setSinopse(sinopse);
            filme.setOrigem(origem);
            filme.setGeneros(generos);
            filme.setAvaliacao(avaliacao);
            filme.setDuracao(duracao);
            filme.setAno(ano);

            System.out.println("diretor cadastrado com sucesso.");
        } else {
            System.out.println("diretor já cadastrado.");
        }
    }

    // metodos
    private static boolean verificarExistencia(Filme filme) {
        return filmes.containsKey(filme.getTitulo());
    }

}
