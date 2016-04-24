package com.example.android.proyectokaraoke.Data.Dao;

import com.example.android.proyectokaraoke.Entity.CatalogoPiqueo;

import java.util.List;

/**
 * Created by USUARIO1 on 23/04/2016.
 */
public interface CatPiqueoDao {
    void catalogoRead(CatalogoPiqueo catalogoPiqueo);
    public List<CatalogoPiqueo> catalogoLista();
    public int catalogoInsert(CatalogoPiqueo catalogoPiqueo);
    public long catalogoDelete(CatalogoPiqueo catalogoPiqueo);
}
