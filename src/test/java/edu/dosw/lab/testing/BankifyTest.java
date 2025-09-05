package edu.dosw.lab.testing;

import static org.junit.jupiter.api.Assertions.*;

import edu.dosw.lab.testing.Reto4.Banco;
import edu.dosw.lab.testing.Reto4.Bankify;
import edu.dosw.lab.testing.Reto4.Cuenta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.dosw.lab.testing.Reto4.Cliente;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankifyTest {
    private Bankify bankify;
    private Banco banco1;
    private Banco banco2;
    private Cliente cliente1;
    private Cliente cliente2;
    private Cuenta cuenta1;
    private Cuenta cuenta2;
    private Cuenta cuentaInvalida;
    @BeforeEach
    public void setUp() {
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
        cuentaInvalida = new Cuenta("0031111111", banco1); // Prefijo no coincide con banco1
    }
    @Test
    public void testCrearCuentaValida() {
        bankify.crearCuenta(cliente1, cuenta1);
        assertTrue(bankify.cuentaExiste(cuenta1.getNumeroCuenta()));
        assertTrue(cliente1.getCuentas().contains(cuenta1));
    }
    @Test
    public void testCrearCuentaInvalida() {
        bankify.crearCuenta(cliente1, cuentaInvalida);
        assertFalse(bankify.cuentaExiste(cuentaInvalida.getNumeroCuenta()));
        assertFalse(cliente1.getCuentas().contains(cuentaInvalida));
    }
    @Test
    public void testValidarNumeroCuenta() {
        assertTrue(bankify.validarNumeroCuenta("0011234567", banco1));
        assertFalse(bankify.validarNumeroCuenta("0031234567", banco1)); // Prefijo incorrecto
        assertFalse(bankify.validarNumeroCuenta("001123456", banco1));  // Longitud incorrecta
        assertFalse(bankify.validarNumeroCuenta("00112A4567", banco1)); // Formato incorrecto
    }
    @Test
    public void testConsultarSaldoCuentaExistente() {
        bankify.crearCuenta(cliente1, cuenta1);
        double saldo = bankify.consultarSaldo(cuenta1.getNumeroCuenta());
        assertEquals(0.0, saldo);
    }
    @Test
    public void testConsultarSaldoCuentaNoExistente() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            bankify.consultarSaldo("9999999999");
        });
        assertTrue(ex.getMessage().contains("Cuenta no encontrada"));
    }
    @Test
    public void testRealizarDepositoValido() {
        bankify.crearCuenta(cliente1, cuenta1);
        bankify.realizarDeposito(cuenta1.getNumeroCuenta(), 500.0);
        double saldo = bankify.consultarSaldo(cuenta1.getNumeroCuenta());
        assertEquals(500.0, saldo);
    }
    @Test
    public void testRealizarDepositoMontoNegativo() {
        bankify.crearCuenta(cliente1, cuenta1);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            bankify.realizarDeposito(cuenta1.getNumeroCuenta(), -100.0);
        });
        assertEquals("Monto de depósito debe ser positivo", ex.getMessage());
    }

    @Test
    public void testRealizarDepositoCuentaNoExistente() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            bankify.realizarDeposito("9999999999", 100.0);
        });
        assertTrue(ex.getMessage().contains("Cuenta no encontrada"));
    }
    @Test
    public void testGetCuentasCliente() {
        bankify.crearCuenta(cliente1, cuenta1);
        bankify.crearCuenta(cliente1, cuenta2); // cuenta2 pertenece a banco2 pero cliente1 puede tenerla
        var cuentas = bankify.getCuentasCliente(cliente1.getIdCliente());
        assertEquals(2, cuentas.size());
        assertTrue(cuentas.contains(cuenta1));
        assertTrue(cuentas.contains(cuenta2));
    }

    @Test
    public void testBuscarClienteYBanco() {
        Cliente c = bankify.buscarCliente("C001");
        assertNotNull(c);
        assertEquals("Juan Pérez", c.getNombre());
        Banco b = bankify.buscarBanco("B001");
        assertNotNull(b);
        assertEquals("Banco Nacional", b.getNombreBanco());
    }

    @Test
    public void testCrearCuenta_ClienteNull() {
        Exception ex = assertThrows(NullPointerException.class, () -> {
            bankify.crearCuenta(null, cuenta1);
        });
    }
    @Test
    public void testCrearCuenta_CuentaNull() {
        Exception ex = assertThrows(NullPointerException.class, () -> {
            bankify.crearCuenta(cliente1, null);
        });
    }
    @Test
    public void testCrearCuenta_NumeroCuentaNull() {
        Cuenta cuentaNullNum = new Cuenta(null, banco1);
        bankify.crearCuenta(cliente1, cuentaNullNum);
        assertFalse(bankify.cuentaExiste(null));
    }
    @Test
    public void testCrearCuenta_BancoNull() {
        Cuenta cuentaBancoNull = new Cuenta("0011234567", null);
        bankify.crearCuenta(cliente1, cuentaBancoNull);
        assertFalse(bankify.cuentaExiste(cuentaBancoNull.getNumeroCuenta()));
    }
}