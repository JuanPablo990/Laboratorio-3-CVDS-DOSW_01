package edu.dosw.lab.testing.Reto4;

public class ValidarCuenta {
    public ValidarCuenta() {}

    public boolean validarLongitud(String numeroCuenta) {
        return numeroCuenta != null && numeroCuenta.length() == 10;
    }

    public boolean validarPrefijo(String numeroCuenta, Banco banco) {
        if (numeroCuenta == null || banco == null) return false;
        String prefijo = numeroCuenta.substring(0, 3);
        return prefijo.equals(banco.getCodigoBanco());
    }

    public boolean validarFormato(String numeroCuenta) {
        return numeroCuenta != null && numeroCuenta.matches("\\d+");
    }
}