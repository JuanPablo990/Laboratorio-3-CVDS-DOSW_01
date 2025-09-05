package edu.dosw.lab.testing.Reto4;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un cliente dentro del sistema bancario.
 *
 * Cada cliente tiene un identificador unico, nombre, documento de identidad,
 * correo electronico y una lista de cuentas asociadas.
 *
 * Permite almacenar y recuperar la informacion del cliente, así como
 * administrar las cuentas que le pertenecen.
 */
public class Cliente {

    private String idCliente;
    private String nombre;
    private String documento;
    private String correo;
    private List<Cuenta> cuentas;

    /**
     * Construye un nuevo cliente con sus datos básicos.
     *
     * @param idCliente Identificador único del cliente
     * @param nombre Nombre del cliente
     * @param documento Documento de identidad del cliente
     * @param correo Correo electrónico del cliente
     */
    public Cliente(String idCliente, String nombre, String documento, String correo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.documento = documento;
        this.correo = correo;
        this.cuentas = new ArrayList<>();
    }

    /**
     * Obtiene el identificador único del cliente.
     *
     * @return ID del cliente
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return Nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el documento de identidad del cliente.
     *
     * @return Documento del cliente
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     *
     * @return Correo del cliente
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Obtiene la lista de cuentas asociadas al cliente.
     *
     * @return Lista de cuentas
     */
    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    /**
     * Agrega una cuenta a la lista de cuentas del cliente.
     *
     * @param cuenta Cuenta a asociar al cliente
     */
    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }
}
