package com.banco.senac.projetobanco.telas;

import com.banco.senac.projetobanco.database.CadastrarConta;
import com.banco.senac.projetobanco.model.ContaBancaria;
import com.banco.senac.projetobanco.model.Endereco;
import com.banco.senac.projetobanco.model.enums.TipoPessoa;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuCriarConta {

    public void imprimirTelaConta() {
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
                    cadastrarConta(console);
                    System.out.println("1");
                    break;
                case 2:
                    listarContas(console);
                    System.out.println("2");
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (true);

    }
    private void cadastrarConta(Scanner console){
        String simOuNao = "";
        do {
            CadastrarConta cadastro = CadastrarConta.criar();

            System.out.println("informar o tipo de pessoa: (fisica ou juridica)");
            TipoPessoa tipoPessoa = lerTipoPessoa(console);

            System.out.println("informar a UF do cliente:");
            String uf = console.nextLine().toUpperCase();

            System.out.println("Informar a cidade do cliente:");
            String cidade = console.nextLine();

            System.out.println("Informar o Cep do cliente:");
            Integer cep = lerInt(console);

            System.out.println("Informar logradouro:");
            String logradouro = console.nextLine();

            System.out.println("Informar número do logradouro:");
            Integer numero = lerInt(console);

            System.out.println("Informar compelmento:");
            String complemento = console.nextLine();

            System.out.println("Informar bairro:");
            String bairro = console.nextLine();

            //Endereco endereco = new Endereco(uf, cidade, cep, logradouro, numero, complemento, bairro);

            if(tipoPessoa.equals(TipoPessoa.FISICA)) {

                System.out.println("informar o Nome:");
                String nome = console.next();

                System.out.println("Informar o número do CPF:");
                Long cpf = lerLong(console);

                ContaBancaria pessoa = new ContaBancaria(nome, cpf);
                cadastro.adicionar(pessoa);

            } else if (tipoPessoa.equals(TipoPessoa.JURIDICA)) {

                System.out.println("Informar a razão social:");
                String razaoSocial = console.next();

                System.out.println("informar o CNPJ:");
                Long cnpj = lerLong(console);

                ContaBancaria empresa = new ContaBancaria(razaoSocial, cnpj);
                cadastro.adicionar(empresa);
            } else {
                System.out.println("Tipo de pessoa errada! escolher entre física ou jurídica");
            }

            System.out.println("deseja cadastrar outro cliente?");
            simOuNao = console.nextLine();
        }   while (simOuNao.equalsIgnoreCase("sim"));
    }

    private void listarContas(Scanner console){
        CadastrarConta cadastro = CadastrarConta.criar();
        List<ContaBancaria> contas = cadastro.getContas();

        if (contas.isEmpty()) {
            System.out.println("Ainda não foramm cadastrados clientes à lista.");
        } else {
            for (int i = 1; i <= contas.size(); i++) {
                ContaBancaria pessoa = contas.get(i - 1);
                System.out.println("(" + i + ")" + pessoa);
            }
        }
    }


    public TipoPessoa lerTipoPessoa(Scanner console) {
        while (true) {
            try {
                String tipo = console.nextLine(); //RS
                return TipoPessoa.valueOf(tipo.toUpperCase());
            } catch (IllegalArgumentException excecao) {
                System.out.println("Tipo de pessoa inválido");
            }
        }
    }

    public Long lerLong(Scanner console) {
        while (true) {
            try {
                Long a = console.nextLong();
                console.nextLine();
                return a;
            } catch (InputMismatchException excecao) {
                System.out.println("Por favor informar apenas números.");
                console.nextLine();
            }
        }
    }

    public Integer lerInt(Scanner console){
        while(true) {
            try {
                Integer a = console.nextInt();
                console.nextLine();
                return a;
            } catch (InputMismatchException excecao) {
                System.out.println("Por favor informar apenas números.");
                console.nextLine();
            }
        }
    }

}
