package com.banco.senac.projetobanco.model;

public class ContaBancaria extends Banco{

    private Long id;
    private Long numeroConta;
    private Float saldo;

    private String nome;

    private Integer senha;

    public ContaBancaria(Long numeroConta, Integer senha) {
        this.numeroConta = numeroConta;
        this.senha = senha;
    }

    public ContaBancaria() {

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

    public Float depositar(Float valor) {
        saldo += saldo + valor;
        return saldo;
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
