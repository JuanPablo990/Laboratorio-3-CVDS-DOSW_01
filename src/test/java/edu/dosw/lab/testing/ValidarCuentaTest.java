package edu.dosw.lab.testing;

import edu.dosw.lab.testing.Reto4.ValidarCuenta;
import edu.dosw.lab.testing.Reto4.Banco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidarCuentaTest {

    private ValidarCuenta validarCuenta;
    private Banco banco;

    @BeforeEach
    public void setUp() {
        validarCuenta = new ValidarCuenta();
        banco = new Banco("B001", "001", "Banco Nacional");
    }

    @Test
    public void testValidarLongitudValida() {
        assertTrue(validarCuenta.validarLongitud("0011234567"));
    }

    @Test
    public void testValidarLongitudInvalida() {
        assertFalse(validarCuenta.validarLongitud("00112345"));
    }

    @Test
    public void testValidarPrefijoValido() {
        assertTrue(validarCuenta.validarPrefijo("0011234567", banco));
    }

    @Test
    public void testValidarPrefijoInvalido() {
        assertFalse(validarCuenta.validarPrefijo("0021234567", banco));
    }

    @Test
    public void testValidarFormatoValido() {
        assertTrue(validarCuenta.validarFormato("0011234567"));
    }

    @Test
    public void testValidarFormatoInvalido() {
        assertFalse(validarCuenta.validarFormato("00112A4567"));
    }
}
