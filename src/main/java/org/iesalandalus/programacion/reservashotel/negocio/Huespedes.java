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

    // M�todo para obtener una copia profunda de la colecci�n
    public List<Huesped> get() {
        return new ArrayList<>(huespedes);
    }

    // M�todo para insertar hu�spedes no nulos al final de la colecci�n sin admitir repetidos
    public void insertar(Huesped huesped) {
        if (huesped != null && !huespedes.contains(huesped)) {
            huespedes.add(huesped);
        }
    }

    // M�todo para buscar un hu�sped en la colecci�n
    public Huesped buscar(Huesped huesped) {
        for (Huesped h : huespedes) {
            if (h.equals(huesped)) {
                return h;
            }
        }
        return null;
    }

    // M�todo para borrar un hu�sped de la colecci�n
    public void borrar(Huesped huesped) {
        huespedes.removeIf(h -> h.equals(huesped));
    }

    // Puedes probar la clase aqu� si lo deseas
    public static void main(String[] args) {
        // C�digo de prueba
    }
}
