package org.iesalandalus.programacion.reservashotel.vista;

import org.iesalandalus.programacion.reservashotel.dominio.*;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.time.format.DateTimeFormatter;


public class Consola {
    private Consola() {
        // Constructor privado para prevenir la instanciacion y problemas a la hora de compilarlo
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
        // Implementacion de leer un huesped...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce los datos del huesped:");

        System.out.println("Nombre:");
        String nombre = scanner.nextLine();

        System.out.println("DNI:");
        String dni = scanner.nextLine();

        System.out.println("Telefono:");
        String telefono = scanner.nextLine();

        System.out.println("Correo:");
        String correo = scanner.nextLine();

        return new Huesped(nombre, dni, telefono, correo);
    }

    public static Huesped leerClientePorDni() {
        // Implementacion de la lectura de un cliente por DNI...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el DNI del huesped:");
        String dni = scanner.nextLine();
        // Creamos un huesped con datos ficticios que cumplen las restricciones de creacion de un huesped
        String nombre = "Manuel Martinez Alcala"; // Nombre ficticio
        String telefono = "644896133"; // Tel?fono ficticio
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
                System.out.println("Fecha invalida. Intentalo de nuevo.");
            }
        } while (fecha == null);
        return fecha;
    }

    public static Habitacion leerHabitacion() {
        // Implementacion de leer una habitacion...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el identificador de la habitacion:");
        String identificador = scanner.nextLine();
        System.out.println("Elige un tipo de habitacion:");
        TipoHabitacion tipo = leerTipoHabitacion();
        System.out.println("Introduce el precio de la habitacion:");
        double precio = scanner.nextDouble();
        return new Habitacion(identificador, tipo, precio);
    }

    public static Habitacion leerHabitacionPorIdentificador() {
        // Implementacion de leer una habitacion por identificador...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el identificador de la habitacion:");
        String identificador = scanner.nextLine();
        // Creamos una habitacion con datos ficticios que cumplen las restricciones de creacion de una habitacion
        TipoHabitacion tipo = TipoHabitacion.SIMPLE; // Tipo de habitacion ficticio
        double precio = 50.0; // Precio ficticio
        return new Habitacion(identificador, tipo, precio);
    }

    public static TipoHabitacion leerTipoHabitacion() {
        // Implementacion de leer un tipo de habitacion...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige un tipo de habitacion:");
        for (TipoHabitacion tipo : TipoHabitacion.values()) {
            System.out.println(tipo.ordinal() + " .- " + tipo.getDescripcion());
        }
        int opcionElegida = scanner.nextInt();
        return TipoHabitacion.values()[opcionElegida];
    }

    public static Regimen leerRegimen() {
        // Implementacion de leer un regimen...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige un regimen:");
        for (Regimen regimen : Regimen.values()) {
            System.out.println(regimen.ordinal() + " .- " + regimen.getDescripcion());
        }
        int opcionElegida = scanner.nextInt();
        return Regimen.values()[opcionElegida];
    }

    public static Reserva leerReserva() {
        // Implementacion de la lectura de una reserva...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce los datos de la reserva:");

        System.out.println("Habitacion:");
        Habitacion habitacion = leerHabitacion();

        System.out.println("Fecha de inicio (dd/MM/yyyy):");
        LocalDate fechaInicio = leerFecha();

        System.out.println("Fecha de fin (dd/MM/yyyy):");
        LocalDate fechaFin = leerFecha();

        System.out.println("Numero de personas:");
        int numeroPersonas = scanner.nextInt();

        return new Reserva(habitacion, fechaInicio, fechaFin, numeroPersonas);
    }
}
