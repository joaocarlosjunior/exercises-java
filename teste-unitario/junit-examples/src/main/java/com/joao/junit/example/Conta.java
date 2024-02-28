package com.joao.junit.example;

public class Conta {
    private Integer numero;
    private Double saldo;

    public Conta(Integer numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public Double getSaldo() {
        return saldo;
    }
}
