package com.example.android.proyectokaraoke.Util;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.proyectokaraoke.Entity.CatalogoPiqueo;
import com.example.android.proyectokaraoke.R;


import java.util.List;

/**
 * Created by USUARIO1 on 19/03/2016.
 */
public class AdapterRecyclerPiqueoCustom extends RecyclerView.Adapter<AdapterRecyclerPiqueoCustom.CustomViewHolder> {
    Context context;  List<CatalogoPiqueo> listaPiqueo;

    public AdapterRecyclerPiqueoCustom(Context context, List<CatalogoPiqueo> listaPiqueo) {
        this.context = context;
        this.listaPiqueo=listaPiqueo;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).
                inflate(R.layout.list_row_piqueo, null);
        CustomViewHolder customViewHolder = new CustomViewHolder(view);
        Log.d("AppRecycler-Create", "create");
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder viewHolder, int position) {
        CatalogoPiqueo catalogoPiqueo = listaPiqueo.get(position);
        viewHolder.imgImagen.setImageResource(catalogoPiqueo.getImagen());
        viewHolder.txtTitulo.setText(catalogoPiqueo.getTitulo());
        viewHolder.txtDescripcion.setText(catalogoPiqueo.getDescripcion());
        viewHolder.txtPrecio.setText(catalogoPiqueo.getPrecio());
        Log.d("AppRecycler", "pos " + position);
    }
    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imgImagen;
        private TextView txtTitulo;
        private TextView txtDescripcion;
        private TextView txtPrecio;

        public CustomViewHolder(View view) {
            super(view);
            this.imgImagen = (ImageView) view.findViewById(R.id.imgcomida);
            this.txtTitulo = (TextView) view.findViewById(R.id.title);
            this.txtDescripcion = (TextView) view.findViewById(R.id.descripcion);
            this.txtPrecio = (TextView) view.findViewById(R.id.precio);

            //imgCatalogoPiqueo.setOnClickListener(this);
            view.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            CatalogoPiqueo catalogoPiqueo = listaPiqueo.get(position);
            Snackbar.make(v, "CatalogoPiqueo Seleccionado: " + catalogoPiqueo.getTitulo(), Snackbar.LENGTH_LONG).show();
        }
    }
    @Override
    public int getItemCount() {
        return null==listaPiqueo? 0: listaPiqueo.size();
    }

}
