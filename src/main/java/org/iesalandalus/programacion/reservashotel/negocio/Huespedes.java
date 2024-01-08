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
        return new ArrayList<>(huespedes);
    }

    public void insertar(Huesped huesped) {
        if (huesped != null && !huespedes.contains(huesped)) {
            huespedes.add(huesped);
        }
    }

    public Huesped buscar(Huesped huesped) {
        int index = huespedes.indexOf(huesped);
        if (index != -1) {
            return huespedes.get(index);
        }
        return null;
    }

    public void borrar(Huesped huesped) {
        huespedes.remove(huesped);
    }
}
