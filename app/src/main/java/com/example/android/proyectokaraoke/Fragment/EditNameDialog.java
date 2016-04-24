package com.example.android.proyectokaraoke.Fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.proyectokaraoke.R;

/**
 * Created by USUARIO1 on 19/04/2016.
 */
public class EditNameDialog extends DialogFragment implements View.OnClickListener {

    private TextView mTextView;
    private RecyclerView mRecyclerView;
    private View.OnClickListener listener;
    private Button mButtonCancel;
    private Button mButtonConfirm;


    public EditNameDialog() {
        // Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_piqueo_catalogo_comfirm, container);
        mTextView = (TextView) view.findViewById(R.id.texttotaltotal);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.listapiqueoconfirm);
        mButtonCancel = (Button) view.findViewById(R.id.buttonCancelarConfirm);
        mButtonConfirm = (Button) view.findViewById(R.id.buttonGrabarConfirm);

        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this.dismiss();
            }
        });

        mButtonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog.dismiss();
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {

    }
}