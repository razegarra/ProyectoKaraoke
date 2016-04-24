package com.example.android.proyectokaraoke.Data.Dao;

import com.example.android.proyectokaraoke.Entity.PiqueoConfirm;

import java.util.List;

/**
 * Created by USUARIO1 on 23/04/2016.
 */
public interface PiqueoConfirmDao {
    void piqueoConfirmRead(PiqueoConfirm piqueoConfirm);

    public int piqueoConfirmExiste(Long id);

    public List<PiqueoConfirm> piqueoConfirmLista();

    public long piqueoConfirmInsert(PiqueoConfirm piqueoConfirm);
}
