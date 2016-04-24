package com.example.android.proyectokaraoke.Data.Dao;

import com.example.android.proyectokaraoke.Entity.CatalogoPiqueoCompra;

import java.util.List;

/**
 * Created by USUARIO1 on 23/04/2016.
 */
public interface CatPiqueoConfirmDao {
    void catalogoConfirmRead(CatalogoPiqueoCompra catalogoPiqueoCompra);
    public List<CatalogoPiqueoCompra> catalogoConfirmLista();
    public int catalogoConfirmInsert(CatalogoPiqueoCompra catalogoPiqueoCompra);
}
