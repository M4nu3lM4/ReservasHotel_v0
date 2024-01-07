package org.iesalandalus.programacion.reservashotel.dominio;

public enum TipoHabitacion {
    EJEMPLO("Habitacion Ejemplo,",0),
    INDIVIDUAL("Habitación Individual", 1),
    DOBLE("Habitación Doble", 2),
    TRIPLE("Habitación Triple", 3),
    SUITE("Suite", 4);

    private String descripcion;
    private int capacidadMaxima;
    private String cadenaAMostrar;

    // Constructor privado
    private TipoHabitacion(String descripcion, int capacidadMaxima) {
        this.descripcion = descripcion;
        this.capacidadMaxima = capacidadMaxima;
        this.cadenaAMostrar = generarCadenaAMostrar();
    }

    // Getter del atributo cadenaAMostrar
    public String getCadenaAMostrar() {
        return cadenaAMostrar;
    }

    // Método toString
    @Override
    public String toString() {
        return cadenaAMostrar;
    }

    // Método privado para generar la cadena a mostrar
    private String generarCadenaAMostrar() {
        return descripcion + " - Capacidad Máxima: " + capacidadMaxima + " personas";
    }

    // Puedes probar el enumerado aquí si lo deseas
    public static void main(String[] args) {
        for (TipoHabitacion tipo : TipoHabitacion.values()) {
            System.out.println(tipo);
        }
    }
}
