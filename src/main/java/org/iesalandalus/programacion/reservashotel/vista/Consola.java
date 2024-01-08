package org.iesalandalus.programacion.reservashotel.vista;

import org.iesalandalus.programacion.reservashotel.dominio.*;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.time.format.DateTimeFormatter;


public class Consola {
    private Consola() {
        // Constructor privado para prevenir la instanciaci�n
    }

    public static void mostrarMenu() {
        for (Opcion opcion : Opcion.values()) {
            System.out.println(opcion);
        }
    }

    public static Opcion elegirOpcion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige una opcion:");
        int opcionElegida = scanner.nextInt();
        return Opcion.values()[opcionElegida];
    }

    public static Huesped leerHuesped() {
        // Implementaci�n de la lectura de un hu�sped...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce los datos del hu�sped:");

        System.out.println("Nombre:");
        String nombre = scanner.nextLine();

        System.out.println("DNI:");
        String dni = scanner.nextLine();

        System.out.println("Tel�fono:");
        String telefono = scanner.nextLine();

        System.out.println("Correo:");
        String correo = scanner.nextLine();

        return new Huesped(nombre, dni, telefono, correo);
    }

    public static Huesped leerClientePorDni() {
        // Implementaci�n de la lectura de un cliente por DNI...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el DNI del hu�sped:");
        String dni = scanner.nextLine();
        // Creamos un hu�sped con datos ficticios que cumplen las restricciones de creaci�n de un hu�sped
        String nombre = "Manuel Mart�nez Alcal�"; // Nombre ficticio
        String telefono = "644896133"; // Tel�fono ficticio
        String correo = "manumaral04@gmail.com.com"; // Correo ficticio
        return new Huesped(nombre, dni, telefono, correo);
    }

    public static LocalDate leerFecha() {
        Scanner scanner = new Scanner(System.in);
        LocalDate fecha = null;
        do {
            System.out.println("Introduce una fecha (dd/MM/yyyy):");
            String fechaCadena = scanner.nextLine();
            try {
                fecha = LocalDate.parse(fechaCadena, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (Exception e) {
                System.out.println("Fecha inv�lida. Int�ntalo de nuevo.");
            }
        } while (fecha == null);
        return fecha;
    }

    public static Habitacion leerHabitacion() {
        // Implementaci�n de la lectura de una habitaci�n...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el identificador de la habitaci�n:");
        String identificador = scanner.nextLine();
        System.out.println("Elige un tipo de habitaci�n:");
        TipoHabitacion tipo = leerTipoHabitacion();
        System.out.println("Introduce el precio de la habitaci�n:");
        double precio = scanner.nextDouble();
        return new Habitacion(identificador, tipo, precio);
    }

    public static Habitacion leerHabitacionPorIdentificador() {
        // Implementaci�n de la lectura de una habitaci�n por identificador...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el identificador de la habitaci�n:");
        String identificador = scanner.nextLine();
        // Crear una habitaci�n con datos ficticios que cumplen las restricciones de creaci�n de una habitaci�n
        TipoHabitacion tipo = TipoHabitacion.SIMPLE; // Tipo de habitaci�n ficticio
        double precio = 50.0; // Precio ficticio
        return new Habitacion(identificador, tipo, precio);
    }

    public static TipoHabitacion leerTipoHabitacion() {
        // Implementaci�n de la lectura de un tipo de habitaci�n...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige un tipo de habitaci�n:");
        for (TipoHabitacion tipo : TipoHabitacion.values()) {
            System.out.println(tipo.ordinal() + " .- " + tipo.getDescripcion());
        }
        int opcionElegida = scanner.nextInt();
        return TipoHabitacion.values()[opcionElegida];
    }

    public static Regimen leerRegimen() {
        // Implementaci�n de la lectura de un r�gimen...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige un r�gimen:");
        for (Regimen regimen : Regimen.values()) {
            System.out.println(regimen.ordinal() + " .- " + regimen.getDescripcion());
        }
        int opcionElegida = scanner.nextInt();
        return Regimen.values()[opcionElegida];
    }

    public static Reserva leerReserva() {
        // Implementaci�n de la lectura de una reserva...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce los datos de la reserva:");

        System.out.println("Habitaci�n:");
        Habitacion habitacion = leerHabitacion();

        System.out.println("Fecha de inicio (dd/MM/yyyy):");
        LocalDate fechaInicio = leerFecha();

        System.out.println("Fecha de fin (dd/MM/yyyy):");
        LocalDate fechaFin = leerFecha();

        System.out.println("N�mero de personas:");
        int numeroPersonas = scanner.nextInt();

        return new Reserva(habitacion, fechaInicio, fechaFin, numeroPersonas);
    }
}
