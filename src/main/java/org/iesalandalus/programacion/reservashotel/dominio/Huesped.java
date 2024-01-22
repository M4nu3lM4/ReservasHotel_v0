package org.iesalandalus.programacion.reservashotel.dominio;

import java.util.Objects;

public class Huesped {
    private String nombre;
    private String dni;
    private String telefono;
    private String correo;

    // Expresiones regulares para validar los datos
    private static final String NOMBRE_REGEX = "^[A-Z][a-z]*( [A-Z][a-z]*)*$";
    private static final String DNI_REGEX = "^[0-9]{8}[A-Z]$";
    private static final String TELEFONO_REGEX = "^[0-9]{9}$";
    private static final String CORREO_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    public Huesped(String nombre) {
        setNombre(nombre);
        setDni(dni);
        setTelefono(telefono);
        setCorreo(correo);
    }

    public Huesped(String nombre, String apellidos, String dni) {
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
        if (!dni.matches(DNI_REGEX)) {
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

    // Implementación de otros métodos como formateaNombre, comprobarLetraDni, getIniciales, equals, hashCode, toString...
    public String formateaNombre(String nombre) {
        // Elimina espacios en blanco adicionales y normaliza las mayúsculas y minúsculas
        return nombre.trim().replaceAll(" +", " ").toLowerCase();
    }

    public boolean comprobarLetraDni(String dni) {
        // Comprueba si la letra del DNI es válida
        int numero = Integer.parseInt(dni.substring(0, 8));
        char letra = dni.charAt(8);
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        return letra == letras.charAt(numero % 23);
    }

    public String getIniciales() {
        // Devuelve las iniciales del nombre
        String[] palabras = nombre.split(" ");
        StringBuilder iniciales = new StringBuilder();
        for (String palabra : palabras) {
            iniciales.append(palabra.charAt(0));
        }
        return iniciales.toString().toUpperCase();
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
        return Objects.hash(dni);
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
