package com.banco.senac.projetobanco.telas;

import com.banco.senac.projetobanco.database.CadastrarConta;
import com.banco.senac.projetobanco.model.ContaBancaria;
import com.banco.senac.projetobanco.model.enums.TipoPessoa;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuExcluirConta {
    Scanner console = new Scanner(System.in);
    ContaBancaria conta;
    CadastrarConta cadastro = CadastrarConta.criar();
    List<ContaBancaria> contas = cadastro.getContas();

    public void imprimirTelaConta() {

        do {
            System.out.println("1) cadastrar Conta nova (Pessoa Física ou Pessoa Jurídica)");
            System.out.println("2) listar Contas");
            System.out.println("0) retornar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcao;

            try {
                opcao = console.nextInt();
                console.nextLine();
            } catch (InputMismatchException excecao) {
                opcao = -1;
            }
            switch (opcao) {
                case 1:
                    excluirConta(console);
                    break;
                case 2:
                    listarContas();
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (true);
    }

    public void excluirConta(Scanner console) {
        ContaBancaria teste = new ContaBancaria("mat", null, 123, TipoPessoa.FISICA, null, 123, null);
        cadastro.adicionar(teste);
        System.out.println(contas);
        System.out.print("Informe o NÚMERO da conta que quer excluir: ");
        Integer numConta = console.nextInt();
        console.nextLine();
        System.out.print("Informe a SENHA da conta que quer excluir: ");
        Integer senhaConta = console.nextInt();
        console.nextLine();
        conta = contas.stream().filter(contaBancaria -> {
            return contaBancaria.getNumeroConta() == numConta && contaBancaria.getSenha().equals(senhaConta);
        }).toList().get(0);
        if (conta != null) {
            System.out.println("Conta bancária de nº " + conta.getNumeroConta() + " foi removida com sucesso!");
            cadastro.deletar(conta);
        }
    }

    private void listarContas() {

        if (contas.isEmpty()) {
            System.out.println("Ainda não foram cadastrados clientes à lista.");
        } else {
            for (int i = 1; i <= contas.size(); i++) {
                ContaBancaria pessoa = contas.get(i - 1);
                System.out.println("(" + i + ")" + pessoa);
            }
        }
    }
}