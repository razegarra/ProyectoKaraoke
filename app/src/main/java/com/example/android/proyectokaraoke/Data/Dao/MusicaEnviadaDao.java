package com.example.android.proyectokaraoke.Data.Dao;

import com.example.android.proyectokaraoke.Entity.MusicaEnviada;

import java.util.List;

/**
 * Created by USUARIO1 on 24/04/2016.
 */
public interface MusicaEnviadaDao {
    void musicaEnviadaRead(MusicaEnviada musicaEnviada);

    public List<MusicaEnviada> musicaEnviadaLista();

    public long musicaEnviadaInsert(MusicaEnviada musicaEnviada);
}
