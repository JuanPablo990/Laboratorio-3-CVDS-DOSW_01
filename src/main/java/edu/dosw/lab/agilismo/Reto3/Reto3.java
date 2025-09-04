package edu.dosw.lab.agilismo.Reto3;

import java.util.*;

public class Reto3 {

    private static final List<Integer> FIB = Arrays.asList(1, 2, 3, 5, 8, 13);

    private static class Story {
        String title;
        Integer finalVote;

        Story(String title) {
            this.title = title;
            this.finalVote = null;
        }
    }

    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== RETO #3: Simulación Planning Poker (consola) ===\n");

        List<Story> stories = Arrays.asList(
                new Story("COMO cliente QUIERO crear una cuenta bancaria PARA PODER manejar mejor el dinero"),
                new Story("COMO cliente QUIERO validar la cuenta PARA PODER ver mis movimientos"),
                new Story("COMO cliente QUIERO consultar saldo PARA PODER ver que cantidad de dinero tengo"),
                new Story("COMO cliente QUIERO realizar deposito PARA PODER pagar cuentas"),
                new Story("COMO Sistema Bankify QUIERO validar cuenta PARA PODER verificar que clientes tengo"),
                new Story("COMO Sistema Bankify QUIERO registrar bancos validos PARA PODER tener un catalogo amplio de clientes"),
                new Story("COMO banco QUIERO recibir informacion de validacion de cuenta PARA PODER tener mis bases de datos validas"),
                new Story("COMO banco QUIERO actualizar informacion de entidad bancaria PARA PODER tener todo según las normas")
        );

        List<String> participants = loadParticipants(sc);

        System.out.println("\nIniciando sesión de Planning Poker...");
        System.out.printf("Historias a estimar: %d | Participantes: %d\n\n", stories.size(), participants.size());

        for (Story s : stories) {
            System.out.println("--------------------------------------------------");
            System.out.println("Historia: " + s.title);

            boolean consensusReached = false;
            int round = 1;
            while (!consensusReached) {
                System.out.printf("\n-- Ronda %d de votación --\n", round);
                Map<String, Integer> votes = new LinkedHashMap<>();

                for (String p : participants) {
                    int vote = askVoteForParticipant(sc, p);
                    votes.put(p, vote);
                }

                Set<Integer> distinct = new HashSet<>(votes.values());
                if (distinct.size() == 1) {
                    int agreed = distinct.iterator().next();
                    s.finalVote = agreed;
                    System.out.printf("\n Todos votaron %d — Consenso alcanzado.\n", agreed);
                    consensusReached = true;
                } else {
                    System.out.println("\nVotos actuales (divergentes):");
                    for (Map.Entry<String, Integer> e : votes.entrySet()) {
                        System.out.printf(" - %s: %d\n", e.getKey(), e.getValue());
                    }
                    System.out.println("\n  Votos divergentes – Discutan y vuelvan a votar.");
                    System.out.println("(Pulsa ENTER cuando estén listos para la siguiente ronda)");
                    sc.nextLine();
                    round++;
                }
            }
        }

        System.out.println("\n==================================================");
        System.out.println("Resumen final de estimaciones:");
        for (Story s : stories) {
            System.out.printf(" - %s -> %s\n", s.title, s.finalVote == null ? "Sin puntaje" : s.finalVote);
        }
        System.out.println("==================================================");
        System.out.println("Fin de la sesión. Gracias.");
        sc.close();
    }

    private static List<String> loadParticipants(Scanner sc) {
        List<String> participants = new ArrayList<>();
        System.out.print("¿Cuántos participantes votarán? ");
        int p = readPositiveInt(sc);
        sc.nextLine();
        for (int i = 1; i <= p; i++) {
            System.out.printf("Nombre participante %d: ", i);
            String name = sc.nextLine().trim();
            if (name.isEmpty()) name = "Participante" + i;
            participants.add(name);
        }
        return participants;
    }

    private static int askVoteForParticipant(Scanner sc, String participant) {
        while (true) {
            System.out.printf("%s, ingresa tu voto %s: ", participant, FIB.toString());
            String line = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(line);
                if (FIB.contains(v)) return v;
                else System.out.printf("Valor inválido. Debes escoger uno de %s.\n", FIB.toString());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Ingresa un número.");
            }
        }
    }

    private static int readPositiveInt(Scanner sc) {
        while (true) {
            String token = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(token);
                if (v > 0) return v;
                else System.out.print("Ingresa un número mayor que cero: ");
            } catch (NumberFormatException e) {
                System.out.print("Entrada no válida. Ingresa un número entero positivo: ");
            }
        }
    }
}
