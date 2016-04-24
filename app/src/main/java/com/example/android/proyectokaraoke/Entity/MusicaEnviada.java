package com.example.android.proyectokaraoke.Entity;

/**
 * Created by USUARIO1 on 23/04/2016.
 */
public class MusicaEnviada extends Musica {

    private Long id;

    public MusicaEnviada(Long id, String titulo, String cantante, String genero) {
        super(titulo, cantante, genero);
        this.id = id;
    }

    public MusicaEnviada() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
