package com.example.inscription.Daos;

import com.example.inscription.Classes.Participation;
import com.example.inscription.Databaseconnection;
import com.example.inscription.Interfaces.Crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipationDao implements Crud<Participation> {
    Connection c = Databaseconnection.getConnection();
    PreparedStatement pr = null;

    @Override
    public boolean create(Participation participation) {
        boolean state;

        try {
            //   java.sql.Statement st = c.createStatement();
            PreparedStatement pr = c.prepareStatement("insert into participation(Matricule, code_formation) values(?,?) ");

            pr.setInt(1, participation.getMatricule());
            pr.setInt(2, participation.getCode_formation());
            pr.executeUpdate();
            System.out.println("participantion a été ajouté avec succès.");
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;

    }

    @Override
    public boolean update(Participation participation) {

        //TODO check return
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            pr = c.prepareStatement("UPDATE participation SET Matricule=?,code_formation=? where Matricule=?and code_formation=?");

            pr.setInt(1, participation.getMatricule());
            pr.setInt(2, participation.getCode_formation());
            pr.setInt(3, participation.getMatricule());
            pr.setInt(4, participation.getCode_formation());
            pr.executeUpdate();
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return state;
    }

    @Override
    public boolean delete(Participation participation) {
        boolean state = false;
        try {
            pr = c.prepareStatement("DELETE FROM participation where Matricule=? and  code_formation=?");
            pr.setInt(1, participation.getMatricule());
            pr.setInt(2, participation.getCode_formation());
            pr.executeUpdate();
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return state;
    }

    @Override
    public List<Participation> findAll() {
        List<Participation> output = new ArrayList<>();
        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  p.Matricule,p.Nom,f.code_formation,f.intitule FROM participation pa ,formation f,participant p where  p.Matricule=pa.Matricule and f.code_formation=pa.code_formation");

            while (resultSet.next()) {
                Participation temp = new Participation(resultSet.getInt("matricule"), resultSet.getString("nom"), resultSet.getInt("code_formation"), resultSet.getString("intitule"));
                output.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return output;
    }

    @Override
    public boolean exists(Participation participation) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            ResultSet resultSet = st.executeQuery("SELECT  * FROM participation where Matricule=? and  code_formation=?");
            pr.setInt(1, participation.getMatricule());
            pr.setInt(2, participation.getCode_formation());
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
