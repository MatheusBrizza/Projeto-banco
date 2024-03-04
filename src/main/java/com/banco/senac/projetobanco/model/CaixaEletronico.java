package com.banco.senac.projetobanco.model;

import java.math.BigDecimal;

public class CaixaEletronico extends Banco{

    private Long id;
    private Long numeroConta;
    private Float saldo;

    private Integer senha;

    public CaixaEletronico(Long id, Long numeroConta, Float saldo) {
        this.id = id;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public CaixaEletronico() {

    }
    public Long getId() {
        return id;
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


    public Float depositar(Float valor) {
        Float saldoNovo = saldo + valor;
        return saldoNovo;
    }

    public Float sacar(Float valor) {
        if((saldo - valor) > 0) {
            throw new RuntimeException("valor a sacar não pode ser maior que o saldo na conta");
        } else {
            Float saldoNovo = saldo - valor;
            return saldoNovo;
        }
    }
}
