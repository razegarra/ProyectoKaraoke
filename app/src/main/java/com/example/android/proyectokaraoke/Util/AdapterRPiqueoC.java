package com.example.android.proyectokaraoke.Util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.android.proyectokaraoke.Entity.PiqueoConfirm;
import com.example.android.proyectokaraoke.R;

import java.util.List;

/**
 * Created by Richard Zegarra on 19/03/2016.
 */
public class AdapterRPiqueoC extends RecyclerView.Adapter<AdapterRPiqueoC.ViewHolder> implements View.OnClickListener   {
    Context context;
    List<PiqueoConfirm> listaPiqueo;
    private View.OnClickListener listener;

    public AdapterRPiqueoC(Context context, List<PiqueoConfirm> listaPiqueo) {
        this.context = context;
        this.listaPiqueo = listaPiqueo;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
            v = LayoutInflater.from(context).inflate(R.layout.list_row_piqueo_confirm, null);
            v.setOnClickListener(this);
            return new CustomViewHolder(v);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        PiqueoConfirm catalogoPiqueo = listaPiqueo.get(position);
        CustomViewHolder holder = (CustomViewHolder) viewHolder;
        holder.txtTitulo.setText(catalogoPiqueo.getTitulo());
        holder.txtCantidad.setText(String.valueOf(catalogoPiqueo.getCantidad())+" und");
        holder.txtSubTotal.setText("S/." + String.valueOf(catalogoPiqueo.getSubtotal()));
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
        private TextView txtCantidad;
        private TextView txtSubTotal;

        public CustomViewHolder(View view) {
            super(view);
            this.txtTitulo = (TextView) view.findViewById(R.id.textproductoconfirm);
            this.txtCantidad = (TextView) view.findViewById(R.id.textcantidadconfirm);
            this.txtSubTotal = (TextView) view.findViewById(R.id.textprecioconfirm);

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
        return null == listaPiqueo ? 0 : listaPiqueo.size();
    }

    @Override
    public int getItemViewType(int position) {
        return listaPiqueo.get(position).isTipo() ? 1 : 0;
    }
}
