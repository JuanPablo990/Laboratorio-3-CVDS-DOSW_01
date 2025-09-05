package edu.dosw.lab.testing;

import edu.dosw.lab.testing.Reto4.Banco;
import edu.dosw.lab.testing.Reto4.Cliente;
import edu.dosw.lab.testing.Reto4.Cuenta;
import edu.dosw.lab.testing.Reto4.GestionarCuenta;
import edu.dosw.lab.testing.Reto4.TipoTransaccion;
import edu.dosw.lab.testing.Reto4.Transaccion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GestionarCuentaTest {

    private GestionarCuenta gestionarCuenta;
    private Cliente cliente;
    private Cuenta cuenta;

    @BeforeEach
    public void setUp() {
        gestionarCuenta = new GestionarCuenta();
        cliente = new Cliente("C001", "Juan Pérez", "12345678", "juan@email.com");
        cuenta = new Cuenta("0011234567", new Banco("B001", "001", "Banco Nacional"));
    }

    @Test
    public void testCrearCuentaValida() {
        gestionarCuenta.crearCuenta(cliente, cuenta);
        assertTrue(cliente.getCuentas().contains(cuenta));
    }

    @Test
    public void testCrearCuentaClienteNull() {
        assertThrows(NullPointerException.class, () -> {
            gestionarCuenta.crearCuenta(null, cuenta);
        });
    }

    @Test
    public void testConsultarSaldoValido() {
        double saldo = gestionarCuenta.consultarSaldo(cuenta);
        assertEquals(0.0, saldo);
    }

    @Test
    public void testConsultarSaldoCuentaNull() {
        assertThrows(NullPointerException.class, () -> {
            gestionarCuenta.consultarSaldo(null);
        });
    }

    @Test
    public void testRealizarDepositoValido() {
        gestionarCuenta.realizarDeposito(cuenta, 500.0);
        assertEquals(500.0, cuenta.getSaldo());
        List<Transaccion> transacciones = cuenta.getTransacciones();
        assertEquals(1, transacciones.size());
        assertEquals(TipoTransaccion.DEPOSITO, transacciones.get(0).getTipo());
        assertEquals(500.0, transacciones.get(0).getMonto());
    }

    @Test
    public void testRealizarDepositoInvalido() {
        gestionarCuenta.realizarDeposito(cuenta, -100.0);
        assertEquals(0.0, cuenta.getSaldo());
        assertTrue(cuenta.getTransacciones().isEmpty());
    }
}
