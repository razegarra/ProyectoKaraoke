package com.example.android.proyectokaraoke.Data.Dao;

import com.example.android.proyectokaraoke.Entity.MusicaEnviada;

import java.util.List;

/**
 * Created by USUARIO1 on 24/04/2016.
 */
public interface MusicaEnviadaDao {
    void musicaEnviadaRead(MusicaEnviada musica);

    public List<MusicaEnviada> musicaEnviadaLista();

    public int musicaEnviadaInsert(MusicaEnviada musica);
}
