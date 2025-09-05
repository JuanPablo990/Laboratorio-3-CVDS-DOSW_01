package edu.dosw.lab.testing.Reto4;

import java.util.Date;

/**
 * Representa una transacción bancaria realizada sobre una cuenta.
 *
 * Cada transacción incluye:
 *
 *     Un identificador único ({@code idTransaccion}).
 *     El tipo de transacción realizada ({@link TipoTransaccion}).
 *     El monto involucrado en la operación.
 *     La fecha en que se efectuó.
 *
 *
 * Los tipos de transacciones posibles son definidos en
 * la enumeración {@link TipoTransaccion}, e incluyen depósitos,
 * retiros y transferencias.
 */
public class Transaccion {
    /** Identificador único de la transacción. */
    private String idTransaccion;

    /** Tipo de transacción (depósito, retiro o transferencia). */
    private TipoTransaccion tipo;

    /** Monto de dinero involucrado en la transacción. */
    private double monto;

    /** Fecha en que se registró la transacción. */
    private Date fecha;

    /**
     * Construye una nueva transacción con los datos especificados.
     *
     * @param idTransaccion identificador único de la transacción
     * @param tipo tipo de transacción (definido en {@link TipoTransaccion})
     * @param monto monto de dinero involucrado
     * @param fecha fecha en que se realizó la transacción
     */
    public Transaccion(String idTransaccion, TipoTransaccion tipo, double monto, Date fecha) {
        this.idTransaccion = idTransaccion;
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
    }

    /**
     * Obtiene el identificador único de la transacción.
     *
     * @return el id de la transacción
     */
    public String getIdTransaccion() {
        return idTransaccion;
    }

    /**
     * Obtiene el tipo de transacción.
     *
     * @return el tipo de transacción
     */
    public TipoTransaccion getTipo() {
        return tipo;
    }

    /**
     * Obtiene el monto de la transacción.
     *
     * @return el monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Obtiene la fecha en que se realizó la transacción.
     *
     * @return la fecha de la transacción
     */
    public Date getFecha() {
        return fecha;
    }
}
