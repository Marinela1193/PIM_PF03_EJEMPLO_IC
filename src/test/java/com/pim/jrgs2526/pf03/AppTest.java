package com.pim.jrgs2526.pf03;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
   @ParameterizedTest(name = "Nota {0} debe devolver {1}")
    @CsvSource({
        "6, 1",    // Caso aprobado
        "2, -1"    // Caso suspenso
    })
    public void testCalcularNotaValida(int nota, int resultadoEsperado) {
        App main = new App();
        int resultado = main.calcularNota(nota);
        Assertions.assertEquals(resultadoEsperado, resultado);
    }

    @ParameterizedTest(name = "Nota no valida {0} debe lanzar IllegalArgumentException")
    @ValueSource(ints = {63, -1, 11}
    public void testCalcularError(int notaInvalida) {
        App main = new App();
        IllegalArgumentException excepcion = Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> main.calcularNota(notaInvalida)
        );
        Assertions.assertEquals("Error al calcular la nota", excepcion.getMessage());
    }
}
