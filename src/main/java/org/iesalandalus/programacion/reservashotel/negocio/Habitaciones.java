package org.iesalandalus.programacion.reservashotel.negocio;

import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;

import java.util.ArrayList;
import java.util.List;

public class Habitaciones {

    // Atributos
    private List<Habitacion> habitaciones;

    // Constructor
    public Habitaciones() {
        habitaciones = new ArrayList<>();
    }

    // M�todo para obtener una copia profunda de la colecci�n
    public List<Habitacion> get() {
        return new ArrayList<>(habitaciones);
    }

    // M�todo para insertar habitaciones no nulas al final de la colecci�n sin admitir repetidos
    public void insertar(Habitacion habitacion) {
        if (habitacion != null && !habitaciones.contains(habitacion)) {
            habitaciones.add(habitacion);
        }
    }

    // M�todo para buscar una habitaci�n en la colecci�n
    public Habitacion buscar(Habitacion habitacion) {
        for (Habitacion h : habitaciones) {
            if (h.equals(habitacion)) {
                return h;
            }
        }
        return null;
    }

    // M�todo para borrar una habitaci�n de la colecci�n
    public void borrar(Habitacion habitacion) {
        habitaciones.removeIf(h -> h.equals(habitacion));
    }

    // Puedes probar la clase aqu� si lo deseas
    public static void main(String[] args) {
        // C�digo de prueba
    }
}
