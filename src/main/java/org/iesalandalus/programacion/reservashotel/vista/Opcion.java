package org.iesalandalus.programacion.reservashotel.vista;

public enum Opcion {
    OPCION_1("Mensaje de la opción 1"),
    OPCION_2("Mensaje de la opción 2"),
    OPCION_3("Mensaje de la opción 3"),
    OPCION_4("Mensaje de la opción 4"),
    OPCION_5("Mensaje de la opción 5"),
    OPCION_6("Mensaje de la opción 6"),
    OPCION_7("Mensaje de la opción 7"),
    OPCION_8("Mensaje de la opción 8"),
    OPCION_9("Mensaje de la opción 9"),
    OPCION_10("Mensaje de la opción 10"),
    OPCION_11("Mensaje de la opción 11"),
    OPCION_12("Mensaje de la opción 12"),
    OPCION_13("Mensaje de la opción 13"),
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
