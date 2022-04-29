package com.example.inscription.Daos;

import com.example.inscription.Classes.Participant;
import com.example.inscription.Databaseconnection;
import com.example.inscription.Interfaces.Crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ParticipantDao implements Crud<Participant> {
    Connection c = Databaseconnection.getConnection();
    PreparedStatement pr = null;

    @Override
    public List<Participant> findAll() {
        return null;
    }

    @Override
    public boolean update(Participant participant) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            pr = c.prepareStatement("UPDATE participant(matricule,nom,prenom,date_naissance) SET values (?,?,?,?)");
            pr.setInt(1, participant.getMatricule());
            pr.setString(2, participant.getNom());
            pr.setString(3, participant.getPrenom());
            pr.setDate(4, (java.sql.Date) participant.getDate_naissance());
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;

    }

    @Override
    public boolean create(Participant participant) {
        boolean state;

        try {
            //   java.sql.Statement st = c.createStatement();
            PreparedStatement pr = c.prepareStatement("insert into participant(matricule,nom,prenom,date_naissance) values(?,?,?,?) ");
            pr.setString(2, participant.getNom());
            pr.setString(3, participant.getPrenom());
            pr.setDate(4, (java.sql.Date) participant.getDate_naissance());
            pr.executeUpdate();
            System.out.println("participant a été ajouté avec succès.");
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;
    }

    @Override
    public boolean delete(Participant participant) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            pr = c.prepareStatement("DELETE FROM participant(matricule,nom,prenom,date_naissance) where matricule=" + participant.getMatricule());
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;

    }

    @Override
    public boolean exists(Participant participant) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            pr = c.prepareStatement("SELECT  * FROM participant(matricule,nom,prenom,date_naissance) where matricule=" + participant.getMatricule());
            pr.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;

    }
}
