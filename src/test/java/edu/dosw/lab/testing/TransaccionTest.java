package edu.dosw.lab.testing;

import edu.dosw.lab.testing.Reto4.Transaccion;
import edu.dosw.lab.testing.Reto4.TipoTransaccion;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TransaccionTest {

    @Test
    void testCrearTransaccionValida() {
        Date fecha = new Date();
        Transaccion transaccion = new Transaccion("TXN001", TipoTransaccion.DEPOSITO, 500.0, fecha);
        assertEquals("TXN001", transaccion.getIdTransaccion());
        assertEquals(TipoTransaccion.DEPOSITO, transaccion.getTipo());
        assertEquals(500.0, transaccion.getMonto());
        assertEquals(fecha, transaccion.getFecha());
    }

    @Test
    void testCrearTransaccionInvalida() {
        Transaccion transaccion = new Transaccion(null, null, -100.0, null);
        assertNull(transaccion.getIdTransaccion());
        assertNull(transaccion.getTipo());
        assertEquals(-100.0, transaccion.getMonto());
        assertNull(transaccion.getFecha());
    }
}
