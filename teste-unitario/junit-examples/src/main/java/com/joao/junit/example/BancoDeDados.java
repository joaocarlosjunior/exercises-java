package com.joao.junit.example;

import java.util.logging.Logger;

public class BancoDeDados {

    private static final Logger LOGGER = Logger.getLogger(BancoDeDados.class.getName());

    public static void iniciarConexao(){
        //fez algo
        LOGGER.info("Iniciou a conexão ao banco de dados.");
    }

    public static void finalizarConexao(){
        //fez algo
        LOGGER.info("Finalizou a conexão ao banco de dados.");
    }

    public static void insereDados(Pessoa pessoa){
        //insere pessoa no DB
        LOGGER.info("Inseriu pessoa no banco de dados.");
    }

    public static void removeDados(Pessoa pessoa){
        //removeu pessoa no DB
        LOGGER.info("Removeu pessoa no banco de dados.");
    }
}
