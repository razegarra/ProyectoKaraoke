package com.example.android.proyectokaraoke.Data.Dao;

import com.example.android.proyectokaraoke.Entity.Piqueo;

import java.util.List;

/**
 * Created by USUARIO1 on 23/04/2016.
 */
public interface PiqueoDao {
    void catalogoRead(Piqueo piqueo);

    public List<Piqueo> catalogoLista();

    public int catalogoInsert(Piqueo piqueo);

    public long catalogoDelete(Piqueo piqueo);
}
