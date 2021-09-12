package com.example.projetatm_gorgui.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetatm_gorgui.R;

import com.example.projetatm_gorgui.model.Client;
import com.example.projetatm_gorgui.model.CompteCheque;
import com.example.projetatm_gorgui.model.CompteEpargne;
import com.example.projetatm_gorgui.model.Guichet;

import java.util.ArrayList;

public class Guichet_PortraitActivity extends AppCompatActivity {

    //declaration des variables
    private Button logout;
    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button height;
    private Button nine;
    private Button clear;
    private Button point;
    private Button etatCompte;
    private Button soumettre;
    private EditText montant;
    private TextView info;
    private TextView infoNip;
    private TextView textViewCheque;
    private TextView textViewEpargne;
    private RadioButton depot;
    private RadioButton retrait;
    private RadioButton virement;
    private RadioButton cheque;
    private RadioButton epargne;
    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;

    private ArrayList<CompteCheque> comptesCheque = new ArrayList<CompteCheque>();
    private ArrayList<CompteEpargne> comptesEpargne = new ArrayList<CompteEpargne>();
    private ArrayList<Client> clients = new ArrayList<Client>();
    private String infonumeroNip;
    private String userName;
    private double soldeCompte;
    private Guichet guichet;
    public CompteCheque c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_guichet__portrait);

        //recuperation de l'objet Intent de la part de l'activité emmetrice
        Intent intent = getIntent();

        //recuperation du Bundle attaché a l'Intent de l'activité emmetrice
        Bundle extras = intent.getExtras();

        //extraction des données jointes dans le bundle;
        infonumeroNip = extras.getString("NIP");
        userName = extras.getString("USER");
        // Log.i("RESULT", "Le nip est: " + infonumeroNip + " le user est " + userName);

        //appel des methodes
        setupGuichet();
        boutonClavier();
        butonSoumettre();
        butonEtatCompte();
    }

    //recuperation des id
    private void setupGuichet() {
        logout = findViewById(R.id.btnLogout);
        zero = findViewById(R.id.btn0);
        one = findViewById(R.id.btn1);
        two = findViewById(R.id.btn2);
        three = findViewById(R.id.btn3);
        four = findViewById(R.id.btn4);
        five = findViewById(R.id.btn5);
        six = findViewById(R.id.btn6);
        seven = findViewById(R.id.btn7);
        height = findViewById(R.id.btn8);
        nine = findViewById(R.id.btn9);
        point = findViewById(R.id.btnPoint);
        clear = findViewById(R.id.btnC);
        soumettre = findViewById(R.id.btnSoumettre);
        etatCompte = findViewById(R.id.btnEtatCompte);
        montant = findViewById(R.id.editTextMontant);
        info = findViewById(R.id.txtInfo);
        textViewCheque = findViewById(R.id.textViewCheque);
        textViewEpargne = findViewById(R.id.textViewEpargne);
    }

    //methode pour ecouter et affecter la valeur correspondante aux bouton du clavier

    private void boutonClavier() {
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                montant.setText(montant.getText().toString() + "0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                montant.setText(montant.getText().toString() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                montant.setText(montant.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                montant.setText(montant.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                montant.setText(montant.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                montant.setText(montant.getText().toString() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                montant.setText(montant.getText().toString() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                montant.setText(montant.getText().toString() + "7");
            }
        });
        height.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                montant.setText(montant.getText().toString() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                montant.setText(montant.getText().toString() + "9");
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                montant.setText(montant.getText().toString() + ".");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                montant.getText().clear();
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seDeconnecter();
            }
        });
    }

    //methode qui permet de renvoyer le resultat de l'operation
    //selon les selectionés

    private void butonSoumettre() {
        soumettre.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                depot = findViewById(R.id.rdbDepot);
                retrait = findViewById(R.id.rdbRetrait);
                virement = findViewById(R.id.rdbVirement);
                cheque = findViewById(R.id.rdbCheque);
                epargne = findViewById(R.id.rdbEpargne);
                //  montant=findViewById(R.id.editTextMontant);

                Guichet guichet = new Guichet();
                double montants;

                String montan = montant.getText().toString();
                montants = Double.parseDouble(montant.getText().toString());


                RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radioGroupe1);
                RadioButton selectedRadioButton1 = (RadioButton) findViewById(radioGroup1.getCheckedRadioButtonId());

                //recuperer RadioButton text
                String choix1 = selectedRadioButton1.getText().toString();


                RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radioGroupe2);
                RadioButton selectedRadioButton2 = (RadioButton) findViewById(radioGroup2.getCheckedRadioButtonId());

                //recuperer RadioButton text
                String choix2 = selectedRadioButton2.getText().toString();
                // afficher Toast de l'operation
                Toast.makeText(Guichet_PortraitActivity.this, choix1 + " de " + montants + " $ sur votre compte " + choix2, Toast.LENGTH_SHORT).show();
                if ((radioGroup1.getCheckedRadioButtonId() == R.id.rdbDepot) && (radioGroup2.getCheckedRadioButtonId() == R.id.rdbCheque)) {

                    guichet.depotCheque(infonumeroNip, montants);
                    textViewCheque.setText("Solde compte Cheque: " + String.valueOf(guichet.depotCheque(infonumeroNip, montants)));

                }
                if ((radioGroup1.getCheckedRadioButtonId() == R.id.rdbRetrait) && (radioGroup2.getCheckedRadioButtonId() == R.id.rdbCheque)) {

                        guichet.retraitCheque(infonumeroNip, montants);
                        textViewCheque.setText("Solde compte Cheque: " + String.valueOf(guichet.retraitCheque(infonumeroNip, montants)));


                }
                if ((radioGroup1.getCheckedRadioButtonId() == R.id.rdbDepot) && (radioGroup2.getCheckedRadioButtonId() == R.id.rdbEpargne)) {
                    guichet.depotEpargne(infonumeroNip, montants);
                    textViewEpargne.setText("Solde compte Epargne: " + String.valueOf(guichet.depotEpargne(infonumeroNip, montants)));
                }
                if ((radioGroup1.getCheckedRadioButtonId() == R.id.rdbRetrait) && (radioGroup2.getCheckedRadioButtonId() == R.id.rdbEpargne)) {
                    guichet.retraitEpargne(infonumeroNip, montants);
                    textViewEpargne.setText("Solde compte Epargne: " + String.valueOf(guichet.retraitEpargne(infonumeroNip, montants)));
                }

                if ((radioGroup1.getCheckedRadioButtonId() == R.id.rdbVirement) && (radioGroup2.getCheckedRadioButtonId() == R.id.rdbCheque)) {
                    guichet.virementCd(infonumeroNip, montants);
                    guichet.virementEr(infonumeroNip, montants);

                    textViewCheque.setText("Solde compte Cheque: " + String.valueOf(guichet.virementCd(infonumeroNip, montants)));
                    textViewEpargne.setText("Solde compte Epargne: " + String.valueOf(guichet.virementEr(infonumeroNip, montants)));
                }

                if ((radioGroup1.getCheckedRadioButtonId() == R.id.rdbVirement) && (radioGroup2.getCheckedRadioButtonId() == R.id.rdbEpargne)) {
                    guichet.virementEd(infonumeroNip, montants);
                    guichet.virementCr(infonumeroNip, montants);

                    textViewCheque.setText("Solde compte Cheque: " + String.valueOf(guichet.virementCr(infonumeroNip, montants)));
                    textViewEpargne.setText("Solde compte Epargne: " + String.valueOf(guichet.virementEd(infonumeroNip, montants)));
                }

            }
        });
    }

    //cette methode permet d'afficher l'etat des comptes du user connecté
    private void butonEtatCompte() {
        etatCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Guichet guichet = new Guichet();
                guichet.etatCompteCheque(infonumeroNip);
                textViewCheque.setText("Solde compte Cheque: " + String.valueOf(guichet.etatCompteCheque(infonumeroNip)));

                guichet.etatCompteCheque(infonumeroNip);
                textViewEpargne.setText("Solde compte Epargne: " + String.valueOf(guichet.etatCompteEpargne(infonumeroNip)));
            }
        });
    }

    //pour se deconnecté de l'application
    private void seDeconnecter() {

        Intent intent = new Intent(Guichet_PortraitActivity.this, MainActivity.class);
        startActivity(intent);


    }


    private void validerMontant(String montant) {

        //on verifie la saisie vide
        if (montant.matches("")) {

            Toast.makeText(Guichet_PortraitActivity.this, "Saisir le montant",
                    Toast.LENGTH_SHORT).show();
            return;
        }

    }

}