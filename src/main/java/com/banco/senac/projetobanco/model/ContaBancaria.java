package com.banco.senac.projetobanco.model;

import com.banco.senac.projetobanco.model.enums.TipoPessoa;

public class ContaBancaria {

    //Atributos da classe
    private Integer numeroConta;

    private Double saldo;

    private String nome;

    private String razaoSocial;

    private Integer senha;

    private TipoPessoa tipoPessoa;

    private Long cnpj;

    private Integer cpf;

    private Endereco endereco;

    //Construtores
    public ContaBancaria() {
    }

    public ContaBancaria(String nome, String razaoSocial, Integer senha, TipoPessoa tipoPessoa, Long cnpj, Integer cpf, Endereco endereco) {
        this.numeroConta = (int) (Math.random() * 10000);
        this.saldo = 0.0;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.senha = senha;
        this.tipoPessoa = tipoPessoa;
        this.cnpj = cnpj;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public ContaBancaria(String nome, Integer cpf, Integer senha, Endereco endereco) {
        this.numeroConta = (int) (Math.random() * 10000);
        this.saldo = 0.0;
        this.tipoPessoa = TipoPessoa.FISICA;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.endereco = endereco;
    }

    public ContaBancaria(String razaoSocial, Long cnpj, Integer senha, Endereco endereco) {
        this.numeroConta = (int) (Math.random() * 10000);
        this.saldo = 0.0;
        this.tipoPessoa = TipoPessoa.JURIDICA;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.senha = senha;
        this.endereco = endereco;
    }
    //Getters e Setters
    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getSenha() {
        return senha;
    }

    public void setSenha(Integer senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    //função para imprimir o conteúdo do objeto em formato de String
    @Override
    public String toString() {
        return "ContaBancaria{" +
                "numeroConta=" + numeroConta +
                ", senha=" + senha +
                ", saldo=" + saldo +
                ", tipoPessoa=" + tipoPessoa +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj=" + cnpj +
                ", endereco=" + endereco +
                '}';
    }

    //função para somar o valor informado ao saldo já existente e validar que o valor não seja 0 ou negativo
    public double depositar(Float valor) {
        if (valor < 1) {
            System.out.println("=====================================================");
            System.out.println("Valor a depositar não pode ser 0 ou negativo");
            System.out.println("=====================================================");
        } else
            saldo += valor;
        return saldo;
    }

    //função para subtrair o valor informado do saldo existente e validar que o valor não é maior que o saldo.
    public double sacar(Float valor) {
        if ((saldo - valor) < 0) {
            System.out.println("=====================================================");
            System.out.println("Valor a sacar não pode ser maior que o saldo na conta");
            System.out.println("=====================================================");
        } else
            saldo -= valor;
        return saldo;
    }
}
