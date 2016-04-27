package com.example.android.proyectokaraoke;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.proyectokaraoke.Data.Dao.PiqueoConfirmDao;
import com.example.android.proyectokaraoke.Data.Dao.PiqueoDao;
import com.example.android.proyectokaraoke.Data.SQLite.PiqueoConfirmSQLite;
import com.example.android.proyectokaraoke.Data.SQLite.PiqueoSQLite;
import com.example.android.proyectokaraoke.Entity.Piqueo;
import com.example.android.proyectokaraoke.Entity.PiqueoConfirm;
import com.example.android.proyectokaraoke.Util.AdapterRecyclerPiqueoCustom;
import com.example.android.proyectokaraoke.Util.UtilPiqueoBadge;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

public class PiqueoCatalogoActivity extends AppCompatActivity {


    private int mNotificationsCount = 0;
    private double precio;

    private final Context context = this;
    private List<Piqueo> piqueoLista;
    private Piqueo piqueoSeleccionado;
    private RecyclerView recyclerView;
    private TextView texttotal;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piqueo_catalogo);

        //Toolbar Config
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Catálogo de piqueos");
        toolbar.setSubtitle("Proyecto Karaoke");
        toolbar.setLogo(R.drawable.icon_dialog);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //Obtención de la lista de piqueos
        PiqueoDao piqueoDAO = new PiqueoSQLite(this);
        piqueoLista = piqueoDAO.piqueoLista();

        //RecyclerView Config
        recyclerView = (RecyclerView) findViewById(R.id.listapiqueo);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdapterRecyclerPiqueoCustom adapter = new AdapterRecyclerPiqueoCustom(this,piqueoLista);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llamarDialogo(recyclerView.getChildAdapterPosition(v));
            }
        });
        recyclerView.setAdapter(adapter);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /*private CatalogoPiqueo itemCatalogo(int index) {
        return llenarLista().get(index);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_piqueo, menu);
        MenuItem item = menu.findItem(R.id.action_cart);
        LayerDrawable icon = (LayerDrawable) item.getIcon();
        UtilPiqueoBadge.setBadgeCount(this, icon, mNotificationsCount);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_cart) {


            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateNotificationsBadge(int count) {
        mNotificationsCount = count;
        invalidateOptionsMenu();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "PiqueoCatalogo Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.android.proyectokaraoke/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "PiqueoCatalogo Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.android.proyectokaraoke/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }


    public void llamarDialogo(int prog) {

        piqueoSeleccionado = piqueoLista.get(prog);

        // custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_piqueo_catalogo);
        //dialog.

        // set the custom dialog components - text, image and button
        TextView textproducto = (TextView) dialog.findViewById(R.id.textproducto);
        textproducto.setText(piqueoSeleccionado.getTitulo());
        texttotal = (TextView) dialog.findViewById(R.id.texttotal);
        texttotal.setText(piqueoSeleccionado.getPrecio());
        ImageView image = (ImageView) dialog.findViewById(R.id.imgcomida);
        image.setImageResource(getResources().getIdentifier(piqueoSeleccionado.getImagen(), "drawable", context.getPackageName()));
        precio = Double.parseDouble(piqueoSeleccionado.getPrecio().replace("S/.", "").trim());

        Button dialogButtonMas = (Button) dialog.findViewById(R.id.buttonMas);
        Button dialogButtonMenos = (Button) dialog.findViewById(R.id.buttonMenos);
        Button dialogButtonCancelar = (Button) dialog.findViewById(R.id.buttonCancelar);
        Button dialogButtonGrabar = (Button) dialog.findViewById(R.id.buttonGrabar);

        // if button is clicked, close the custom dialog
        dialogButtonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialogButtonMas.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                EditText cantidad = (EditText) dialog.findViewById(R.id.editTextCantidad);

                int n = Integer.parseInt(cantidad.getText().toString());
                if (n < 20) {
                    n = n + 1;
                    cantidad.setText("" + n);
                    texttotal.setText("S/. " + precio * ((double) n));
                }
            }
        });

        dialogButtonMenos.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                EditText cantidad = (EditText) dialog.findViewById(R.id.editTextCantidad);
                int n = Integer.parseInt(cantidad.getText().toString());
                if (n > 1) {
                    n = n - 1;
                    cantidad.setText("" + n);
                    texttotal.setText("S/. " + precio * ((double) n));
                }
            }
        });

        dialogButtonGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText cantidad = (EditText) dialog.findViewById(R.id.editTextCantidad);
                int n = Integer.parseInt(cantidad.getText().toString());
                PiqueoConfirmDao piqueoConfirmDAO = new PiqueoConfirmSQLite(context);
                piqueoConfirmDAO.piqueoConfirmInsert(new PiqueoConfirm(
                        piqueoSeleccionado.getId(),
                        piqueoSeleccionado.getTitulo(),
                        piqueoSeleccionado.getDescripcion(),
                        piqueoSeleccionado.getPrecio(),
                        n,
                        precio * ((double) n)));
                updateNotificationsBadge(mNotificationsCount + 1);
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
