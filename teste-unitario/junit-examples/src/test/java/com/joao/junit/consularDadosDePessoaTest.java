package com.joao.junit;

import com.joao.junit.example.BancoDeDados;
import com.joao.junit.example.Pessoa;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

public class consularDadosDePessoaTest {
    Pessoa pessoa = new Pessoa("Joao", LocalDate.now());

    @BeforeAll
    static void configuraConexao(){
        BancoDeDados.iniciarConexao();
    }

    @BeforeEach
    void insereDadosParaTeste(){
        BancoDeDados.insereDados(pessoa);
    }

    @Test
    void validarDadosDeRetorno(){
        Assertions.assertTrue(true);
    }

    @AfterEach
    void removeDadosTeste(){
        BancoDeDados.removeDados(pessoa);
    }

    @AfterAll
    static void finalizarConexao(){
        BancoDeDados.finalizarConexao();
    }
}
