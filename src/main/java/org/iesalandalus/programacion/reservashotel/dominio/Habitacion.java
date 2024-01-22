package org.iesalandalus.programacion.reservashotel.dominio;


import java.util.Objects;

public class Habitacion {
    private static final int MAX_PLANTAS = 3;
    private static final int MAX_PUERTAS = 15;
    private static final double MIN_PRECIO = 40.0;
    private static final double MAX_PRECIO = 150.0;

    private String identificador;
    private TipoHabitacion tipo;
    private double precio;
    private int capacidad;

    public Habitacion(String identificador) {
        setIdentificador(identificador);
        setTipo(tipo);
        setPrecio(precio);
    }

    public Habitacion(Habitacion otra) {
        this(otra.identificador);
    }

    public Habitacion(int numeroPlanta, int numeroPuerta) {
    }

    public Habitacion(int numeroPlanta, int numeroPuerta, String tipoFicticio, int i, boolean b) {
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        // Comprueba que el identificador es válido
        // Lanza una excepción si no lo es
        String[] partes = identificador.split("-");
        if (partes.length != 2) {
            throw new IllegalArgumentException("Identificador inválido");
        }
        int planta = Integer.parseInt(partes[0]);
        int puerta = Integer.parseInt(partes[1]);
        if (planta < 1 || planta > MAX_PLANTAS || puerta < 1 || puerta > MAX_PUERTAS) {
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
        Habitacion that = (Habitacion) obj;
        return identificador.equals(that.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "identificador='" + identificador + '\'' +
                ", tipo=" + tipo +
                ", precio=" + precio +
                '}';
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}