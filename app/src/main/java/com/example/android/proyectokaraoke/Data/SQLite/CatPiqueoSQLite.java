package com.example.android.proyectokaraoke.Data.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.proyectokaraoke.Data.Dao.CatPiqueoDao;
import com.example.android.proyectokaraoke.Data.Helper.MySqlOpenHelper;
import com.example.android.proyectokaraoke.Entity.CatalogoPiqueo;

import java.util.List;

/**
 * Created by USUARIO1 on 23/04/2016.
 */
public class CatPiqueoSQLite implements CatPiqueoDao {

    MySqlOpenHelper mySqlOpenHelper;

    public CatPiqueoSQLite(Context context) {
        mySqlOpenHelper = new MySqlOpenHelper(context);
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getWritableDatabase();
    }

    @Override
    public void catalogoRead(CatalogoPiqueo catalogoPiqueo) {

    }

    @Override
    public List<CatalogoPiqueo> catalogoLista() {
        return null;
    }

    @Override
    public int catalogoInsert(CatalogoPiqueo catalogoPiqueo) {
        return 0;
    }

    @Override
    public long catalogoDelete(CatalogoPiqueo catalogoPiqueo) {
        return 0;
    }
}
