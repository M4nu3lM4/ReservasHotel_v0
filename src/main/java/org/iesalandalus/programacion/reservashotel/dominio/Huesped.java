package org.iesalandalus.programacion.reservashotel.dominio;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Huesped {

    // Expresiones regulares para validación
    private static final String NOMBRE_REGEX = "^[A-Za-zÁÉÍÓÚÑáéíóúñ]+(\\s[A-Za-zÁÉÍÓÚÑáéíóúñ]+)*$";
    private static final String DNI_REGEX = "^\\d{8}[A-HJ-NP-TV-Z]$";
    private static final String TELEFONO_REGEX = "^\\d{9}$";
    private static final String CORREO_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private String nombre;
    private String dni;
    private String telefono;
    private String correo;

    // Constructor con parámetros
    public Huesped(String nombre, String dni, String telefono, String correo) {
        setNombre(nombre);
        setDni(dni);
        setTelefono(telefono);
        setCorreo(correo);
    }

    // Constructor copia
    public Huesped(Huesped otro) {
        this(otro.nombre, otro.dni, otro.telefono, otro.correo);
    }

    // Métodos de acceso y modificación con validación
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (!nombre.matches(NOMBRE_REGEX)) {
            throw new IllegalArgumentException("Nombre no válido");
        }
        this.nombre = formateaNombre(nombre);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (!dni.matches(DNI_REGEX) || !comprobarLetraDni(dni)) {
            throw new IllegalArgumentException("DNI no válido");
        }
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (!telefono.matches(TELEFONO_REGEX)) {
            throw new IllegalArgumentException("Teléfono no válido");
        }
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (!correo.matches(CORREO_REGEX)) {
            throw new IllegalArgumentException("Correo no válido");
        }
        this.correo = correo;
    }

    // Método para formatear el nombre
    private String formateaNombre(String nombre) {
        // Implementa la lógica para formatear el nombre aquí
        // Retorna el nombre formateado
  return nombre;  }

    // Método para comprobar la letra del DNI
    private boolean comprobarLetraDni(String dni) {
        // Implementa la lógica para comprobar la letra del DNI aquí
        // Retorna true si la letra es válida, false en caso contrario
        System.out.print("Ingrese el número de DNI (sin el dígito verificador): ");
        int dni = scanner.nextInt();

        int digitoVerificador = calcularDigitoVerificador(dni);

        System.out.println("El dígito verificador es: " + digitoVerificador);
    }

    private static int calcularDigitoVerificador(int dni) {
        int[] coeficientes = {2, 3, 4, 5, 6, 7, 2, 3, 4, 5};
        int suma = 0;

        for (int i = 9; i >= 0; i--) {
            int digito = dni % 10;
            dni /= 10;
            suma += digito * coeficientes[i];
        }

        int resto = suma % 11;
        int resultado = 11 - resto;

        return (resultado == 11) ? 0 : resultado;
    }
}

    // Otros métodos requeridos: getIniciales, equals, hashCode, toString
    // ...


