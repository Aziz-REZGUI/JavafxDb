package com.example.inscription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    public List<Participant> getParticipants()
    {
    return null;
    }
    public boolean ajouter_participant(Connection Cx) throws SQLException {
        boolean state;

        try {
            //   java.sql.Statement st = Cx.createStatement();
            PreparedStatement pst = Cx.prepareStatement("insert into participant(matricule,nom,prenom,date_naissance) values(?,?,?,?) ");
            pst.setString(2, this.getNom());
            pst.setString(3, this.getPrenom());
            pst.setDate(4, (java.sql.Date) this.getDate_naissance());
            pst.executeUpdate();
            System.out.println("participant a été ajouté avec succès.");
            state = true;
        } catch (SQLException e) {
            state = false;
        }
        return state;
    }

    public boolean supprimer_participant(Connection Cx){
        boolean state = false;
        try
        {   java.sql.Statement st = Cx.createStatement();

            pr = Cx.prepareStatement("DELETE FROM participant(matricule,nom,prenom,date_naissance) where matricule="+this.getMatricule());
            pr.executeUpdate();
        }
        catch (SQLException e) {
            state = false;
        }
        return state;

    }
    public boolean Chercher_participant(Connection Cx){
        boolean state = false;
        try
        {   java.sql.Statement st = Cx.createStatement();

            pr = Cx.prepareStatement("SELECT  * FROM participant(matricule,nom,prenom,date_naissance) where matricule="+this.getMatricule());
            pr.executeUpdate();

        }
        catch (SQLException e) {
            state = false;
        }
        return state;

    }
    //update_participant
    public boolean modifiier_participant(Connection Cx){
        boolean state = false;
        try
        {   java.sql.Statement st = Cx.createStatement();

            pr = Cx.prepareStatement("UPDATE participant(matricule,nom,prenom,date_naissance) SET values (?,?,?,?)");
            pr.setInt(1, this.getMatricule());
            pr.setString(2, this.getNom());
            pr.setString(3, this.getPrenom());
            pr.setDate(4, (java.sql.Date) this.getDate_naissance());
            pr.executeUpdate();
        }
        catch (SQLException e) {
            state = false;
        }
        return state;

    }
}
