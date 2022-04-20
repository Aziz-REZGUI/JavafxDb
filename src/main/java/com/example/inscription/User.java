package com.example.inscription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {


    private int Codeutilisateur;
    PreparedStatement pr;

    private String login, password, role, fullname;


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }


    public User(String fullname, String login, String password) {
        this.login = login;
        this.password = password;
        this.role = "user";
        this.fullname = fullname;
    }

    public int getCodeutilisateur() {
        return Codeutilisateur;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getFullname() {
        return fullname;
    }

    public boolean login(Connection c) {
        boolean state = false;
        try {
            pr = c.prepareStatement("select count(1) from utilisateur where login = '" + this.getLogin() + "' and password = '" + this.getPassword() + "'");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                if (rs.getInt(1) == 1) {
                    state = true;

                } else {
                    state = false;

                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        return state;
        //  return con.login(c, this);
    }

    public boolean register(Connection c) {
        Databaseconnection con = new Databaseconnection();
        boolean state;
        try {
            //statement.executeUpdate("INSERT INTO utilisateur (login,password,full_name,role) VALUES ('" + user.getLogin() + "','" + user.getPassword() + "','" + user.getFullname() + "','" + user.getRole() + "')");
            pr = c.prepareStatement("insert into utilisateur(login,password,full_name,role) values(?,?,?,?)");
            // pr.setInt(1, eid);
            pr.setString(1, this.getLogin());
            pr.setString(2, this.getPassword());
            pr.setString(3, this.getFullname());
            pr.setString(4, this.getRole());
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

}


