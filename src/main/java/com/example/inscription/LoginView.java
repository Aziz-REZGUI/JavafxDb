package com.example.inscription;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginView extends Application {
    private Stage stage;
    private Scene scene;
    @FXML
    private Label loginMessagelabel;
    @FXML
    private TextField Usernamefield;
    @FXML
    private PasswordField passwordfield;

    @FXML
    private Button Sign_up;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginView.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void gotosignupAction(ActionEvent event) throws IOException {
        if (event.getSource() == Sign_up) {
            FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("register.fxml"));
            Scene scene2 = new Scene(fxmlLoader2.load());
            stage = (Stage) Sign_up.getScene().getWindow();
            stage.setScene(scene2);
            stage.setTitle("Sign up");
            stage.show();


        }
    }


    public void loginButtonOnAction(ActionEvent event) {
        if (Usernamefield.getText().isBlank() || passwordfield.getText().isBlank()) {
            loginMessagelabel.setText("Please enter your password and username");

        } else {
            User user = new User(Usernamefield.getText().trim(), passwordfield.getText());
            if (LoginController.validatelogin(user)) {
                loginMessagelabel.setText("loogin successfuly");
            } else {
                loginMessagelabel.setText("verify your data");

            }

        }
    }


    public static void main(String[] args) {
        launch();
    }

}
