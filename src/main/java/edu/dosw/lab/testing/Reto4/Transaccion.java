package edu.dosw.lab.testing.Reto4;

import java.util.Date;

public class Transaccion {
    private String idTransaccion;
    private TipoTransaccion tipo;
    private double monto;
    private Date fecha;

    public Transaccion(String idTransaccion, TipoTransaccion tipo, double monto, Date fecha) {
        this.idTransaccion = idTransaccion;
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public TipoTransaccion getTipo() {
        return tipo;
    }

    public double getMonto() {
        return monto;
    }

    public Date getFecha() {
        return fecha;
    }
}