package edu.dosw.lab.Reto4;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private String numeroCuenta;
    private double saldo;
    private Banco banco;
    private List<Transaccion> transacciones;

    public Cuenta(String numeroCuenta, Banco banco) {
        this.numeroCuenta = numeroCuenta;
        this.banco = banco;
        this.saldo = 0.0;
        this.transacciones = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double monto) {
        this.saldo = monto;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public Banco getBanco() {
        return banco;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void agregarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }
}