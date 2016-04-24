package com.example.android.proyectokaraoke.Data.Dao;

import com.example.android.proyectokaraoke.Entity.PiqueoPedido;

import java.util.List;

/**
 * Created by USUARIO1 on 24/04/2016.
 */
public interface PiqueoPedidoDao {
    void catalogoRead(PiqueoPedido piqueoPedido);

    public List<PiqueoPedido> catalogoLista();

    public int catalogoInsert(PiqueoPedido piqueoPedido);

    public long catalogoDelete(PiqueoPedido piqueoPedido);
}
