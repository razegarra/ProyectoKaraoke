package com.example.android.proyectokaraoke.Data.DBContract;

import android.provider.BaseColumns;

/**
 * Created by USUARIO1 on 22/04/2016.
 */
public class CatPiqueoDBContract {

    public static final class CatPiqueoEntry implements BaseColumns {
        public static final String TABLE_NAME = "catalogopiqueo";
        public static final String COLUMN_TITULO = "titulo";
        public static final String COLUMN_DESCRIPCION = "descripcion";
        public static final String COLUMN_PRECIO = "precio";
        public static final String COLUMN_TIPO = "tipo";
        public static final String COLUMN_IMAGEN = "imagen";
    }

}
