package menu.register;


import util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RegisterMovie {

    private List<Filme> filmes;
    private RegisterActor registerActor;
    private RegisterDirector registerDirector;

    public RegisterMovie(List<Filme> filmes, RegisterActor registerActor, RegisterDirector registerDirector) {
        this.filmes = filmes;
        this.registerActor = registerActor;
        this.registerDirector = registerDirector;
    }

    public void catalogMovie(Scanner scanner) {

        System.out.println("--- Cadastro de Filme ---");

        System.out.print("Titulo do Filme: ");
        String titulo = scanner.nextLine();

        if (!checkExistence(titulo)) {


            System.out.print("Sinopse do Filme: ");
            String sinopse = scanner.nextLine();

            Set<Genero> generos = escolherGeneros(scanner); // criar private Set<Genero> generos; na classe filme
            EnumClassificacaoIndicativa classificacao = escolherClassificacao(scanner);
            LocalDate dataLancamento = escolherDataLancamento(scanner);
            EnumDuracao duracao = escolherDuracao(scanner);
            Map<String, Diretor> diretoresNoFilme = selecionarDiretores(scanner, registerDirector);
            List<Ator> atoresNoFilme = cadastrarAtores(scanner);
            System.out.print("Avaliação do Filme (0.0 a 10.0): ");
            double avaliacao = cadastrarAvaliacao(scanner);


            Filme filme = new Filme(titulo, sinopse, generos, classificacao, dataLancamento, duracao, diretoresNoFilme, atoresNoFilme, avaliacao);
            filmes.add(filme);

            System.out.println("Filme cadastrado com sucesso!");
        } else {
            System.out.println("Um filme com esse título já existe.");
        }
    }

    // methods
    private boolean checkExistence(String titulo) {
        return filmes.stream().anyMatch(filme -> filme.getTitulo().equalsIgnoreCase(titulo));
    }

    private Set<Genero> escolherGeneros(Scanner scanner) {
        Set<Genero> generosSelecionados = new HashSet<>();
        System.out.println("Selecione os gêneros do filme (separe por vírgula):");
        for (Genero genero : Genero.values()) {
            System.out.println(genero.name());
        }

        String[] generosInput = scanner.nextLine().split(",");
        for (String g : generosInput) {
            try {
                Genero genero = Genero.valueOf(g.trim().toUpperCase());
                generosSelecionados.add(genero);
            } catch (IllegalArgumentException e) {
                System.out.println("Gênero não encontrado: " + g);
            }
        }
        return generosSelecionados;
    }

    private EnumClassificacaoIndicativa escolherClassificacao(Scanner scanner) {
        EnumClassificacaoIndicativa enumClassificacaoIndicativa = null;

        while (enumClassificacaoIndicativa == null) {
            System.out.println("Selecione a classificação indicativa do filme:");
            for (EnumClassificacaoIndicativa classificacao : EnumClassificacaoIndicativa.values()) {
                System.out.println(classificacao.name());
            }

            String classificacaoInput = scanner.nextLine();

            try {
                enumClassificacaoIndicativa = EnumClassificacaoIndicativa.valueOf(classificacaoInput.trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Classificação não encontrada: " + classificacaoInput + ". Por favor, tente novamente.");
            }
        }

        return enumClassificacaoIndicativa;
    }

    private LocalDate escolherDataLancamento(Scanner scanner) {
        LocalDate dataLancamento = null;

        while (dataLancamento == null) {
            System.out.print("Data de lançamento (dd/MM/yyyy): ");
            String dataLancamentoInput = scanner.nextLine();

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dataLancamento = LocalDate.parse(dataLancamentoInput, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida: " + dataLancamentoInput + ". Por favor, insira uma data válida.");
            }
        }

        return dataLancamento;
    }

    private EnumDuracao escolherDuracao(Scanner scanner) {
        EnumDuracao enumDuracao = null;

        while (enumDuracao == null) {
            System.out.println("Selecione a duração filme:");
            for (EnumDuracao duracao : EnumDuracao.values()) {
                System.out.println(duracao.name());
            }

            String duracaoInput = scanner.nextLine();

            try {
                enumDuracao = EnumDuracao.valueOf(duracaoInput.trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Duraçao não encontrada: " + duracaoInput + ". Por favor, tente novamente.");
            }
        }

        return enumDuracao;
    }

    private Map<EnumTipoDiretor, Diretor> selecionarDiretores(Scanner scanner, RegisterDirector registerDirector) {
        Map<EnumTipoDiretor, Diretor> diretoresSelecionados = new HashMap<>();

        for (EnumTipoDiretor tipo : EnumTipoDiretor.values()) {
            System.out.println("Selecionando: " + tipo.name());

            // Listar diretores cadastrados
            System.out.println("Diretores já cadastrados:");
            for (Diretor diretor : registerDirector.getDiretores()) {
                System.out.println(diretor.getNome());
            }

            System.out.println("Digite o nome do diretor ou 'novo' para cadastrar um novo:");
            String nomeDiretor = scanner.nextLine();

            if ("novo".equalsIgnoreCase(nomeDiretor)) {
                registerDirector.catalogDirector(scanner);
                continue; // Volta para o início do loop para selecionar o diretor recém-cadastrado
            }

            Diretor diretor = registerDirector.buscarDiretor(nomeDiretor);
            if (diretor != null) {
                diretoresSelecionados.put(tipo, diretor);
            } else {
                System.out.println("Diretor não encontrado: " + nomeDiretor);
            }
        }

        return diretoresSelecionados;
    }

    private List<Ator> cadastrarAtores(Scanner scanner) {
        List<Ator> atoresSelecionados = new ArrayList<>();

        // Mostrar a lista de atores cadastrados
        System.out.println("Atores já cadastrados:");
        for (Ator ator : registerActor.getAtores()) {
            System.out.println(ator.getNome());
        }

        System.out.println("Digite os nomes dos atores separados por vírgula:");
        String entrada = scanner.nextLine();
        String[] nomesAtores = entrada.split(",");

        for (String nomeAtor : nomesAtores) {
            nomeAtor = nomeAtor.trim();

            Ator ator = registerActor.buscarAtor(nomeAtor);
            if (ator != null) {
                atoresSelecionados.add(ator);
            } else {
                System.out.println("Ator não encontrado: " + nomeAtor);
                System.out.println("Deseja cadastrá-lo agora? (sim/não)");
                String resposta = scanner.nextLine();
                if ("sim".equalsIgnoreCase(resposta)) {
                    registerActor.catalogActor(scanner); // Supõe-se que este método faz o cadastro
                    ator = registerActor.buscarAtor(nomeAtor); // Buscar novamente após o cadastro
                    if (ator != null) {
                        atoresSelecionados.add(ator);
                    }
                }
            }
        }

        return atoresSelecionados;
    }


    private double cadastrarAvaliacao(Scanner scanner) {
        double avaliacao = 0.0;
        boolean avaliacaoValida = false;

        while (!avaliacaoValida) {
            try {
                System.out.print("Avaliação do Filme (0.0 a 10.0): ");
                avaliacao = scanner.nextDouble();

                if (avaliacao < 0.0 || avaliacao > 10.0) {
                    System.out.println("Avaliação deve estar entre 0.0 e 10.0. Tente novamente.");
                } else {
                    avaliacaoValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido.");
                scanner.nextLine(); // Descartar entrada inválida
            }
        }
        return avaliacao;
    }}

}