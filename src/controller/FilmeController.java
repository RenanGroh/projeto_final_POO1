package controller;


import models.Ator;
import models.Diretor;
import models.Filme;
import java.util.ArrayList;
import java.util.List;

public class FilmeController {
    private List<Filme> filmes;

    public List<Filme> getFilmes() {
        return filmes;
    }

    public List<Ator> getAtores() {
        List<Ator> atores = new ArrayList<>();
        for (Filme filme : filmes) {
            atores.addAll(filme.getAtores());
        }
        return atores;
    }
    public List<Diretor> getDiretores() {
        List<Diretor> diretores = new ArrayList<>();
        for (Filme filme : filmes) {
            diretores.addAll(filme.getDiretores());
        }
        return diretores;
    }

    public FilmeController() {
        this.filmes = new ArrayList<>();
    }

    public void cadastrarFilme(String titulo, String sinopse, String origem, String genero, double avaliacao, String duracao, int ano) {
        Filme filme = new Filme(titulo, sinopse, origem, genero, avaliacao, duracao, ano);
        filmes.add(filme);
    }

    public void cadastrarAtor(String nome, int idade, String cpf) {
        Ator ator = new Ator(nome, idade, cpf);

    }

    public void cadastrarDiretor(String nome, int idade, String cpf, String area) {
        Diretor diretor = new Diretor(nome, idade, cpf, area);

    }

    public void associarAtorAoFilme(Ator ator, Filme tituloFilme) {
        for (Filme filme : filmes) {
            if (filme.getTitulo().equals(tituloFilme)) {
                filme.adicionarAtor(ator);
                return;
            }
        }
        System.out.println("Filme não encontrado.");
    }

    public void associarDiretorAoFilme(Diretor diretor, Filme tituloFilme) {
        for (Filme filme : filmes) {
            if (filme.getTitulo().equals(tituloFilme)) {
                filme.adicionarDiretor(diretor);
                return;
            }
        }
        System.out.println("Filme não encontrado.");
    }
}