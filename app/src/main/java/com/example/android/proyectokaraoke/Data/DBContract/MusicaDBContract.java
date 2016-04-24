package com.example.android.proyectokaraoke.Data.DBContract;

import android.provider.BaseColumns;

/**
 * Created by USUARIO1 on 23/04/2016.
 */
public class MusicaDBContract {

    public static final class Musica implements BaseColumns {
        public static final String TABLE_NAME = "musica";
        public static final String COLUMN_TITULO = "titulo";
        public static final String COLUMN_CANTANTE = "cantante";
        public static final String COLUMN_GENERO = "genero";
    }

    public static final class MusicaFavorita implements BaseColumns {
        public static final String TABLE_NAME = "musicafavorita";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_TITULO = "titulo";
        public static final String COLUMN_CANTANTE = "cantante";
        public static final String COLUMN_GENERO = "genero";
    }

    public static final class MusicaEnviada implements BaseColumns {
        public static final String TABLE_NAME = "musicaenviada";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_TITULO = "titulo";
        public static final String COLUMN_CANTANTE = "cantante";
        public static final String COLUMN_GENERO = "genero";
    }

}
