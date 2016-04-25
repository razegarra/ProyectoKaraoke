package com.example.android.proyectokaraoke.Data.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.proyectokaraoke.Data.DBContract.MusicaDBContract;
import com.example.android.proyectokaraoke.Data.Dao.MusicaFavoritaDao;
import com.example.android.proyectokaraoke.Data.Helper.MySqlOpenHelper;
import com.example.android.proyectokaraoke.Entity.MusicaFavorita;

import java.util.ArrayList;
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
    public void musicaFavoritaRead(MusicaFavorita musicaFavorita) {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(MusicaDBContract.MusicaFavorita.TABLE_NAME, null,
                MusicaDBContract.MusicaFavorita._ID + "=?", new String[]{"" + musicaFavorita.getId()}, null, null, null);

        cursor.moveToFirst();
        musicaFavorita.setTitulo(
                cursor.getString(
                        cursor.getColumnIndex(
                                MusicaDBContract.MusicaFavorita.COLUMN_TITULO)));
        musicaFavorita.setCantante(cursor.getString(cursor.getColumnIndex(MusicaDBContract.MusicaFavorita.COLUMN_CANTANTE)));
        musicaFavorita.setGenero(cursor.getString(cursor.getColumnIndex(MusicaDBContract.MusicaFavorita.COLUMN_GENERO)));
        sqLiteDatabase.close();
    }

    @Override
    public int musicaFavoritaExiste(Long id) {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getReadableDatabase();
        Cursor mCount= sqLiteDatabase.rawQuery("select count(1) from "+MusicaDBContract.MusicaFavorita.TABLE_NAME+" where id=" + id, null);
        mCount.moveToFirst();
        int count= mCount.getInt(0);
        mCount.close();
        return count;
    }

    @Override
    public List<MusicaFavorita> musicaFavoritaLista() {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(MusicaDBContract.MusicaFavorita.TABLE_NAME, null, null, null, null, null, null);
        List<MusicaFavorita> musicaFavoritaLista = new ArrayList<>();
        MusicaFavorita musicaFavorita;

        cursor.moveToFirst();
        do {
            musicaFavorita = new MusicaFavorita();
            musicaFavorita.setTitulo(cursor.getString(cursor.getColumnIndex(MusicaDBContract.MusicaFavorita.COLUMN_TITULO)));
            musicaFavorita.setCantante(cursor.getString(cursor.getColumnIndex(MusicaDBContract.MusicaFavorita.COLUMN_CANTANTE)));
            musicaFavorita.setGenero(cursor.getString(cursor.getColumnIndex(MusicaDBContract.MusicaFavorita.COLUMN_GENERO)));
            musicaFavoritaLista.add(musicaFavorita);
        } while (cursor.moveToNext());

        sqLiteDatabase.close();

        return musicaFavoritaLista;
    }

    @Override
    public long musicaFavoritaInsert(MusicaFavorita musicaFavorita) {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MusicaDBContract.MusicaFavorita.COLUMN_ID, musicaFavorita.getId());
        contentValues.put(MusicaDBContract.MusicaFavorita.COLUMN_TITULO, musicaFavorita.getTitulo());
        contentValues.put(MusicaDBContract.MusicaFavorita.COLUMN_CANTANTE, musicaFavorita.getCantante());
        contentValues.put(MusicaDBContract.MusicaFavorita.COLUMN_GENERO, musicaFavorita.getGenero());

        long row = sqLiteDatabase.insert(MusicaDBContract.MusicaFavorita.TABLE_NAME, null, contentValues);
        return row;
    }

    @Override
    public boolean musicaFavoritaDelete(MusicaFavorita musica) {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getWritableDatabase();
        return sqLiteDatabase.delete(MusicaDBContract.MusicaFavorita.TABLE_NAME, MusicaDBContract.MusicaFavorita.COLUMN_ID + "=" + musica.getId(), null) > 0;
    }
}
