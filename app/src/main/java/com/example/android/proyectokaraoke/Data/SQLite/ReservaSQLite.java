package com.example.android.proyectokaraoke.Data.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.proyectokaraoke.Data.Dao.ReservaDao;
import com.example.android.proyectokaraoke.Data.Helper.MySqlOpenHelper;
import com.example.android.proyectokaraoke.Entity.Reserva;

import java.util.List;

/**
 * Created by USUARIO1 on 23/04/2016.
 */
public class ReservaSQLite implements ReservaDao {

    MySqlOpenHelper mySqlOpenHelper;

    public ReservaSQLite(Context context) {
        mySqlOpenHelper = new MySqlOpenHelper(context);
        SQLiteDatabase sqLiteDatabase = mySqlOpenHelper.getWritableDatabase();
    }

    @Override
    public int catalogoInsert(Reserva reserva) {
        return 0;
    }
}
