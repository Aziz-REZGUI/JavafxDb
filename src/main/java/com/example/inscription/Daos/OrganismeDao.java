package com.example.inscription.Daos;

import com.example.inscription.Classes.Organisme;
import com.example.inscription.Databaseconnection;
import com.example.inscription.Interfaces.Crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrganismeDao implements Crud<Organisme> {
    Connection c = Databaseconnection.getConnection();
    PreparedStatement pr = null;

    @Override
    public List<Organisme> findAll() {
        List<Organisme> output = new ArrayList<>();
        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  * FROM organisme");

            while (resultSet.next()) {
                Organisme temp = new Organisme(resultSet.getInt("code_organisme"), resultSet.getString("libelle"));
                output.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return output;

    }

    @Override
    public boolean create(Organisme organisme) {
        boolean state;

        try {
            //   java.sql.Statement st = c.createStatement();
            PreparedStatement pst = c.prepareStatement("insert into organisme(libelle) values(?) ");
            pr.setString(1, organisme.getLibelle());
            pr.executeUpdate();
            System.out.println("organisme a été ajouté avec succès.");
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;
    }

    @Override
    public boolean delete(Organisme organisme) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            pr = c.prepareStatement("DELETE FROM organisme(code_organisme,libelle) where code_Organisme=" + organisme.getCode_organisme());
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
        return state;

    }

    @Override
    public boolean exists(Organisme organisme) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            ResultSet resultSet = st.executeQuery("SELECT  * FROM Organisme(code_organisme,libelle) where code_organisme=" + organisme.getCode_organisme());

            if (resultSet.next()) {
                state = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
        return state;

    }


    @Override
    public boolean update(Organisme organisme) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            pr = c.prepareStatement("UPDATE organisme set libelle=? where code_organisme=?)");
            pr.setString(1, organisme.getLibelle());
            pr.setInt(2, organisme.getCode_organisme());
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
        return state;

    }

}