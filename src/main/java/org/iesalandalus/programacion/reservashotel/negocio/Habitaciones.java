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

    // Método para obtener una copia profunda de la colección
    public List<Habitacion> get() {
        return new ArrayList<>(habitaciones);
    }

    // Método para insertar habitaciones no nulas al final de la colección sin admitir repetidos
    public void insertar(Habitacion habitacion) {
        if (habitacion != null && !habitaciones.contains(habitacion)) {
            habitaciones.add(habitacion);
        }
    }

    // Método para buscar una habitación en la colección
    public Habitacion buscar(Habitacion habitacion) {
        for (Habitacion h : habitaciones) {
            if (h.equals(habitacion)) {
                return h;
            }
        }
        return null;
    }

    // Método para borrar una habitación de la colección
    public void borrar(Habitacion habitacion) {
        habitaciones.removeIf(h -> h.equals(habitacion));
    }

    // Puedes probar la clase aquí si lo deseas
    public static void main(String[] args) {
        // Código de prueba
    }
}
