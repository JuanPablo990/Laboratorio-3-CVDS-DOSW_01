package edu.dosw.lab.testing.Reto4;

import java.util.Date;

/**
 * Clase encargada de gestionar las operaciones principales
 * relacionadas con una {@link Cuenta}.
 *
 * Permite crear cuentas para los clientes, consultar saldos
 * y realizar depositos registrando automaticamente las transacciones.
 */
public class GestionarCuenta {

    /**
     * Constructor vacio para inicializar el gestor de cuentas.
     */
    public GestionarCuenta() {}

    /**
     * Asocia una nueva cuenta a un cliente.
     *
     * @param cliente Cliente al que se le asignará la cuenta
     * @param cuenta  Cuenta que será creada para el cliente
     */
    public void crearCuenta(Cliente cliente, Cuenta cuenta) {
        cliente.agregarCuenta(cuenta);
    }

    /**
     * Consulta el saldo actual de una cuenta.
     *
     * @param cuenta Cuenta sobre la cual se consulta el saldo
     * @return Saldo disponible en la cuenta
     */
    public double consultarSaldo(Cuenta cuenta) {
        return cuenta.getSaldo();
    }

    /**
     * Realiza un deposito en la cuenta indicada.
     *
     * Si el monto es mayor a 0, se actualiza el saldo de la cuenta
     * y se registra una transaccion de tipo {@link TipoTransaccion#DEPOSITO}.
     *
     * @param cuenta Cuenta donde se realizara el depósito
     * @param monto  Monto a depositar, debe ser positivo
     */
    public void realizarDeposito(Cuenta cuenta, double monto) {
        if (monto > 0) {
            double nuevoSaldo = cuenta.getSaldo() + monto;
            cuenta.setSaldo(nuevoSaldo);

            Transaccion transaccion = new Transaccion(
                    "TXN" + System.currentTimeMillis(), // Genera un ID único con timestamp
                    TipoTransaccion.DEPOSITO,
                    monto,
                    new Date()
            );
            cuenta.agregarTransaccion(transaccion);
        }
    }
}
