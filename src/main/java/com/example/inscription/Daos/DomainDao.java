package com.example.inscription.Daos;

import com.example.inscription.Classes.Domaine;
import com.example.inscription.Databaseconnection;
import com.example.inscription.Interfaces.Crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomainDao implements Crud<Domaine> {
    Connection c = Databaseconnection.getConnection();
    PreparedStatement pr = null;

    public List<Domaine> findAll() {
        List<Domaine> output = new ArrayList<>();
        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  * FROM profil(code_domaine,libelle)");

            while (resultSet.next()) {
                Domaine temp = new Domaine(resultSet.getInt("code_domain"), resultSet.getString("libelle"));
                output.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return output;

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
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  * FROM profil(code_domaine,libelle) where code_profil=" + domaine.getCode_domaine());

            if (resultSet.next()) {
                state = true;
            }
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
