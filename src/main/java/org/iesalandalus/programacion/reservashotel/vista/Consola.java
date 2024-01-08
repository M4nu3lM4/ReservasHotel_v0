package org.iesalandalus.programacion.reservashotel.vista;

import org.iesalandalus.programacion.reservashotel.dominio.*;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.time.format.DateTimeFormatter;


public class Consola {
    private Consola() {
        // Constructor privado para prevenir la instanciación
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
        // Implementación de la lectura de un huésped...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce los datos del huésped:");

        System.out.println("Nombre:");
        String nombre = scanner.nextLine();

        System.out.println("DNI:");
        String dni = scanner.nextLine();

        System.out.println("Teléfono:");
        String telefono = scanner.nextLine();

        System.out.println("Correo:");
        String correo = scanner.nextLine();

        return new Huesped(nombre, dni, telefono, correo);
    }

    public static Huesped leerClientePorDni() {
        // Implementación de la lectura de un cliente por DNI...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el DNI del huésped:");
        String dni = scanner.nextLine();
        // Creamos un huésped con datos ficticios que cumplen las restricciones de creación de un huésped
        String nombre = "Manuel Martínez Alcalá"; // Nombre ficticio
        String telefono = "644896133"; // Teléfono ficticio
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
                System.out.println("Fecha inválida. Inténtalo de nuevo.");
            }
        } while (fecha == null);
        return fecha;
    }

    public static Habitacion leerHabitacion() {
        // Implementación de la lectura de una habitación...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el identificador de la habitación:");
        String identificador = scanner.nextLine();
        System.out.println("Elige un tipo de habitación:");
        TipoHabitacion tipo = leerTipoHabitacion();
        System.out.println("Introduce el precio de la habitación:");
        double precio = scanner.nextDouble();
        return new Habitacion(identificador, tipo, precio);
    }

    public static Habitacion leerHabitacionPorIdentificador() {
        // Implementación de la lectura de una habitación por identificador...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el identificador de la habitación:");
        String identificador = scanner.nextLine();
        // Crear una habitación con datos ficticios que cumplen las restricciones de creación de una habitación
        TipoHabitacion tipo = TipoHabitacion.SIMPLE; // Tipo de habitación ficticio
        double precio = 50.0; // Precio ficticio
        return new Habitacion(identificador, tipo, precio);
    }

    public static TipoHabitacion leerTipoHabitacion() {
        // Implementación de la lectura de un tipo de habitación...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige un tipo de habitación:");
        for (TipoHabitacion tipo : TipoHabitacion.values()) {
            System.out.println(tipo.ordinal() + " .- " + tipo.getDescripcion());
        }
        int opcionElegida = scanner.nextInt();
        return TipoHabitacion.values()[opcionElegida];
    }

    public static Regimen leerRegimen() {
        // Implementación de la lectura de un régimen...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige un régimen:");
        for (Regimen regimen : Regimen.values()) {
            System.out.println(regimen.ordinal() + " .- " + regimen.getDescripcion());
        }
        int opcionElegida = scanner.nextInt();
        return Regimen.values()[opcionElegida];
    }

    public static Reserva leerReserva() {
        // Implementación de la lectura de una reserva...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce los datos de la reserva:");

        System.out.println("Habitación:");
        Habitacion habitacion = leerHabitacion();

        System.out.println("Fecha de inicio (dd/MM/yyyy):");
        LocalDate fechaInicio = leerFecha();

        System.out.println("Fecha de fin (dd/MM/yyyy):");
        LocalDate fechaFin = leerFecha();

        System.out.println("Número de personas:");
        int numeroPersonas = scanner.nextInt();

        return new Reserva(habitacion, fechaInicio, fechaFin, numeroPersonas);
    }
}
