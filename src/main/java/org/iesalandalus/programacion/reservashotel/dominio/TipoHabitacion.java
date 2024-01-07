package org.iesalandalus.programacion.reservashotel.dominio;

public enum TipoHabitacion {
    EJEMPLO("Habitacion Ejemplo,",0),
    INDIVIDUAL("Habitaci�n Individual", 1),
    DOBLE("Habitaci�n Doble", 2),
    TRIPLE("Habitaci�n Triple", 3),
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

    // M�todo toString
    @Override
    public String toString() {
        return cadenaAMostrar;
    }

    // M�todo privado para generar la cadena a mostrar
    private String generarCadenaAMostrar() {
        return descripcion + " - Capacidad M�xima: " + capacidadMaxima + " personas";
    }

    // Puedes probar el enumerado aqu� si lo deseas
    public static void main(String[] args) {
        for (TipoHabitacion tipo : TipoHabitacion.values()) {
            System.out.println(tipo);
        }
    }
}
