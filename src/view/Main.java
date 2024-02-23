package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.AtorController;
import controller.DiretorController;
import controller.FilmeController;
import menu.MenuBusca;
import menu.MenuCadastro;
import menu.MenuEdicao;
import models.Ator;
import models.Filme;
import database.database;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n======= MENU =======");
            System.out.println("1 - Menu de Busca");
            System.out.println("2 - Menu de Cadastro");
            System.out.println("3 - Menu de Edição");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    MenuBusca.menuBusca();
                    break;
                case 2:
                    MenuCadastro.menuCadastro();
                    break;
                case 3:
                    MenuEdicao.menuEdicao();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }
        } while (opcao != 0);

        scanner.close();
    }



}
