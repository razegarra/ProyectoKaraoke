package com.example.android.proyectokaraoke.Data.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.proyectokaraoke.Data.Dao.MusicaFavoritaDao;
import com.example.android.proyectokaraoke.Data.Helper.MySqlOpenHelper;
import com.example.android.proyectokaraoke.Entity.MusicaFavorita;

import java.util.List;

/**
 * Created by USUARIO1 on 24/04/2016.
 */
public class MusicaFavoritaSQLite implements MusicaFavoritaDao {

    MySqlOpenHelper mySqlOpenHelper;

    public MusicaFavoritaSQLite(Context context) {
        mySqlOpenHelper = new MySqlOpenHelper(context);
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getWritableDatabase();
    }


    @Override
    public void musicaFavoritaRead(MusicaFavorita musica) {

    }

    @Override
    public List<MusicaFavorita> musicaFavoritaLista() {
        return null;
    }

    @Override
    public int musicaFavoritaInsert(MusicaFavorita musica) {
        return 0;
    }
}
