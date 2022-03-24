package com.example.inscription;

public class User {
    //user w aka fazet mta3 base

    private int Codeutilisateur;

    private String login, password, role, fullname;

    //constructeur
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    // constructeur user


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


