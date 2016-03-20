package com.example.android.proyectokaraoke;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MenuPrincipal extends AppCompatActivity {
private Button btnPiqueos ,btnCanciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btnPiqueos = (Button) findViewById(R.id.btnPiqueos);
        btnCanciones = (Button) findViewById(R.id.btnCanciones);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Evento click del boton mostrar el cual cargara la información en un toast
        btnPiqueos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnPiqueos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Generando el pase de pantalla
                Intent intent = new Intent(MenuPrincipal.this, PiqueoCatalogoActivity.class);
                Intent intent1 = new Intent(MenuPrincipal.this,ReservarMesaActivity.class);
                //Ejecutamos el pase
                startActivity(intent);
            }
        });

    }






}
