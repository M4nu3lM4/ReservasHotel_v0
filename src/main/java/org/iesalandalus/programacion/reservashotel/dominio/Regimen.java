package org.iesalandalus.programacion.reservashotel.dominio;

public enum Regimen {
    MP("Media pensión", 40),
    PC("Pensión completa", 70),
    AD("Alojamiento y desayuno", 30),
    SA("Solo Alojamiento", 20);
    private String descripcion;
    private double incrementoPrecio;

    Regimen(String descripcion, double incrementoPrecio) {
        this.descripcion = descripcion;
        this.incrementoPrecio = incrementoPrecio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getIncrementoPrecio() {
        return incrementoPrecio;
    }

    @Override
    public String toString() {
        return descripcion + " (" + incrementoPrecio + "€ por persona)";
    }
}

