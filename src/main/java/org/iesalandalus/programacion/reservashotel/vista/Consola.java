package org.iesalandalus.programacion.reservashotel.vista;

import org.iesalandalus.programacion.reservashotel.dominio.*;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Consola {

    // Constructor privado, ya que no tiene sentido instanciar objetos de esta clase
    private Consola() {}

    // Método para mostrar el menú
    public static void mostrarMenu() {
        System.out.println("Menú:");
        for (Opcion opcion : Opcion.values()) {
            System.out.println(opcion);
        }
    }

    // Método para elegir una opción del menú
    public static Opcion elegirOpcion() {
        Scanner scanner = new Scanner(System.in);
        int opcionElegida;
        do {
            System.out.print("Elige una opción: ");
            try {
                opcionElegida = scanner.nextInt();
                if (opcionElegida >= 0 && opcionElegida < Opcion.values().length) {
                    return Opcion.values()[opcionElegida];
                } else {
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Debes introducir un número.");
                scanner.nextLine(); // Limpiar el buffer de entrada
            }
        } while (true);
    }

    // Método para leer datos de un huésped desde la consola
    public static Huesped leerHuesped() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del huésped: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce el DNI del huésped: ");
        String dni = scanner.nextLine();
        // Puedes añadir más atributos según las necesidades
        return new Huesped("NombreFicticio", dni);
    }

    // Método para leer un huésped por DNI
    public static Huesped leerClientePorDni(String dni) {
        // Puedes introducir datos ficticios o pedir al usuario los datos necesarios
        return new Huesped("NombreFicticio", dni);
    }

    // Método para leer una fecha desde la consola
    public static LocalDate leerFecha() {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.print("Introduce la fecha (YYYY-MM-DD): ");
                String fechaStr = scanner.nextLine();
                return LocalDate.parse(fechaStr);
            } catch (Exception e) {
                System.out.println("Fecha no válida. Inténtalo de nuevo.");
            }
        } while (true);
    }

    // Métodos similares para leer habitaciones, tipo de habitación, régimen, reservas, etc.

    // Puedes agregar métodos similares para leer habitaciones, tipo de habitación, régimen, reservas, etc.

    // Ejemplo de método para leer una habitación desde la consola
    public static Habitacion leerHabitacion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el número de planta: ");
        int planta = scanner.nextInt();
        System.out.print("Introduce el número de puerta: ");
        int puerta = scanner.nextInt();
        // Puedes añadir más atributos según las necesidades
        return new Habitacion(planta, puerta, TipoHabitacion.EJEMPLO, 100);
    }

    // Puedes agregar métodos similares para leer tipo de habitación, régimen, reservas, etc.

    // Método para leer un tipo de habitación desde la consola
    public static TipoHabitacion leerTipoHabitacion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige un tipo de habitación:");
        for (TipoHabitacion tipo : TipoHabitacion.values()) {
            System.out.println(tipo);
        }
        do {
            try {
                int opcion = scanner.nextInt();
                if (opcion >= 0 && opcion < TipoHabitacion.values().length) {
                    return TipoHabitacion.values()[opcion];
                } else {
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Debes introducir un número.");
                scanner.nextLine(); // Limpiar el buffer de entrada
            }
        } while (true);
    }

    // Método para leer un régimen desde la consola
    public static Regimen leerRegimen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige un tipo de régimen:");
        for (Regimen regimen : Regimen.values()) {
            System.out.println(regimen);
        }
        do {
            try {
                int opcion = scanner.nextInt();
                if (opcion >= 0 && opcion < Regimen.values().length) {
                    return Regimen.values()[opcion];
                } else {
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Debes introducir un número.");
                scanner.nextLine(); // Limpiar el buffer de entrada
            }
        } while (true);
    }

    // Método para leer una reserva desde la consola
    public static Reserva leerReserva() {
        // Puedes implementar este método de manera similar a los anteriores
        return new Reserva(); // Reemplaza con la lógica adecuada
    }
}
