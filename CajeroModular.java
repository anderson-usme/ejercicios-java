import java.util.Scanner;

public class CajeroModular {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double saldo = 1000.0;
        boolean continuar = true;

        while (continuar) {
            int opcion = mostrarMenu(sc);

            switch (opcion) {
                case 1:
                    consultarSaldo(sc, saldo);
                    break;
                case 2:
                    saldo = retirarDinero(sc, saldo);
                    break;
                case 3:
                    saldo = depositarDinero(sc, saldo);
                    break;
                case 4:
                    saldo = transferirDinero(sc, saldo);
                    break;
                case 5:
                    continuar = confirmarSalida(sc);
                    break;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        }

        sc.close();
    }

    // === MÉTODOS ===

    public static int mostrarMenu(Scanner sc) {
        System.out.println("\n=== CAJERO AUTOMÁTICO ===");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Depositar dinero");
        System.out.println("4. Transferir dinero");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");

        while (!sc.hasNextInt()) {
            System.out.println("Entrada inválida. Ingresa un número.");
            sc.next();
        }
        return sc.nextInt();
    }

    public static void consultarSaldo(Scanner sc, double saldo) {
        sc.nextLine(); // limpiar buffer
        System.out.println("Tu saldo actual es: $" + saldo);
    }

    public static double retirarDinero(Scanner sc, double saldo) {
        double retiro = 0;
        boolean confirmado = false;

        do {
            System.out.print("Ingresa el monto a retirar: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Valor inválido. Ingresa un número.");
                sc.next();
            }
            retiro = sc.nextDouble();
            sc.nextLine();

            System.out.print("Confirmas retirar $" + retiro + "? (S/N): ");
            char conf = sc.nextLine().charAt(0);
            if (conf == 'S' || conf == 's') {
                confirmado = true;
            }

        } while (!confirmado);

        if (retiro > saldo) {
            System.out.println("No tienes suficiente saldo.");
        } else {
            saldo -= retiro;
            System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
        }
        return saldo;
    }

    public static double depositarDinero(Scanner sc, double saldo) {
        double deposito = 0;
        boolean confirmado = false;

        do {
            System.out.print("Ingresa el monto a depositar: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Valor inválido. Ingresa un número.");
                sc.next();
            }
            deposito = sc.nextDouble();
            sc.nextLine();

            System.out.print("Confirmas depositar $" + deposito + "? (S/N): ");
            char conf = sc.nextLine().charAt(0);
            if (conf == 'S' || conf == 's') {
                confirmado = true;
            }

        } while (!confirmado);

        saldo += deposito;
        System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
        return saldo;
    }

    public static double transferirDinero(Scanner sc, double saldo) {
        double transferencia = 0;
        boolean confirmado = false;

        do {
            System.out.print("Ingresa el monto a transferir: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Valor inválido. Ingresa un número.");
                sc.next();
            }
            transferencia = sc.nextDouble();
            sc.nextLine();

            System.out.print("Confirmas transferir $" + transferencia + "? (S/N): ");
            char conf = sc.nextLine().charAt(0);
            if (conf == 'S' || conf == 's') {
                confirmado = true;
            }

        } while (!confirmado);

        if (transferencia > saldo) {
            System.out.println("No tienes suficiente saldo para transferir.");
        } else {
            saldo -= transferencia;
            System.out.println("Transferencia exitosa.");
            System.out.println("Valor transferido: $" + transferencia);
            System.out.println("Nuevo saldo: $" + saldo);
        }
        return saldo;
    }

    public static boolean confirmarSalida(Scanner sc) {
        sc.nextLine(); // limpiar buffer
        System.out.print("¿Estás seguro de que deseas salir? (S/N): ");
        char conf = sc.nextLine().charAt(0);
        if (conf == 'S' || conf == 's') {
            System.out.println("Gracias por usar el cajero. ¡Hasta pronto!");
            return false; // detener el bucle
        } else {
            System.out.println("Operación cancelada. Regresando al menú...");
            return true; // continuar
        }
    }
}
