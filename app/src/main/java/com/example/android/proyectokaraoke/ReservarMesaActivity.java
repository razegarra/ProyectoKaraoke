package com.example.android.proyectokaraoke;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.proyectokaraoke.Data.Dao.ReservaDao;
import com.example.android.proyectokaraoke.Data.SQLite.ReservaSQLite;
import com.example.android.proyectokaraoke.Entity.Reserva;

import java.util.Date;

public class ReservarMesaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar_mesa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    public void enviar(View view) {
        ReservaDao reservaDao = new ReservaSQLite(this);
        Reserva reserva = new Reserva();

        EditText dni = (EditText)  findViewById(R.id.editTextDni);
        EditText nombres = (EditText)  findViewById(R.id.editTextNombres);
        EditText apellidos = (EditText)  findViewById(R.id.editTextApellidos);
        EditText telefono = (EditText)  findViewById(R.id.editTextTelefono);

        reserva.setDni(dni.getText().toString());
        reserva.setNombre(nombres.getText().toString());
        reserva.setApellido(apellidos.getText().toString());
        reserva.setTelefono(telefono.getText().toString());
        reserva.setFecha(new Date());

        reservaDao.catalogoInsert(reserva);

        Toast.makeText(this,"Reserva enviada, se le enviará un sms confirmando su reserva...",Toast.LENGTH_SHORT).show();
        onBackPressed();

    }
}
