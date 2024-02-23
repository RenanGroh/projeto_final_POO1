package models;
public class Pessoa {

    private String nome;
    private int idade;
    private String identidade;

    public Pessoa(String nome, int idade) {
        validaString(nome, "Nome");
        validaIdade(idade);


        this.nome = nome;
        this.idade = idade;
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