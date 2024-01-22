package org.iesalandalus.programacion.reservashotel.vista;

import org.iesalandalus.programacion.reservashotel.dominio.*;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;


public class Consola {
    private Consola() {}

    // Método para mostrar el menú
    public static void mostrarMenu() {
        for (Opcion opcion : Opcion.values()) {
            System.out.println(opcion);
        }
    }

    // Método para elegir una opción
    public static Opcion elegirOpcion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige una opción:");
        int eleccion = scanner.nextInt();
        return Opcion.values()[eleccion];
    }

    // Método para leer una fecha
    public static LocalDate leerFecha() {
        Scanner scanner = new Scanner(System.in);
        LocalDate fecha = null;
        do {
            System.out.println("Introduce una fecha (formato YYYY-MM-DD):");
            String entradaFecha = scanner.nextLine();
            try {
                fecha = LocalDate.parse(entradaFecha, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                System.out.println("Fecha no válida. Inténtalo de nuevo.");
            }
        } while (fecha == null);
        return fecha;
    }

    // ... Continúa con los demás métodos
    public static Huesped leerHuesped() throws ExcepcionHuesped {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce los datos del huésped:");
        String nombre = scanner.nextLine();
        String apellidos = scanner.nextLine();
        String dni = scanner.nextLine();
        // Aquí puedes agregar validaciones para los datos introducidos
        // y lanzar una ExcepcionHuesped si los datos no son válidos
        return new Huesped(nombre, apellidos, dni);
    }

    // Método para leer una habitación
    public static Habitacion leerHabitacion() throws ExcepcionHabitacion {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce los datos de la habitación:");
        int numeroPlanta = scanner.nextInt();
        int numeroPuerta = scanner.nextInt();
        // Aquí puedes agregar validaciones para los datos introducidos
        // y lanzar una ExcepcionHabitacion si los datos no son válidos
        return new Habitacion(numeroPlanta, numeroPuerta);
    }

    // Método para leer un tipo de habitación
    public static TipoHabitacion leerTipoHabitacion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige un tipo de habitación:");
        int eleccion = scanner.nextInt();
        return TipoHabitacion.values()[eleccion];
    }

    public static String leerIdentificador() {
        return null;
    }

    public static String leerDni() {
        return null;
    }


    public static class ExcepcionHuesped extends Exception {
    }

    private static class ExcepcionHabitacion extends Exception {
    }
    // Método para leer un cliente por DNI
    public static Huesped leerClientePorDni() throws ExcepcionHuesped {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el DNI del cliente:");
        String dni = scanner.nextLine();
        // Aquí puedes agregar validaciones para el DNI introducido
        // y lanzar una ExcepcionCliente si el DNI no es válido
        return new Huesped("Nombre ficticio", "Apellidos ficticios", dni);
    }

    // Método para leer una habitación por identificador
    public static Habitacion leerHabitacionPorIdentificador() throws ExcepcionHabitacion {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el número de planta y el número de puerta de la habitación:");
        int numeroPlanta = scanner.nextInt();
        int numeroPuerta = scanner.nextInt();
        // Aquí puedes agregar validaciones para los datos introducidos
        // y lanzar una ExcepcionHabitacion si los datos no son válidos
        return new Habitacion(numeroPlanta, numeroPuerta, "Tipo ficticio", 1, true);
    }

    // Método para leer un régimen
    public static Regimen leerRegimen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige un tipo de régimen:");
        int eleccion = scanner.nextInt();
        return Regimen.values()[eleccion];
    }

    // Método para leer una reserva
    public static Reserva leerReserva() throws ExcepcionReserva, ExcepcionHuesped, ExcepcionHabitacion {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce los datos de la reserva:");
        String codigo = scanner.nextLine();
        LocalDate fechaInicio = leerFecha();
        LocalDate fechaFin = leerFecha();
        // Aquí puedes agregar validaciones para los datos introducidos
        // y lanzar una ExcepcionReserva si los datos no son válidos
        return new Reserva(codigo, fechaInicio, fechaFin, leerClientePorDni(), leerHabitacionPorIdentificador(), leerRegimen());
    }

    private static class ExcepcionReserva extends Exception {
    }

    private static class ExcepcionCliente extends Exception {
    }
}
