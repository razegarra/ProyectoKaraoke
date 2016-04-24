package com.example.android.proyectokaraoke.Data.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.proyectokaraoke.Data.Dao.MusicaEnviadaDao;
import com.example.android.proyectokaraoke.Data.Helper.MySqlOpenHelper;
import com.example.android.proyectokaraoke.Entity.MusicaEnviada;

import java.util.List;

/**
 * Created by USUARIO1 on 24/04/2016.
 */
public class MusicaEnviadaSQLite implements MusicaEnviadaDao {

    MySqlOpenHelper mySqlOpenHelper;

    public MusicaEnviadaSQLite(Context context) {
        mySqlOpenHelper = new MySqlOpenHelper(context);
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getWritableDatabase();
    }

    @Override
    public void musicaEnviadaRead(MusicaEnviada musica) {

    }

    @Override
    public List<MusicaEnviada> musicaEnviadaLista() {
        return null;
    }

    @Override
    public int musicaEnviadaInsert(MusicaEnviada musica) {
        return 0;
    }
}
