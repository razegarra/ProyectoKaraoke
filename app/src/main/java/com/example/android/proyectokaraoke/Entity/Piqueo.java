package com.example.android.proyectokaraoke.Entity;

import android.graphics.Bitmap;

/**
 * Created by Richard Zegarra on 18/03/2016.
 */
public class Piqueo {
    private Long id;
    private String titulo;
    private String descripcion;
    private String precio;
    private String imagen;
    private boolean tipo;

    public Piqueo(Long id, String titulo, String descripcion, String precio, String imagen, boolean tipo) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.tipo = tipo;
    }

    public Piqueo(String titulo, String descripcion, String precio) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Piqueo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
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
