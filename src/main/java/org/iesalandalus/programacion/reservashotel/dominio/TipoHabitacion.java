package org.iesalandalus.programacion.reservashotel.dominio;
import java.util.Scanner;
public enum TipoHabitacion {
    SIMPLE("Habitaci�n simple, capacidad m�xima: 1 persona"),
    DOBLE("Habitaci�n doble, capacidad m�xima: 2 personas"),
    FAMILIAR("Habitaci�n familiar, capacidad m�xima: 4 personas");

    private final String cadenaAMostrar;

    TipoHabitacion(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }

    public String getCadenaAMostrar() {
        return cadenaAMostrar;
    }

    @Override
    public String toString() {
        return cadenaAMostrar;
    }

    public int getDescripcion() {
        return getDescripcion();
    }
}
