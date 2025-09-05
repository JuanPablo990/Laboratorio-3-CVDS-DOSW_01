package edu.dosw.lab.testing;

import static org.junit.jupiter.api.Assertions.*;

import edu.dosw.lab.testing.Reto4.Banco;
import edu.dosw.lab.testing.Reto4.Cliente;
import edu.dosw.lab.testing.Reto4.Cuenta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteTest {


    private Cliente cliente;
    @BeforeEach
    public void setUp() {
        cliente = new Cliente("c1", "Juan Perez", "12345678", "juan@example.com");
    }
    @Test
    public void testGetters() {
        assertEquals("c1", cliente.getIdCliente());
        assertEquals("Juan Perez", cliente.getNombre());
        assertEquals("12345678", cliente.getDocumento());
        assertEquals("juan@example.com", cliente.getCorreo());
    }

    @Test
    public void testAgregarCuenta() {
        Cuenta cuenta = new Cuenta("0001", null); // Asumiendo constructor Cuenta(numeroCuenta, banco, saldo)
        cliente.agregarCuenta(cuenta);
        assertTrue(cliente.getCuentas().contains(cuenta));
    }

    @Test
    public void testValidarCodigo_Null() {
        Banco banco = new Banco("1", "123", "BancoTest");
        assertFalse(banco.validarCodigo(null)); // Ahora banco no es null
    }
    @Test
    public void testValidarCodigo_Vacio() {
        Banco banco = new Banco("1", "123", "BancoTest");
        assertFalse(banco.validarCodigo(""));
    }

}
