package com.joao.junit.example;

public abstract class TransferenciaEntreContas {

    public static void transfere(Conta contaOrigem, Conta contaDestino, int valor){
        if (valor <= 0){
            throw new IllegalArgumentException("Valor deve ser maior que 0.");
        }
    }
}
