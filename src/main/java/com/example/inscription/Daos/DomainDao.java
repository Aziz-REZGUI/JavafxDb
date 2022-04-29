package com.example.inscription.Daos;

import com.example.inscription.Classes.Domaine;
import com.example.inscription.Databaseconnection;
import com.example.inscription.Interfaces.Crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DomainDao implements Crud<Domaine> {
    Connection c = Databaseconnection.getConnection();
    PreparedStatement pr = null;

    public List<Domaine> findAll() {
        return null;
    }

    @Override
    public boolean create(Domaine domaine) {
        boolean state;

        try {
            //   java.sql.Statement st = c.createStatement();
            PreparedStatement pst = c.prepareStatement("insert into domaine(libelle) values(?) ");
            pst.setString(1, domaine.getLibelle());
            pst.executeUpdate();
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
    public boolean delete(Domaine domaine) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            pr = c.prepareStatement("DELETE FROM domaine(code_domaine,libelle) where code_profil=" + domaine.getCode_domaine());
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;

    }

    @Override
    public boolean exists(Domaine domaine) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            pr = c.prepareStatement("SELECT  * FROM profil(code_domaine,libelle) where code_profil=" + domaine.getCode_domaine());
            pr.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;

    }

    @Override
    public boolean update(Domaine domaine) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            pr = c.prepareStatement("UPDATE profil(code_domaine,libelle) SET values (?,?)");
            pr.setInt(1, domaine.getCode_domaine());
            pr.setString(2, domaine.getLibelle());
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;

    }
}
