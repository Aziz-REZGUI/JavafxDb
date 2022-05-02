package com.example.inscription.Controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class RoutingClass  extends Application {
    @Override
     public void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(this.getClass().getResource("/views/login.fxml"));
        Scene sceneX = new Scene(root, 1500, 870);
        sceneX.getStylesheets().addAll(this.getClass().getResource("/views/login.css").toExternalForm());
        primaryStage.setMaximized(true);
        primaryStage.setScene(sceneX);
        primaryStage.setTitle("Sign in");
        primaryStage.show();
    }
    static public void goTo(Stage stage,String fileName ,String title, float width,float height) throws IOException {
        Parent signUp = FXMLLoader.load(RoutingClass.class.getResource("/views/"+fileName));
        Scene scene = new Scene(signUp, width, height);
        scene.getStylesheets().add(RoutingClass.class.getResource("/views/login.css").toExternalForm());

        //This line gets the stage information
        stage = (Stage) stage.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setMaximized(true);
        stage.show();
    }
    static public void goTo(Stage stage,String fileName ,String title) throws IOException {
        Parent signUp = FXMLLoader.load(RoutingClass.class.getResource("/views/"+fileName));
        Scene scene = new Scene(signUp, 1500, 870);
        scene.getStylesheets().add(RoutingClass.class.getResource("/views/login.css").toExternalForm());

        //This line gets the stage information
        stage = (Stage) stage.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setMaximized(true);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
