package Filme;

public class Filme {

    private String titulo;
    private String sinopse;
    private String origem;
    private String generos;
    private Double avaliacao;
    private String duracao;
    private String ano;

    public Filme(){
        // construtor sem parametros
    }

    public Filme(String titulo, String sinopse, String origem, String generos, Double avaliacao, String duracao, String ano) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.origem = origem;
        this.generos = generos;
        this.avaliacao = avaliacao;
        this.duracao = duracao;
        this.ano = ano;
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

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getGeneros() {
        return generos;
    }

    public void setGeneros(String generos) {
        this.generos = generos;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
