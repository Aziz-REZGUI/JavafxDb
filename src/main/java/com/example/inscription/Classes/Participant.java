package com.example.inscription.Classes;

import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

public class Participant {
    private int matricule;

    private String nom, prenom;
    private Date date_naissance;
PreparedStatement pr;
    //constructeur
    public Participant(int matricule, String nom, String prenom) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
    }

    public int getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }


}
