package controller;

import models.*;
import models.Diretor;
import models.Diretor;
import database.database;
import util.Enums;

import java.util.ArrayList;

public class DiretorController {

    public static void adicionarDiretor(String nome, int idade, Enums.AreaDiretor area) {
        Diretor diretor = new Diretor(nome, idade, area);
        database.getListaDiretores().add(diretor);
        System.out.println("Diretor cadastrado com sucesso!");

    }

    public static void exibirAreasDiretor() {
        System.out.println("Escolha a área do diretor:");
        for (Enums.AreaDiretor area : Enums.AreaDiretor.values()) {
            System.out.println((area.ordinal() + 1) + " - " + area);
        }
    }

    public static void removerDiretorSistema(Diretor diretor) {
        ArrayList<Diretor> listaDiretores = database.getListaDiretores();

        if (listaDiretores.contains(diretor)) {
            listaDiretores.remove(diretor);
            System.out.println("Diretor removido com sucesso!");
        }
        else {
            System.out.println("Diretor não encontrado.");
        }
    }

    public static void buscarTodosDiretores() {
        ArrayList<Diretor> listaDiretores = database.getListaDiretores();

        if (listaDiretores.isEmpty()) {
            System.out.println("Nenhum diretor cadastrado.");
        } else {
            System.out.println("Diretores cadastrados: ");

            for (Diretor diretor : listaDiretores) {
                System.out.println(diretor.toString());
            }
        }
    }

    public static void associarDiretorAFilme(Diretor diretor, Filme filme) {
        if (database.getListaDiretores().contains(diretor) && database.getListaFilmes().contains(filme)) {
            if (filme.getDiretores() == null) {
                filme.setDiretores(new ArrayList<>());
            }
            filme.getDiretores().add(diretor);
            System.out.println("Diretor associado ao filme com sucesso!");
        } else {
            System.out.println("Diretor ou filme não encontrado no sistema.");
        }
    }


    public static void desassociarDiretorAFilme(Diretor diretor, Filme filme) {
        ArrayList<Filme> listaFilmes = database.getListaFilmes();


        if (listaFilmes.contains(filme)) {

            filme.getDiretores().remove(diretor);
            System.out.println("Diretor desassociado do filme com sucesso!");
        } else {
            System.out.println("Filme não encontrado no sistema.");
        }
    }

    public static void editarDiretor(Diretor diretor, String novoNome, int novaIdade, Enums.AreaDiretor novaArea) {

        if (database.getListaDiretores().contains(diretor)) {

            diretor.setNome(novoNome);
            diretor.setIdade(novaIdade);
            diretor.setArea(novaArea);
            System.out.println("Diretor editado com sucesso!");
        } else {
            System.out.println("Diretor não encontrado.");
        }
    }



}
