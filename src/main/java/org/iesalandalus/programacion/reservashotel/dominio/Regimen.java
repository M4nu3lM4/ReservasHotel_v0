package org.iesalandalus.programacion.reservashotel.dominio;

public enum Regimen {
    SOLO_ALOJAMIENTO("Solo alojamiento, incremento por persona: 0?"),
    MEDIA_PENSION("Media pensión, incremento por persona: 20?"),
    PENSION_COMPLETA("Pensión completa, incremento por persona: 40?");

    private final String descripcion;

    Regimen(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
