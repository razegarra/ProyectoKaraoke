package com.example.android.proyectokaraoke.Entity;

import java.util.Date;

/**
 * Created by USUARIO1 on 23/04/2016.
 */
public class Reserva {

    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private Date fecha;

    public Reserva(String dni, String nombre, String apellido, String telefono, Date fecha) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fecha = fecha;
    }

    public Reserva() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
