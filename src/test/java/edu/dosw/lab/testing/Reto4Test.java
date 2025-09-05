package edu.dosw.lab.testing;

import edu.dosw.lab.testing.Reto4.Bankify;
import edu.dosw.lab.testing.Reto4.Banco;
import edu.dosw.lab.testing.Reto4.Cliente;
import edu.dosw.lab.testing.Reto4.Cuenta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Reto4Test {

    private Bankify bankify;
    private Banco banco1;
    private Banco banco2;
    private Cliente cliente1;
    private Cliente cliente2;
    private Cuenta cuenta1;
    private Cuenta cuenta2;
    private Cuenta cuentaInvalida;

    @BeforeEach
    void setUp() {
        bankify = new Bankify();
        banco1 = new Banco("B001", "001", "Banco Nacional");
        banco2 = new Banco("B002", "002", "Banco Internacional");

        bankify.registrarBanco(banco1);
        bankify.registrarBanco(banco2);

        cliente1 = new Cliente("C001", "Juan Pérez", "12345678", "juan@email.com");
        cliente2 = new Cliente("C002", "María García", "87654321", "maria@email.com");

        bankify.registrarCliente(cliente1);
        bankify.registrarCliente(cliente2);

        cuenta1 = new Cuenta("0011234567", banco1);
        cuenta2 = new Cuenta("0027654321", banco2);
        cuentaInvalida = new Cuenta("0031111111", banco1);
    }

    @Test
    void testCrearCuentaValida() {
        bankify.crearCuenta(cliente1, cuenta1);
        assertTrue(bankify.cuentaExiste("0011234567"));
        assertTrue(cliente1.getCuentas().contains(cuenta1));
    }

    @Test
    void testCrearCuentaInvalida() {
        bankify.crearCuenta(cliente1, cuentaInvalida);
        assertFalse(bankify.cuentaExiste("0031111111"));
        assertFalse(cliente1.getCuentas().contains(cuentaInvalida));
    }

    @Test
    void testValidarNumeroCuentaCorrecta() {
        assertTrue(bankify.validarNumeroCuenta("0011234567", banco1));
    }

    @Test
    void testValidarNumeroCuentaIncorrecta() {
        assertFalse(bankify.validarNumeroCuenta("0031234567", banco1));
    }

    @Test
    void testConsultarSaldoCuentaExistente() {
        bankify.crearCuenta(cliente1, cuenta1);
        double saldo = bankify.consultarSaldo("0011234567");
        assertEquals(0.0, saldo);
    }

    @Test
    void testConsultarSaldoCuentaNoExistente() {
        assertThrows(IllegalArgumentException.class, () -> {
            bankify.consultarSaldo("9999999999");
        });
    }

    @Test
    void testRealizarDepositoValido() {
        bankify.crearCuenta(cliente1, cuenta1);
        bankify.realizarDeposito("0011234567", 500.0);
        assertEquals(500.0, bankify.consultarSaldo("0011234567"));
    }

    @Test
    void testRealizarDepositoInvalido() {
        bankify.crearCuenta(cliente1, cuenta1);
        assertThrows(IllegalArgumentException.class, () -> {
            bankify.realizarDeposito("0011234567", -200.0);
        });
    }

    @Test
    void testGetCuentasClienteValido() {
        bankify.crearCuenta(cliente1, cuenta1);
        bankify.crearCuenta(cliente1, cuenta2);
        List<Cuenta> cuentas = bankify.getCuentasCliente("C001");
        assertEquals(2, cuentas.size());
        assertTrue(cuentas.contains(cuenta1));
        assertTrue(cuentas.contains(cuenta2));
    }

    @Test
    void testGetCuentasClienteInvalido() {
        List<Cuenta> cuentas = bankify.getCuentasCliente("C999");
        assertTrue(cuentas.isEmpty());
    }

    @Test
    void testBuscarClienteValido() {
        Cliente c = bankify.buscarCliente("C001");
        assertNotNull(c);
        assertEquals("Juan Pérez", c.getNombre());
    }

    @Test
    void testBuscarClienteInvalido() {
        Cliente c = bankify.buscarCliente("C999");
        assertNull(c);
    }

    @Test
    void testBuscarBancoValido() {
        Banco b = bankify.buscarBanco("B001");
        assertNotNull(b);
        assertEquals("Banco Nacional", b.getNombreBanco());
    }

    @Test
    void testBuscarBancoInvalido() {
        Banco b = bankify.buscarBanco("B999");
        assertNull(b);
    }
}
