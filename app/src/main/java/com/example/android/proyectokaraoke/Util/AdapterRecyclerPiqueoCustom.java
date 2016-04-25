package com.example.android.proyectokaraoke.Util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.proyectokaraoke.Entity.Piqueo;
import com.example.android.proyectokaraoke.R;


import java.util.List;

/**
 * Created by Richard Zegarra on 19/03/2016.
 */
public class AdapterRecyclerPiqueoCustom extends RecyclerView.Adapter<AdapterRecyclerPiqueoCustom.ViewHolder> implements View.OnClickListener   {
    Context context;
    List<Piqueo> piqueoLista;

    public static final int LISTA = 0;
    public static final int CATEGORIA = 1;
    private View.OnClickListener listener;

    public AdapterRecyclerPiqueoCustom(Context context, List<Piqueo> piqueoLista) {
        this.context = context;
        this.piqueoLista = piqueoLista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (viewType == LISTA) {
            v = LayoutInflater.from(context).
                    inflate(R.layout.list_row_piqueo, null);
            v.setOnClickListener(this);
            return new CustomViewHolder(v);
        } else {
            v = LayoutInflater.from(context).inflate(R.layout.list_row_piqueo_cat, null);
            return new CatalogoViewHolder(v);
        }

    }

    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        Piqueo piqueo = piqueoLista.get(position);

        if (viewHolder.getItemViewType() == LISTA) {
            CustomViewHolder holder = (CustomViewHolder) viewHolder;
            holder.imgImagen.setImageResource(context.getResources().getIdentifier(piqueo.getImagen(), "drawable", context.getPackageName()));
            holder.txtTitulo.setText(piqueo.getTitulo());
            holder.txtDescripcion.setText(piqueo.getDescripcion());
            holder.txtPrecio.setText(piqueo.getPrecio());
        } else {
            CatalogoViewHolder holder = (CatalogoViewHolder) viewHolder;
            holder.txtTitulo.setText(piqueo.getTitulo());
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
        }

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
        return null == piqueoLista ? 0 : piqueoLista.size();
    }

    @Override
    public int getItemViewType(int position) {
        return piqueoLista.get(position).isTipo() ? 1 : 0;
    }
}
