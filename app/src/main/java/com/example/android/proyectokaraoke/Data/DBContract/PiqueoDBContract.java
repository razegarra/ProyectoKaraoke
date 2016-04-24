package com.example.android.proyectokaraoke.Data.DBContract;

import android.provider.BaseColumns;

/**
 * Created by USUARIO1 on 22/04/2016.
 */
public class PiqueoDBContract {

    public static final class Piqueo implements BaseColumns {
        public static final String TABLE_NAME = "piqueo";
        public static final String COLUMN_TITULO = "titulo";
        public static final String COLUMN_DESCRIPCION = "descripcion";
        public static final String COLUMN_PRECIO = "precio";
        public static final String COLUMN_TIPO = "tipo";
        public static final String COLUMN_IMAGEN = "imagen";
    }

    public static final class PiqueoConfirm implements BaseColumns {
        public static final String TABLE_NAME = "piqueoconfirm";
        public static final String COLUMN_TITULO = "titulo";
        public static final String COLUMN_DESCRIPCION = "descripcion";
        public static final String COLUMN_PRECIO = "precio";
        public static final String COLUMN_CANTIDAD = "cantidad";
        public static final String COLUMN_TIPO = "tipo";
        public static final String COLUMN_SUBTOTAL = "subtotal";

    }

    public static final class PiqueoPedido implements BaseColumns {
        public static final String TABLE_NAME = "piqueopedido";
        public static final String COLUMN_TITULO = "titulo";
        public static final String COLUMN_DESCRIPCION = "descripcion";
        public static final String COLUMN_PRECIO = "precio";
        public static final String COLUMN_CANTIDAD = "cantidad";
        public static final String COLUMN_TIPO = "tipo";
        public static final String COLUMN_SUBTOTAL = "subtotal";

    }
}
