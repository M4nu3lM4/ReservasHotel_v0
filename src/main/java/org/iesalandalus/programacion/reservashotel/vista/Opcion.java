package org.iesalandalus.programacion.reservashotel.vista;

public enum Opcion {

    SALIR("Hasta Luego"),
    INSERTAR_HUESPED("INSERTAR HUESPED"),
    BUSCAR_HUESPED("BUSCAR HUESPED 2"),
    BORRAR_HUESPED("BORRAR HUESPED 3"),
    MOSTRAR_HUESPED("MOSTRAR HUESPEDES 4"),
    INSERTAR_HABITACION("INSERTAR HABITACION 5"),
    BUSCAR_HABITACION("BUSCAR HABITACION 6"),
    BORRAR_HABITACION("BORRAR HABITACION 7"),
    MOSTRAR_HABITACIONES("MOSTRAR HABITACIONES 8"),
    INSERTAR_RESERVA("INSERTAR RESERVA 9"),
    ANULAR_RESERVA("ANULAR RESERVA 10"),
    MOSTRAR_RESERVAS("MOSTRAR RESERVAS 11"),
    CONSULTAR_DISPONIBILIDAD("CONSULTAR DISPONIBILIDAD 12");

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
