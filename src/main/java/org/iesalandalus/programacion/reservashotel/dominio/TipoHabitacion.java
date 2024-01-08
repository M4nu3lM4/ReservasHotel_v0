package org.iesalandalus.programacion.reservashotel.dominio;
import java.util.Scanner;
public enum TipoHabitacion {
    SIMPLE("Habitación simple, capacidad máxima: 1 persona"),
    DOBLE("Habitación doble, capacidad máxima: 2 personas"),
    FAMILIAR("Habitación familiar, capacidad máxima: 4 personas");

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
