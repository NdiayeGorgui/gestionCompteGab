package com.example.projetatm_gorgui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projetatm_gorgui.controller.ClientAdapter;
import com.example.projetatm_gorgui.model.Client;
import com.example.projetatm_gorgui.model.Guichet;

import java.util.ArrayList;

public class ClientsActivity extends AppCompatActivity {
    private Guichet guichet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients);

        ArrayList<Client> clientList = new ArrayList<Client>();
        Guichet guichet = new Guichet();
        guichet.initClient(clientList);

        ClientAdapter adapter = new ClientAdapter(this, R.layout.liste_layout, clientList);
        final ListView list = findViewById(R.id.maListe);
        final TextView quantite = (TextView) findViewById(R.id.nombre);
        String nombreClient = "Nombre de clients " + adapter.getCount();
        quantite.setText(nombreClient);
        list.setAdapter(adapter);
    }

}