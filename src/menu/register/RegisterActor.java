package menu.register;

import util.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class RegisterActor {

    private AList<Ator> atores;

    public RegisterActor() {
        atores = new ArrayList<>();
    }

    public void catalogActor(Scanner scanner) {
        System.out.println("--- Cadastro de Ator ---");

        System.out.print("Nome do Ator: ");
        String nome = scanner.nextLine();

        System.out.print("Documento (CPF): ");
        String documento = scanner.nextLine();

        if (!ValidadorCPF.validarCPF(documento)) {
            System.out.println("CPF inválido.");
            return; // Interrompe o cadastro se o CPF for inválido
        }

        if (atorJaCadastrado(nome, documento)) {
            System.out.println("Um ator com este nome ou documento já foi cadastrado.");
        } else {
            Ator ator = new Ator(nome, documento);
            atores.add(ator);
            System.out.println("Ator cadastrado com sucesso!");
        }

        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        LocalDate dataNascimento = null;
        while (dataNascimento == null) {
            String dataNascimentoStr = scanner.nextLine();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Por favor, insira a data no formato dd/MM/yyyy.");
            }
        }

    }


    private boolean atorJaCadastrado(String nome, String documento) {
        for (Ator ator : atores) {
            if (ator.getNome().equalsIgnoreCase(nome) || ator.getDocumento().equals(documento)) {
                return true;
            }
        }
        return false;
    }

    public Ator buscarAtor(String nome) {
        for (Ator ator : atores) {
            if (ator.getNome().equalsIgnoreCase(nome)) {
                return ator;
            }
        }
        return null;

    }
}
