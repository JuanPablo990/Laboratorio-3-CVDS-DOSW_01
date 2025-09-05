package edu.dosw.lab.testing.Reto4;

/**
 * Enumeración que representa los tipos de transacciones
 * posibles dentro del sistema bancario.
 *
 * Los valores disponibles son:
 *
 *     {@link #DEPOSITO} → Cuando se agrega dinero a una cuenta.
 *     {@link #RETIRO} → Cuando se retira dinero de una cuenta.
 *     {@link #TRANSFERENCIA} → Cuando se transfiere dinero entre cuentas.
 *
 *
 * Esta enumeración se utiliza en la clase {@link Transaccion}
 * para definir la naturaleza de cada movimiento bancario.
 */
public enum TipoTransaccion {
    DEPOSITO,
    RETIRO,
    TRANSFERENCIA
}
