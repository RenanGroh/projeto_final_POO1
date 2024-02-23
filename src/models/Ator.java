package models;

import util.GeradorCPF;
public class Ator extends Pessoa {

    private String cpf;

    public Ator(String nome, int idade) {

        super(nome, idade);
        this.cpf = util.GeradorCPF.gerarCPF();
    }

    private String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n Idade: " + this.getIdade() + "\n Identidade: " + this.getCpf();
    }




}
