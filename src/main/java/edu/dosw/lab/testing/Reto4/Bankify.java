package edu.dosw.lab.testing.Reto4;

import java.util.ArrayList;
import java.util.List;

public class Bankify {
    private GestionarCuenta gestionarCuenta;
    private ValidarCuenta validarCuenta;
    private List<Cliente> clientes;
    private List<Cuenta> cuentas;
    private List<Banco> bancos;

    public Bankify() {
        this.gestionarCuenta = new GestionarCuenta();
        this.validarCuenta = new ValidarCuenta();
        this.clientes = new ArrayList<>();
        this.cuentas = new ArrayList<>();
        this.bancos = new ArrayList<>();
    }

    public void crearCuenta(Cliente cliente, Cuenta cuenta) {
        if (validarNumeroCuenta(cuenta.getNumeroCuenta(), cuenta.getBanco())) {
            gestionarCuenta.crearCuenta(cliente, cuenta);
            cuentas.add(cuenta);
            System.out.println("Cuenta creada exitosamente: " + cuenta.getNumeroCuenta());
        } else {
            System.out.println("Error: Número de cuenta no válido");
        }
    }

    public boolean validarNumeroCuenta(String numeroCuenta, Banco banco) {
        return validarCuenta.validarLongitud(numeroCuenta) &&
                validarCuenta.validarPrefijo(numeroCuenta, banco) &&
                validarCuenta.validarFormato(numeroCuenta);
    }

    public boolean cuentaExiste(String numeroCuenta) {
        return cuentas.stream()
                .anyMatch(cuenta -> cuenta.getNumeroCuenta().equals(numeroCuenta));
    }

    public Cuenta buscarCuenta(String numeroCuenta) {
        return cuentas.stream()
                .filter(cuenta -> cuenta.getNumeroCuenta().equals(numeroCuenta))
                .findFirst()
                .orElse(null);
    }

    public double consultarSaldo(String numeroCuenta) {
        Cuenta cuenta = buscarCuenta(numeroCuenta);
        if (cuenta != null && cuentaExiste(numeroCuenta)) {
            return gestionarCuenta.consultarSaldo(cuenta);
        }
        throw new IllegalArgumentException("Cuenta no encontrada: " + numeroCuenta);
    }

    public void realizarDeposito(String numeroCuenta, double monto) {
        Cuenta cuenta = buscarCuenta(numeroCuenta);
        if (cuenta != null && cuentaExiste(numeroCuenta)) {
            if (monto > 0) {
                gestionarCuenta.realizarDeposito(cuenta, monto);
                System.out.println("Depósito exitoso: $" + monto + " en cuenta " + numeroCuenta);
            } else {
                throw new IllegalArgumentException("Monto de depósito debe ser positivo");
            }
        } else {
            throw new IllegalArgumentException("Cuenta no encontrada: " + numeroCuenta);
        }
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void registrarBanco(Banco banco) {
        bancos.add(banco);
    }

    public Cliente buscarCliente(String idCliente) {
        return clientes.stream()
                .filter(cliente -> cliente.getIdCliente().equals(idCliente))
                .findFirst()
                .orElse(null);
    }

    public Banco buscarBanco(String idBanco) {
        return bancos.stream()
                .filter(banco -> banco.getIdBanco().equals(idBanco))
                .findFirst()
                .orElse(null);
    }

    public List<Cuenta> getCuentasCliente(String idCliente) {
        Cliente cliente = buscarCliente(idCliente);
        if (cliente != null) {
            return cliente.getCuentas();
        }
        return new ArrayList<>();
    }
}