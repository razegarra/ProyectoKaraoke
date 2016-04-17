package com.example.android.proyectokaraoke;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Bienvenida extends AppCompatActivity {
    private Button btnIngreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        btnIngreso = (Button) findViewById(R.id.btnIngreso);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View view){
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/


    }


    @Override
    protected void onResume() {
        super.onResume();
        //Evento click del boton mostrar el cual cargara la información en un toast
        btnIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Generando el pase de pantalla
                Intent intent = new Intent(Bienvenida.this, MenuPrincipal.class);

                //Ejecutamos el pase
                startActivity(intent);
            }
        });

    }
}
