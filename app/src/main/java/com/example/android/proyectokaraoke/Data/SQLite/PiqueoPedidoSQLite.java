package com.example.android.proyectokaraoke.Data.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.proyectokaraoke.Data.Dao.PiqueoPedidoDao;
import com.example.android.proyectokaraoke.Data.Helper.MySqlOpenHelper;
import com.example.android.proyectokaraoke.Entity.PiqueoPedido;

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
    public void catalogoRead(PiqueoPedido piqueoPedido) {

    }

    @Override
    public List<PiqueoPedido> catalogoLista() {
        return null;
    }

    @Override
    public int catalogoInsert(PiqueoPedido piqueoPedido) {
        return 0;
    }

    @Override
    public long catalogoDelete(PiqueoPedido piqueoPedido) {
        return 0;
    }
}
