package com.banco.senac.projetobanco.telas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCriarConta {
    Scanner console = new Scanner(System.in);

		do {
        System.out.println("digite a opção que deseja:");
        System.out.println("Opção 1 - cadastrar Clientes (Pessoa Física ou Pessoa Jurídica)");
        System.out.println("Opção 2 - listar Clientes");
        System.out.println("Opção 0 - retornar ao Menu Principal");

        int opcao;

        try {
            opcao = console.nextInt();
            console.nextLine();
        } catch (InputMismatchException excecao) {
            opcao = -1;
        }
        switch (opcao) {
            case 1:
                this.cadastrarCliente(console);
                break;
            case 2:
                this.listarClientes(console);
                break;
            case 0:
                System.out.println("Voltando ao Menu Principal...");
                return;
            default:
                System.out.println("Opção inválida.");
        }
    } while (true);


}
