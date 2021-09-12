package com.example.projetatm_gorgui.model;

public abstract class Compte {
    private String numeroNip;
    private String numeroCompte;
    private double soldeCompte;
    private double montant;

    /**
     * constructeur avec 3 arguments de compte
     *
     * @param numeroNip
     * @param numeroCompte
     * @param soldeCompte
     */
    public Compte(String numeroNip, String numeroCompte, double soldeCompte) {
        this.numeroNip = numeroNip;
        this.numeroCompte = numeroCompte;
        this.soldeCompte = soldeCompte;
        this.depot(montant);
        this.retrait(montant);

    }

    /**
     * constructeur avec 2 arguments de compte
     *
     * @param numeroNip
     * @param montant
     */

    public Compte(String numeroNip, double montant) {
        this.numeroNip = numeroNip;
        this.montant = montant;
        this.numeroCompte = numeroCompte;
        this.soldeCompte = soldeCompte;
        // this.depot(montant);
        // this.retrait(montant);

    }

    // constructeur avec 1 argument de compte
    public Compte(String numeroNip) {
        this.numeroNip = numeroNip;


    }

    // constructeur avec 3 arguments de compte
    public Compte(String numeroNip, double montant, double soldeCompte) {
        this.numeroNip = numeroNip;
        this.montant = montant;
        this.soldeCompte = soldeCompte;
        this.depot(montant);
        this.retrait(montant);

    }

    // la methode qui permet d'effectuer un depot
    public double depot(double montant) {
        if (montant > 0) {
            soldeCompte += montant;
            return soldeCompte;
        } else
            return 0;
    }

    // la methode qui permet d'effectuer un retrait
    public double retrait(double montant) {
        if (this.soldeCompte > montant) {

            if (montant <= 1000) {
                if (montant%10==0)

                soldeCompte -= montant;
            }
            return soldeCompte;
        } else

            return 0;
    }

    // les getters et setters

    public String getNumeroNip() {
        return numeroNip;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSoldeCompte() {
        return soldeCompte;
    }

    public double getMontant() {
        return montant;
    }


    public void setNumeroNip(String numeroNip) {
        this.numeroNip = numeroNip;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public void setSoldeCompte(double soldeCompte) {
        this.soldeCompte = soldeCompte;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
