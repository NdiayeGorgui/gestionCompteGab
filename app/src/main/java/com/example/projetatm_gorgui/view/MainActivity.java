package com.example.projetatm_gorgui.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projetatm_gorgui.model.Guichet;
import com.example.projetatm_gorgui.Ecran_AdminActivity;
import com.example.projetatm_gorgui.R;


public class MainActivity extends AppCompatActivity {
    private EditText userName;
    private EditText password;
    private TextView info;
    private Button login;
    private int counter = 3;
    private Guichet guichet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.editTextTextUserName);
        password = findViewById(R.id.editTextTextPassword);
        login = findViewById(R.id.btnSign);
        info = findViewById(R.id.txtInfo);

        info.setText("Nombre total de tentatives: 3");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateUser(userName.getText().toString(), password.getText().toString());
            }
        });
    }

    //validation du user, on ajoute le nip et nomuser dans un bundle
    //pour pouvoir les recupérer dans la page guichet
    //c'est ce qui nous permettra de comparer le nip du user connecté
    //aux nip des comptes et des clients

    public void validateUser(String nomUtilisateur, String numeroNip) {

        //creation d'un objet bundle
        Bundle extras = new Bundle();

        //ajout des cles/valeur dans le bundle
        //utilisation du nip
        extras.putString("NIP", password.getText().toString());
        extras.putString("USER", userName.getText().toString());

        guichet = new Guichet(nomUtilisateur, numeroNip);
        if (guichet.validerUtilisateur(nomUtilisateur, numeroNip)) {
            if ((!nomUtilisateur.equals("Admin")) && (!numeroNip.equals("D001"))) {
                Intent intent = new Intent(MainActivity.this, Guichet_PortraitActivity.class);
                intent.putExtras(extras);
                startActivity(intent);
            } else if ((nomUtilisateur.equals("Admin")) && (numeroNip.equals("D001"))) {
                Intent intent = new Intent(MainActivity.this, Ecran_AdminActivity.class);
                startActivity(intent);
            }

        } else {
            counter--;
            info.setText("Nombre de tentatives restantes: " + String.valueOf(counter));
            if (counter == 0) {
                login.setEnabled(false);
                info.setText("Nombre limite de tentatives atteint,Veuillez reessayer plutard ");
            }
        }

    }


}