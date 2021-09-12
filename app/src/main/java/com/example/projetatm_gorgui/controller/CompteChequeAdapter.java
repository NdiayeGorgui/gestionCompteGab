package com.example.projetatm_gorgui.controller;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.projetatm_gorgui.R;

import com.example.projetatm_gorgui.model.CompteCheque;

import java.util.ArrayList;

public class CompteChequeAdapter extends ArrayAdapter<CompteCheque> {

    private ArrayList<CompteCheque> comptesChequeList;
    private Context context;
    private int viewRes;
    private Resources res;

    //création de  ArrayAdapter et à la liaison de cet adaptateur avec liste des comptes cheque
    public CompteChequeAdapter(Context ctx, int textViewResourceId, ArrayList<CompteCheque> comptes) {
        super(ctx, textViewResourceId, comptes);
        comptesChequeList = comptes;
        context = ctx;
        viewRes = textViewResourceId;
        res = ctx.getResources();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes, parent, false);
        }
        final CompteCheque compteCheque = comptesChequeList.get(position);
        if (compteCheque != null) {
            final TextView numero = (TextView) view.findViewById(R.id.numero);
            final TextView solde = (TextView) view.findViewById(R.id.solde);

            //numero et solde compte cheque

            String numeroCompte = "Numero  compte:" + " " + compteCheque.getNumeroCompte();
            numero.setText(numeroCompte);
            String soldeCompte = "Solde  compte:" + " " + compteCheque.getSoldeCompte();
            solde.setText(soldeCompte);

        }
        return view;
    }

    @Override
    //compter et retourner le nombre de comptes cheque
    public int getCount() {
        return comptesChequeList.size();
    }


}
