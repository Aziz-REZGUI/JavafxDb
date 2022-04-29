package com.example.inscription.Classes;

public class Formateur {
    private  int code_formateur,n_tel;
    private String nom,prenom,email;

    public int getCode_formateur() {
        return code_formateur;
    }

    public void setCode_formateur(int code_formateur) {
        this.code_formateur = code_formateur;
    }

    public int getN_tel() {
        return n_tel;
    }

    public void setN_tel(int n_tel) {
        this.n_tel = n_tel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Formateur(int n_tel, String nom, String prenom, String email) {
        this.n_tel = n_tel;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public Formateur(int code_formateur, int n_tel, String nom, String prenom, String email) {
        this.code_formateur = code_formateur;
        this.n_tel = n_tel;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }
}
