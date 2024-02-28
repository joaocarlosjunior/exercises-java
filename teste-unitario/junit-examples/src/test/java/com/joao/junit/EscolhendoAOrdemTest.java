package com.joao.junit;

import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EscolhendoAOrdemTest {
    @Order(3)
    @Test
    void validoFluxoA(){
        Assertions.assertTrue(true);
    }

    @Order(2)
    @Test
    void validoFluxoB(){
        Assertions.assertTrue(true);

    }

    @Order(1)
    @Test
    void validoFluxoC(){
        Assertions.assertTrue(true);

    }
}
