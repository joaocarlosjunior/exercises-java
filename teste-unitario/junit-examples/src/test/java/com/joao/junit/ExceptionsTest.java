package com.joao.junit;

import com.joao.junit.example.Conta;
import com.joao.junit.example.TransferenciaEntreContas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionsTest {

    @Test
    void validarCenarioDeExcecaoNaTransferencia(){
        Conta conta1 = new Conta(1000,200.00);
        Conta conta2 = new Conta(2000,100.00);

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                TransferenciaEntreContas.transfere(conta1,conta2, 10)
                );

        Assertions.assertDoesNotThrow(() ->
                TransferenciaEntreContas.transfere(conta1,conta2, 10)
        );
    }
}
