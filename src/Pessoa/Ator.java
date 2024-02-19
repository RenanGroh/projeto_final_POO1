package Pessoa;

public class Ator {

    private String nome;
    private String identidade;
    private int idade;

    public Ator() {
        // construtor sem parametros
    }

    // Constructor with parameters
    public Ator(String nome, String identidade, int idade) {
        this.nome = nome;
        this.identidade = identidade;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}

