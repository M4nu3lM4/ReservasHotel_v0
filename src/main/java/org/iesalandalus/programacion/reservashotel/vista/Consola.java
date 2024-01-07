package org.iesalandalus.programacion.reservashotel.vista;

import org.iesalandalus.programacion.reservashotel.dominio.*;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Consola {

    // Constructor privado, ya que no tiene sentido instanciar objetos de esta clase
    private Consola() {}

    // M�todo para mostrar el men�
    public static void mostrarMenu() {
        System.out.println("Men�:");
        for (Opcion opcion : Opcion.values()) {
            System.out.println(opcion);
        }
    }

    // M�todo para elegir una opci�n del men�
    public static Opcion elegirOpcion() {
        Scanner scanner = new Scanner(System.in);
        int opcionElegida;
        do {
            System.out.print("Elige una opci�n: ");
            try {
                opcionElegida = scanner.nextInt();
                if (opcionElegida >= 0 && opcionElegida < Opcion.values().length) {
                    return Opcion.values()[opcionElegida];
                } else {
                    System.out.println("Opci�n no v�lida. Int�ntalo de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no v�lida. Debes introducir un n�mero.");
                scanner.nextLine(); // Limpiar el buffer de entrada
            }
        } while (true);
    }

    // M�todo para leer datos de un hu�sped desde la consola
    public static Huesped leerHuesped() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del hu�sped: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce el DNI del hu�sped: ");
        String dni = scanner.nextLine();
        // Puedes a�adir m�s atributos seg�n las necesidades
        return new Huesped("NombreFicticio", dni);
    }

    // M�todo para leer un hu�sped por DNI
    public static Huesped leerClientePorDni(String dni) {
        // Puedes introducir datos ficticios o pedir al usuario los datos necesarios
        return new Huesped("NombreFicticio", dni);
    }

    // M�todo para leer una fecha desde la consola
    public static LocalDate leerFecha() {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.print("Introduce la fecha (YYYY-MM-DD): ");
                String fechaStr = scanner.nextLine();
                return LocalDate.parse(fechaStr);
            } catch (Exception e) {
                System.out.println("Fecha no v�lida. Int�ntalo de nuevo.");
            }
        } while (true);
    }

    // M�todos similares para leer habitaciones, tipo de habitaci�n, r�gimen, reservas, etc.

    // Puedes agregar m�todos similares para leer habitaciones, tipo de habitaci�n, r�gimen, reservas, etc.

    // Ejemplo de m�todo para leer una habitaci�n desde la consola
    public static Habitacion leerHabitacion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el n�mero de planta: ");
        int planta = scanner.nextInt();
        System.out.print("Introduce el n�mero de puerta: ");
        int puerta = scanner.nextInt();
        // Puedes a�adir m�s atributos seg�n las necesidades
        return new Habitacion(planta, puerta, TipoHabitacion.EJEMPLO, 100);
    }

    // Puedes agregar m�todos similares para leer tipo de habitaci�n, r�gimen, reservas, etc.

    // M�todo para leer un tipo de habitaci�n desde la consola
    public static TipoHabitacion leerTipoHabitacion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige un tipo de habitaci�n:");
        for (TipoHabitacion tipo : TipoHabitacion.values()) {
            System.out.println(tipo);
        }
        do {
            try {
                int opcion = scanner.nextInt();
                if (opcion >= 0 && opcion < TipoHabitacion.values().length) {
                    return TipoHabitacion.values()[opcion];
                } else {
                    System.out.println("Opci�n no v�lida. Int�ntalo de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no v�lida. Debes introducir un n�mero.");
                scanner.nextLine(); // Limpiar el buffer de entrada
            }
        } while (true);
    }

    // M�todo para leer un r�gimen desde la consola
    public static Regimen leerRegimen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige un tipo de r�gimen:");
        for (Regimen regimen : Regimen.values()) {
            System.out.println(regimen);
        }
        do {
            try {
                int opcion = scanner.nextInt();
                if (opcion >= 0 && opcion < Regimen.values().length) {
                    return Regimen.values()[opcion];
                } else {
                    System.out.println("Opci�n no v�lida. Int�ntalo de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no v�lida. Debes introducir un n�mero.");
                scanner.nextLine(); // Limpiar el buffer de entrada
            }
        } while (true);
    }

    // M�todo para leer una reserva desde la consola
    public static Reserva leerReserva() {
        // Puedes implementar este m�todo de manera similar a los anteriores
        return new Reserva(); // Reemplaza con la l�gica adecuada
    }
}
