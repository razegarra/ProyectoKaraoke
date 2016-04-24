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

import com.example.android.proyectokaraoke.Entity.Musica;
import com.example.android.proyectokaraoke.MusicaActivity;
import com.example.android.proyectokaraoke.R;


import java.util.List;


public class AdapterRecyclerMusicaCustom extends RecyclerView.Adapter<AdapterRecyclerMusicaCustom.ViewHolder> implements View.OnClickListener {
    Context context;
    List<Musica> listaMusica;

    public static final int LISTA = 0;
    public static final int CATEGORIA = 1;
    private View.OnClickListener listener;



    public AdapterRecyclerMusicaCustom(Context context, List<Musica> listaMusica) {
        this.context = context;
        this.listaMusica = listaMusica;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (viewType == LISTA) {
            v = LayoutInflater.from(context).
                    inflate(R.layout.list_row_musica, null);
            v.setOnClickListener(this);
            return new CustomViewHolder(v);
        }

        return null;
    }



    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Musica musica = listaMusica.get(position);
        if (viewHolder.getItemViewType() == LISTA) {
            CustomViewHolder holder = (CustomViewHolder) viewHolder;
            holder.txtTitulo.setText(musica.getTitulo());
            holder.txtCantante.setText(musica.getCantante());

        }
        Log.d("AppRecycler", "pos " + position);

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
        }
    }
    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }

    public class CustomViewHolder extends ViewHolder  { //implements View.OnClickListener
        private TextView txtTitulo;
        private TextView txtCantante;


        public CustomViewHolder(View view) {
            super(view);

            this.txtTitulo = (TextView) view.findViewById(R.id.titulo);
            this.txtCantante = (TextView) view.findViewById(R.id.cantante);


            //imgCatalogoPiqueo.setOnClickListener(this);
            //view.setOnClickListener(this);
        }


       /* @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            CatalogoPiqueo catalogoPiqueo = listaPiqueo.get(position);
            //PiqueoCatalogoActivity.añadir();
            Snackbar.make(v, "CatalogoPiqueo Seleccionado: " + catalogoPiqueo.getTitulo(), Snackbar.LENGTH_LONG).show();
        }*/
    }


    public class CatalogoViewHolder extends ViewHolder {
        private TextView txtTitulo;

        public CatalogoViewHolder(View view) {
            super(view);
            this.txtTitulo = (TextView) view.findViewById(R.id.title);
        }
    }


    @Override
    public int getItemCount() {
        return null == listaMusica ? 0 : listaMusica.size();
    }

  /*  @Override
    public int getItemViewType(int position) {
        return listaPiqueo.get(position).isTipo() ? 1 : 0;
    }*/
}


       /* @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            CatalogoPiqueo catalogoPiqueo = listaPiqueo.get(position);
            //PiqueoCatalogoActivity.añadir();
            Snackbar.make(v, "CatalogoPiqueo Seleccionado: " + catalogoPiqueo.getTitulo(), Snackbar.LENGTH_LONG).show();
        }*/




   /* public AdapterRecyclerMusicaCustom(Context context, int resource, List<Musica> listaMusicaData) {
        super(context, resource);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Musica musica = (Musica) getItem(position);
        View view = LayoutInflater.from(getContext()).
                inflate(R.layout.list_row_musica, null);


        TextView txtTitulo = (TextView) view.findViewById(R.id.titulo);
        TextView txtCantante = (TextView) view.findViewById(R.id.cantante);

        txtTitulo.setText(musica.getTitulo());
        txtCantante.setText(musica.getCantante());
        return view;
    }

}*/


































/*
public class AdapterRecyclerMusicaCustom  extends  RecyclerView.Adapter<AdapterRecyclerMusicaCustom.ViewHolder> implements View.OnClickListener{
    Context context;
    List<Musica> listaMusica;
    public static final int LISTA = 0;
    private View.OnClickListener listener;

    public AdapterRecyclerMusicaCustom(Context context, List<Musica> listaMusica) {
        this.context = context;
        this.listaMusica = listaMusica;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (viewType == LISTA) {
            v = LayoutInflater.from(context).
                    inflate(R.layout.list_row_musica, null);
            v.setOnClickListener(this);
            return new CustomViewHolder(v);
        }

    }

    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        Musica musica = listaMusica.get(position);

        if (viewHolder.getItemViewType() == LISTA) {
            CustomViewHolder holder = (CustomViewHolder) viewHolder;
            holder.Titulo.setText(musica.getTitulo());
            holder.txtDescripcion.setText(catalogoPiqueo.getDescripcion());
            holder.txtPrecio.setText(catalogoPiqueo.getPrecio());
        } else {
            CatalogoViewHolder holder = (CatalogoViewHolder) viewHolder;
            holder.txtTitulo.setText(catalogoPiqueo.getTitulo());
        }

        Log.d("AppRecycler", "pos " + position);
    }


    @Override
    public void onClick(View v) {

    }
}
*/