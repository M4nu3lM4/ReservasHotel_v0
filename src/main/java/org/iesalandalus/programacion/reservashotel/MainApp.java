package org.iesalandalus.programacion.reservashotel;


import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.negocio.Habitaciones;
import org.iesalandalus.programacion.reservashotel.negocio.Huespedes;
import org.iesalandalus.programacion.reservashotel.negocio.Reservas;
import org.iesalandalus.programacion.reservashotel.vista.Consola;
import org.iesalandalus.programacion.reservashotel.vista.Opcion;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MainApp {
    private static Huespedes huespedes = new Huespedes();
    private static Habitaciones habitaciones = new Habitaciones();
    private static Reservas reservas = new Reservas();

    public static void ejecutarOpcion(Opcion opcion) {
        // Implementación de la ejecución de una opción...
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