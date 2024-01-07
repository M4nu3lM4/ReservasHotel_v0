package org.iesalandalus.programacion.reservashotel.negocio;

import org.iesalandalus.programacion.reservashotel.dominio.Huesped;

import java.util.ArrayList;
import java.util.List;

public class Huespedes {

    // Atributos
    private List<Huesped> huespedes;

    // Constructor
    public Huespedes() {
        huespedes = new ArrayList<>();
    }

    // Método para obtener una copia profunda de la colección
    public List<Huesped> get() {
        return new ArrayList<>(huespedes);
    }

    // Método para insertar huéspedes no nulos al final de la colección sin admitir repetidos
    public void insertar(Huesped huesped) {
        if (huesped != null && !huespedes.contains(huesped)) {
            huespedes.add(huesped);
        }
    }

    // Método para buscar un huésped en la colección
    public Huesped buscar(Huesped huesped) {
        for (Huesped h : huespedes) {
            if (h.equals(huesped)) {
                return h;
            }
        }
        return null;
    }

    // Método para borrar un huésped de la colección
    public void borrar(Huesped huesped) {
        huespedes.removeIf(h -> h.equals(huesped));
    }

    // Puedes probar la clase aquí si lo deseas
    public static void main(String[] args) {
        // Código de prueba
    }
}
