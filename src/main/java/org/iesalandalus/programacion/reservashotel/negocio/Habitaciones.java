package org.iesalandalus.programacion.reservashotel.negocio;

import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Habitaciones {
    private ArrayList<Habitacion> habitaciones;

    public Habitaciones() {
        this.habitaciones = new ArrayList<>();
    }

    public ArrayList<Habitacion> getHabitaciones() {
        // Devuelve una copia profunda de la colecci�n
        return new ArrayList<>(habitaciones);
    }

    public void addHabitacion(Habitacion habitacion) {
        // Inserta habitaciones no nulas al final de la colecci�n sin admitir repetidos
        if (habitacion != null && !habitaciones.contains(habitacion)) {
            habitaciones.add(habitacion);
        }
    }

    public Habitacion buscar(Habitacion habitacion) {
        // Devuelve una habitaci�n si �sta se encuentra en la colecci�n y null en caso contrario
        int index = habitaciones.indexOf(habitacion);
        if (index != -1) {
            return habitaciones.get(index);
        } else {
            return null;
        }
    }

    public void borrar(Habitacion habitacion) {
        // Si la habitaci�n se encuentra en la colecci�n, la borra
        habitaciones.remove(habitacion);
    }
}