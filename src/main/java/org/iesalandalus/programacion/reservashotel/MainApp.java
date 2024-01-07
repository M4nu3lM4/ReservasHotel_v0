package org.iesalandalus.programacion.reservashotel;


import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.negocio.Habitaciones;
import org.iesalandalus.programacion.reservashotel.negocio.Huespedes;
import org.iesalandalus.programacion.reservashotel.negocio.Reservas;
import org.iesalandalus.programacion.reservashotel.vista.Consola;
import org.iesalandalus.programacion.reservashotel.vista.Opcion;

import java.util.List;

public class MainApp {

    // Atributos
    private Huespedes huespedes;
    private Habitaciones habitaciones;
    private Reservas reservas;

    // Constructor
    public MainApp() {
        huespedes = new Huespedes();
        habitaciones = new Habitaciones();
        reservas = new Reservas();
    }

    // Método para ejecutar una opción del menú
    public void ejecutarOpcion(Opcion opcion) {
        switch (opcion) {
            case OPCION_1:
                insertarHuesped();
                break;
            case OPCION_2:
                buscarHuesped();
                break;
            case OPCION_3:
                borrarHuesped();
                break;
            case OPCION_4:
                mostrarHuespedes();
                break;
            case OPCION_5:
                insertarHabitacion();
                break;
            case OPCION_6:
                buscarHabitacion();
                break;
            case OPCION_7:
                borrarHabitacion();
                break;
            case OPCION_8:
                mostrarHabitaciones();
                break;
            case OPCION_9:
                insertarReserva();
                break;
            case OPCION_10:
                listarReservas();
                break;
            case OPCION_11:
                mostrarReservas();
                break;
            case OPCION_12:
                anularReserva();
                break;
            case OPCION_13:
                consultarDisponibilidad();
                break;
            case SALIR:
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    // Métodos para las opciones del menú
    private void insertarHuesped() {
        Huesped huesped = Consola.leerHuesped();
        huespedes.insertar(huesped);
        System.out.println("Huesped insertado correctamente.");
    }

    private void buscarHuesped() {
        String dni = Consola.leerDni();
        Huesped huesped = huespedes.buscar(new Huesped("", dni));
        if (huesped != null) {
            System.out.println("Huesped encontrado: " + huesped);
        } else {
            System.out.println("Huesped no encontrado.");
        }
    }

    private void borrarHuesped() {
        String dni = Consola.leerDni();
        Huesped huesped = huespedes.buscar(new Huesped("", dni));
        if (huesped != null) {
            huespedes.borrar(huesped);
            System.out.println("Huesped borrado correctamente.");
        } else {
            System.out.println("Huesped no encontrado.");
        }
    }

    private void mostrarHuespedes() {
        List<Huesped> listaHuespedes = huespedes.get();
        if (!listaHuespedes.isEmpty()) {
            System.out.println("Listado de Huespedes:");
            for (Huesped huesped : listaHuespedes) {
                System.out.println(huesped);
            }
        } else {
            System.out.println("No hay Huespedes registrados.");
        }
    }

    private void insertarHabitacion() {
        Habitacion habitacion = Consola.leerHabitacion();
        habitaciones.insertar(habitacion);
        System.out.println("Habitacion insertada correctamente.");
    }

    private void buscarHabitacion() {
        Habitacion habitacion = Consola.leerHabitacionPorIdentificador();
        Habitacion encontrada = habitaciones.buscar(habitacion);
        if (encontrada != null) {
            System.out.println("Habitacion encontrada: " + encontrada);
        } else {
            System.out.println("Habitacion no encontrada.");
        }
    }

    private void borrarHabitacion() {
        Habitacion habitacion = Consola.leerHabitacionPorIdentificador();
        Habitacion encontrada = habitaciones.buscar(habitacion);
        if (encontrada != null) {
            habitaciones.borrar(encontrada);
            System.out.println("Habitacion borrada correctamente.");
        } else {
            System.out.println("Habitacion no encontrada.");
        }
    }

    private void mostrarHabitaciones() {
        List<Habitacion> listaHabitaciones = habitaciones.get();
        if (!listaHabitaciones.isEmpty()) {
            System.out.println("Listado de Habitaciones:");
            for (Habitacion habitacion : listaHabitaciones) {
                System.out.println(habitacion);
            }
        } else {
            System.out.println("No hay Habitaciones registradas.");
        }
    }

    private void insertarReserva() {
        Reserva reserva = Consola.leerReserva();
        // Lógica para verificar disponibilidad y agregar reserva
        reservas.insertar(reserva);
        System.out.println("Reserva realizada correctamente.");
    }

    private void listarReservas() {
        // Lógica para listar reservas según el parámetro proporcionado
    }

    private void mostrarReservas() {
        List<Reserva> listaReservas = reservas.get();
        if (!listaReservas.isEmpty()) {
            System.out.println("Listado de Reservas:");
            for (Reserva reserva : listaReservas) {
                System.out.println(reserva);
            }
        } else {
            System.out.println("No hay Reservas registradas.");
        }
    }

    private void anularReserva() {
        // Lógica para anular reserva
    }

    private void consultarDisponibilidad() {
        // Lógica para consultar disponibilidad
    }

    // Método principal (main)
    public static void main(String[] args) {
        MainApp mainApp = new MainApp();

        do {
            Consola.mostrarMenu();
            Opcion opcionElegida = Consola.elegirOpcion();
            mainApp.ejecutarOpcion(opcionElegida);
        } while (opcionElegida != Opcion.SALIR);
    }
}
