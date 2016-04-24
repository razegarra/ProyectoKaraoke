package com.example.android.proyectokaraoke;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.proyectokaraoke.Entity.CatalogoPiqueo;
import com.example.android.proyectokaraoke.Entity.CatalogoPiqueoCompra;
import com.example.android.proyectokaraoke.Util.AdapterRecyclerPiqueoCustom;
import com.example.android.proyectokaraoke.Util.UtilPiqueoBadge;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class PiqueoCatalogoActivity extends AppCompatActivity {


    private int mNotificationsCount = 0;
    private List<CatalogoPiqueoCompra> compra;
    CatalogoPiqueo seleccionado;
    private RecyclerView recyclerView;
    private final Context context = this;
    private Button button;
    private TextView texttotal;
    private double precio;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piqueo_catalogo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Catálogo de piqueos");
        toolbar.setSubtitle("Proyecto Karaoke");
        toolbar.setLogo(R.drawable.icon_dialog);

        
        compra = new ArrayList<CatalogoPiqueoCompra>();
        recyclerView = (RecyclerView) findViewById(R.id.listapiqueo);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        AdapterRecyclerPiqueoCustom adapter = new AdapterRecyclerPiqueoCustom(this, llenarLista());

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

    private CatalogoPiqueo itemCatalogo(int index) {
        return llenarLista().get(index);
    }


    private List<CatalogoPiqueo> llenarLista() {

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

        seleccionado = itemCatalogo(prog);

        // custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_piqueo_catalogo);
        //dialog.

        // set the custom dialog components - text, image and button

        TextView textproducto = (TextView) dialog.findViewById(R.id.textproducto);
        textproducto.setText(seleccionado.getTitulo());
        texttotal = (TextView) dialog.findViewById(R.id.texttotal);
        texttotal.setText(seleccionado.getPrecio());
        ImageView image = (ImageView) dialog.findViewById(R.id.imgcomida);
        image.setImageResource(seleccionado.getImagen());
        precio = Double.parseDouble(seleccionado.getPrecio().replace("S/.", "").trim());

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
                compra.add(new CatalogoPiqueoCompra(seleccionado.getTitulo(), seleccionado.getDescripcion(), seleccionado.getPrecio(),
                        seleccionado.getImagen(), seleccionado.isTipo(), n, precio * ((double) n)));
                updateNotificationsBadge(mNotificationsCount + 1);
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
