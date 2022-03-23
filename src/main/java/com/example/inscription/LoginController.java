package com.example.inscription;

import java.sql.Connection;

public class LoginController {

    public static boolean validatelogin(User user) {

        Connection connectDB = Databaseconnection.getConnection();
        Databaseconnection con = new Databaseconnection();
        if (con.login(connectDB, user)) {
            return true;
        } else {

            return false;
        }

    }


}


