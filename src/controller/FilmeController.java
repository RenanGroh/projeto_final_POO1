package controller;


import models.Filme;
import database.database;
import util.Enums;

import java.time.LocalDate;
import java.util.ArrayList;

public class FilmeController {

    public static void cadastrarFilme(String titulo, String sinopse, Enums.Genero genero, Enums.ClassificacaoIndicativa classificacaoIndicativa, Enums.AvaliacaoFilme avaliacaoFilme, Enums.Duracao duracao, LocalDate dataDeLancamento) {
        Filme filme = new Filme(titulo, sinopse, genero, classificacaoIndicativa, avaliacaoFilme, duracao, dataDeLancamento);
        database.getListaFilmes().add(filme);
        System.out.println("Filme cadastrado com sucesso!");
    }

    public static void removerFilme(Filme filme){
        ArrayList<Filme> listaFilmes = database.getListaFilmes();

        if (listaFilmes.contains(filme)) {
            listaFilmes.remove(filme);
            System.out.println("Filme removido com sucesso!");
        }
        else {
            System.out.println("Filme não encontrado!");
        }
    }



    public static ArrayList<String> buscarNomesFilmes() {
        ArrayList<String> nomesFilmes = new ArrayList<>();
        for (Filme filme : database.getListaFilmes()) {
            nomesFilmes.add(filme.getTitulo());
        }
        return nomesFilmes;
    }

    public static void editarFilme(Filme filme, String novoTitulo, String novaSinopse, Enums.Genero novoGenero,
                                   Enums.ClassificacaoIndicativa novaClassificacaoIndicativa, Enums.AvaliacaoFilme novaAvaliacaoFilme,
                                   Enums.Duracao novaDuracao, LocalDate novaDataDeLancamento) {

        if (database.getListaFilmes().contains(filme)) {
            filme.setTitulo(novoTitulo);
            filme.setSinopse(novaSinopse);
            filme.setGenero(novoGenero);
            filme.setClassificacaoIndicativa(novaClassificacaoIndicativa);
            filme.setAvaliacaoFilme(novaAvaliacaoFilme);
            filme.setDuracao(novaDuracao);
            filme.setDataDeLancamento(novaDataDeLancamento);
            System.out.println("Filme editado com sucesso!");

        } else {
            System.out.println("Filme não encontrado.");
        }
    }


}
