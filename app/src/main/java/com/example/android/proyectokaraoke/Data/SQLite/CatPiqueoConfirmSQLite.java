package com.example.android.proyectokaraoke.Data.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.proyectokaraoke.Data.Dao.CatPiqueoConfirmDao;
import com.example.android.proyectokaraoke.Data.Helper.MySqlOpenHelper;
import com.example.android.proyectokaraoke.Entity.CatalogoPiqueoCompra;

import java.util.List;

/**
 * Created by USUARIO1 on 23/04/2016.
 */
public class CatPiqueoConfirmSQLite implements CatPiqueoConfirmDao {


    MySqlOpenHelper mySqlOpenHelper;

    public CatPiqueoConfirmSQLite(Context context) {
        mySqlOpenHelper = new MySqlOpenHelper(context);
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getWritableDatabase();
    }

    @Override
    public void catalogoConfirmRead(CatalogoPiqueoCompra catalogoPiqueoCompra) {

    }

    @Override
    public List<CatalogoPiqueoCompra> catalogoConfirmLista() {
        return null;
    }

    @Override
    public int catalogoConfirmInsert(CatalogoPiqueoCompra catalogoPiqueoCompra) {
        return 0;
    }
}
