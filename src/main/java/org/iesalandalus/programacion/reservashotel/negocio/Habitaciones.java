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
        return new ArrayList<>(habitaciones);
    }

    public void insertar(Habitacion habitacion) {
        if (habitacion != null && !habitaciones.contains(habitacion)) {
            habitaciones.add(habitacion);
        }
    }

    public Habitacion buscar(Habitacion habitacion) {
        int index = habitaciones.indexOf(habitacion);
        if (index != -1) {
            return habitaciones.get(index);
        }
        return null;
    }

    public void borrar(Habitacion habitacion) {
        habitaciones.remove(habitacion);
    }
}
