package controller;

import models.Ator;
import database.database;
import models.Diretor;
import models.Filme;

import java.util.ArrayList;

public class AtorController {

    public static void adicionarAtorSistema(String nome, int idade) {
        Ator ator = new Ator(nome, idade);
        database.getListaAtores().add(ator);
        System.out.println("Ator cadastrado com sucesso!");
    }

    public static void removerAtorSistema(Ator ator) {
        ArrayList<Ator> listaAtores = database.getListaAtores();

        if (listaAtores.contains(ator)) {
            listaAtores.remove(ator);
            System.out.println("Ator removido com sucesso!");
        }
            else {
                System.out.println("Ator não encontrado.");
            }
        }

    public static void buscarTodosOsAtores() {
        ArrayList<Ator> listaAtores = database.getListaAtores();

        if (listaAtores.isEmpty()) {
            System.out.println("Nenhum ator cadastrado.");
        } else {
            System.out.println("Atores cadastrados:");

            for (Ator ator : listaAtores) {
                System.out.println(ator.toString());
            }
        }
    }

    public static void associarAtorAFilme(Ator ator, Filme filme) {
        if (database.getListaAtores().contains(ator) && database.getListaFilmes().contains(filme)) {
            if (filme.getAtores() == null) {
                filme.setAtores(new ArrayList<>());
            }
            filme.getAtores().add(ator);
            System.out.println("Ator associado ao filme com sucesso!");
        } else {
            System.out.println("Ator ou filme não encontrado no sistema.");
        }
    }

    public static void desassociarAtorAFilme(Ator ator, Filme filme) {
        ArrayList<Filme> listaFilmes = database.getListaFilmes();


        if (listaFilmes.contains(filme)) {

            filme.getAtores().remove(ator);
            System.out.println("Ator desassociado do filme com sucesso!");
        } else {
            System.out.println("Filme não encontrado no sistema.");
        }
    }

    public static void editarAtor(Ator ator, String novoNome, int novaIdade) {

        if (database.getListaAtores().contains(ator)) {

            ator.setNome(novoNome);
            ator.setIdade(novaIdade);

            System.out.println("Ator editado com sucesso!");
        } else {
            System.out.println("Ator não encontrado.");
        }
    }




    }

    // Outros métodos relacionados a atores, como remover, buscar, etc.
