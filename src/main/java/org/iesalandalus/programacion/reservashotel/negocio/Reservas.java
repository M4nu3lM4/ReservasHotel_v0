package org.iesalandalus.programacion.reservashotel.negocio;

import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.dominio.TipoHabitacion;
import java.util.Scanner;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Reservas {
    private ArrayList<Reserva> reservas;

    public Reservas() {
        this.reservas = new ArrayList<>();
    }

    public ArrayList<Reserva> getReservas() {
        return new ArrayList<>(reservas);
    }

    public void insertar(Reserva reserva) {
        if (reserva != null && !reservas.contains(reserva)) {
            reservas.add(reserva);
        }
    }

    public Reserva buscar(Reserva reserva) {
        int index = reservas.indexOf(reserva);
        if (index != -1) {
            return reservas.get(index);
        }
        return null;
    }

    public void borrar(Reserva reserva) {
        reservas.remove(reserva);
    }

    public ArrayList<Reserva> getReservas(Huesped huesped) {
        return reservas.stream()
                .filter(reserva -> reserva.getHuesped().equals(huesped))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Reserva> getReservas(TipoHabitacion tipo) {
        return reservas.stream()
                .filter(reserva -> reserva.getHabitacion().getClass().equals(tipo))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Reserva> getReservasFuturas(Habitacion habitacion) {
        return reservas.stream()
                .filter(reserva -> reserva.getHabitacion().equals(habitacion) && reserva.getFechaInicio().isAfter(Instant.from(LocalDate.now())))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
