package com.example.projetatm_gorgui.model;

public class CompteEpargne extends Compte {
    private final double tauxInteret = 0.0125;

    //constructeur par defaut
    public CompteEpargne() {
        super("0", "inconnu", 0);
    }

    //constructeur a 3 arguments
    public CompteEpargne(String numeroNip, String numeroCompte, double soldeCompte) {
        super(numeroNip, numeroCompte, soldeCompte);
    }

    //constructeur a 2 arguments
    public CompteEpargne(String numeroNip, double montant) {
        super(numeroNip, montant);
    }

    //constructeur a 1 argument
    public CompteEpargne(String numeroNip) {
        super(numeroNip);
    }

    //depot compte epargne
    public double depotEpargne(double montant) {
        return super.depot(montant);
    }

    //retrait compte epargne
    public double retraitEpargne(double montant) {
        return super.retrait(montant);
    }



    //paiement des interets
    public double paiementInterets() {
        double c = (getSoldeCompteEpargne() + getSoldeCompteEpargne() * tauxInteret);
        return c;

    }

    //getters et setters
    public String getNumeroNip() {
        return super.getNumeroNip();
    }

    public String getNumeroCompteEpargne() {
        return super.getNumeroCompte();
    }
    public double getMontantCompteEpargne() {
        return super.getMontant();
    }

    public double getSoldeCompteEpargne() {
        return super.getSoldeCompte();
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setNumeroNip(String numeroNip) {
        super.setNumeroNip(numeroNip);
    }

    public void setNumeroCompteEpargne(String numeroCompte) {
        super.setNumeroCompte(numeroCompte);
    }

    public void setSoldeCompeEpargne(double soldeCompe) {
        super.setSoldeCompte(soldeCompe);
    }

}

