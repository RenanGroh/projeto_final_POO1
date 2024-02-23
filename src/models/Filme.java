package models;

import util.Enums;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static database.database.getListaAtores;
import static database.database.getListaDiretores;

public class Filme {
    private String titulo;
    private String sinopse;
    private Enums.Genero genero;

    private Enums.ClassificacaoIndicativa classificacaoIndicativa;
    private Enums.AvaliacaoFilme avaliacaoFilme;
    private Enums.Duracao duracao;
    private LocalDate dataDeLancamento;
    private ArrayList<Diretor> diretores;
    private ArrayList<Ator> atores;

    public Filme(String titulo, String sinopse, Enums.Genero genero, Enums.ClassificacaoIndicativa classificacaoIndicativa, Enums.AvaliacaoFilme avaliacaoFilme, Enums.Duracao duracao, LocalDate dataDeLancamento) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.genero = genero;
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.avaliacaoFilme = avaliacaoFilme;
        this.duracao = duracao;
        this.dataDeLancamento = dataDeLancamento;
        this.diretores = getListaDiretores();
        this.atores = getListaAtores();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Enums.Genero getGenero() {
        return genero;
    }

    public void setGenero(Enums.Genero genero) {
        this.genero = genero;
    }

    public Enums.ClassificacaoIndicativa getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(Enums.ClassificacaoIndicativa classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public Enums.AvaliacaoFilme getAvaliacaoFilme() {
        return avaliacaoFilme;
    }

    public void setAvaliacaoFilme(Enums.AvaliacaoFilme avaliacaoFilme) {
        this.avaliacaoFilme = avaliacaoFilme;
    }

    public Enums.Duracao getDuracao() {
        return duracao;
    }

    public void setDuracao(Enums.Duracao duracao) {
        this.duracao = duracao;
    }

    public LocalDate getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(LocalDate dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    public ArrayList<Diretor> getDiretores() {
        return diretores;
    }

    public void setDiretores(ArrayList<Diretor> diretores) {
        this.diretores = diretores;
    }

    public ArrayList<Ator> getAtores() {
        return atores;
    }

    public void setAtores(ArrayList<Ator> atores) {
        this.atores = atores;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Título: ").append(titulo).append("\n");
        stringBuilder.append("Sinopse: ").append(sinopse).append("\n");
        stringBuilder.append("Gênero: ").append(genero).append("\n");
        stringBuilder.append("Classificação Indicativa: ").append(classificacaoIndicativa).append("\n");
        stringBuilder.append("Avaliação: ").append(avaliacaoFilme).append("\n");
        stringBuilder.append("Duração: ").append(duracao).append("\n");
        stringBuilder.append("Data de Lançamento: ").append(dataDeLancamento).append("\n");
        stringBuilder.append("Diretores: ").append(diretores).append("\n");
        stringBuilder.append("Atores: ").append(atores).append("\n");
        return stringBuilder.toString();
    }

}
