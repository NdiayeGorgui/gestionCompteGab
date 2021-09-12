package com.example.projetatm_gorgui.model;

import com.example.projetatm_gorgui.ClientsActivity;
import com.example.projetatm_gorgui.Comptes_ChequeActivity;
import com.example.projetatm_gorgui.view.Guichet_PortraitActivity;

import java.util.ArrayList;
import java.util.List;

public class Guichet {

    private ArrayList<Client> clients = new ArrayList<Client>();
    private ArrayList<CompteCheque> comptesCheque = new ArrayList<CompteCheque>();
    private ArrayList<CompteEpargne> comptesEpargne = new ArrayList<CompteEpargne>();
    private String userName;
    private String numeroNip;
    private String numeroCompte;
    private double soldeCompte;
    private double montant;



    public Guichet() {

    }

    public Guichet(String userName, String numeroNip) {
        this.userName = userName;
        this.numeroNip = numeroNip;
    }

    public Guichet(String numeroNip, double montant) {
        this.numeroNip = numeroNip;
        this.montant = montant;

    }

    public Guichet(String numeroNip) {
        this.numeroNip = numeroNip;

    }

    //initialisation des clients
    public void initClient(ArrayList<Client> clientListe) {
        // client1
        Client client1 = new Client();
        client1.setNomClient("Faty");
        client1.setPrenomClient("Michel");
        client1.setUserName("michi");
        client1.setNumeroNip("1234");

        clientListe.add(client1);

        // client2
        Client client2 = new Client();
        client2.setNomClient("Rock");
        client2.setPrenomClient("Boby");
        client2.setUserName("bob");
        client2.setNumeroNip("2345");

        clientListe.add(client2);

        // client3
        Client client3 = new Client();
        client3.setNomClient("Njaay");
        client3.setPrenomClient("Gorgui");
        client3.setUserName("gogo");
        client3.setNumeroNip("3456");

        clientListe.add(client3);
    }

    //initialisation des comptes cheques
    public void InitCompteCheque(ArrayList<CompteCheque> compteListe) {
        // compte1
        CompteCheque compte1 = new CompteCheque();
        compte1.setNumeroCompte("1111");
        compte1.setSoldeCompeCheque(1000);
        compte1.setNumeroNip("1234");
        compteListe.add(compte1);

        // compte2
        CompteCheque compte2 = new CompteCheque();
        compte2.setNumeroCompte("2222");
        compte2.setSoldeCompeCheque(1500);
        compte2.setNumeroNip("2345");
        compteListe.add(compte2);

        // compte3
        CompteCheque compte3 = new CompteCheque();
        compte3.setNumeroCompte("3333");
        compte3.setSoldeCompeCheque(2500);
        compte3.setNumeroNip("3456");
        compteListe.add(compte3);
    }

    //initialisation des comptes epargne
    public void InitCompteEpargne(ArrayList<CompteEpargne> compteListe) {
        // compte1
        CompteEpargne compte1 = new CompteEpargne();
        compte1.setNumeroCompte("9111");
        compte1.setSoldeCompeEpargne(2000);
        compte1.setNumeroNip("1234");
        compteListe.add(compte1);

        // compte2
        CompteEpargne compte2 = new CompteEpargne();
        compte2.setNumeroCompte("9222");
        compte2.setSoldeCompeEpargne(2500);
        compte2.setNumeroNip("2345");
        compteListe.add(compte2);

        // compte3
        CompteEpargne compte3 = new CompteEpargne();
        compte3.setNumeroCompte("9333");
        compte3.setSoldeCompeEpargne(3500);
        compte3.setNumeroNip("3456");
        compteListe.add(compte3);
    }

    //validation de l'utilisateur lors de la connexion
    //on verifie si le user correspond aux users initialisés
    public boolean validerUtilisateur(String nomUtilisateur, String numeroNip) {
        initClient(clients);
        for (int i = 0; i < clients.size(); i++)
            if ((nomUtilisateur.equals(clients.get(i).getUserName())) && (numeroNip.equals(clients.get(i).getNumeroNip()))) {

                return true;
            } else if ((nomUtilisateur.equals("Admin")) && (numeroNip.equals("D001"))) {

                return true;
            } else {

            }
        return false;
    }

    // retrait dans le compte cheque, on parcour tous les comptes
    //pour comparer les nips au nip connecté avant de faire le retrait
    public double retraitCheque(String numeroNip, double montant) {

        ArrayList<CompteCheque> comptesCheque = new ArrayList<CompteCheque>();

        this.comptesCheque = comptesCheque;
        this.montant=montant;
        InitCompteCheque(comptesCheque);
        for (int i = 0; i < comptesCheque.size(); i++) {
            this.soldeCompte = comptesCheque.get(i).getSoldeCompteCheque();
          //  this.montant = comptesCheque.get(i).getMontantCompteCheque();
            this.numeroCompte=comptesCheque.get(i).getNumeroCompteCheque();
            if (numeroNip.equals(comptesCheque.get(i).getNumeroNip())) {
                comptesCheque.get(i).retraitCheque(montant);
                return comptesCheque.get(i).getSoldeCompteCheque();
            }

        }
        return 0;

    }

    // retrait dans le compte epargne, on parcour tous les comptes
    //pour comparer les nips au nip connecté avant de faire le retrait

    public double retraitEpargne(String numeroNip, double montant) {

        ArrayList<CompteEpargne> comptesEpargne = new ArrayList<CompteEpargne>();
        CompteEpargne compteEpargne = new CompteEpargne(numeroNip, montant);
         this.comptesEpargne = comptesEpargne;
         this.montant=montant;
        InitCompteEpargne(comptesEpargne);
        for (int i = 0; i < comptesEpargne.size(); i++) {
            if (numeroNip.equals(comptesEpargne.get(i).getNumeroNip())) {
                comptesEpargne.get(i).retraitEpargne(montant);
                return comptesEpargne.get(i).getSoldeCompteEpargne();
            }

        }
        return 0;
    }

    // depot dans le compte cheque, on parcour tous les comptes
    //pour comparer les nips au nip connecté avant de faire le depot

    public double depotCheque(String numeroNip, double montant) {
        ArrayList<CompteCheque> comptesCheque = new ArrayList<CompteCheque>();
        CompteCheque compteCheque = new CompteCheque(numeroNip, montant);
           this.comptesCheque = comptesCheque;
           this.montant=montant;
        InitCompteCheque(comptesCheque);
        for (int i = 0; i < comptesCheque.size(); i++) {
            if (numeroNip.equals(comptesCheque.get(i).getNumeroNip())) {
                comptesCheque.get(i).depotCheque(montant);
                return comptesCheque.get(i).getSoldeCompteCheque();
            }

        }
        return 0;
    }

    // depot dans le compte epargne, on parcour tous les comptes
    //pour comparer les nips au nip connecté avant de faire le depot

    public double depotEpargne(String numeroNip, double montant) {

        ArrayList<CompteEpargne> comptesEpargne = new ArrayList<CompteEpargne>();
        CompteEpargne compteEpargne = new CompteEpargne(numeroNip, montant);
        this.comptesEpargne = comptesEpargne;
        this.montant=montant;
        InitCompteEpargne(comptesEpargne);
        for (int i = 0; i < comptesEpargne.size(); i++) {
            if (numeroNip.equals(comptesEpargne.get(i).getNumeroNip())) {
                comptesEpargne.get(i).depotEpargne(montant);
                return comptesEpargne.get(i).getSoldeCompteEpargne();
            }

        }
        return 0;
    }

    // virement  vers le compte cheque

   public double virementCd(String numeroNip, double montant){

      return depotCheque(numeroNip,montant);

   }

    public double virementCr(String numeroNip, double montant){
        return retraitCheque(numeroNip,montant);

    }

   // virement vers le compte epargne
    public double virementEd(String numeroNip, double montant){
        return depotEpargne(numeroNip,montant);

    }


    public double virementEr(String numeroNip, double montant){
        return retraitEpargne(numeroNip,montant);

    }

    //pour verifier et afficher l'etat du compte cheque connecté, en parcourant et comparant
    //les nips au nip connecté puis renvoyé le solde du compte connecté

    public String etatCompteCheque(String numeroNip) {
        ArrayList<CompteCheque> comptesCheque = new ArrayList<CompteCheque>();
        CompteCheque compteCheque = new CompteCheque(numeroNip);
        // this.comptesCheque = comptesCheque;
        InitCompteCheque(comptesCheque);

        for (int i = 0; i < comptesCheque.size(); i++) {
            if (numeroNip.equals(comptesCheque.get(i).getNumeroNip())) {

                return "" + comptesCheque.get(i).getSoldeCompteCheque();
            }

        }
        return "";
    }

    //pour verifier et afficher l'etat du compte epargne connecté, en parcourant et comparant
    //les nips au nip connecté puis renvoyé le solde du compte connecté

    public String etatCompteEpargne(String numeroNip) {
        ArrayList<CompteEpargne> comptesEpargne = new ArrayList<CompteEpargne>();
        CompteEpargne compteEpargne = new CompteEpargne(numeroNip);
        //  this.comptesEpargne = comptesEpargne;
        InitCompteEpargne(comptesEpargne);

        for (int i = 0; i < comptesEpargne.size(); i++) {
            if (numeroNip.equals(comptesEpargne.get(i).getNumeroNip())) {

                return "" + comptesEpargne.get(i).getSoldeCompteEpargne();
            }

        }
        return "";
    }

    //payer interet sur les comptes epargne
    public void payerInterets() {

        ArrayList<CompteEpargne> comptesEpargne = new ArrayList<CompteEpargne>();
        CompteEpargne compteEpargne = new CompteEpargne();
        // this.comptesEpargne = comptesEpargne;
        InitCompteEpargne(comptesEpargne);
        for (int i = 0; i < comptesEpargne.size(); i++) {

            comptesEpargne.get(i).paiementInterets();
            comptesEpargne.get(i).getSoldeCompteEpargne();

        }


    }
}

