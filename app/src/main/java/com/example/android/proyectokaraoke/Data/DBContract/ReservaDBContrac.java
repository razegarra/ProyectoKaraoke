package com.example.android.proyectokaraoke.Data.DBContract;

import android.provider.BaseColumns;

/**
 * Created by USUARIO1 on 23/04/2016.
 */
public class ReservaDBContrac {

    public static final class Reserva implements BaseColumns {
        public static final String TABLE_NAME = "reserva";
        public static final String COLUMN_DNI = "dni";
        public static final String COLUMN_NOMBRE = "nombre";
        public static final String COLUMN_APELLIDO = "apellido";
        public static final String COLUMN_TELEFONO = "telefono";
        public static final String COLUMN_FECHA = "fecha";
    }
}
