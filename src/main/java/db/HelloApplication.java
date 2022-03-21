package db;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.Connection;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
       // launch();
        Scanner sc = new Scanner(System.in);
        Connection conn = DatabaseHandler.databaseConnect();
        System.out.println("Entrez le login : ");
        String login = sc.next();
        System.out.println("Entrez le mot de passe  : ");
        String password = sc.next();
        //System.out.println("Entrez le role : ");
        //String role = sc.next();
        User user = new User(login, password);
        DatabaseHandler db = new DatabaseHandler();

        //db.addUser(conn,user);
        if(db.login(conn,user)){
            System.out.println("login avec succes ");
        }
        else
        {
            System.out.println("check info's");
        }


    }
}