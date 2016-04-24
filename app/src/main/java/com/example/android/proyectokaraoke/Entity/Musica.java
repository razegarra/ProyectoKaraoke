package com.example.android.proyectokaraoke.Entity;

public class Musica {

    private Long id;
    private String titulo;
    private String cantante;
    private String genero;

    public Musica(Long id, String titulo, String cantante, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.cantante = cantante;
        this.genero = genero;
    }

    public Musica() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
