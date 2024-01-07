package org.iesalandalus.programacion.reservashotel.dominio;

public enum Regimen {

    MEDIA_PENSION("Media Pensi�n", 20),
    PENSION_COMPLETA("Pensi�n Completa", 30),
    TODO_INCLUIDO("Todo Incluido", 50);

    // Atributos
    private String descripcion;
    private int incrementoPrecioPorPersona;

    // Constructor privado
    private Regimen(String descripcion, int incrementoPrecioPorPersona) {
        this.descripcion = descripcion;
        this.incrementoPrecioPorPersona = incrementoPrecioPorPersona;
    }

    // M�todo getter
    public int getIncrementoPrecioPorPersona() {
        return incrementoPrecioPorPersona;
    }

    // M�todo toString
    @Override
    public String toString() {
        return descripcion + " - Incremento por persona: " + incrementoPrecioPorPersona + "?";
    }

    // Puedes probar el enumerado aqu� si lo deseas
    public static void main(String[] args) {
        for (Regimen regimen : Regimen.values()) {
            System.out.println(regimen);
        }
    }
}
