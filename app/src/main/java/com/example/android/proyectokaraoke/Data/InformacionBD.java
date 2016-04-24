package com.example.android.proyectokaraoke.Data;

import android.content.Context;
import com.example.android.proyectokaraoke.Entity.Musica;
import com.example.android.proyectokaraoke.Entity.Piqueo;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USUARIO1 on 24/04/2016.
 */
public class InformacionBD {

    public static List<Musica> listaMusica(){

        final String[] titulo = {"50 Sombras de Austin","Amarte Es Hermoso","Andas En Mi Cabeza","Baby","Borro Cassette","Bronche de Oro","CicatrIIIces","Como Lo Hacia Yo",
                "Corazon Acelerao","Culpa Al Corazon","DEL Negociante","Desde Esa Noche","El Error","El Mentado","El Perdedor","El Perdon","Embriagame","En Esta No","Encantadora",
                "Espero Con Ansias","Fuiste Mia","Ginza","Hablemos","Hasta El Amanecer","Hasta Que Se Seque El Malecon","La Llamada de Mi Ex","La Ocasion","Me Empezo A Valer",
                "Nadie Como Tu","No Lo Hice Bien","No Soy Una De Esas","Not A Crime (No Es Ilegal)","Obsesionado","Pero Sin Enamorarse","Por Que Terminamos?","Prestamela A Mi",
                "Que Caro Estoy Pagando","Rumbo A Maza","Shalalala","Si No Es Contigo","Solo Con Verte","Solo Yo","Tan Facil","Tomen Nota","Traidora","Tu Ausencia","Una En Un Millon",
                "Vale La Pena","Ya Lo Supere","Ya Te Perdi La Fe","Yo Quisiera Entrar"};
        final String[] cantante = {"Arcangel & DJ Luian","Los Huracanes del Norte","Chino & Nacho Featuring Daddy Yankee","Jencarlos Featuring Lennox","Maluma",
                "La Trakalosa de Monterrey","Regulo Caro","Ken-Y & Nicky Jam","Wisin","Prince Royce","Los Plebes del Rancho de Ariel Camacho","Thalia Featuring Maluma",
                "Reykon","Los Plebes del Rancho de Ariel Camacho","Maluma","Nicky Jam & Enrique Iglesias","Zion & Lennox","Sin Bandera","Yandel","Remmy Valenzuela","Gerardo Ortiz",
                "J Balvin","Ariel Camacho y Los Plebes del Rancho","Nicky Jam","Jacob Forever","Chiquito Team Band",
                "DJ Luian & Mambo Kings Presentan: De La Ghetto Featuring Arcangel X Ozuna X Anuel","La Septima Banda","Banda Clave Nueva de Max Peraza",
                "Los Plebes del Rancho de Ariel Camacho","Jesse & Joy Featuring Alejandro Sanz","Play-N-Skillz x Daddy Yankee","Farruko","Jesus Ojeda y Sus Parientes",
                "Gerardo Ortiz","Calibre 50","Los Plebes del Rancho de Ariel Camacho","Los Titanes de Durango","Tito El Bambino","Banda El Recodo de Cruz Lizarraga",
                "Banda Sinaloense MS de Sergio Lizarraga","Sofia Reyes / Prince Royce","CNCO","Adriel Favela Featuring Los del Arroyo","Gente de Zona Featuring Marc Anthony",
                "Intocable","Alexis & Fido","Roberto Tapia","Los Plebes del Rancho de Ariel Camacho","La Arrolladora Banda el Limon de Rene Camacho","Ariel Camacho y Los Plebes del Rancho"};
        final String[] genero = {"Pop","Rock and Roll","Rock and Roll","Pop","Urban","Reguetón","Hip Hop","Reguetón","Blue","Blue","Hip Hop","Pop","Urban","Reguetón",
                "Reguetón","Blue","Urban","Hip Hop","Urban","Salsa","Rock and Roll","Rock and Roll","Reguetón","Blue","Rock and Roll","Pop","Blue","Urban","Urban","Blue",
                "Reguetón","Hip Hop","Blue","Salsa","Pop","Salsa","Hip Hop","Rock and Roll","Salsa","Salsa","Pop","Blue","Urban","Salsa","Hip Hop","Urban","Reguetón",
                "Hip Hop","Salsa","Rock and Roll","Rock and Roll"};
        Musica musica;

        List<Musica> listaData = new ArrayList<>();
        for (int i = 0; i < titulo.length; i++) {
            musica = new Musica();
            musica.setTitulo(titulo[i]);
            musica.setCantante(cantante[i]);
            musica.setGenero(genero[i]);
            listaData.add(musica);
        }
        return listaData;
    }

    public static List<Piqueo> listaPiqueo(Context context) {
        Piqueo piqueo;
        List<Piqueo> piqueoLista = new ArrayList<>();

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
            piqueo = new Piqueo();
            piqueo.setTitulo(titulo[i]);
            piqueo.setDescripcion(descripcion[i]);
            piqueo.setPrecio(precio[i]);
            piqueo.setImagen(imagenes[i]);
            piqueo.setTipo(tipo[i]);
            piqueoLista.add(piqueo);
        }
        return piqueoLista;
    }


}
