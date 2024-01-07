package org.iesalandalus.programacion.reservashotel.dominio;


public class Habitacion {

    // Constantes
    private static final int MAX_PLANTAS = 3;
    private static final int MAX_HABITACIONES_POR_PLANTA = 15;
    private static final int PRECIO_MINIMO = 40;
    private static final int PRECIO_MAXIMO = 150;

    // Atributos
    private int planta;
    private int puerta;
    private TipoHabitacion tipo;
    private int precio;

    // Constructor con parámetros
    public Habitacion(int planta, int puerta, TipoHabitacion tipo, int precio) {
        setPlanta(planta);
        setPuerta(puerta);
        setTipo(tipo);
        setPrecio(precio);
    }

    // Constructor copia
    public Habitacion(Habitacion otra) {
        this(otra.planta, otra.puerta, otra.tipo, otra.precio);
    }

    // Métodos de acceso y modificación con validación
    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        if (planta < 1 || planta > MAX_PLANTAS) {
            throw new IllegalArgumentException("Número de planta no válido");
        }
        this.planta = planta;
    }

    public int getPuerta() {
        return puerta;
    }

    public void setPuerta(int puerta) {
        if (puerta < 1 || puerta > MAX_HABITACIONES_POR_PLANTA) {
            throw new IllegalArgumentException("Número de puerta no válido");
        }
        this.puerta = puerta;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        if (precio < PRECIO_MINIMO || precio > PRECIO_MAXIMO) {
            throw new IllegalArgumentException("Precio no válido");
        }
        this.precio = precio;
    }

    // Métodos equals y hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Habitacion habitacion = (Habitacion) obj;
        return planta == habitacion.planta &&
                puerta == habitacion.puerta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(planta, puerta);
    }

    // Método toString
    @Override
    public String toString() {
        return "Habitación " + planta + "-" + puerta +
                ", Tipo: " + tipo +
                ", Precio: " + precio + "?";
    }

    // Puedes probar la clase aquí si lo deseas
    public static void main(String[] args) {
        // Código de prueba
    }
}