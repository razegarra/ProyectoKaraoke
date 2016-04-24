package com.example.android.proyectokaraoke.Data.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.proyectokaraoke.Data.Dao.PiqueoConfirmDao;
import com.example.android.proyectokaraoke.Data.Helper.MySqlOpenHelper;
import com.example.android.proyectokaraoke.Entity.PiqueoConfirm;

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

    }

    @Override
    public List<PiqueoConfirm> piqueoConfirmLista() {
        return null;
    }

    @Override
    public int piqueoConfirmInsert(PiqueoConfirm piqueoConfirm) {
        return 0;
    }
}
