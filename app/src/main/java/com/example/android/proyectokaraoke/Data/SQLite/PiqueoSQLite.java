package com.example.android.proyectokaraoke.Data.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.proyectokaraoke.Data.Dao.PiqueoDao;
import com.example.android.proyectokaraoke.Data.Helper.MySqlOpenHelper;
import com.example.android.proyectokaraoke.Entity.Piqueo;

import java.util.List;

/**
 * Created by USUARIO1 on 23/04/2016.
 */
public class PiqueoSQLite implements PiqueoDao {

    MySqlOpenHelper mySqlOpenHelper;

    public PiqueoSQLite(Context context) {
        mySqlOpenHelper = new MySqlOpenHelper(context);
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getWritableDatabase();
    }

    @Override
    public void catalogoRead(Piqueo piqueo) {

    }

    @Override
    public List<Piqueo> catalogoLista() {
        return null;
    }

    @Override
    public int catalogoInsert(Piqueo piqueo) {
        return 0;
    }

    @Override
    public long catalogoDelete(Piqueo piqueo) {
        return 0;
    }
}
