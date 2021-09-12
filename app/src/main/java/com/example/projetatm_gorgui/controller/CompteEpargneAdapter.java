package com.example.projetatm_gorgui.controller;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.projetatm_gorgui.R;
import com.example.projetatm_gorgui.model.CompteEpargne;

import java.util.ArrayList;

public class CompteEpargneAdapter extends ArrayAdapter<CompteEpargne> {

    private ArrayList<CompteEpargne> comptesEpargneList;
    private Context context;
    private int viewRes;
    private Resources res;

    //création de  ArrayAdapter et à la liaison de cet adaptateur avec liste des comptes epargne

    public CompteEpargneAdapter(Context ctx, int textViewResourceId, ArrayList<CompteEpargne> comptes) {
        super(ctx, textViewResourceId, comptes);
        comptesEpargneList = comptes;
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
        final CompteEpargne compteEpargne = comptesEpargneList.get(position);
        if (compteEpargne != null) {
            final TextView numero = (TextView) view.findViewById(R.id.numero);
            final TextView solde = (TextView) view.findViewById(R.id.solde);

            //le numero et solde du compte epargne
            String numeroCompte = "Numero  compte:" + " " + compteEpargne.getNumeroCompte();
            numero.setText(numeroCompte);
            String soldeCompte = "Solde  compte:" + " " + compteEpargne.getSoldeCompte();
            solde.setText(soldeCompte);
        }
        return view;
    }

    @Override
    //compter et retourner le nombre de comptes epargne
    public int getCount() {
        return comptesEpargneList.size();
    }


}
