package org.iesalandalus.programacion.reservashotel.vista;

public enum Opcion {
    OPCION_1("Bienvenido"),
    OPCION_2("Crear Reserva"),
    OPCION_3("Buscar reserva"),
    OPCION_4("Borrar reserva"),
    OPCION_5("Crear Huesped"),
    OPCION_6("Buscar Huesped"),
    OPCION_7("Borrar Huesped"),
    OPCION_8("Crear Habitacion"),
    OPCION_9("Buscar habitacion"),
    OPCION_10("Borrar habitacion"),
    SALIR("Hasta Luego");

    // Atributo
    private String mensaje;

    // Constructor
    private Opcion(String mensaje) {
        this.mensaje = mensaje;
    }

    // Método para obtener el mensaje
    public String getMensaje() {
        return mensaje;
    }

    // Método toString
    @Override
    public String toString() {
        return ordinal() + " .- " + mensaje;
    }

    // Puedes probar el enumerado aquí si lo deseas
    public static void main(String[] args) {
        for (Opcion opcion : Opcion.values()) {
            System.out.println(opcion);
        }
    }
}
