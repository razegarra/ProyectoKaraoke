package com.example.android.proyectokaraoke.Entity;

/**
 * Created by Richard Zegarra on 18/03/2016.
 */
public class Piqueo {
    private String titulo;
    private String descripcion;
    private String precio;
    private int imagen;
    private boolean tipo;

    public Piqueo(String titulo, String descripcion, String precio, int imagen, boolean tipo) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.tipo = tipo;
    }

    public Piqueo() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }
}
