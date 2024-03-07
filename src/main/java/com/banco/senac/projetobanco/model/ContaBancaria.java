package com.banco.senac.projetobanco.model;

import com.banco.senac.projetobanco.model.enums.TipoPessoa;

public class ContaBancaria extends Banco{


    private Long numeroConta;
    private Float saldo;

    private String nome;

    private Integer senha;

    private TipoPessoa tipoPessoa;

    private Long cpf;

    private Endereco endereco;

    public ContaBancaria(Long numeroConta, Integer senha) {
        this.numeroConta = numeroConta;
        this.senha = senha;
    }

    public ContaBancaria() {

    }

    public ContaBancaria(ContaBancaria contaBancaria, Long numeroConta, Float saldo, String nome, Integer senha, TipoPessoa tipoPessoa, Long cpf, Endereco endereco) {
        super(contaBancaria);
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.nome = nome;
        this.senha = senha;
        this.tipoPessoa = tipoPessoa;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public ContaBancaria(String nome, Long cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public Long getNumeroConta() {
        return numeroConta;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public Integer getSenha() {
        return senha;
    }

    public void setSenha(Integer senha) {
        this.senha = senha;
    }

    public void setNumeroConta(Long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Float depositar(Float valor) {
        saldo += saldo + valor;
        return saldo;
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "numeroConta=" + numeroConta +
                ", saldo=" + saldo +
                ", nome='" + nome + '\'' +
                ", senha=" + senha +
                ", tipoPessoa=" + tipoPessoa +
                ", cpf=" + cpf +
                ", endereco=" + endereco +
                '}';
    }

    public Float sacar(Float valor) {
        if((saldo - valor) > 0) {
            throw new RuntimeException("valor a sacar não pode ser maior que o saldo na conta");
        } else {
            saldo -= saldo - valor;
            return saldo;
        }
    }
}
