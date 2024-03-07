package com.banco.senac.projetobanco.model;

import com.banco.senac.projetobanco.model.enums.TipoPessoa;

public class ContaBancaria extends Banco{


    private Integer numeroConta;

    private Double saldo;

    private String nome;

    private String razaoSocial;

    private Integer senha;

    private TipoPessoa tipoPessoa;

    private Long cnpj;

    private Long cpf;

    private Endereco endereco;

    public ContaBancaria(Integer numeroConta, Integer senha) {
        this.numeroConta = numeroConta;
        this.senha = senha;
    }

    public ContaBancaria() {

    }

    public ContaBancaria(String nome, String razaoSocial, Integer senha, TipoPessoa tipoPessoa, Long cnpj, Long cpf, Endereco endereco) {
        this.numeroConta = (int)(Math.random()*10000);
        this.saldo = 0.0;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.senha = senha;
        this.tipoPessoa = tipoPessoa;
        this.cnpj = cnpj;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public ContaBancaria(String nome, Long cpf, Integer senha, Endereco endereco) {
        this.numeroConta = (int)(Math.random()*10000);
        this.saldo = 0.0;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.endereco = endereco;
    }


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

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public TipoPessoa getTipoPessoa() { return tipoPessoa; }

    public void setTipoPessoa(TipoPessoa tipoPessoa) { this.tipoPessoa = tipoPessoa; }

    public Long getCpf() { return cpf; }

    public void setCpf(Long cpf) { this.cpf = cpf; }

    public Endereco getEndereco() { return endereco; }

    public void setEndereco(Endereco endereco) { this.endereco = endereco; }


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

    public double depositar(Float valor) {
        if (valor < 1) {
            System.out.println("Valor a depositar não pode ser 0 ou negativo");
        } else
            saldo += valor;
            return saldo;

    }

    public double sacar(Float valor) {
        if((saldo - valor) < 0) {
            System.out.println("Valor a sacar não pode ser maior que o saldo na conta");
        } else
            saldo -= valor;
            return saldo;
    }
}
