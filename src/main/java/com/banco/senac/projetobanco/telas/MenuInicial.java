package com.banco.senac.projetobanco.telas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuInicial {

    public void imprimirMenuInicial() {
        Scanner console = new Scanner(System.in);

        do {
            System.out.println("Bem vindo ao Banco Senac Tech");
            System.out.println("1) Acessar conta");
            System.out.println("2) Criar conta");
            System.out.println("3) Deletar conta");
            System.out.println("0) Sair");
            System.out.println("Escolha uma opção");

            int opcao;

            try {
                opcao = console.nextInt();
                console.nextLine();
            } catch (InputMismatchException excecao) {
                opcao = -1;
            }
            switch (opcao) {
                case 1:
                    System.out.println("Acessando conta...");
                    MenuAcessarConta tela1 = new MenuAcessarConta();
                    tela1.AcessarConta();
                    break;
                case 2:
                    System.out.println("Criando conta...");
                    MenuCriarConta tela2 = new MenuCriarConta();
                    tela2.imprimirTelaConta();
                    break;
                case 3:
                    System.out.println("Indo para Tela de Locações...");
                    break;
                case 0:
                    System.out.println("Programa encarrado...");
                    console.close();
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        } while (true);

    }
}
