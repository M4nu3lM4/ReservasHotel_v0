package org.iesalandalus.programacion.reservashotel.dominio;

import java.util.regex.*;
import java.util.Scanner;
public class Huesped {
    private String nombre;
    private String dni;
    private String telefono;
    private String correo;

    private static final String NOMBRE_REGEX = "^[A-Z][a-z]*([ ][A-Z][a-z]*)*$";
    private static final String DNI_REGEX = "^[0-9]{8}[A-Z]$";
    private static final String TELEFONO_REGEX = "^[0-9]{9}$";
    private static final String CORREO_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    public Huesped(String nombre, String dni, String telefono, String correo) {
        setNombre(nombre);
        setDni(dni);
        setTelefono(telefono);
        setCorreo(correo);
    }

    public Huesped(Huesped otro) {
        this(otro.nombre, otro.dni, otro.telefono, otro.correo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (!nombre.matches(NOMBRE_REGEX)) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (!dni.matches(DNI_REGEX) || !comprobarLetraDni(dni)) {
            throw new IllegalArgumentException("DNI inválido");
        }
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (!telefono.matches(TELEFONO_REGEX)) {
            throw new IllegalArgumentException("Teléfono inválido");
        }
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (!correo.matches(CORREO_REGEX)) {
            throw new IllegalArgumentException("Correo inválido");
        }
        this.correo = correo;
    }

    public String getIniciales() {
        String[] palabras = nombre.split(" ");
        StringBuilder iniciales = new StringBuilder();
        for (String palabra : palabras) {
            iniciales.append(palabra.charAt(0));
        }
        return iniciales.toString();
    }

    private boolean comprobarLetraDni(String dni) {
        // Implementación de la comprobación de la letra del DNI
        // Extraer el número y la letra del DNI
        String numeroDni = dni.substring(0, 8);
        char letraDni = dni.charAt(8);

        // Calcular la letra correcta
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int indiceLetraCorrecta = Integer.parseInt(numeroDni) % 23;
        char letraCorrecta = letras.charAt(indiceLetraCorrecta);

        // Comprobar si la letra del DNI es correcta
        return letraDni == letraCorrecta;


    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Huesped huesped = (Huesped) obj;
        return dni.equals(huesped.dni);
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }

    @Override
    public String toString() {
        return "Huesped{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}