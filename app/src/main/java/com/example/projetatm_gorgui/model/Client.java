package com.example.projetatm_gorgui.model;

public class Client {
    private String nomClient;
    private String prenomClient;
    private String userName;
    private String numeroNip;

    /**
     * creation du constructeur par defaut de client
     */
    public Client(){
        this("inconnu","inconnu","inconnu","inconnu");
    }

    /**
     * constructeur avec 4 arguments
     * @param nomClient
     * @param prenomClient
     * @param userName
     * @param numeroNip
     */
    public  Client(String nomClient, String prenomClient, String userName, String numeroNip ){
        this.nomClient=nomClient;
        this.nomClient=prenomClient;
        this.userName=userName;
        this.numeroNip=numeroNip;

    }

    /**
     * redefinition de la methode toSting
     * @return
     */
    public String toString() {
        String chaine;
        chaine ="Client "+nomClient+" "+prenomClient+" "+userName;
        return chaine;
    }

 // les getters et setters

    public String getNomClient(){
        return nomClient;
    }
    public String getPrenomClient(){
        return prenomClient;
    }
    public String getUserName(){
        return userName;
    }
    public String getNumeroNip(){
        return numeroNip;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setNumeroNip(String numeroNip) {
        this.numeroNip = numeroNip;
    }
}
