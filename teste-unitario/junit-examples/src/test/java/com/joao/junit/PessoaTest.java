package com.joao.junit;

import com.joao.junit.example.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PessoaTest {

    @Test
    void deveCalcularIdadeCorretamente(){
        Pessoa joao = new Pessoa("João", LocalDate.of(2000,1,1));
        Assertions.assertEquals(24,joao.getIdade());
    }

    @Test
    void deveRetornarSeEhMaiorDeIdade(){
        Pessoa joao = new Pessoa("João", LocalDate.of(2000,1,1));
        Assertions.assertTrue(joao.ehMaiorDeIdade());

        Pessoa carlos = new Pessoa("Carlos", LocalDate.now());
        Assertions.assertFalse(carlos.ehMaiorDeIdade());

        Pessoa ribas = new Pessoa("Carlos", LocalDate.of(2010,1,1));
        Assertions.assertFalse(ribas.ehMaiorDeIdade());
    }

    @Test
    void verificarLancamento(){
        int[] primeiroLancamento = {0,1,2,3,4};
        int[] segundoLancamento = {1,2,3,5,8};

        Assertions.assertArrayEquals(primeiroLancamento,segundoLancamento);
    }

    @Test
    void validarObjetoNulo(){
        Pessoa pessoa = null;

        Assertions.assertNull(pessoa);
    }

    @Test
    void validarObjetoNaoNulo(){
        Pessoa joao = new Pessoa("João", LocalDate.of(2000,1,1));

        Assertions.assertNotNull(joao);
    }


}
