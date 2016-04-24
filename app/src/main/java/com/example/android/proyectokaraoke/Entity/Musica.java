package com.example.android.proyectokaraoke.Entity;

public class Musica {

    private String titulo;
    private String cantante;
    private String genero;

    public Musica(String titulo, String cantante, String genero) {
        this.titulo = titulo;
        this.cantante = cantante;
        this.genero = genero;
    }

    public Musica() {
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
