package com.example.android.proyectokaraoke.Data.Dao;

import com.example.android.proyectokaraoke.Entity.Musica;

import java.util.List;

/**
 * Created by USUARIO1 on 24/04/2016.
 */
public interface MusicaDao {
    void musicaRead(Musica musica);

    public List<Musica> musicaLista();

    public int musicaInsert(Musica musica);
}

