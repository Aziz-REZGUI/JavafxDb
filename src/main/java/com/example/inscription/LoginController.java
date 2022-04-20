package com.example.inscription;

import java.sql.Connection;


public class LoginController {

    public static boolean validatelogin(User user) {

        Connection connectDB = Databaseconnection.getConnection();
        // Databaseconnection con = new Databaseconnection();
        return user.login(connectDB);


    }


}


