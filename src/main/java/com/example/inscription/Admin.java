package com.example.inscription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Admin {
    private int code_admin;
    PreparedStatement pr;
    private String login,password;

    public Admin(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getCode_admin() {
        return code_admin;
    }

    public void setCode_admin(int code_admin) {
        this.code_admin = code_admin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public List<Profil> getProfil()
    {
        return null;
    }
    public boolean ajouter_profil(Profil profil, Connection Cx) throws SQLException {
        boolean state;

        try {
            //   java.sql.Statement st = Cx.createStatement();
            PreparedStatement pst = Cx.prepareStatement("insert into profil(libelle) values(?) ");
            pst.setString(1, profil.getLibelle());
            pst.executeUpdate();
            System.out.println("participant a été ajouté avec succès.");
            state = true;
        } catch (SQLException e) {
            state = false;
        }
        return state;
    }

    public boolean supprimer_profil(Profil profil,Connection Cx){
        boolean state = false;
        try
        {   java.sql.Statement st = Cx.createStatement();

            pr = Cx.prepareStatement("DELETE FROM profil(code_profil,libelle) where code_profil="+profil.getCode_profil());
            pr.executeUpdate();
        }
        catch (SQLException e) {
            state = false;
        }
        return state;

    }
    public boolean Chercher_profil(Profil profil ,Connection Cx){
        boolean state = false;
        try
        {   java.sql.Statement st = Cx.createStatement();

            pr = Cx.prepareStatement("SELECT  * FROM profil(code_profil,libelle) where code_profil="+profil.getCode_profil());
            pr.executeUpdate();

        }
        catch (SQLException e) {
            state = false;
        }
        return state;

    }

    public boolean modifiier_profil(Profil profil,Connection Cx){
        boolean state = false;
        try
        {   java.sql.Statement st = Cx.createStatement();

            pr = Cx.prepareStatement("UPDATE profil(code_profil,libelle) SET values (?,?)");
            pr.setInt(1, profil.getCode_profil());
            pr.setString(2, profil.getLibelle());
            pr.executeUpdate();
        }
        catch (SQLException e) {
            state = false;
        }
        return state;

    }
    public List<Domaine> getDomaine()
    {
        return null;
    }
    public boolean ajouter_domaine(Domaine domaine, Connection Cx) throws SQLException {
        boolean state;

        try {
            //   java.sql.Statement st = Cx.createStatement();
            PreparedStatement pst = Cx.prepareStatement("insert into domaine(libelle) values(?) ");
            pst.setString(1, domaine.getLibelle());
            pst.executeUpdate();
            System.out.println("participant a été ajouté avec succès.");
            state = true;
        } catch (SQLException e) {
            state = false;
        }
        return state;
    }

    public boolean supprimer_domaine(Domaine domaine,Connection Cx){
        boolean state = false;
        try
        {   java.sql.Statement st = Cx.createStatement();

            pr = Cx.prepareStatement("DELETE FROM domaine(code_domaine,libelle) where code_profil="+domaine.getCode_domaine());
            pr.executeUpdate();
        }
        catch (SQLException e) {
            state = false;
        }
        return state;

    }
    public boolean Chercher_domaine(Domaine domaine,Connection Cx){
        boolean state = false;
        try
        {   java.sql.Statement st = Cx.createStatement();

            pr = Cx.prepareStatement("SELECT  * FROM profil(code_domaine,libelle) where code_profil="+domaine.getCode_domaine());
            pr.executeUpdate();

        }
        catch (SQLException e) {
            state = false;
        }
        return state;

    }

    public boolean modifiier_domaine(Domaine domaine,Connection Cx){
        boolean state = false;
        try
        {   java.sql.Statement st = Cx.createStatement();

            pr = Cx.prepareStatement("UPDATE profil(code_domaine,libelle) SET values (?,?)");
            pr.setInt(1, domaine.getCode_domaine());
            pr.setString(2, domaine.getLibelle());
            pr.executeUpdate();
        }
        catch (SQLException e) {
            state = false;
        }
        return state;

    }



}
