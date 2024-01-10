package org.iesalandalus.programacion.reservashotel;


import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.dominio.TipoHabitacion;
import org.iesalandalus.programacion.reservashotel.negocio.Habitaciones;
import org.iesalandalus.programacion.reservashotel.negocio.Huespedes;
import org.iesalandalus.programacion.reservashotel.negocio.Reservas;
import org.iesalandalus.programacion.reservashotel.vista.Consola;
import org.iesalandalus.programacion.reservashotel.vista.Opcion;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import static org.iesalandalus.programacion.reservashotel.vista.Consola.*;

public class MainApp {
    private static Huespedes huespedes = new Huespedes();
    private static Habitaciones habitaciones = new Habitaciones();
    private static Reservas reservas = new Reservas();

    public static void ejecutarOpcion(Opcion opcion) {
        // Implementacion de la ejecucion de una opcion...
        switch (opcion) {
            case OPCION_1:
                // Codigo para ejecutar la opcion 1
                System.out.println("Bienvenido");
                break;
            case OPCION_2:
                // Código para ejecutar la opcion 2
                crearReserva();
                break;
            case OPCION_3:
                // Codigo para ejecutar la opcion 3
                buscarReserva();
                break;
            case OPCION_4:
                // Código para ejecutar la opción 4
                borrarReserva();
                break;
            case OPCION_5:
                // Código para ejecutar la opción 5
                insertarHuesped();
                break;
            case OPCION_6:
                // Código para ejecutar la opción 6
                buscarHuesped();
                break;
            case OPCION_7:
                // Código para ejecutar la opción 7
                borrarHuesped();
                break;
            case OPCION_8:
                // Código para ejecutar la opción 8
                crearHabitacion();
                break;
            case OPCION_9:
                // Código para ejecutar la opción 9
                break;
            case OPCION_10:
                // Código para ejecutar la opción 10
                break;
            case SALIR:
                // Código para ejecutar la opción 11
                break;
            default:
                System.out.println("Opción no reconocida");
                break;
        }
    }

    public static void insertarHuesped() {
        Huesped huesped = Consola.leerHuesped();
        huespedes.insertar(huesped);
    }

    public static void buscarHuesped() {
        Huesped huesped = Consola.leerClientePorDni();
        Huesped encontrado = huespedes.buscar(huesped);
        if (encontrado != null) {
            System.out.println("Huésped encontrado: " + encontrado);
        } else {
            System.out.println("Huésped no encontrado");
        }
    }

    public static void borrarHuesped() {
        Huesped huesped = Consola.leerClientePorDni();
        huespedes.borrar(huesped);
    }

    public static void mostrarHuespedes() {
        ArrayList<Huesped> listaHuespedes = huespedes.getHuespedes();
        if (listaHuespedes.isEmpty()) {
            System.out.println("No hay huéspedes");
        } else {
            for (Huesped huesped : listaHuespedes) {
                System.out.println(huesped);
            }
        }
    }

    // Métodos similares para habitaciones y reservas...
    public static void crearReserva() {
        // Aquí va el código para crear una reserva
// Leer los datos necesarios para la reserva
        Huesped huesped = Consola.leerHuesped();
        Habitacion habitacion = Consola.leerHabitacion();
        LocalDate fechaInicio = Consola.leerFecha();
        LocalDate fechaFin = Consola.leerFecha();

        // Crear la reserva
        Reserva reserva = new Reserva(habitacion, fechaInicio, fechaFin, huesped);

        // Insertar la reserva en la colección de reservas
        reservas.insertar(reserva);
    }

    public static void buscarReserva() {
        // Leer los datos necesarios para buscar la reserva
        Huesped huesped = Consola.leerClientePorDni();
        Habitacion habitacion = Consola.leerHabitacionPorIdentificador();
        LocalDate fechaInicio = Consola.leerFecha();

        // Crear una reserva ficticia con los datos leídos
        Reserva reservaBuscada = new Reserva(habitacion, fechaInicio, fechaInicio.plusDays(1), huesped);

        // Buscar la reserva en la colección de reservas
        Reserva reservaEncontrada = reservas.buscar(reservaBuscada);

        if (reservaEncontrada != null) {
            System.out.println("Reserva encontrada: " + reservaEncontrada);
        } else {
            System.out.println("Reserva no encontrada");
        }
    }
    public static void borrarReserva() {
        // Leer los datos necesarios para buscar la reserva
        Huesped huesped = Consola.leerClientePorDni();
        Habitacion habitacion = Consola.leerHabitacionPorIdentificador();
        LocalDate fechaInicio = Consola.leerFecha();

        // Crear una reserva ficticia con los datos leídos
        Reserva reservaParaBorrar = new Reserva(habitacion, fechaInicio, fechaInicio.plusDays(1), huesped);

        // Buscar la reserva en la colección de reservas
        Reserva reservaEncontrada = reservas.buscar(reservaParaBorrar);

        if (reservaEncontrada != null) {
            // Borrar la reserva encontrada
            reservas.borrar(reservaEncontrada);
            System.out.println("Reserva borrada: " + reservaEncontrada);
        } else {
            System.out.println("Reserva no encontrada");
        }
    }
    public static void crearHabitacion() {
        // Leer los datos necesarios para la habitación
        System.out.println("Introduce el identificador de la habitación:");
        String identificador = leerHabitacion().getIdentificador();

        System.out.println("Elige un tipo de habitación:");
        TipoHabitacion tipo = leerTipoHabitacion();

        System.out.println("Introduce el precio de la habitación:");
        double precio = leerHabitacionPorIdentificador().getPrecio();

        // Crear la habitacion
        Habitacion habitacion = new Habitacion(identificador, tipo, precio);

        // Insertar la habitacion en el array /lista de habitaciones
        habitaciones.insertar(habitacion);
    }

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            Consola.mostrarMenu();
            Opcion opcion = Consola.elegirOpcion();
            if (opcion == Opcion.SALIR) {
                salir = true;
            } else {
                ejecutarOpcion(opcion);
            }
        }
        System.out.println("Gracias por usar nuestra aplicación. ¡Hasta la próxima!");
    }
}