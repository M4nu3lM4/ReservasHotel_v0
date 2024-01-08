package org.iesalandalus.programacion.reservashotel.dominio;


import java.util.Objects;
import java.util.Scanner;
public class Habitacion {
    private String identificador;
    private TipoHabitacion tipo;
    private double precio;

    private static final int MAX_PLANTAS = 3;
    private static final int MAX_PUERTAS = 15;
    private static final double MIN_PRECIO = 40.0;
    private static final double MAX_PRECIO = 150.0;

    public Habitacion(String identificador, TipoHabitacion tipo, double precio) {
        setIdentificador(identificador);
        setTipo(tipo);
        setPrecio(precio);
    }

    public Habitacion(Habitacion otra) {
        this(otra.identificador, otra.tipo, otra.precio);
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        if (!identificador.matches("^[1-" + MAX_PLANTAS + "][01-" + MAX_PUERTAS + "]$")) {
            throw new IllegalArgumentException("Identificador inválido");
        }
        this.identificador = identificador;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < MIN_PRECIO || precio > MAX_PRECIO) {
            throw new IllegalArgumentException("Precio inválido");
        }
        this.precio = precio;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Habitacion habitacion = (Habitacion) obj;
        return identificador.equals(habitacion.identificador);
    }

    @Override
    public int hashCode() {
        return identificador.hashCode();
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "identificador='" + identificador + '\'' +
                ", tipo=" + tipo +
                ", precio=" + precio +
                '}';
    }
}