package com.banco.senac.projetobanco.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
public class Banco {

    Banco() {
    }

    public void menuInicial() {
        System.out.println("Bem vindo ao Banco Senac Tech");
        System.out.println("Escolha uma opção");
        System.out.println("1) Ver saldo");
        System.out.println("2) Fazer depósito");
        System.out.println("3) Fazer saque");
        System.out.println("4) Sair");
    }
}
