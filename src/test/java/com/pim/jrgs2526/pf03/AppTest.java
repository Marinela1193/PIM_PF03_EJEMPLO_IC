package com.pim.jrgs2526.pf03;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
    @ParameterizedTest
    @ValueSource(ints = {5, 6, 9})
    public void testCalcularAprobado(int nota) {
        App main = new App();
        int resultado = main.calcularNota(nota);
        Assertions.assertEquals(1, resultado);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 4})
    public void testCalcularSuspenso(int nota) {
        App main = new App();
        int resultado = main.calcularNota(nota);
        Assertions.assertEquals(-1, resultado);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {-1, 11, 63})
    public void testCalcularError(int notaInvalida) {
        App main = new App();
        try {
            int resultado = main.calcularNota(notaInvalida);
            Assertions.fail(); 
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Error al calcular la nota", e.getMessage());
        }
    }
}
