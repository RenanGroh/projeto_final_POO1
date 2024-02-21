package models;
public class Pessoa {

    private String nome;
    private int idade;
    private String identidade;

    public Pessoa(String nome, int idade, String identidade) {
        validaString(nome, "Nome");
        validaIdade(idade);
        validaString(identidade, "Documento");

        this.nome = nome;
        this.idade = idade;
        this.identidade = identidade;
    }

    // GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validaString(nome, "Nome");
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        validaIdade(idade);
        this.idade = idade;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        validaString(identidade, "Documento");
        this.identidade = identidade;
    }


    // VALIDAÇÕES
    private static void validaString(String valor, String nomeAtributo) {
        if (valor == null || valor.isEmpty()) {
            throw new IllegalArgumentException(nomeAtributo + " inválido!");
        }
    }

    private void validaIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade inválida!");
        }
    }
}