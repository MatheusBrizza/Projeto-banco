package com.banco.senac.projetobanco.telas;

import ch.qos.logback.core.net.server.Client;

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
                    this.cadastrarContaCliente(console);
                    break;
                case 2:
                    this.listarDadosCliente(console);
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (true);

    }
}private void cadastrarContaCliente(Scanner console){
    String simOuNao = "";
    do {
        CadatroCliente cadatro = cadastrarContaCliente. criar();

        System.out.println("informar o tipo de pessoa: (fisica ou juridica)");
        TipoPessoa tipoPessoa = lerTipoPessoa(console);

        System.out.println("informar a UF do cliente:");
        String uf = console.nextLine().toUpperCase();

        System.out.println("Informar a cidade do cliente:");
        String cidade = console.nextLine();

        System.out.println("Informar o Cep do cliente:");
        Interger cep = LerInt(console;

        System.out.println("Informar compelmento:");
        String complemento = console.nextLine();

        System.out.println("Informar bairro:");
        String bairro = console.nextLine();

        Endereco endereco = new Endereco(uf,cidade, cep, logradouro, numero, complemento,bairro);

        if(tipoPessoa.equals(TipoPessoa.FISCA)) {

            System.out.println("informar o Nome:");
            String nome = console.next();

            System.out.println("Informar o tipo documento:(rg, cpf, chh)");
            TipoDocumneto tipoDocumneto = LerTipoDocumento(console);

            System.out.println("Informar o número do documento:");
            Long documento = LerLong(console);

            Cliente pessoa = new Cliente(nome, documento, tipoDocumneto, endereco);
            cadastro.adicionar(pessoa);

        } else if (tipoPessoa.equals(TipoPessoa.Juridica)) {

            System.out.println("Informar a razão social:");
            String razaoSocial = console.next();

            System.out.println("informar o CNPJ:");
            Long cnpj = lerLong(console);

            Cliente empresa = new Cliente(razaoSocial, cnpj, endereco);
            cadatro.adicionar(empresa);
        }

        System.out.println("deseja cadastrar outro cliente?);
        simOuNao = console.nextLine();
        While (simOuNao.equalsIgnoreCase(anotherString:"sim"));
    }

    private void ListarClientes(Scanner console){
        CadastroClientes cadasto = CadastroClienetes.criar();
        List<Cliente> clientes = cadastro.getClientes();

        if (clientes.isEmpty()) {
            System.out.println("Ainda não foramm cadastrados clientes à lista.");
        } else {

            for (int i = 1; i <= clientes.size(); i++) {
                Cliente pessoa = cliente.get(i - 1);
                System.out.println("(" + i + ")" + pessoa);
            }
        }
    }

    public TipoDocumento LerTipoDocumento(Scanner console){
        While(true) {
            try {
                String tipo = console.nextLine();
                return TipoDocumento.valueof(tipo.toUpperCase());
            } catch (IllegalAccessException excecao) {
                System.out.println("Tipo de documento inválido.");
            }

        }

    }
    public TipoPessoa LerTipoPessoa (Scanner console){
        while (true) {
            try {
                String tipo = console.nextLine();
                return;
                LerTipoPessoa.valueof(tipo.toUpperCase());
            } catch (IllegalAccessException) {
                System.out.println("Tipo de pessoa invalido");
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
                System.out.println("Por favoe informar apenas números.");
                console.nextLine();

            }
        }
    }

    public Integer lerInt(Scanner console){
        While(true) {
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













            }
        }
    }






















    }





