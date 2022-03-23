package com.example.inscription;


import java.sql.Connection;
import java.sql.SQLException;


public class RegisterController {
    public static boolean validateRegister(User user) throws SQLException {
        Connection connectDB = Databaseconnection.getConnection();
        Databaseconnection con = new Databaseconnection();

        return con.addUser(connectDB, user);
    }

}





