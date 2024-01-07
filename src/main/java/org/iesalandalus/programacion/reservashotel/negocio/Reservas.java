package org.iesalandalus.programacion.reservashotel.negocio;

import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.dominio.TipoHabitacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reservas {

    // Atributos
    private List<Reserva> reservas;

    // Constructor
    public Reservas() {
        reservas = new ArrayList<>();
    }

    // Método para obtener una copia profunda de la colección
    public List<Reserva> get() {
        return new ArrayList<>(reservas);
    }

    // Método para insertar reservas no nulas al final de la colección sin admitir repetidos
    public void insertar(Reserva reserva) {
        if (reserva != null && !reservas.contains(reserva)) {
            reservas.add(reserva);
        }
    }

    // Método para buscar una reserva en la colección
    public Reserva buscar(Reserva reserva) {
        for (Reserva r : reservas) {
            if (r.equals(reserva)) {
                return r;
            }
        }
        return null;
    }

    // Método para borrar una reserva de la colección
    public void borrar(Reserva reserva) {
        reservas.removeIf(r -> r.equals(reserva));
    }

    // Método sobrecargado para obtener reservas por huésped o tipo de habitación
    public List<Reserva> getReservas(Huesped huesped) {
        List<Reserva> reservasHuesped = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getHuesped().equals(huesped)) {
                reservasHuesped.add(reserva);
            }
        }
        return reservasHuesped;
    }

    public List<Reserva> getReservas(TipoHabitacion tipoHabitacion) {
        List<Reserva> reservasTipoHabitacion = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().getTipo().equals(tipoHabitacion)) {
                reservasTipoHabitacion.add(reserva);
            }
        }
        return reservasTipoHabitacion;
    }

    // Método para obtener reservas futuras para una habitación
    public List<Reserva> getReservasFuturas(Habitacion habitacion) {
        List<Reserva> reservasFuturas = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().equals(habitacion) && reserva.getFechaInicio().isAfter(LocalDate.now())) {
                reservasFuturas.add(reserva);
            }
        }
        return reservasFuturas;
    }

    // Puedes probar la clase aquí si lo deseas
    public static void main(String[] args) {
        // Código de prueba
    }
}
