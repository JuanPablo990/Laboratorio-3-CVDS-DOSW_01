package edu.dosw.lab.testing.Reto4;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que representa el sistema bancario "Bankify".
 *
 * Esta clase gestiona clientes, cuentas y bancos, permitiendo realizar
 * operaciones como creacion de cuentas, validacion de numeros de cuenta,
 * consultas de saldo, depositos y busquedas.
 *
 * Funciona como un intermediario entre las operaciones de {@link GestionarCuenta},
 * las validaciones de {@link ValidarCuenta}, y las entidades {@link Cliente}, {@link Cuenta}, {@link Banco}.
 */
public class Bankify {

    private GestionarCuenta gestionarCuenta;
    private ValidarCuenta validarCuenta;
    private List<Cliente> clientes;
    private List<Cuenta> cuentas;
    private List<Banco> bancos;

    /**
     * Constructor que inicializa las listas y servicios de gestion y validación.
     */
    public Bankify() {
        this.gestionarCuenta = new GestionarCuenta();
        this.validarCuenta = new ValidarCuenta();
        this.clientes = new ArrayList<>();
        this.cuentas = new ArrayList<>();
        this.bancos = new ArrayList<>();
    }

    /**
     * Crea una cuenta para un cliente si el numero de cuenta es valido.
     *
     * @param cliente Cliente asociado a la cuenta
     * @param cuenta Cuenta a crear
     */
    public void crearCuenta(Cliente cliente, Cuenta cuenta) {
        if (validarNumeroCuenta(cuenta.getNumeroCuenta(), cuenta.getBanco())) {
            gestionarCuenta.crearCuenta(cliente, cuenta);
            cuentas.add(cuenta);
            System.out.println("Cuenta creada exitosamente: " + cuenta.getNumeroCuenta());
        } else {
            System.out.println("Error: Numero de cuenta no válido");
        }
    }

    /**
     * Valida si un numero de cuenta cumple con longitud, prefijo y formato.
     *
     * @param numeroCuenta Numero de cuenta a validar
     * @param banco Banco asociado
     * @return {@code true} si el numero de cuenta es valido, {@code false} en caso contrario
     */
    public boolean validarNumeroCuenta(String numeroCuenta, Banco banco) {
        return validarCuenta.validarLongitud(numeroCuenta) &&
                validarCuenta.validarPrefijo(numeroCuenta, banco) &&
                validarCuenta.validarFormato(numeroCuenta);
    }

    /**
     * Verifica si una cuenta existe en el sistema.
     *
     * @param numeroCuenta Numero de cuenta a buscar
     * @return {@code true} si la cuenta existe, {@code false} en caso contrario
     */
    public boolean cuentaExiste(String numeroCuenta) {
        return cuentas.stream()
                .anyMatch(cuenta -> cuenta.getNumeroCuenta().equals(numeroCuenta));
    }

    /**
     * Busca una cuenta en el sistema.
     *
     * @param numeroCuenta Numero de cuenta a buscar
     * @return La cuenta encontrada o {@code null} si no existe
     */
    public Cuenta buscarCuenta(String numeroCuenta) {
        return cuentas.stream()
                .filter(cuenta -> cuenta.getNumeroCuenta().equals(numeroCuenta))
                .findFirst()
                .orElse(null);
    }

    /**
     * Consulta el saldo de una cuenta.
     *
     * @param numeroCuenta Numero de cuenta
     * @return Saldo de la cuenta
     * @throws IllegalArgumentException si la cuenta no existe
     */
    public double consultarSaldo(String numeroCuenta) {
        Cuenta cuenta = buscarCuenta(numeroCuenta);
        if (cuenta != null && cuentaExiste(numeroCuenta)) {
            return gestionarCuenta.consultarSaldo(cuenta);
        }
        throw new IllegalArgumentException("Cuenta no encontrada: " + numeroCuenta);
    }

    /**
     * Realiza un deposito en una cuenta.
     *
     * @param numeroCuenta Numero de cuenta destino
     * @param monto Monto a depositar (debe ser positivo)
     * @throws IllegalArgumentException si la cuenta no existe o el monto es invalido
     */
    public void realizarDeposito(String numeroCuenta, double monto) {
        Cuenta cuenta = buscarCuenta(numeroCuenta);
        if (cuenta != null && cuentaExiste(numeroCuenta)) {
            if (monto > 0) {
                gestionarCuenta.realizarDeposito(cuenta, monto);
                System.out.println("Deposito exitoso: $" + monto + " en cuenta " + numeroCuenta);
            } else {
                throw new IllegalArgumentException("Monto de deposito debe ser positivo");
            }
        } else {
            throw new IllegalArgumentException("Cuenta no encontrada: " + numeroCuenta);
        }
    }

    /**
     * Registra un nuevo cliente en el sistema.
     *
     * @param cliente Cliente a registrar
     */
    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    /**
     * Registra un nuevo banco en el sistema.
     *
     * @param banco Banco a registrar
     */
    public void registrarBanco(Banco banco) {
        bancos.add(banco);
    }

    /**
     * Busca un cliente por su ID.
     *
     * @param idCliente ID del cliente
     * @return Cliente encontrado o {@code null} si no existe
     */
    public Cliente buscarCliente(String idCliente) {
        return clientes.stream()
                .filter(cliente -> cliente.getIdCliente().equals(idCliente))
                .findFirst()
                .orElse(null);
    }

    /**
     * Busca un banco por su ID.
     *
     * @param idBanco ID del banco
     * @return Banco encontrado o {@code null} si no existe
     */
    public Banco buscarBanco(String idBanco) {
        return bancos.stream()
                .filter(banco -> banco.getIdBanco().equals(idBanco))
                .findFirst()
                .orElse(null);
    }

    /**
     * Obtiene todas las cuentas asociadas a un cliente.
     *
     * @param idCliente ID del cliente
     * @return Lista de cuentas del cliente, vacía si no existe
     */
    public List<Cuenta> getCuentasCliente(String idCliente) {
        Cliente cliente = buscarCliente(idCliente);
        if (cliente != null) {
            return cliente.getCuentas();
        }
        return new ArrayList<>();
    }
}
