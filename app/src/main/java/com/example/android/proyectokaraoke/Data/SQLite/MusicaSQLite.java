package com.example.android.proyectokaraoke.Data.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.proyectokaraoke.Data.DBContract.MusicaDBContract;
import com.example.android.proyectokaraoke.Data.Dao.MusicaDao;
import com.example.android.proyectokaraoke.Data.Helper.MySqlOpenHelper;
import com.example.android.proyectokaraoke.Entity.Musica;

import java.util.ArrayList;
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
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(MusicaDBContract.Musica.TABLE_NAME, null,
                MusicaDBContract.Musica._ID + "=?", new String[]{"" + musica.getId()}, null, null, null);

        cursor.moveToFirst();
        musica.setTitulo(
                cursor.getString(
                        cursor.getColumnIndex(
                                MusicaDBContract.Musica.COLUMN_TITULO)));
        musica.setCantante(cursor.getString(cursor.getColumnIndex(MusicaDBContract.Musica.COLUMN_CANTANTE)));
        musica.setGenero(cursor.getString(cursor.getColumnIndex(MusicaDBContract.Musica.COLUMN_GENERO)));
        sqLiteDatabase.close();
    }

    @Override
    public List<Musica> musicaLista() {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(MusicaDBContract.Musica.TABLE_NAME, null, null, null, null, null, null);
        List<Musica> musicaLista = new ArrayList<>();
        Musica musica;

        cursor.moveToFirst();
        do {
            musica = new Musica();
            musica.setId(cursor.getLong(cursor.getColumnIndex(MusicaDBContract.Musica._ID)));
            musica.setTitulo(cursor.getString(cursor.getColumnIndex(MusicaDBContract.Musica.COLUMN_TITULO)));
            musica.setCantante(cursor.getString(cursor.getColumnIndex(MusicaDBContract.Musica.COLUMN_CANTANTE)));
            musica.setGenero(cursor.getString(cursor.getColumnIndex(MusicaDBContract.Musica.COLUMN_GENERO)));
            musicaLista.add(musica);
        } while (cursor.moveToNext());

        sqLiteDatabase.close();

        return musicaLista;
    }

    @Override
    public long musicaInsert(Musica musica) {

        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MusicaDBContract.Musica.COLUMN_TITULO, musica.getTitulo());
        contentValues.put(MusicaDBContract.Musica.COLUMN_CANTANTE, musica.getCantante());
        contentValues.put(MusicaDBContract.Musica.COLUMN_GENERO, musica.getGenero());

        long row = sqLiteDatabase.insert(MusicaDBContract.Musica.TABLE_NAME, null, contentValues);
        return row;
    }
}
