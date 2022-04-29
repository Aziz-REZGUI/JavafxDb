package com.example.inscription.Daos;

import com.example.inscription.Classes.User;
import com.example.inscription.Databaseconnection;
import com.example.inscription.Interfaces.Crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements Crud<User> {
    Connection c = Databaseconnection.getConnection();
    PreparedStatement pr = null;

    public boolean login(User user) {
        boolean state = false;
        try {
            pr = c.prepareStatement("select count(1) from utilisateur where login = '" + user.getLogin() + "' and password = '" + user.getPassword() + "'");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                state = rs.getInt(1) == 1;
            }


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        return state;
        //  return con.login(c, user);
    }


    public boolean register(User user) {
        Databaseconnection con = new Databaseconnection();
        boolean state;
        try {
            //statement.executeUpdate("INSERT INTO utilisateur (login,password,full_name,role) VALUES ('" + user.getLogin() + "','" + user.getPassword() + "','" + user.getFullname() + "','" + user.getRole() + "')");
            pr = c.prepareStatement("insert into utilisateur(login,password,full_name,role) values(?,?,?,?)");
            // pr.setInt(1, eid);
            pr.setString(1, user.getLogin());
            pr.setString(2, user.getPassword());
            pr.setString(3, user.getFullname());
            pr.setString(4, user.getRole());
            pr.executeUpdate();
            System.out.println("L'utilisateur a été ajouté avec succès.");
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;
    }


    @Override
    public boolean create(User user) {
        //TODO
        return false;
    }

    @Override
    public boolean update(User user) {
        //TOOO
        return false;
    }

    @Override
    public boolean delete(User user) {
        //TODO
        return false;
    }

    @Override
    public List<User> findAll() {
        //TODO
        return null;
    }

    @Override
    public boolean exists(User user) {
        boolean state = false;
        try {
            pr = c.prepareStatement("select count(1) from utilisateur where login = '" + user.getLogin() + "'");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                state = rs.getInt(1) == 1;
            }


        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }

        return state;
    }
}
