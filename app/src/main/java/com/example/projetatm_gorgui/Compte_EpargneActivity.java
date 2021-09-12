package com.example.projetatm_gorgui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projetatm_gorgui.controller.CompteChequeAdapter;
import com.example.projetatm_gorgui.controller.CompteEpargneAdapter;
import com.example.projetatm_gorgui.model.CompteCheque;
import com.example.projetatm_gorgui.model.CompteEpargne;
import com.example.projetatm_gorgui.model.Guichet;

import java.util.ArrayList;

public class Compte_EpargneActivity extends AppCompatActivity {


    private Button btnPayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compte__epargne);


        ArrayList<CompteEpargne> compteEpargneList = new ArrayList<CompteEpargne>();
        Guichet guichet = new Guichet();
        guichet.InitCompteEpargne(compteEpargneList);

        CompteEpargneAdapter adapter = new CompteEpargneAdapter(this, R.layout.liste_layout_compte, compteEpargneList);
        final ListView list = findViewById(R.id.maListe);
        final TextView quantite = (TextView) findViewById(R.id.nombre);
        String nombreCompte = "Nombre de comptes " + adapter.getCount();
        quantite.setText(nombreCompte);
        list.setAdapter(adapter);

    }


}