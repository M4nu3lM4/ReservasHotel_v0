package org.iesalandalus.programacion.reservashotel.negocio;

import org.iesalandalus.programacion.reservashotel.dominio.Huesped;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Huespedes {
    private ArrayList<Huesped> huespedes;

    public Huespedes() {
        this.huespedes = new ArrayList<>();
    }

    public ArrayList<Huesped> getHuespedes() {
        // Devuelve una copia profunda de la colección
        return new ArrayList<>(huespedes);
    }

    public void addHuesped(Huesped huesped) {
        // Inserta huéspedes no nulos al final de la colección sin admitir repetidos
        if (huesped != null && !huespedes.contains(huesped)) {
            huespedes.add(huesped);
        }
    }

    public Huesped buscar(Huesped huesped) {
        // Devuelve un huésped si éste se encuentra en la colección y null en caso contrario
        int index = huespedes.indexOf(huesped);
        if (index != -1) {
            return huespedes.get(index);
        } else {
            return null;
        }
    }

    public void borrar(Huesped huesped) {
        // Si el huésped se encuentra en la colección, lo borra
        huespedes.remove(huesped);
    }
}
