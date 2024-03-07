package com.banco.senac.projetobanco.telas;

import com.banco.senac.projetobanco.database.CadastrarConta;
import com.banco.senac.projetobanco.model.ContaBancaria;
import com.banco.senac.projetobanco.model.enums.TipoPessoa;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuAcessarConta {
    int numConta;
    int senhaConta;
    ContaBancaria conta;
    Scanner console = new Scanner(System.in);
    CadastrarConta cadastro = CadastrarConta.criar();
    List<ContaBancaria> contas = cadastro.getContas();
    public void AcessarConta() {
            ContaBancaria teste = new ContaBancaria("mat",null,123, TipoPessoa.FISICA,null,123L,null);
            cadastro.adicionar(teste);
            System.out.println(contas);
            System.out.print("Informe n° da conta: ");
            numConta = console.nextInt();
            console.nextLine();
            System.out.print("Informe a senha da conta: ");
            senhaConta = console.nextInt();
            console.nextLine();
//            try {
                conta = contas.stream().filter(contaBancaria -> {
                    return contaBancaria.getNumeroConta() == numConta && contaBancaria.getSenha() == senhaConta;
                }).toList().get(0);

  //          } catch (ArrayIndexOutOfBoundsException e) {
                if (conta != null) {
                   do {
                       System.out.println("Menu de Conta:");
                       System.out.println("1) Ver saldo");
                       System.out.println("2) Sacar");
                       System.out.println("3) Depositar");
                       System.out.println("4) Ver informações do cliente");
                       System.out.println("5) Alterar senha");
                       System.out.println("0) Voltar");
                       System.out.print("Digite uma opção: ");

                       int opcao;

                       try {
                           opcao = console.nextInt();
                           console.nextLine();
                       } catch (InputMismatchException excecao) {
                           opcao = -1;
                       }
                       switch (opcao) {
                           case 1:
                               mostrarSaldo();
                               break;
                           case 2:
                               sacar(console);
                               break;
                           case 3:
                               depositar(console);
                               break;
                           case 4:
                               mostrarDados();
                               break;
                           case 5:
                               alterarSenha(console);
                               break;
                           case 0:
                               System.out.println("Voltando ao Menu Principal...");
                               return;
                           default:
                               System.out.println("Opção inválida.");
                       }
                   }while (true);
                }
   //         }
    }
 /*   public void imprimirTelaAcessarConta() {
        System.out.println("Menu de Conta:");
        System.out.println("1) Ver saldo");
        System.out.println("2) Sacar");
        System.out.println("3) Depositar");
        System.out.println("4) Ver informações do cliente");
        System.out.println("5) Alterar senha");
        System.out.println("0) Voltar");

        int opcao;

        try {
            opcao = console.nextInt();
            console.nextLine();
        } catch (InputMismatchException excecao) {
            opcao = -1;
        }
        switch (opcao) {
            case 1:
                mostrarSaldo();
                break;
            case 2:
                sacar(console);
                break;
            case 3:
                depositar(console);
                break;
            case 4:
                mostrarDados();
                break;
            case 5:
                break;
            case 0:
                System.out.println("Voltando ao Menu Principal...");
                return;
            default:
                System.out.println("Opção inválida.");
        }while (true);
    }*/

    public void mostrarSaldo() {
        System.out.println("Saldo atual: R$" + conta.getSaldo());
    }

    public void sacar(Scanner console) {
        System.out.print("Informe o valor que deseja sacar:");
        Float valor = console.nextFloat();
        console.nextLine();
        conta.sacar(valor);
        System.out.println("Saldo atual: R$" + conta.getSaldo());
    }

    public void depositar(Scanner console) {
        System.out.print("Informe o valor que deseja depositar:");
        Float valor = console.nextFloat();
        console.nextLine();
        conta.depositar(valor);
        System.out.println("Saldo atual: R$" + conta.getSaldo());
    }
    public void mostrarDados() {
        System.out.println(conta.toString());
    }

    public void alterarSenha(Scanner console) {
        System.out.print("Informe a nova senha: ");
        Integer senhaNova = console.nextInt();
        conta.setSenha(senhaNova);
        System.out.println("senha alterada!");
    }
}
