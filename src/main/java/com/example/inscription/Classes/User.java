package com.example.inscription.Classes;

import com.example.inscription.Databaseconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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



}


