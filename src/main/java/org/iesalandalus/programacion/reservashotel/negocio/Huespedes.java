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
        // Devuelve una copia profunda de la colecci�n
        return new ArrayList<>(huespedes);
    }

    public void addHuesped(Huesped huesped) {
        // Inserta hu�spedes no nulos al final de la colecci�n sin admitir repetidos
        if (huesped != null && !huespedes.contains(huesped)) {
            huespedes.add(huesped);
        }
    }

    public Huesped buscar(Huesped huesped) {
        // Devuelve un hu�sped si �ste se encuentra en la colecci�n y null en caso contrario
        int index = huespedes.indexOf(huesped);
        if (index != -1) {
            return huespedes.get(index);
        } else {
            return null;
        }
    }

    public void borrar(Huesped huesped) {
        // Si el hu�sped se encuentra en la colecci�n, lo borra
        huespedes.remove(huesped);
    }
}
