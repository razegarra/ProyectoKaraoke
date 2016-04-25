package com.example.android.proyectokaraoke.Data.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.proyectokaraoke.Data.DBContract.PiqueoDBContract;
import com.example.android.proyectokaraoke.Data.Dao.PiqueoPedidoDao;
import com.example.android.proyectokaraoke.Data.Helper.MySqlOpenHelper;
import com.example.android.proyectokaraoke.Entity.PiqueoPedido;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USUARIO1 on 24/04/2016.
 */
public class PiqueoPedidoSQLite implements PiqueoPedidoDao {

    MySqlOpenHelper mySqlOpenHelper;

    public PiqueoPedidoSQLite(Context context) {
        mySqlOpenHelper = new MySqlOpenHelper(context);
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getWritableDatabase();
    }

    @Override
    public void piqueoPedidoRead(PiqueoPedido piqueoPedido) {
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(PiqueoDBContract.PiqueoPedido.TABLE_NAME, null,
                PiqueoDBContract.PiqueoPedido.COLUMN_ID + "=?", new String[]{"" + piqueoPedido.getId()}, null, null, null);

        cursor.moveToFirst();
        piqueoPedido.setTitulo(
                cursor.getString(
                        cursor.getColumnIndex(
                                PiqueoDBContract.Piqueo.COLUMN_TITULO)));
        piqueoPedido.setDescripcion(cursor.getString(cursor.getColumnIndex(PiqueoDBContract.PiqueoPedido.COLUMN_DESCRIPCION)));
        piqueoPedido.setPrecio(cursor.getString(cursor.getColumnIndex(PiqueoDBContract.PiqueoPedido.COLUMN_PRECIO)));
        piqueoPedido.setCantidad(cursor.getDouble(cursor.getColumnIndex(PiqueoDBContract.PiqueoPedido.COLUMN_CANTIDAD)));
        piqueoPedido.setSubtotal(cursor.getDouble(cursor.getColumnIndex(PiqueoDBContract.PiqueoPedido.COLUMN_SUBTOTAL)));
        sqLiteDatabase.close();
    }

    @Override
    public List<PiqueoPedido> piqueoPedidoLista() {

        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(PiqueoDBContract.PiqueoPedido.TABLE_NAME, null, null, null, null, null, null);
        List<PiqueoPedido> piqueoPedidoLista = new ArrayList<>();
        PiqueoPedido piqueoPedido;

        cursor.moveToFirst();
        do {
            piqueoPedido = new PiqueoPedido();
            piqueoPedido.setId(cursor.getLong(cursor.getColumnIndex(PiqueoDBContract.PiqueoPedido.COLUMN_ID)));
            piqueoPedido.setTitulo(cursor.getString(cursor.getColumnIndex(PiqueoDBContract.PiqueoPedido.COLUMN_TITULO)));
            piqueoPedido.setDescripcion(cursor.getString(cursor.getColumnIndex(PiqueoDBContract.PiqueoPedido.COLUMN_DESCRIPCION)));
            piqueoPedido.setPrecio(cursor.getString(cursor.getColumnIndex(PiqueoDBContract.PiqueoPedido.COLUMN_PRECIO)));
            piqueoPedido.setCantidad(cursor.getDouble(cursor.getColumnIndex(PiqueoDBContract.PiqueoPedido.COLUMN_CANTIDAD)));
            piqueoPedido.setSubtotal(cursor.getDouble(cursor.getColumnIndex(PiqueoDBContract.PiqueoPedido.COLUMN_SUBTOTAL)));
            piqueoPedidoLista.add(piqueoPedido);
        } while (cursor.moveToNext());

        sqLiteDatabase.close();

        return piqueoPedidoLista;

    }

    @Override
    public long piqueoPedidoInsert(PiqueoPedido piqueoPedido) {

        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PiqueoDBContract.PiqueoPedido.COLUMN_ID, piqueoPedido.getId());
        contentValues.put(PiqueoDBContract.PiqueoPedido.COLUMN_TITULO, piqueoPedido.getTitulo());
        contentValues.put(PiqueoDBContract.PiqueoPedido.COLUMN_DESCRIPCION, piqueoPedido.getDescripcion());
        contentValues.put(PiqueoDBContract.PiqueoPedido.COLUMN_PRECIO, piqueoPedido.getPrecio());
        contentValues.put(PiqueoDBContract.PiqueoPedido.COLUMN_CANTIDAD, piqueoPedido.getCantidad());
        contentValues.put(PiqueoDBContract.PiqueoPedido.COLUMN_SUBTOTAL, piqueoPedido.getSubtotal());

        long row = sqLiteDatabase.insert(PiqueoDBContract.PiqueoPedido.TABLE_NAME, null, contentValues);
        return row;

    }

}
