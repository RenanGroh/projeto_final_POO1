package database;

import models.*;
import util.*;
import controller.*;
import view.*;

import java.util.ArrayList;
public class database {

    // Lista com todos os atores

    private final static ArrayList<Ator> listaAtores = new ArrayList<>();

    // Lista com todos os diretores

    private final static ArrayList<Diretor> listaDiretores = new ArrayList<>();


    // Lista com todos os filmes
    private final static ArrayList<Filme> listaFilmes = new ArrayList<Filme>();

    public static ArrayList<Diretor> getListaDiretores() {
        return listaDiretores;
    }

    public static ArrayList<Ator> getListaAtores() {
        return listaAtores;
    }

    public static ArrayList<Filme> getListaFilmes() {
        return listaFilmes;
    }

}
