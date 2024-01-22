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
            // Devuelve una copia profunda de la colecci�n
            return new ArrayList<>(reservas);
        }

        public void addReserva(Reserva reserva) {
            // Inserta reservas no nulas al final de la colecci�n sin admitir repetidos
            if (reserva != null && !reservas.contains(reserva)) {
                reservas.add(reserva);
            }
        }

        public Reserva buscar(Reserva reserva) {
            // Devuelve una reserva si �sta se encuentra en la colecci�n y null en caso contrario
            int index = reservas.indexOf(reserva);
            if (index != -1) {
                return reservas.get(index);
            } else {
                return null;
            }
        }

        public void borrar(Reserva reserva) {
            // Si la reserva se encuentra en la colecci�n, la borra
            reservas.remove(reserva);
        }

        public ArrayList<Reserva> getReservas(Huesped huesped) {
            // Devuelve una colecci�n de las reservas realizadas por el hu�sped pasado por par�metro
            return reservas.stream()
                    .filter(reserva -> reserva.getHuesped().equals(huesped))
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        public ArrayList<Reserva> getReservas(TipoHabitacion tipo) {
            // Devuelve una colecci�n de las reservas realizadas para el tipo de habitaci�n indicada como par�metro
            return reservas.stream()
                    .filter(reserva -> reserva.getHabitacion().getTipo().equals(tipo))
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        public ArrayList<Reserva> getReservasFuturas(Habitacion habitacion) {
            // Devuelve una colecci�n de las reservas realizadas para la habitaci�n indicada como par�metro y que sean posteriores a la fecha de hoy
            return reservas.stream()
                    .filter(reserva -> reserva.getHabitacion().equals(habitacion) && reserva.getFechaInicio().isAfter(Instant.from(LocalDate.now())))
                    .collect(Collectors.toCollection(ArrayList::new));
        }

    public void anularReserva(Huesped huespedParaAnular) {
    }

    public Habitacion consultarDisponibilidad(TipoHabitacion tipo, LocalDate inicio, LocalDate fin) {
            return null;
    }
}