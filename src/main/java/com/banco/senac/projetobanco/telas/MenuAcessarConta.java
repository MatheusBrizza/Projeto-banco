package com.banco.senac.projetobanco.telas;

import com.banco.senac.projetobanco.database.CadastrarConta;
import com.banco.senac.projetobanco.model.ContaBancaria;

import java.util.List;
import java.util.Scanner;

public class MenuAcessarConta {
    int numConta;
    int senhaConta;
    ContaBancaria conta;
    public void AcessarConta() {
        Scanner console = new Scanner(System.in);
        CadastrarConta cadastro = CadastrarConta.criar();
        List<ContaBancaria> contas = cadastro.getContas();
        do {
            System.out.print("Informe n° da conta: ");
            numConta = console.nextInt();
            console.nextLine();
            System.out.print("Informe a senha da conta: ");
            senhaConta = console.nextInt();
            console.nextLine();
            try {
                conta = contas.stream().filter(contaBancaria -> {
                    return contaBancaria.getNumeroConta() == numConta && contaBancaria.getSenha() == senhaConta;
                }).toList().get(0);

            } catch (ArrayIndexOutOfBoundsException e) {
                if (conta != null) {
                    imprimirTelaAcessarConta();
                }
            }



        }while (true);
    }
    public void imprimirTelaAcessarConta() {

    }
}
