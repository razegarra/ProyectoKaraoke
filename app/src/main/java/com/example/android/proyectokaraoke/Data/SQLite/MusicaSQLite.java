package com.example.android.proyectokaraoke.Data.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.proyectokaraoke.Data.Dao.MusicaDao;
import com.example.android.proyectokaraoke.Data.Helper.MySqlOpenHelper;
import com.example.android.proyectokaraoke.Entity.Musica;

import java.util.List;

/**
 * Created by USUARIO1 on 24/04/2016.
 */
public class MusicaSQLite implements MusicaDao {

    MySqlOpenHelper mySqlOpenHelper;

    public MusicaSQLite(Context context) {
        mySqlOpenHelper = new MySqlOpenHelper(context);
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getWritableDatabase();
    }

    @Override
    public void musicaRead(Musica musica) {

    }

    @Override
    public List<Musica> musicaLista() {
        return null;
    }

    @Override
    public int musicaInsert(Musica musica) {
        return 0;
    }
}
