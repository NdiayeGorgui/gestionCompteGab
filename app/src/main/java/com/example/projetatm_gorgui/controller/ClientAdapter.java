package com.example.projetatm_gorgui.controller;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.projetatm_gorgui.R;
import com.example.projetatm_gorgui.model.Client;

import java.util.ArrayList;

public class ClientAdapter extends ArrayAdapter<Client> {

    private ArrayList<Client> clientsList;
    private Context context;
    private int viewRes;
    private Resources res;

    //création de  ArrayAdapter et à la liaison de cet adaptateur avec liste des clients

    public ClientAdapter(Context ctx, int textViewResourceId, ArrayList<Client> client) {
        super(ctx,textViewResourceId,client);
        clientsList=client;
        context=ctx;
        viewRes=textViewResourceId;
        res=ctx.getResources();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        if (view==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context. LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes, parent, false);
        }
        final Client leClient= clientsList.get(position);
        if (leClient != null) {
            final TextView nom = (TextView) view.findViewById(R.id.nom);
            final TextView prenom = (TextView) view.findViewById(R.id.prenom);

            //prenom et nom du client
            String nomClient = "Nom du  client:" + " " + leClient.getNomClient();
            nom.setText(nomClient);
            String prenomClient ="Penom du client:" + " "  + leClient.getPrenomClient();
            prenom.setText(prenomClient);

        }
        return view;
    }
    @Override

    //compter et retourner le nombre de clients
    public int getCount() {
        return clientsList.size();
    }


}
