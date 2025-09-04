package edu.dosw.lab.Reto4;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String idCliente;
    private String nombre;
    private String documento;
    private String correo;
    private List<Cuenta> cuentas;

    public Cliente(String idCliente, String nombre, String documento, String correo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.documento = documento;
        this.correo = correo;
        this.cuentas = new ArrayList<>();
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getCorreo() {
        return correo;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }
}