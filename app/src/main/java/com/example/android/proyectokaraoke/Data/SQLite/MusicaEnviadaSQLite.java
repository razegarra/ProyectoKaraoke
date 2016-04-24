package com.example.android.proyectokaraoke.Data.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.proyectokaraoke.Data.DBContract.MusicaDBContract;
import com.example.android.proyectokaraoke.Data.Dao.MusicaEnviadaDao;
import com.example.android.proyectokaraoke.Data.Helper.MySqlOpenHelper;
import com.example.android.proyectokaraoke.Entity.MusicaEnviada;
import java.util.ArrayList;
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
    public void musicaEnviadaRead(MusicaEnviada musicaEnviada) {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(MusicaDBContract.MusicaEnviada.TABLE_NAME, null,
                MusicaDBContract.MusicaEnviada._ID + "=?", new String[]{"" + musicaEnviada.getId()}, null, null, null);

        cursor.moveToFirst();
        musicaEnviada.setTitulo(
                cursor.getString(
                        cursor.getColumnIndex(
                                MusicaDBContract.MusicaEnviada.COLUMN_TITULO)));
        musicaEnviada.setCantante(cursor.getString(cursor.getColumnIndex(MusicaDBContract.MusicaEnviada.COLUMN_CANTANTE)));
        musicaEnviada.setGenero(cursor.getString(cursor.getColumnIndex(MusicaDBContract.MusicaEnviada.COLUMN_GENERO)));
        sqLiteDatabase.close();
    }

    @Override
    public List<MusicaEnviada> musicaEnviadaLista() {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(MusicaDBContract.MusicaEnviada.TABLE_NAME, null, null, null, null, null, null);
        List<MusicaEnviada> musicaEnviadaLista = new ArrayList<>();
        MusicaEnviada musicaEnviada;

        cursor.moveToFirst();
        do {
            musicaEnviada = new MusicaEnviada();
            musicaEnviada.setTitulo(cursor.getString(cursor.getColumnIndex(MusicaDBContract.MusicaEnviada.COLUMN_TITULO)));
            musicaEnviada.setCantante(cursor.getString(cursor.getColumnIndex(MusicaDBContract.MusicaEnviada.COLUMN_CANTANTE)));
            musicaEnviada.setGenero(cursor.getString(cursor.getColumnIndex(MusicaDBContract.MusicaEnviada.COLUMN_GENERO)));
            musicaEnviadaLista.add(musicaEnviada);
        } while (cursor.moveToNext());

        sqLiteDatabase.close();

        return musicaEnviadaLista;
    }

    @Override
    public long musicaEnviadaInsert(MusicaEnviada musicaEnviada) {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MusicaDBContract.MusicaEnviada.COLUMN_ID, musicaEnviada.getId());
        contentValues.put(MusicaDBContract.MusicaEnviada.COLUMN_TITULO, musicaEnviada.getTitulo());
        contentValues.put(MusicaDBContract.MusicaEnviada.COLUMN_CANTANTE, musicaEnviada.getCantante());
        contentValues.put(MusicaDBContract.MusicaEnviada.COLUMN_GENERO, musicaEnviada.getGenero());

        long row = sqLiteDatabase.insert(MusicaDBContract.MusicaEnviada.TABLE_NAME, null, contentValues);
        return row;
    }
}
