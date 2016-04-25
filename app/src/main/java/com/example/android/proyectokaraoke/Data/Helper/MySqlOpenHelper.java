package com.example.android.proyectokaraoke.Data.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.proyectokaraoke.Data.DBContract.MusicaDBContract;
import com.example.android.proyectokaraoke.Data.DBContract.PiqueoDBContract;
import com.example.android.proyectokaraoke.Data.Dao.PiqueoDao;
import com.example.android.proyectokaraoke.Data.InformacionBD;
import com.example.android.proyectokaraoke.Data.SQLite.PiqueoSQLite;
import com.example.android.proyectokaraoke.Entity.Musica;
import com.example.android.proyectokaraoke.Entity.Piqueo;

import java.util.List;

/**
 * Created by USUARIO1 on 22/04/2016.
 */
public class MySqlOpenHelper extends SQLiteOpenHelper {


    private static final String dbname = "karaoke.db";
    Context context;
    private static int versionDB = 1;

    public MySqlOpenHelper(Context context) {
        super(context, dbname, null, versionDB);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql ="CREATE TABLE "+ PiqueoDBContract.Piqueo.TABLE_NAME+" ("+
                PiqueoDBContract.Piqueo._ID + " INTEGER PRIMARY KEY, " +
                PiqueoDBContract.Piqueo.COLUMN_TITULO + " TEXT NOT NULL, " +
                PiqueoDBContract.Piqueo.COLUMN_DESCRIPCION + " TEXT NOT NULL, " +
                PiqueoDBContract.Piqueo.COLUMN_PRECIO + " DOUBLE NOT NULL, " +
                PiqueoDBContract.Piqueo.COLUMN_TIPO + " INTEGER NOT NULL, " +
                PiqueoDBContract.Piqueo.COLUMN_IMAGEN + " TEXT) ";
        db.execSQL(sql);

        sql ="CREATE TABLE "+ PiqueoDBContract.PiqueoConfirm.TABLE_NAME+" ("+
                PiqueoDBContract.PiqueoConfirm.COLUMN_ID+ " INTEGER NOT NULL, " +
                PiqueoDBContract.PiqueoConfirm.COLUMN_TITULO + " TEXT NOT NULL, " +
                PiqueoDBContract.PiqueoConfirm.COLUMN_DESCRIPCION + " TEXT NOT NULL, " +
                PiqueoDBContract.PiqueoConfirm.COLUMN_PRECIO + " DOUBLE NOT NULL, " +
                PiqueoDBContract.PiqueoConfirm.COLUMN_CANTIDAD + " DOUBLE NOT NULL, " +
                PiqueoDBContract.PiqueoConfirm.COLUMN_SUBTOTAL + " DOUBLE NOT NULL) ";
        db.execSQL(sql);

        sql ="CREATE TABLE "+ PiqueoDBContract.PiqueoPedido.TABLE_NAME+" ("+
                PiqueoDBContract.PiqueoPedido.COLUMN_ID+ " INTEGER NOT NULL, " +
                PiqueoDBContract.PiqueoPedido.COLUMN_TITULO + " TEXT NOT NULL, " +
                PiqueoDBContract.PiqueoPedido.COLUMN_DESCRIPCION + " TEXT NOT NULL, " +
                PiqueoDBContract.PiqueoPedido.COLUMN_PRECIO + " DOUBLE NOT NULL, " +
                PiqueoDBContract.PiqueoPedido.COLUMN_CANTIDAD + " DOUBLE NOT NULL, " +
                PiqueoDBContract.PiqueoPedido.COLUMN_SUBTOTAL + " DOUBLE NOT NULL) ";
        db.execSQL(sql);

        sql ="CREATE TABLE "+ MusicaDBContract.Musica.TABLE_NAME+" ("+
                MusicaDBContract.Musica._ID + " INTEGER PRIMARY KEY, " +
                MusicaDBContract.Musica.COLUMN_TITULO + " TEXT NOT NULL, " +
                MusicaDBContract.Musica.COLUMN_CANTANTE + " TEXT NOT NULL, " +
                MusicaDBContract.Musica.COLUMN_GENERO + " TEXT NOT NULL) ";
        db.execSQL(sql);

        sql ="CREATE TABLE "+ MusicaDBContract.MusicaFavorita.TABLE_NAME+" ("+
                MusicaDBContract.MusicaFavorita.COLUMN_ID + " INTEGER, " +
                MusicaDBContract.MusicaFavorita.COLUMN_TITULO + " TEXT NOT NULL, " +
                MusicaDBContract.MusicaFavorita.COLUMN_CANTANTE + " TEXT NOT NULL, " +
                MusicaDBContract.MusicaFavorita.COLUMN_GENERO + " TEXT NOT NULL) ";
        db.execSQL(sql);

        sql ="CREATE TABLE "+ MusicaDBContract.MusicaEnviada.TABLE_NAME+" ("+
                MusicaDBContract.MusicaEnviada.COLUMN_ID + " INTEGER, " +
                MusicaDBContract.MusicaEnviada.COLUMN_TITULO + " TEXT NOT NULL, " +
                MusicaDBContract.MusicaEnviada.COLUMN_CANTANTE + " TEXT NOT NULL, " +
                MusicaDBContract.MusicaEnviada.COLUMN_GENERO + " TEXT NOT NULL) ";
        db.execSQL(sql);

        sql ="CREATE UNIQUE INDEX indexmusica ON musica (_id ASC)";
        db.execSQL(sql);

        llenadoPiqueo(db);
        llenadoMusica(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "DROP TABLE IF EXISTS " + PiqueoDBContract.PiqueoConfirm.TABLE_NAME);
        db.execSQL( "DROP TABLE IF EXISTS " + PiqueoDBContract.Piqueo.TABLE_NAME);
        db.execSQL( "DROP INDEX indexmusica");

        onCreate(db);
    }

    private void llenadoPiqueo(SQLiteDatabase db){
        String sql;
        List<Piqueo> listaPiqueo = InformacionBD.listaPiqueo();
        for (int i = 0; i < listaPiqueo.size(); i++) {
            sql = "INSERT INTO " + PiqueoDBContract.Piqueo.TABLE_NAME + " ("+
                    PiqueoDBContract.Piqueo.COLUMN_TITULO + ", " +
                    PiqueoDBContract.Piqueo.COLUMN_DESCRIPCION + ", " +
                    PiqueoDBContract.Piqueo.COLUMN_PRECIO + ", " +
                    PiqueoDBContract.Piqueo.COLUMN_TIPO + ", " +
                    PiqueoDBContract.Piqueo.COLUMN_IMAGEN + ") VALUES ('"+
                    listaPiqueo.get(i).getTitulo()+ "', '" +
                    listaPiqueo.get(i).getDescripcion()+ "', '" +
                    listaPiqueo.get(i).getPrecio()+ "', " +
                    (listaPiqueo.get(i).isTipo()?1:0)+ ", '" +
                    listaPiqueo.get(i).getImagen()+"')";
            db.execSQL(sql);
        }
    }

    private void llenadoMusica(SQLiteDatabase db){
        String sql;
        List<Musica> listaMusica = InformacionBD.listaMusica();
        for (int i = 0; i < listaMusica.size(); i++) {
            sql = "INSERT INTO " + MusicaDBContract.Musica.TABLE_NAME + " ("+
                    MusicaDBContract.Musica.COLUMN_TITULO + ", " +
                    MusicaDBContract.Musica.COLUMN_CANTANTE + ", " +
                    MusicaDBContract.Musica.COLUMN_GENERO + ") VALUES ('"+
                    listaMusica.get(i).getTitulo()+ "', '" +
                    listaMusica.get(i).getCantante()+ "', '" +
                    listaMusica.get(i).getGenero()+ "')";
            db.execSQL(sql);
        }
    }

}
