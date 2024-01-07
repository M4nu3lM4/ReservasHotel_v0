package org.iesalandalus.programacion.reservashotel.dominio;

public enum Regimen {

    MEDIA_PENSION("Media Pensión", 20),
    PENSION_COMPLETA("Pensión Completa", 30),
    TODO_INCLUIDO("Todo Incluido", 50);

    // Atributos
    private String descripcion;
    private int incrementoPrecioPorPersona;

    // Constructor privado
    private Regimen(String descripcion, int incrementoPrecioPorPersona) {
        this.descripcion = descripcion;
        this.incrementoPrecioPorPersona = incrementoPrecioPorPersona;
    }

    // Método getter
    public int getIncrementoPrecioPorPersona() {
        return incrementoPrecioPorPersona;
    }

    // Método toString
    @Override
    public String toString() {
        return descripcion + " - Incremento por persona: " + incrementoPrecioPorPersona + "?";
    }

    // Puedes probar el enumerado aquí si lo deseas
    public static void main(String[] args) {
        for (Regimen regimen : Regimen.values()) {
            System.out.println(regimen);
        }
    }
}
