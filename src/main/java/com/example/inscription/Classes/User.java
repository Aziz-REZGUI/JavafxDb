package com.example.inscription.Classes;

public class User {


    private int Codeutilisateur;

    public User(int codeutilisateur, String login, String password, String fullname, String role) {
        Codeutilisateur = codeutilisateur;
        this.login = login;
        this.password = password;
        this.role = role;
        this.fullname = fullname;
    }

    public User(String login, String password, String fullname, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.fullname = fullname;
    }

    private String login, password, role, fullname;


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }


    public User( String login, String password,String fullname) {
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


