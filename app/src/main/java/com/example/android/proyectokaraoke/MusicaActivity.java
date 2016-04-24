package com.example.android.proyectokaraoke;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.LinearLayoutManager;


import java.util.ArrayList;
import java.util.List;



import com.example.android.proyectokaraoke.Entity.Musica;
import com.example.android.proyectokaraoke.Util.AdapterRecyclerMusicaCustom;

import java.util.ArrayList;
import java.util.List;

public class MusicaActivity extends AppCompatActivity {

    /*
       Declarar instancias globales
        */
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica_catalogo);

        recycler = (RecyclerView) findViewById(R.id.listamusica);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        AdapterRecyclerMusicaCustom adapter = new AdapterRecyclerMusicaCustom(this, llenarLista());
        recycler.setAdapter(adapter);
    }

    private Musica itemMusica(int index) {
        return llenarLista().get(index);
    }

    private List<Musica> llenarLista() {

        final String[] titulo = {"Angel de amor", "Labios compartidos", "Muella de san blas","Aqui","Snow","Otherside"};

        final String[] cantante = {"Mana", "Mana", "Mana","La ley","RHCP","RCHP"};

        List<Musica> listaData = new ArrayList<>();
        for (int i = 0; i < titulo.length; i++) {
            Musica musica = new Musica();
            musica.setTitulo(titulo[i]);
            musica.setCantante(cantante[i]);
            listaData.add(musica);
        }

        return listaData;

    }


}
    /*RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);


        //data
        final String[] titulo = {"Peru", "Bolivia", "Chile", "Argentina", "Estados Unidos"};
        final String[] cantante = {"Sur America", "Sur America", "Sur America", "Sur America", "Norte America"};

        List<Musica> listaMusicaData= new ArrayList<>();
        for (int i=0; i<titulo.length;i++){
            Musica musica= new Musica();
            musica.setTitulo(titulo[i]);
            musica.setCantante(cantante[i]);
            listaMusicaData.add(musica);
        }

        //adapter
        ListAdapter adapter = new AdapterRecyclerMusicaCustom
                (this, R.layout.list_row_musica,listaMusicaData);
        RecyclerView.Adapter adapter = new AdapterRecyclerMusicaCustom(this, listaPaisesData);
        recyclerView.setAdapter(adapter);

        //view
        ListView listMusica = (ListView) findViewById(R.id.listamusica);


        listMusica.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String musica= titulo[position];
                Toast.makeText(getApplicationContext(), "Musica seleccionada: " + titulo,
                        Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_musica, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}






*/


/*
public class MusicaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    Musica seleccionado;
   private final Context context = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);
        recyclerView = (RecyclerView) findViewById(R.id.listamusica);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        AdapterRecyclerPiqueoCustom adapter = new AdapterRecyclerPiqueoCustom(this, llenarLista());
        recyclerView.setAdapter(adapter);

    }
    /*private Musica itemCatalogo(int index){
        return llenarLista().get(index);
    }*/
/*
    private List<Musica> llenarLista() {

        final String[] titulo = {"Angel de Amor", "Muelle de San blas", "Amor clandestino", "Mariposa Traicionera", "Oye mi amor","Eres mi religion"};

        final String[] cantante = {"Mana", "Mana", "Mana","Mana","Mana"};


        List<Musica> listaData = new ArrayList<>();

        for (int i = 0; i < titulo.length; i++) {
            Musica musica = new Musica();
            musica.setTitulo(titulo[i]);
            musica.setCantante(cantante[i]);
        }

        return listaData;
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_musica, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
*/