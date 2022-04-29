package com.example.inscription.Classes;

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



}
