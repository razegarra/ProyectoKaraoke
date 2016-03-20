package com.example.android.proyectokaraoke.Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.proyectokaraoke.Entity.CatalogoPiqueo;
import com.example.android.proyectokaraoke.R;


import java.util.List;

/**
 * Created by USUARIO1 on 19/03/2016.
 */
public class AdapterRecyclerPiqueoCustom extends ArrayAdapter {

    public AdapterRecyclerPiqueoCustom(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        CatalogoPiqueo catalogoPiqueo = (CatalogoPiqueo) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.list_row_piqueo,null);

        ImageView imgComida = (ImageView) view.findViewById(R.id.imgcomida);
        TextView txtTitulo = (TextView) view.findViewById(R.id.title);
        TextView txtDescripcion = (TextView) view.findViewById(R.id.descripcion);
        TextView txtPrecio = (TextView) view.findViewById(R.id.precio);

        imgComida.setImageResource(catalogoPiqueo.getImagen());
        txtTitulo.setText(catalogoPiqueo.getTitulo());
        txtDescripcion.setText(catalogoPiqueo.getDescripcion());
        txtPrecio.setText(catalogoPiqueo.getPrecio());
        return view;
    }
}
