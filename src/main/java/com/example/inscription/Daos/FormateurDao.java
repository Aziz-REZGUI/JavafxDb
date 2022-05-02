package com.example.inscription.Daos;

import com.example.inscription.Classes.Formateur;
import com.example.inscription.Databaseconnection;
import com.example.inscription.Interfaces.Crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FormateurDao implements Crud<Formateur> {
    Connection c = Databaseconnection.getConnection();
    PreparedStatement pr = null;

    @Override
    public boolean create(Formateur formateur) {
        boolean state;

        try {
            //   java.sql.Statement st = c.createStatement();
            PreparedStatement pst = c.prepareStatement("insert into formateur(Nom,Prenom,Email) values(?,?,?) ");
            pr.setString(1, formateur.getNom());
            pr.setString(2, formateur.getPrenom());
            pr.setString(3, formateur.getEmail());
            pr.executeUpdate();
            System.out.println("formateur a été ajouté avec succès.");
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;
    }

    @Override
    public boolean update(Formateur formateur) {
        boolean state = false;
        try {
            pr = c.prepareStatement("UPDATE formateur SET Nom=?,Prenom=?,Email=?,N_tel=?    where Code_formateur=?");
            pr.setString(1, formateur.getNom());
            pr.setString(2, formateur.getPrenom());
            pr.setString(3, formateur.getEmail());
            pr.setInt(4, formateur.getN_tel());
            pr.setInt(5, formateur.getCode_formateur());
            pr.executeUpdate();
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return state;

    }

    @Override
    public boolean delete(Formateur formateur) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            pr = c.prepareStatement("DELETE FROM formateur where Code_formateur=" + formateur.getCode_formateur());
            pr.executeUpdate();
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return state;
    }

    @Override
    public List<Formateur> findAll() {
        List<Formateur> output = new ArrayList<>();
        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  * FROM formateur");

            while (resultSet.next()) {
                Formateur temp = new Formateur(resultSet.getInt("code_formateur"), resultSet.getInt("n_tel"), resultSet.getString("nom"), resultSet.getString("prenom"), resultSet.getString("email"));
                output.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return output;
    }

    @Override
    public boolean exists(Formateur formateur) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            ResultSet resultSet = st.executeQuery("SELECT  * FROM formateur where Code_formateur=" + formateur.getCode_formateur());

            if (resultSet.next()) {
                state = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
        return state;

    }
}
