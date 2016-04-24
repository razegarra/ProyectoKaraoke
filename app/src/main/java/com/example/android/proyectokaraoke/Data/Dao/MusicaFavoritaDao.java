package com.example.android.proyectokaraoke.Data.Dao;

import com.example.android.proyectokaraoke.Entity.MusicaFavorita;

import java.util.List;

/**
 * Created by USUARIO1 on 24/04/2016.
 */
public interface MusicaFavoritaDao {
    void musicaFavoritaRead(MusicaFavorita musica);

    public List<MusicaFavorita> musicaFavoritaLista();

    public int musicaFavoritaInsert(MusicaFavorita musica);
}
