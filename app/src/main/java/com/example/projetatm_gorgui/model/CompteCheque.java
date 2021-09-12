package com.example.projetatm_gorgui.model;

public class CompteCheque extends Compte {

    //constructeur par defaut
    public CompteCheque() {
        super("inconnu", "inconnu", 0);
    }


    //constructeur a 3 argument de comptecheque
    public CompteCheque(String numeroNip, String numeroCompte, double soldeCompte) {
        super(numeroNip, numeroCompte, soldeCompte);

    }

    public CompteCheque(String numeroNip, double montant, double soldeCompte) {
        super(numeroNip, montant, soldeCompte);

    }

    //constructeur a 2 arguments de comptecheque
    public CompteCheque(String numeroNip, double montant) {
        super(numeroNip, montant);
    }

    //constructeur a 1 argument de comptecheque
    public CompteCheque(String numeroNip) {
        super(numeroNip);
    }

    //pour faire un depot
    public double depotCheque(double montant) {
        return super.depot(montant);
    }

    //pour faire un retrait
    public double retraitCheque(double montant) {
        return super.retrait(montant);
    }

    //les getters et setters

    public String getNumeroNip() {
        return super.getNumeroNip();
    }

    public String getNumeroCompteCheque() {
        return super.getNumeroCompte();
    }

    public double getSoldeCompteCheque() {
        return super.getSoldeCompte();
    }

    public double getMontantCompteCheque() {
        return super.getMontant();
    }

    public void setNumeroNip(String numeroNip) {
        super.setNumeroNip(numeroNip);
    }

    public void setNumeroCompteCheque(String numeroCompte) {
        super.setNumeroCompte(numeroCompte);
    }

    public void setSoldeCompeCheque(double soldeCompe) {
        super.setSoldeCompte(soldeCompe);
    }
}
