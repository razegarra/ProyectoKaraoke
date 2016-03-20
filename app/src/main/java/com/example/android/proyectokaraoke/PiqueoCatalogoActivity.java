package com.example.android.proyectokaraoke;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.android.proyectokaraoke.Entity.CatalogoPiqueo;
import com.example.android.proyectokaraoke.Util.AdapterRecyclerPiqueoCustom;

import java.util.ArrayList;
import java.util.List;

public class PiqueoCatalogoActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piqueo_catalogo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.listapiqueo);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.Adapter adapter= new AdapterRecyclerPiqueoCustom(this,llenarLista());
        recyclerView.setAdapter(adapter);

    }


    private List<CatalogoPiqueo> llenarLista(){

        final String[] titulo = {"P R O M O C I O N E S","Camarones al mojo de ajo", "Cocktail de langostinos", "Pulpo a la vinagreta", "CATALOGO KARAOKE","Almejas a la marinera",
                "Piqueo Marino Frío", "Piqueo Marino Caliente", "Piqueo de Tiraditos", "Piqueo rustico",
                "Piqueo criollo (para 2 personas)", "Brochetas de pescado"};

        final String[] descripcion = {"","camaron fresco en gotas de limón con mantequilla, sal y ajos", "langostinos en salsa inglesa con aguacates," +
                " limón, ketchup, mayonesa, acompañado de huevos duros y lechuca", "pulpo en aceite con cebolla, pimiento rojo y verde, vinagre y sal","",
                "Almejas frescas en ajo, cebolla, tomate, vino blanco, Aceite de oliva y pirmienta", "Ceviche de Curvina, Tiradito al Ají Amarillo, " +
                "Pulpo al Olivo, Causa Rellena de Camarones", "Conchitas ala Parmesana, Pulpo Anticuchado, Chicharrón de Calamar, Curvina al Panko",
                "Tiradito de Curvina, Tiradito al Ají Amarillo, Tiradito Nikkei, Tiradito al Maracuyá", "(Para 2 personas) Chicharron de pollo  + " +
                "alitas + tequeños + papas fritas", "Fuente con humita verde y tamal criollo hechos en casa; rocoto relleno a la arequipeña; papas " +
                "rellenas a la limeña; 3 anticuchos de corazón; 3 anticuchos de pollo; chicharrón de lechón; choclitos brujos; bolitas de yuca doradas " +
                "con salsas: huancaína; de ocopa; de huacatay; de rocotay y salsa criolla", "Pescado blanco con Cebolla, Pimiento rojo, Calabacín y Limón"};

        final String[] precio = {"","S/.23.99", "S/.35.99", "S/.39.99","", "S/.125.00", "S/.155.00", "S/.95.00", "S/.73.00", "S/.60.00", "S/.33.00", "S/.128.00"};

        final String[] imagenes = {"","p1", "p2", "p3","", "p4", "p5", "p6", "p7", "p8", "p9", "p10"};

        final boolean[] tipo = {true,false, false, false,true, false, false, false, false, false, false, false};

        List<CatalogoPiqueo> listaData = new ArrayList<>();

        for (int i = 0; i < titulo.length; i++) {
            CatalogoPiqueo catalogoPiqueo = new CatalogoPiqueo();
            catalogoPiqueo.setTitulo(titulo[i]);
            catalogoPiqueo.setDescripcion(descripcion[i]);
            catalogoPiqueo.setPrecio(precio[i]);
            catalogoPiqueo.setImagen(getResources().getIdentifier(imagenes[i], "drawable", getPackageName()));
            catalogoPiqueo.setTipo(tipo[i]);
            listaData.add(catalogoPiqueo);
        }

        return listaData;
    }

}
