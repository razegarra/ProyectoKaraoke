package com.example.android.proyectokaraoke.Data.Dao;

import com.example.android.proyectokaraoke.Entity.Piqueo;

import java.util.List;

/**
 * Created by USUARIO1 on 23/04/2016.
 */
public interface PiqueoDao {
    void piqueoRead(Piqueo piqueo);

    public List<Piqueo> piqueoLista();

    public long piqueoInsert(Piqueo piqueo);

}
