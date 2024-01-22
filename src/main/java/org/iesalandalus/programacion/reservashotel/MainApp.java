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

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Opcion opcion;

        do {
            mostrarMenu();
            opcion = elegirOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != Opcion.SALIR);

        System.out.println("¡Hasta luego!");
    }

    private static void ejecutarOpcion(Opcion opcion) throws Exception {
        switch (opcion) {
            case INSERTAR_HUESPED:
                Huesped huesped = leerHuesped();
                huespedes.addHuesped(huesped);
                break;
            case BUSCAR_HUESPED:
                String dni = leerDni();
                Huesped huespedEncontrado = huespedes.buscar(new Huesped(dni));
                System.out.println(huespedEncontrado != null ? huespedEncontrado : "Huésped no encontrado");
                break;
            case BORRAR_HUESPED:
                String dniParaBorrar = leerDni();
                huespedes.borrar(new Huesped(dniParaBorrar));
                break;
            case MOSTRAR_HUESPED:
                System.out.println(huespedes);
                break;
            case INSERTAR_HABITACION:
                Habitacion habitacion = leerHabitacion();
                habitaciones.addHabitacion(habitacion);
                break;
            case BUSCAR_HABITACION:
                String identificador = leerIdentificador();
                Habitacion habitacionEncontrada = habitaciones.buscar(new Habitacion(identificador));
                System.out.println(habitacionEncontrada != null ? habitacionEncontrada : "Habitación no encontrada");
                break;
            case BORRAR_HABITACION:
                String identificadorParaBorrar = leerIdentificador();
                habitaciones.borrar(new Habitacion(identificadorParaBorrar));
                break;
            case MOSTRAR_HABITACIONES:
                System.out.println(habitaciones);
                break;
            case INSERTAR_RESERVA:
                Reserva reserva = leerReserva();
                reservas.addReserva(reserva);
                break;
            case ANULAR_RESERVA:
                String dni1 = leerDni();
                Huesped huespedParaAnular = new Huesped(dni1);
                reservas.anularReserva(huespedParaAnular);
                break;
            case MOSTRAR_RESERVAS:
                System.out.println(reservas);
                break;
            case CONSULTAR_DISPONIBILIDAD:
                TipoHabitacion tipo = leerTipoHabitacion();
                LocalDate inicio = leerFecha();
                LocalDate fin = leerFecha();
                Habitacion habitacionDisponible = reservas.consultarDisponibilidad(tipo, inicio, fin);
                System.out.println(habitacionDisponible != null ? habitacionDisponible : "No hay habitaciones disponibles");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + opcion);
        }
    }
}