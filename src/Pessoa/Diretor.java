package Pessoa;

public class Diretor {

    private String nome;
    private String area;
    private int idade;

    public Diretor(String nome, String area, int idade) {
        this.nome = nome;
        this.area = area;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
