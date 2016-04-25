package com.example.android.proyectokaraoke.Data.Dao;

import com.example.android.proyectokaraoke.Entity.MusicaFavorita;

import java.util.List;

/**
 * Created by USUARIO1 on 24/04/2016.
 */
public interface MusicaFavoritaDao {
    void musicaFavoritaRead(MusicaFavorita musica);

    public int musicaFavoritaExiste(Long id);

    public List<MusicaFavorita> musicaFavoritaLista();

    public long musicaFavoritaInsert(MusicaFavorita musica);

    public boolean musicaFavoritaDelete(MusicaFavorita musica);
}
