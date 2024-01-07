package org.iesalandalus.programacion.reservashotel.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Reserva {

    // Constantes
    private static final int MAX_NUMERO_MESES_RESERVA = 6;
    private static final int MAX_HORAS_POSTERIOR_CHECKOUT = 12;

    // Atributos
    private Habitacion habitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int numeroPersonas;
    private LocalDateTime checkin;
    private LocalDateTime checkout;
    private Regimen regimen;
    private int precio;

    // Constructor con par�metros
    public Reserva(Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin, int numeroPersonas, LocalDateTime checkin, LocalDateTime checkout, Regimen regimen) {
        setHabitacion(habitacion);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setNumeroPersonas(numeroPersonas);
        setCheckin(checkin);
        setCheckout(checkout);
        setRegimen(regimen);
        calcularPrecio();
    }

    // Constructor copia
    public Reserva(Reserva otra) {
        this(otra.habitacion, otra.fechaInicio, otra.fechaFin, otra.numeroPersonas, otra.checkin, otra.checkout, otra.regimen);
    }

    // M�todos de acceso y modificaci�n con validaci�n
    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        if (fechaInicio.isBefore(LocalDate.now()) || fechaInicio.isAfter(LocalDate.now().plusMonths(MAX_NUMERO_MESES_RESERVA))) {
            throw new IllegalArgumentException("Fecha de inicio de reserva no v�lida");
        }
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        if (fechaFin.isBefore(fechaInicio)) {
            throw new IllegalArgumentException("Fecha de fin de reserva no v�lida");
        }
        this.fechaFin = fechaFin;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        if (numeroPersonas > habitacion.getTipo().getCapacidadMaxima()) {
            throw new IllegalArgumentException("N�mero de personas supera la capacidad m�xima de la habitaci�n");
        }
        this.numeroPersonas = numeroPersonas;
        calcularPrecio();
    }

    public LocalDateTime getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDateTime checkin) {
        if (checkin.isBefore(LocalDateTime.now()) || checkin.isBefore(LocalDateTime.of(fechaInicio, LocalTime.MIN))) {
            throw new IllegalArgumentException("Fecha de checkin no v�lida");
        }
        this.checkin = checkin;
    }

    public LocalDateTime getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDateTime checkout) {
        if (checkout.isBefore(checkin) || checkout.isAfter(LocalDateTime.of(fechaFin, LocalTime.of(MAX_HORAS_POSTERIOR_CHECKOUT, 0)))) {
            throw new IllegalArgumentException("Fecha de checkout no v�lida");
        }
        this.checkout = checkout;
        calcularPrecio();
    }

    public Regimen getRegimen() {
        return regimen;
    }

    public void setRegimen(Regimen regimen) {
        this.regimen = regimen;
        calcularPrecio();
    }

    public int getPrecio() {
        return precio;
    }

    // M�todo privado para calcular el precio
    private void calcularPrecio() {
        int precioHabitacion = habitacion.getPrecio();
        int precioRegimen = numeroPersonas * regimen.getIncrementoPrecioPorPersona();
        this.precio = precioHabitacion + precioRegimen;
    }

    // M�todos equals y hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Reserva reserva = (Reserva) obj;
        return habitacion.equals(reserva.habitacion) && fechaInicio.equals(reserva.fechaInicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(habitacion, fechaInicio);
    }

    // M�todo toString
    @Override
    public String toString() {
        return "Reserva en " + habitacion +
                "\nFecha de inicio: " + fechaInicio +
                "\nFecha de fin: " + fechaFin +
                "\nN�mero de personas: " + numeroPersonas +
                "\nCheckin: " + checkin +
                "\nCheckout: " + checkout +
                "\nR�gimen: " + regimen +
                "\nPrecio: " + precio + "?";
    }

    // Puedes probar la clase aqu� si lo deseas
    public static void main(String[] args) {
        // C�digo de prueba
    }
}
