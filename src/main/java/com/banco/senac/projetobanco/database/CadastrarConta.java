package com.banco.senac.projetobanco.database;

import com.banco.senac.projetobanco.model.ContaBancaria;

import java.util.LinkedList;
import java.util.List;

public class CadastrarConta {
    private static CadastrarConta instancia;
    private List<ContaBancaria> contas;

    private CadastrarConta() {
        this.contas = new LinkedList<>();
    }

    public static CadastrarConta criar() {
        if (instancia == null) {
            instancia = new CadastrarConta();
        }
        return instancia;
    }

    public static CadastrarConta getInstancia() {
        return instancia;
    }

    public List<ContaBancaria> getContas() {
        return contas;
    }

    //função para buscar se tem número da conta na lista de contas
    //public boolean getNumeroConta(int numConta) { return contas.contains(numConta); }

    public void adicionar(ContaBancaria conta) {
        contas.add(conta);
    }

    public void deletar(ContaBancaria conta) {
        contas.remove(conta);
    }
}
