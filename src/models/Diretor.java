package models;

import util.Enums;

public class Diretor extends Pessoa {

    private Enums.AreaDiretor area;

    private String cpf;

    public Enums.AreaDiretor getArea() {
        return area;
    }

    private String getCpf() {
        return cpf;
    }

    public void setArea(Enums.AreaDiretor area) {
        this.area = area;
    }

    public Diretor(String nome, int idade, Enums.AreaDiretor area) {
        super(nome, idade);
        this.cpf = util.GeradorCPF.gerarCPF();
        this.area = area;


    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n Idade: " + this.getIdade() + "\n Identidade: " + this.getCpf() + "\n Área: " + this.getArea();
    }


}