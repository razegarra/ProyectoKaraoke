package com.example.android.proyectokaraoke.Data.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.proyectokaraoke.Data.DBContract.CatPiqueoConfirmDBContract;
import com.example.android.proyectokaraoke.Data.DBContract.CatPiqueoDBContract;
import com.example.android.proyectokaraoke.Data.Dao.CatPiqueoDao;
import com.example.android.proyectokaraoke.Data.SQLite.CatPiqueoSQLite;
import com.example.android.proyectokaraoke.Entity.CatalogoPiqueo;

import java.util.ArrayList;
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
        String sql ="CREATE TABLE "+ CatPiqueoConfirmDBContract.CatPiqueoConfirmEntry.TABLE_NAME+" ("+
                CatPiqueoConfirmDBContract.CatPiqueoConfirmEntry._ID + " INTEGER PRIMARY KEY, " +
                CatPiqueoConfirmDBContract.CatPiqueoConfirmEntry.COLUMN_TITULO + " TEXT NOT NULL, " +
                CatPiqueoConfirmDBContract.CatPiqueoConfirmEntry.COLUMN_DESCRIPCION + " TEXT NOT NULL, " +
                CatPiqueoConfirmDBContract.CatPiqueoConfirmEntry.COLUMN_PRECIO + " DOUBLE NOT NULL, " +
                CatPiqueoConfirmDBContract.CatPiqueoConfirmEntry.COLUMN_CANTIDAD + " DOUBLE NOT NULL, " +
                CatPiqueoConfirmDBContract.CatPiqueoConfirmEntry.COLUMN_TIPO + " INTEGER NOT NULL, " +
                CatPiqueoConfirmDBContract.CatPiqueoConfirmEntry.COLUMN_SUBTOTAL + " DOUBLE NOT NULL) ";
        db.execSQL(sql);

        sql ="CREATE TABLE "+ CatPiqueoDBContract.CatPiqueoEntry.TABLE_NAME+" ("+
                CatPiqueoDBContract.CatPiqueoEntry._ID + " INTEGER PRIMARY KEY, " +
                CatPiqueoDBContract.CatPiqueoEntry.COLUMN_TITULO + " TEXT NOT NULL, " +
                CatPiqueoDBContract.CatPiqueoEntry.COLUMN_DESCRIPCION + " TEXT NOT NULL, " +
                CatPiqueoDBContract.CatPiqueoEntry.COLUMN_PRECIO + " DOUBLE NOT NULL, " +
                CatPiqueoDBContract.CatPiqueoEntry.COLUMN_TIPO + " INTEGER NOT NULL, " +
                CatPiqueoDBContract.CatPiqueoEntry.COLUMN_IMAGEN + " BLOB) ";
        db.execSQL(sql);

        llenado(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "DROP TABLE IF EXISTS " + CatPiqueoConfirmDBContract.CatPiqueoConfirmEntry.TABLE_NAME);
        onCreate(db);
        db.execSQL( "DROP TABLE IF EXISTS " + CatPiqueoDBContract.CatPiqueoEntry.TABLE_NAME);
        onCreate(db);
    }

    private void llenado(SQLiteDatabase db){

        CatPiqueoDao catPiqueoDAO = new CatPiqueoSQLite(context);
        CatalogoPiqueo catalogoPiqueo;

        final String[] titulo = {"P R O M O C I O N E S", "Camarones al mojo de ajo", "Cocktail de langostinos", "Pulpo a la vinagreta", "CATALOGO KARAOKE", "Almejas a la marinera",
                "Piqueo Marino Frío", "Piqueo Marino Caliente", "Piqueo de Tiraditos", "Piqueo rustico",
                "Piqueo criollo (para 2 personas)", "Brochetas de pescado"};

        final String[] descripcion = {"", "camaron fresco en gotas de limón con mantequilla, sal y ajos", "langostinos en salsa inglesa con aguacates," +
                " limón, ketchup, mayonesa, acompañado de huevos duros y lechuca", "pulpo en aceite con cebolla, pimiento rojo y verde, vinagre y sal", "",
                "Almejas frescas en ajo, cebolla, tomate, vino blanco, Aceite de oliva y pirmienta", "Ceviche de Curvina, Tiradito al Ají Amarillo, " +
                "Pulpo al Olivo, Causa Rellena de Camarones", "Conchitas ala Parmesana, Pulpo Anticuchado, Chicharrón de Calamar, Curvina al Panko",
                "Tiradito de Curvina, Tiradito al Ají Amarillo, Tiradito Nikkei, Tiradito al Maracuyá", "(Para 2 personas) Chicharron de pollo  + " +
                "alitas + tequeños + papas fritas", "Fuente con humita verde y tamal criollo hechos en casa; rocoto relleno a la arequipeña; papas " +
                "rellenas a la limeña; 3 anticuchos de corazón; 3 anticuchos de pollo; chicharrón de lechón; choclitos brujos; bolitas de yuca doradas " +
                "con salsas: huancaína; de ocopa; de huacatay; de rocotay y salsa criolla", "Pescado blanco con Cebolla, Pimiento rojo, Calabacín y Limón"};

        final String[] precio = {"", "S/.23.99", "S/.35.99", "S/.39.99", "", "S/.125.00", "S/.155.00", "S/.95.00", "S/.73.00", "S/.60.00", "S/.33.00", "S/.128.00"};

        final String[] imagenes = {"", "p1", "p2", "p3", "", "p4", "p5", "p6", "p7", "p8", "p9", "p10"};

        final boolean[] tipo = {true, false, false, false, true, false, false, false, false, false, false, false};

        for (int i = 0; i < titulo.length; i++) {

            catalogoPiqueo = new CatalogoPiqueo();
            catalogoPiqueo.setTitulo(titulo[i]);
            catalogoPiqueo.setDescripcion(descripcion[i]);
            catalogoPiqueo.setPrecio(precio[i]);
            catalogoPiqueo.setImagen(context.getResources().getIdentifier(imagenes[i], "drawable", context.getPackageName()));
            catalogoPiqueo.setTipo(tipo[i]);
            catPiqueoDAO.catalogoInsert(catalogoPiqueo);

        }

    }

}
