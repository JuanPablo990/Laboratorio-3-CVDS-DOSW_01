package edu.dosw.lab.testing.Reto4;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una cuenta bancaria perteneciente a un {@link Cliente}.
 *
 * Cada cuenta tiene un numero unico, un banco asociado, un saldo disponible
 * y un historial de transacciones realizadas.
 *
 * Permite consultar y modificar el saldo, asi como registrar transacciones.
 */
public class Cuenta {
    /** Numero unico de la cuenta bancaria */
    private String numeroCuenta;

    /** Saldo actual de la cuenta */
    private double saldo;

    /** Banco al que pertenece la cuenta */
    private Banco banco;

    /** Lista de transacciones asociadas a la cuenta */
    private List<Transaccion> transacciones;

    /**
     * Crea una nueva cuenta con un numero de cuenta y un banco especifico.
     * El saldo inicial es 0 y no tiene transacciones registradas.
     *
     * @param numeroCuenta Numero unico de la cuenta
     * @param banco Banco al que pertenece la cuenta
     */
    public Cuenta(String numeroCuenta, Banco banco) {
        this.numeroCuenta = numeroCuenta;
        this.banco = banco;
        this.saldo = 0.0;
        this.transacciones = new ArrayList<>();
    }

    /**
     * Obtiene el saldo actual de la cuenta.
     *
     * @return Saldo disponible
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Actualiza el saldo de la cuenta.
     *
     * @param monto Nuevo saldo a asignar
     */
    public void setSaldo(double monto) {
        this.saldo = monto;
    }

    /**
     * Obtiene el numero unico de la cuenta.
     *
     * @return Numero de cuenta
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Obtiene el banco asociado a esta cuenta.
     *
     * @return Banco de la cuenta
     */
    public Banco getBanco() {
        return banco;
    }

    /**
     * Obtiene la lista de transacciones realizadas en esta cuenta.
     *
     * @return Lista de transacciones
     */
    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    /**
     * Registra una nueva transaccion en la cuenta.
     *
     * @param transaccion Transaccion a agregar
     */
    public void agregarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }
}
