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

    // Constructor con par�metros
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

    // M�todos de acceso y modificaci�n con validaci�n
    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        if (planta < 1 || planta > MAX_PLANTAS) {
            throw new IllegalArgumentException("N�mero de planta no v�lido");
        }
        this.planta = planta;
    }

    public int getPuerta() {
        return puerta;
    }

    public void setPuerta(int puerta) {
        if (puerta < 1 || puerta > MAX_HABITACIONES_POR_PLANTA) {
            throw new IllegalArgumentException("N�mero de puerta no v�lido");
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
            throw new IllegalArgumentException("Precio no v�lido");
        }
        this.precio = precio;
    }

    // M�todos equals y hashCode
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

    // M�todo toString
    @Override
    public String toString() {
        return "Habitaci�n " + planta + "-" + puerta +
                ", Tipo: " + tipo +
                ", Precio: " + precio + "?";
    }

    // Puedes probar la clase aqu� si lo deseas
    public static void main(String[] args) {
        // C�digo de prueba
    }
}