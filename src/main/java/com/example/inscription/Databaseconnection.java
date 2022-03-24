package com.example.inscription;

import java.sql.*;


public class Databaseconnection {

    PreparedStatement pr = null;

    public static Connection getConnection() {
        Connection databaselink = null;
        String url = "jdbc:mysql://localhost:3306/db_formation";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink = DriverManager.getConnection(url, user, password);
            System.out.println("connexion établie.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("erreur de connexion !");
            e.printStackTrace();
            e.getCause();
        }
        return databaselink;
    }

    public boolean login(Connection cn, User user) {
        boolean state = false;
        try {
            pr = cn.prepareStatement("select count(1) from utilisateur where login = '" + user.getLogin() + "' and password = '" + user.getPassword() + "'");
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
    }

    public boolean addUser(Connection cn, User user) throws SQLException {

        //Statement statement = cn.createStatement();
        boolean state;
        try {
            //statement.executeUpdate("INSERT INTO utilisateur (login,password,full_name,role) VALUES ('" + user.getLogin() + "','" + user.getPassword() + "','" + user.getFullname() + "','" + user.getRole() + "')");
            pr = cn.prepareStatement("insert into utilisateur(login,password,full_name,role) values(?,?,?,?)");
            // pr.setInt(1, eid);
            pr.setString(1, user.getLogin());
            pr.setString(2, user.getPassword());
            pr.setString(3, user.getFullname());
            pr.setString(4, user.getRole());
            pr.executeUpdate();
            System.out.println("L'utilisateur a été ajouté avec succès.");
            state = true;
        } catch (SQLException e) {
            state = false;
        }
        return state;
    }
}

