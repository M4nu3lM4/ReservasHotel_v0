package org.iesalandalus.programacion.reservashotel.dominio;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reserva {
    private Habitacion habitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int numeroPersonas;
    private LocalDateTime checkin;
    private LocalDateTime checkout;
    private double precio;

    private static final int MAX_NUMERO_MESES_RESERVA = 6;
    private static final int MAX_HORAS_POSTERIOR_CHECKOUT = 12;

    public Reserva(Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin, int numeroPersonas) {
        setHabitacion(habitacion);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setNumeroPersonas(numeroPersonas);
        calcularPrecio();
    }

    private void setFechaInicio(LocalDate fechaInicio) {
    }

    private void setFechaFin(LocalDate fechaFin) {
        
    }

    private void setNumeroPersonas(int numeroPersonas) {
        
    }

    private void setHabitacion(Habitacion habitacion) {
    }

    public Reserva(Reserva otra) {
        this(otra.habitacion, otra.fechaInicio, otra.fechaFin, otra.numeroPersonas);
    }

    // Métodos de acceso y modificación...

    private void calcularPrecio() {
        // Implementación del cálculo del precio...
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Reserva reserva = (Reserva) obj;
        return habitacion.equals(reserva.habitacion) && fechaInicio.equals(reserva.fechaInicio);
    }

    @Override
    public int hashCode() {
        return habitacion.hashCode() + fechaInicio.hashCode();
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "habitacion=" + habitacion +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", numeroPersonas=" + numeroPersonas +
                ", checkin=" + checkin +
                ", checkout=" + checkout +
                ", precio=" + precio +
                '}';
    }

    public Object getHabitacion() {
        return null;
    }

    public Object getHuesped() {
        return null;
    }

    public Instant getFechaInicio() {
        return null;
    }
    public Instant getTipo(){
        return null;
    }
}