package edu.dosw.lab.testing.Reto4;

/**
 * Representa un banco dentro del sistema.
 *
 * Cada banco esta identificado por un ID unico, un código de banco
 * (prefijo usado en las cuentas) y un nombre.
 *
 * Esta clase permite validar si un codigo corresponde al banco y
 * proporciona acceso a sus atributos.
 */
public class Banco {
    /** Identificador unico del banco */
    private String idBanco;

    /** Codigo del banco usado como prefijo en las cuentas */
    private String codigoBanco;

    /** Nombre del banco */
    private String nombreBanco;

    /**
     * Construye un nuevo banco con sus datos basicos.
     *
     * @param idBanco Identificador unico del banco
     * @param codigoBanco Codigo del banco
     * @param nombreBanco Nombre del banco
     */
    public Banco(String idBanco, String codigoBanco, String nombreBanco) {
        this.idBanco = idBanco;
        this.codigoBanco = codigoBanco;
        this.nombreBanco = nombreBanco;
    }

    /**
     * Verifica si el codigo ingresado corresponde al codigo del banco.
     *
     * @param codigo Codigo a validar
     * @return {@code true} si el codigo coincide, {@code false} en caso contrario
     */
    public boolean validarCodigo(String codigo) {
        return this.codigoBanco.equals(codigo);
    }

    /**
     * Obtiene el identificador unico del banco.
     *
     * @return ID del banco
     */
    public String getIdBanco() {
        return idBanco;
    }

    /**
     * Obtiene el codigo del banco.
     *
     * @return Codigo del banco
     */
    public String getCodigoBanco() {
        return codigoBanco;
    }

    /**
     * Obtiene el nombre del banco.
     *
     * @return Nombre del banco
     */
    public String getNombreBanco() {
        return nombreBanco;
    }
}
