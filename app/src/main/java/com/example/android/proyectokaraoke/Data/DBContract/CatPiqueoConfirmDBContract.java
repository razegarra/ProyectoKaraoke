package com.example.android.proyectokaraoke.Data.DBContract;

import android.provider.BaseColumns;

/**
 * Created by USUARIO1 on 22/04/2016.
 */
public class CatPiqueoConfirmDBContract {

    public static final class CatPiqueoConfirmEntry implements BaseColumns {
        public static final String TABLE_NAME = "catalogopiqueoconfirm";
        public static final String COLUMN_TITULO = "titulo";
        public static final String COLUMN_DESCRIPCION = "descripcion";
        public static final String COLUMN_PRECIO = "precio";
        public static final String COLUMN_CANTIDAD = "cantidad";
        public static final String COLUMN_TIPO = "tipo";
        public static final String COLUMN_SUBTOTAL = "subtotal";

    }
}
