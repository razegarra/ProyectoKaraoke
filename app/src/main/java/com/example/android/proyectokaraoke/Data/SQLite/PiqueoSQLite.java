package com.example.android.proyectokaraoke.Data.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.proyectokaraoke.Data.DBContract.PiqueoDBContract;
import com.example.android.proyectokaraoke.Data.Dao.PiqueoDao;
import com.example.android.proyectokaraoke.Data.Helper.MySqlOpenHelper;
import com.example.android.proyectokaraoke.Entity.Piqueo;

import java.util.ArrayList;
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
    public void piqueoRead(Piqueo piqueo) {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(PiqueoDBContract.Piqueo.TABLE_NAME, null,
                PiqueoDBContract.Piqueo._ID + "=?", new String[]{"" + piqueo.getId()}, null, null, null);

        cursor.moveToFirst();
        piqueo.setTitulo(
                cursor.getString(
                        cursor.getColumnIndex(
                                PiqueoDBContract.Piqueo.COLUMN_TITULO)));
        piqueo.setDescripcion(cursor.getString(cursor.getColumnIndex(PiqueoDBContract.Piqueo.COLUMN_DESCRIPCION)));
        piqueo.setPrecio(cursor.getString(cursor.getColumnIndex(PiqueoDBContract.Piqueo.COLUMN_PRECIO)));
        piqueo.setTipo(cursor.getInt(cursor.getColumnIndex(PiqueoDBContract.Piqueo.COLUMN_TIPO))==0?false:true);
        piqueo.setImagen(cursor.getString(cursor.getColumnIndex(PiqueoDBContract.Piqueo.COLUMN_IMAGEN)));
        sqLiteDatabase.close();
    }

    @Override
    public List<Piqueo> piqueoLista() {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(PiqueoDBContract.Piqueo.TABLE_NAME, null, null, null, null, null, null);
        List<Piqueo> piqueoLista = new ArrayList<>();
        Piqueo piqueo;

        cursor.moveToFirst();
        do {
            piqueo = new Piqueo();
            piqueo.setId(cursor.getLong(cursor.getColumnIndex(PiqueoDBContract.Piqueo._ID)));
            piqueo.setTitulo(cursor.getString(cursor.getColumnIndex(PiqueoDBContract.Piqueo.COLUMN_TITULO)));
            piqueo.setDescripcion(cursor.getString(cursor.getColumnIndex(PiqueoDBContract.Piqueo.COLUMN_DESCRIPCION)));
            piqueo.setPrecio(cursor.getString(cursor.getColumnIndex(PiqueoDBContract.Piqueo.COLUMN_PRECIO)));
            piqueo.setTipo(cursor.getInt(cursor.getColumnIndex(PiqueoDBContract.Piqueo.COLUMN_TIPO))==0?false:true);
            piqueo.setImagen(cursor.getString(cursor.getColumnIndex(PiqueoDBContract.Piqueo.COLUMN_IMAGEN)));

            piqueoLista.add(piqueo);
        } while (cursor.moveToNext());

        sqLiteDatabase.close();

        return piqueoLista;
    }

    @Override
    public long piqueoInsert(Piqueo piqueo) {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PiqueoDBContract.Piqueo.COLUMN_TITULO, piqueo.getTitulo());
        contentValues.put(PiqueoDBContract.Piqueo.COLUMN_DESCRIPCION, piqueo.getDescripcion());
        contentValues.put(PiqueoDBContract.Piqueo.COLUMN_PRECIO, piqueo.getPrecio());
        contentValues.put(PiqueoDBContract.Piqueo.COLUMN_TIPO, piqueo.isTipo()?1:0);
        contentValues.put(PiqueoDBContract.Piqueo.COLUMN_IMAGEN, piqueo.getTitulo());

        long row = sqLiteDatabase.insert(PiqueoDBContract.Piqueo.TABLE_NAME, null, contentValues);
        return row;
    }


}
