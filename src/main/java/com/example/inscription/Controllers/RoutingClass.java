package com.example.inscription.Controllers;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Optional;

import static javafx.scene.control.Alert.AlertType.ERROR;
import static javafx.scene.control.ButtonType.OK;

public class RoutingClass<S> extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(this.getClass().getResource("/views/login.fxml"));
        Scene sceneX = new Scene(root, 450, 650);
        sceneX.getStylesheets().addAll(this.getClass().getResource("/views/login.css").toExternalForm());

        primaryStage.setScene(sceneX);
        primaryStage.setTitle("Sign in");
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    static public void goTo(Stage stage, String fileName, String title, float width, float height) throws IOException {
        Parent signUp = FXMLLoader.load(RoutingClass.class.getResource("/views/" + fileName));
        Scene scene = new Scene(signUp, width, height);
        scene.getStylesheets().add(RoutingClass.class.getResource("/views/login.css").toExternalForm());

        //This line gets the stage information
        stage = (Stage) stage.getScene().getWindow();
        stage.setScene(scene);

        stage.setTitle(title);
        stage.setResizable(false);


        stage.show();
    }

    static public void goTo(Stage stage, String fileName, String title, float width, float height, Object data) throws IOException {
        Parent signUp = FXMLLoader.load(RoutingClass.class.getResource("/views/" + fileName));
        Scene scene = new Scene(signUp, width, height);
        scene.getStylesheets().add(RoutingClass.class.getResource("/views/login.css").toExternalForm());

        //This line gets the stage information
        stage = (Stage) stage.getScene().getWindow();
        stage.setScene(scene);
        stage.setUserData(data);
        stage.setTitle(title);
        stage.setResizable(false);


        stage.show();
    }

    static public void goTo(String fileName, String title, float width, float height, Object data) throws IOException {
        Stage SecondStage = new Stage();
        Pane root = FXMLLoader.load(RoutingClass.class.getResource("/views/" + fileName));
        Scene sceneX = new Scene(root, width, height);
        SecondStage.setScene(sceneX);
        SecondStage.setUserData(data);
        SecondStage.setTitle(title);
        SecondStage.setResizable(false);

        SecondStage.show();
    }

    static public void goTo(Stage stage, String fileName, String title) throws IOException {
        Parent signUp = FXMLLoader.load(RoutingClass.class.getResource("/views/" + fileName));
        Scene scene = new Scene(signUp, 1500, 870);
        scene.getStylesheets().add(RoutingClass.class.getResource("/views/login.css").toExternalForm());

        //This line gets the stage information
        stage = (Stage) stage.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(title);

        stage.show();
    }

    static public void goTo(String fileName, String title, float width, float height) throws IOException {
        Stage SecondStage = new Stage();
        Pane root = FXMLLoader.load(RoutingClass.class.getResource("/views/" + fileName));
        Scene sceneX = new Scene(root, width, height);
        //sceneX.getStylesheets().add(RoutingClass.class.getResource("/views/login.css").toExternalForm());


        SecondStage.setScene(sceneX);
        SecondStage.setTitle(title);
        SecondStage.show();
    }

    public static void MsgErreur(Label label) {
        FadeTransition ft = new FadeTransition(Duration.millis(1000), label);
        ft.setFromValue(0.0);
        ft.setToValue(1);
        ft.play();
    }


    public static void alert(String alertText) {
        Alert alert = new Alert(ERROR, alertText, OK);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(RoutingClass.class.getResource("/views/login.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");
        alert.show();
    }
    public static void alertDelete (String alertText){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de supprisstion");
        alert.setHeaderText(null);
        alert.setContentText("Êtes-vous sûr de vouloir supprimer?");
        Optional<ButtonType> action = alert.showAndWait();

    }


    //TODO delete all cumntss after checking with abir
    public static void main(String[] args) {
        launch(args);
    }

}
