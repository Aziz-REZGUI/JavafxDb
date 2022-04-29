package com.example.inscription.Daos;

import com.example.inscription.Classes.Profil;
import com.example.inscription.Databaseconnection;
import com.example.inscription.Interfaces.Crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProfileDao implements Crud<Profil> {
    Connection c = Databaseconnection.getConnection();
    PreparedStatement pr = null;

    @Override
    public List<Profil> findAll() {
        return null;
    }

    @Override
    public boolean create(Profil profil) {
        boolean state;

        try {
            //   java.sql.Statement st = c.createStatement();
            PreparedStatement pst = c.prepareStatement("insert into profil(libelle) values(?) ");
            pr.setString(1, profil.getLibelle());
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
    public boolean delete(Profil profil) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            pr = c.prepareStatement("DELETE FROM profil(code_profil,libelle) where code_profil=" + profil.getCode_profil());
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;

    }

    @Override
    public boolean exists(Profil profil) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            pr = c.prepareStatement("SELECT  * FROM profil(code_profil,libelle) where code_profil=" + profil.getCode_profil());
            pr.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;

    }


    @Override
    public boolean update(Profil profil) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            pr = c.prepareStatement("UPDATE profil(code_profil,libelle) SET values (?,?)");
            pr.setInt(1, profil.getCode_profil());
            pr.setString(2, profil.getLibelle());
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;

    }
}
