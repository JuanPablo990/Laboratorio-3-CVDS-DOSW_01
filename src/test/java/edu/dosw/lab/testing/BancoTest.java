package edu.dosw.lab.testing;


import static org.junit.jupiter.api.Assertions.*;

import edu.dosw.lab.testing.Reto4.Banco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BancoTest {

    private Banco banco;
    @BeforeEach
    public void setUp() {
        banco = new Banco("1", "123", "BancoTest");
    }
    @Test
    public void testValidarCodigo_Correcto() {
        assertTrue(banco.validarCodigo("123"));
    }

    @Test
    public void testValidarCodigo_Incorrecto() {
        assertFalse(banco.validarCodigo("999"));
    }
    @Test
    public void testGetters() {
        assertEquals("1", banco.getIdBanco());
        assertEquals("123", banco.getCodigoBanco());
        assertEquals("BancoTest", banco.getNombreBanco());
    }

    @Test
    public void testValidarCodigo_Null() {
        assertFalse(banco.validarCodigo(null)); // Puede lanzar NullPointerException si no se maneja null
    }
    @Test
    public void testValidarCodigo_Vacio() {
        assertFalse(banco.validarCodigo("")); // Debe ser falso, pero si no se maneja puede fallar
    }


}
