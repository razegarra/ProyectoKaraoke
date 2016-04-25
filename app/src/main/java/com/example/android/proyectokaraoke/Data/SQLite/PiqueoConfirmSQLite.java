package com.example.android.proyectokaraoke.Data.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.proyectokaraoke.Data.DBContract.PiqueoDBContract;
import com.example.android.proyectokaraoke.Data.Dao.PiqueoConfirmDao;
import com.example.android.proyectokaraoke.Data.Helper.MySqlOpenHelper;
import com.example.android.proyectokaraoke.Entity.PiqueoConfirm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USUARIO1 on 23/04/2016.
 */
public class PiqueoConfirmSQLite implements PiqueoConfirmDao {


    MySqlOpenHelper mySqlOpenHelper;

    public PiqueoConfirmSQLite(Context context) {
        mySqlOpenHelper = new MySqlOpenHelper(context);
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getWritableDatabase();
    }

    @Override
    public void piqueoConfirmRead(PiqueoConfirm piqueoConfirm) {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(PiqueoDBContract.PiqueoConfirm.TABLE_NAME, null,
                PiqueoDBContract.PiqueoConfirm.COLUMN_ID + "=?", new String[]{"" + piqueoConfirm.getId()}, null, null, null);

        cursor.moveToFirst();
        piqueoConfirm.setTitulo(
                cursor.getString(
                        cursor.getColumnIndex(
                                PiqueoDBContract.Piqueo.COLUMN_TITULO)));
        piqueoConfirm.setDescripcion(cursor.getString(cursor.getColumnIndex(PiqueoDBContract.PiqueoConfirm.COLUMN_DESCRIPCION)));
        piqueoConfirm.setPrecio(cursor.getString(cursor.getColumnIndex(PiqueoDBContract.PiqueoConfirm.COLUMN_PRECIO)));
        piqueoConfirm.setCantidad(cursor.getDouble(cursor.getColumnIndex(PiqueoDBContract.PiqueoConfirm.COLUMN_CANTIDAD)));
            piqueoConfirm.setSubtotal(cursor.getDouble(cursor.getColumnIndex(PiqueoDBContract.PiqueoConfirm.COLUMN_SUBTOTAL)));
        sqLiteDatabase.close();
    }

    @Override
    public int piqueoConfirmExiste(Long id) {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getReadableDatabase();
        Cursor mCount= sqLiteDatabase.rawQuery("select count(1) from "+PiqueoDBContract.PiqueoConfirm.TABLE_NAME+" where id=" + id, null);
        mCount.moveToFirst();
        int count= mCount.getInt(0);
        mCount.close();
        return count;
    }

    @Override
    public List<PiqueoConfirm> piqueoConfirmLista() {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(PiqueoDBContract.PiqueoConfirm.TABLE_NAME, null, null, null, null, null, null);
        List<PiqueoConfirm> piqueoConfirmLista = new ArrayList<>();
        PiqueoConfirm piqueoConfirm;

        cursor.moveToFirst();
        do {
            piqueoConfirm = new PiqueoConfirm();
            piqueoConfirm.setId(cursor.getLong(cursor.getColumnIndex(PiqueoDBContract.PiqueoConfirm.COLUMN_ID)));
            piqueoConfirm.setTitulo(cursor.getString(cursor.getColumnIndex(PiqueoDBContract.PiqueoConfirm.COLUMN_TITULO)));
            piqueoConfirm.setDescripcion(cursor.getString(cursor.getColumnIndex(PiqueoDBContract.PiqueoConfirm.COLUMN_DESCRIPCION)));
            piqueoConfirm.setPrecio(cursor.getString(cursor.getColumnIndex(PiqueoDBContract.PiqueoConfirm.COLUMN_PRECIO)));
            piqueoConfirm.setCantidad(cursor.getDouble(cursor.getColumnIndex(PiqueoDBContract.PiqueoConfirm.COLUMN_CANTIDAD)));
            piqueoConfirm.setSubtotal(cursor.getDouble(cursor.getColumnIndex(PiqueoDBContract.PiqueoConfirm.COLUMN_SUBTOTAL)));
            piqueoConfirmLista.add(piqueoConfirm);
        } while (cursor.moveToNext());

        sqLiteDatabase.close();

        return piqueoConfirmLista;


    }

    @Override
    public long piqueoConfirmInsert(PiqueoConfirm piqueoConfirm) {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PiqueoDBContract.PiqueoConfirm.COLUMN_ID, piqueoConfirm.getId());
        contentValues.put(PiqueoDBContract.PiqueoConfirm.COLUMN_TITULO, piqueoConfirm.getTitulo());
        contentValues.put(PiqueoDBContract.PiqueoConfirm.COLUMN_DESCRIPCION, piqueoConfirm.getDescripcion());
        contentValues.put(PiqueoDBContract.PiqueoConfirm.COLUMN_PRECIO, piqueoConfirm.getPrecio());
        contentValues.put(PiqueoDBContract.PiqueoConfirm.COLUMN_CANTIDAD, piqueoConfirm.getCantidad());
        contentValues.put(PiqueoDBContract.PiqueoConfirm.COLUMN_SUBTOTAL, piqueoConfirm.getSubtotal());

        long row = sqLiteDatabase.insert(PiqueoDBContract.PiqueoConfirm.TABLE_NAME, null, contentValues);
        return row;
    }

    @Override
    public boolean piqueoConfirmDelete(PiqueoConfirm piqueoConfirm) {

        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getWritableDatabase();
        return sqLiteDatabase.delete(PiqueoDBContract.PiqueoConfirm.TABLE_NAME, PiqueoDBContract.PiqueoConfirm.COLUMN_ID + "=" + piqueoConfirm.getId(), null) > 0;

    }
}
