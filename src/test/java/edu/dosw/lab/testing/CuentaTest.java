package edu.dosw.lab.testing;

import static edu.dosw.lab.testing.Reto4.TipoTransaccion.DEPOSITO;
import static edu.dosw.lab.testing.Reto4.TipoTransaccion.RETIRO;
import static org.junit.jupiter.api.Assertions.*;

import edu.dosw.lab.testing.Reto4.Banco;
import edu.dosw.lab.testing.Reto4.Cuenta;
import edu.dosw.lab.testing.Reto4.TipoTransaccion;
import edu.dosw.lab.testing.Reto4.Transaccion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class CuentaTest {

    private Cuenta cuenta;
    private Banco banco;

    @BeforeEach
    public void setUp() {
        banco = new Banco("B001", "001", "Banco Test");
        cuenta = new Cuenta("0011234567", banco);
    }

    @Test
    public void testConstructorInicializaCorrectamente() {
        assertEquals("0011234567", cuenta.getNumeroCuenta());
        assertEquals(banco, cuenta.getBanco());
        assertEquals(0.0, cuenta.getSaldo());
        assertNotNull(cuenta.getTransacciones());
        assertTrue(cuenta.getTransacciones().isEmpty());
    }

    @Test
    public void testGetSaldoYSetSaldo() {
        cuenta.setSaldo(500.0);
        assertEquals(500.0, cuenta.getSaldo());

        cuenta.setSaldo(0.0);
        assertEquals(0.0, cuenta.getSaldo());
    }

    @Test
    public void testAgregarTransaccion() {
        Transaccion transaccion = new Transaccion("T001", TipoTransaccion.DEPOSITO, 100.0, new Date());
        cuenta.agregarTransaccion(transaccion);
        List<Transaccion> transacciones = cuenta.getTransacciones();
        assertEquals(1, transacciones.size());
        assertTrue(transacciones.contains(transaccion));
    }
    @Test
    public void testAgregarMultiplesTransacciones() {
        Transaccion t1 = new Transaccion("T002", TipoTransaccion.DEPOSITO, 100.0, new Date());
        Transaccion t2 = new Transaccion("T003", TipoTransaccion.RETIRO, 50.0, new Date());
        cuenta.agregarTransaccion(t1);
        cuenta.agregarTransaccion(t2);
        List<Transaccion> transacciones = cuenta.getTransacciones();
        assertEquals(2, transacciones.size());
        assertTrue(transacciones.contains(t1));
        assertTrue(transacciones.contains(t2));
    }

    @Test
    public void testGetBancoNoNull() {
        assertNotNull(cuenta.getBanco());
        assertEquals("Banco Test", cuenta.getBanco().getNombreBanco());
    }
}