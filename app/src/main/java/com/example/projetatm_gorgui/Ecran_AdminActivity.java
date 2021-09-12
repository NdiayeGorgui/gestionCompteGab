package com.example.projetatm_gorgui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projetatm_gorgui.model.CompteEpargne;
import com.example.projetatm_gorgui.model.Guichet;
import com.example.projetatm_gorgui.view.Guichet_PortraitActivity;
import com.example.projetatm_gorgui.view.MainActivity;

import java.util.ArrayList;

public class Ecran_AdminActivity extends AppCompatActivity {

    private Button btnPaiement;
    private Button btnComptesCheques;
    private Button btnComptesEpargnes;
    private Button btnListeClients;
    private Button logout;
    private Button btnPayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran__admin);

        btnPaiement = findViewById(R.id.btnPaiement);
        btnComptesCheques = findViewById(R.id.btnComptesCheques);
        btnComptesEpargnes = findViewById(R.id.btnComptesEpargnes);
        btnListeClients = findViewById(R.id.btnListeClients);
        logout = findViewById(R.id.btnLogoutAdmin);
        btnPayer = findViewById(R.id.btnPayer);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seDeconnecter();
            }
        });

        btnPaiement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectPaiementInteret();
                // connectCompteEpargne();
            }
        });

        btnComptesCheques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectCompteCheque();


            }
        });
        btnComptesEpargnes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                connectCompteEpargne();
                Compte_EpargneActivity compte_epargneActivity = new Compte_EpargneActivity();

            }
        });

        btnListeClients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectClients();

            }
        });
    }

    private void seDeconnecter() {

        Intent intent = new Intent(Ecran_AdminActivity.this, MainActivity.class);
        startActivity(intent);


    }
     //pour afficher l'ecran de paiement
    private void connectPaiementInteret() {

        Intent intent = new Intent(Ecran_AdminActivity.this, Payer_InteretActivity.class);
        startActivity(intent);
    }
    //pour afficher la liste des comptes cheque
    private void connectCompteCheque() {

        Intent intent = new Intent(Ecran_AdminActivity.this, Comptes_ChequeActivity.class);
        startActivity(intent);

    }

    //pour afficher la liste des comptes epargne
    private void connectCompteEpargne() {

        Intent intent = new Intent(Ecran_AdminActivity.this, Compte_EpargneActivity.class);
        startActivity(intent);

    }
    //pour afficher la liste des clients
    private void connectClients() {

        Intent intent = new Intent(Ecran_AdminActivity.this, ClientsActivity.class);
        startActivity(intent);


    }


}