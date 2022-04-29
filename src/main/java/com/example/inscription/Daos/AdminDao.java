package com.example.inscription.Daos;

import com.example.inscription.Classes.Admin;
import com.example.inscription.Classes.Domaine;
import com.example.inscription.Databaseconnection;
import com.example.inscription.Interfaces.Crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDao implements Crud<Admin> {
    Connection c = Databaseconnection.getConnection();
    PreparedStatement pr = null;

    @Override
    public boolean create(Admin admin) {
        boolean state;

        try {
            //   java.sql.Statement st = c.createStatement();
            PreparedStatement pst = c.prepareStatement("insert into admin(code_admin, login, password) values(?,?,?) ");
            pst.setInt(1, admin.getCode_admin());
            pst.setString(2, admin.getLogin());
            pst.setString(3, admin.getPassword());
            pst.executeUpdate();
            System.out.println("admin a été ajouté avec succès.");
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;
    }

    @Override
    public boolean update(Admin admin) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            pr = c.prepareStatement("UPDATE admin SET login=?,password=? where code_admin=? ");
            pr.setString(1, admin.getLogin());
            pr.setString(2, admin.getPassword());
            pr.setInt(3, admin.getCode_admin());
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
        return state;

    }

    @Override
    public boolean delete(Admin admin) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            pr = c.prepareStatement("DELETE FROM admin where code_admin=" + admin.getCode_admin());
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return state;
    }

    @Override
    public List<Admin> findAll() {
        List<Admin> output = new ArrayList<>();
        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  * FROM domaine");

            while (resultSet.next()) {
                Admin temp = new Admin(resultSet.getInt("code_admin"), resultSet.getString("login"), resultSet.getString("password"));
                output.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return output;
    }

    @Override
    public boolean exists(Admin admin) {
        boolean state = false;
        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  * FROM admin where code_admin=" + admin.getCode_admin());

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
