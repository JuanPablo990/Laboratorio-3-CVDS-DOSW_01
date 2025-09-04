package edu.dosw.lab.testing.Reto4;

public class Banco {
    private String idBanco;
    private String codigoBanco;
    private String nombreBanco;

    public Banco(String idBanco, String codigoBanco, String nombreBanco) {
        this.idBanco = idBanco;
        this.codigoBanco = codigoBanco;
        this.nombreBanco = nombreBanco;
    }

    public boolean validarCodigo(String codigo) {
        return this.codigoBanco.equals(codigo);
    }

    public String getIdBanco() {
        return idBanco;
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }
}