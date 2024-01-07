package org.iesalandalus.programacion.reservashotel.vista;

public enum Opcion {
    OPCION_1("Mensaje de la opci�n 1"),
    OPCION_2("Mensaje de la opci�n 2"),
    OPCION_3("Mensaje de la opci�n 3"),
    OPCION_4("Mensaje de la opci�n 4"),
    OPCION_5("Mensaje de la opci�n 5"),
    OPCION_6("Mensaje de la opci�n 6"),
    OPCION_7("Mensaje de la opci�n 7"),
    OPCION_8("Mensaje de la opci�n 8"),
    OPCION_9("Mensaje de la opci�n 9"),
    OPCION_10("Mensaje de la opci�n 10"),
    OPCION_11("Mensaje de la opci�n 11"),
    OPCION_12("Mensaje de la opci�n 12"),
    OPCION_13("Mensaje de la opci�n 13"),
    SALIR("Hasta Luego");






















    // Atributo
    private String mensaje;

    // Constructor
    private Opcion(String mensaje) {
        this.mensaje = mensaje;
    }

    // M�todo para obtener el mensaje
    public String getMensaje() {
        return mensaje;
    }

    // M�todo toString
    @Override
    public String toString() {
        return ordinal() + " .- " + mensaje;
    }

    // Puedes probar el enumerado aqu� si lo deseas
    public static void main(String[] args) {
        for (Opcion opcion : Opcion.values()) {
            System.out.println(opcion);
        }
    }
}
