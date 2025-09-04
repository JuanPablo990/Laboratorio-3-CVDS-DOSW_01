package edu.dosw.lab.testing.Reto4;

import java.util.Date;

public class GestionarCuenta {
    public GestionarCuenta() {}

    public void crearCuenta(Cliente cliente, Cuenta cuenta) {
        cliente.agregarCuenta(cuenta);
    }

    public double consultarSaldo(Cuenta cuenta) {
        return cuenta.getSaldo();
    }

    public void realizarDeposito(Cuenta cuenta, double monto) {
        if (monto > 0) {
            double nuevoSaldo = cuenta.getSaldo() + monto;
            cuenta.setSaldo(nuevoSaldo);

            Transaccion transaccion = new Transaccion(
                    "TXN" + System.currentTimeMillis(),
                    TipoTransaccion.DEPOSITO,
                    monto,
                    new Date()
            );
            cuenta.agregarTransaccion(transaccion);
        }
    }
}