package com.example.inscription;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.Alert.AlertType.ERROR;
import static javafx.scene.control.ButtonType.OK;

public class LoginView extends Application {
    Stage window;


    @FXML
    private Label sign_up;

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button sign_in;
    @FXML
    private Label Sign_up;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Pane root2 = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene sceneX = new Scene(root2, 1500, 870);
        sceneX.getStylesheets().addAll(this.getClass().getResource("login.css").toExternalForm());
        primaryStage.setMaximized(true);
        window.setScene(sceneX);
        window.setTitle("Sign in");
        window.show();
    }

    @FXML
    public void sign_up(javafx.scene.input.MouseEvent mouseEvent) throws Exception {
        Parent signUp = FXMLLoader.load(getClass().getResource("register.fxml"));
        Scene scene = new Scene(signUp, 1500, 870);
        scene.getStylesheets().add(this.getClass().getResource("login.css").toExternalForm());

        //This line gets the stage information
        window = (Stage) sign_up.getScene().getWindow();
        window.setScene(scene);
        window.setTitle("Sign up");
        window.setMaximized(true);
        window.show();
    }

    //Login-btn
    public void loginButtonOnAction(ActionEvent event) throws IOException {
        if (username.getText().isBlank() || password.getText().isBlank()) {
            alert("Please enter your password and username");


        } else {
            User user = new User(username.getText().trim(), password.getText());
            if (LoginController.validatelogin(user)) {
                Parent signUp = FXMLLoader.load(getClass().getResource("OK.fxml"));
                Scene scene = new Scene(signUp, 1500, 870);
                scene.getStylesheets().add(this.getClass().getResource("login.css").toExternalForm());

                //This line gets the stage information
                window = (Stage) sign_up.getScene().getWindow();
                window.setScene(scene);
                window.setTitle("Successfull Login");
                window.setMaximized(true);
                window.show();

            } else {
                alert("The entered password is wrong!");

            }

        }
    }

    // alerte
    private Alert alert(String alertText) {
        Alert alert = new Alert(ERROR, alertText, OK);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");
        alert.show();
        return alert;
    }


    public static void main(String[] args) {
        launch(args);
    }

}
