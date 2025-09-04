package edu.dosw.lab.testing.Reto4;

public class Reto4 {
    public static void ejecutar() {
        Bankify bankify = new Bankify();

        Banco banco1 = new Banco("B001", "001", "Banco Nacional");
        Banco banco2 = new Banco("B002", "002", "Banco Internacional");

        bankify.registrarBanco(banco1);
        bankify.registrarBanco(banco2);

        Cliente cliente1 = new Cliente("C001", "Juan Pérez", "12345678", "juan@email.com");
        Cliente cliente2 = new Cliente("C002", "María García", "87654321", "maria@email.com");

        bankify.registrarCliente(cliente1);
        bankify.registrarCliente(cliente2);

        System.out.println("=== CREACIÓN DE CUENTAS ===");

        Cuenta cuenta1 = new Cuenta("0011234567", banco1);
        Cuenta cuenta2 = new Cuenta("0027654321", banco2);
        Cuenta cuentaInvalida = new Cuenta("0031111111", banco1);

        bankify.crearCuenta(cliente1, cuenta1);
        bankify.crearCuenta(cliente2, cuenta2);
        bankify.crearCuenta(cliente1, cuentaInvalida);

        System.out.println("\n=== VALIDACIÓN DE CUENTAS ===");
        System.out.println("Cuenta 0011234567 existe: " + bankify.cuentaExiste("0011234567"));
        System.out.println("Cuenta 9999999999 existe: " + bankify.cuentaExiste("9999999999"));
        System.out.println("Cuenta 0011234567 es válida: " + bankify.validarNumeroCuenta("0011234567", banco1));

        System.out.println("\n=== CONSULTA DE SALDOS ===");
        try {
            double saldo1 = bankify.consultarSaldo("0011234567");
            System.out.println("Saldo cuenta 0011234567: $" + saldo1);

            double saldo2 = bankify.consultarSaldo("0027654321");
            System.out.println("Saldo cuenta 0027654321: $" + saldo2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== REALIZAR DEPÓSITOS ===");
        try {
            bankify.realizarDeposito("0011234567", 1000.0);
            bankify.realizarDeposito("0027654321", 500.0);

            double nuevoSaldo1 = bankify.consultarSaldo("0011234567");
            double nuevoSaldo2 = bankify.consultarSaldo("0027654321");

            System.out.println("Nuevo saldo cuenta 0011234567: $" + nuevoSaldo1);
            System.out.println("Nuevo saldo cuenta 0027654321: $" + nuevoSaldo2);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== CUENTAS POR CLIENTE ===");
        System.out.println("Cuentas de Juan Pérez:");
        bankify.getCuentasCliente("C001").forEach(cuenta ->
                System.out.println("- " + cuenta.getNumeroCuenta() + " (" + cuenta.getBanco().getNombreBanco() + ")")
        );

        System.out.println("\n=== PRUEBA DE ERRORES ===");
        try {
            bankify.consultarSaldo("9999999999");
        } catch (IllegalArgumentException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }

        try {
            bankify.realizarDeposito("0011234567", -100.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
    }
}