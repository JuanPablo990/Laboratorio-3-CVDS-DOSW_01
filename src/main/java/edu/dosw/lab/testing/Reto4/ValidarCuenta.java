package edu.dosw.lab.testing.Reto4;

/**
 * Clase encargada de validar las reglas asociadas a los números de cuenta bancaria.
 *
 * Provee métodos para verificar que un número de cuenta cumpla con:
 *
 *     La longitud adecuada (10 dígitos).
 *     El prefijo correcto, asociado al banco correspondiente.
 *     El formato correcto (solo caracteres numéricos).
 *
 */
public class ValidarCuenta {

    /**
     * Constructor por defecto de la clase.
     */
    public ValidarCuenta() {}

    /**
     * Verifica que el número de cuenta tenga exactamente 10 caracteres.
     *
     * @param numeroCuenta número de cuenta a validar
     * @return {@code true} si la cuenta tiene 10 dígitos, {@code false} en caso contrario
     */
    public boolean validarLongitud(String numeroCuenta) {
        return numeroCuenta != null && numeroCuenta.length() == 10;
    }

    /**
     * Verifica que el número de cuenta tenga un prefijo válido
     * que coincida con el código del banco asociado.
     *
     * @param numeroCuenta número de cuenta a validar
     * @param banco banco al que debería pertenecer el prefijo
     * @return {@code true} si el prefijo coincide con el código del banco, {@code false} en caso contrario
     */
    public boolean validarPrefijo(String numeroCuenta, Banco banco) {
        if (numeroCuenta == null || banco == null) return false;
        String prefijo = numeroCuenta.substring(0, 3);
        return prefijo.equals(banco.getCodigoBanco());
    }

    /**
     * Verifica que el número de cuenta contenga únicamente caracteres numéricos.
     *
     * @param numeroCuenta número de cuenta a validar
     * @return {@code true} si el formato es válido (solo números), {@code false} en caso contrario
     */
    public boolean validarFormato(String numeroCuenta) {
        return numeroCuenta != null && numeroCuenta.matches("\\d+");
    }
}
