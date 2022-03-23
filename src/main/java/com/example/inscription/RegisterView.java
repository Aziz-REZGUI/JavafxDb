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
import java.sql.SQLException;


public class RegisterView extends Application {
    @FXML
    private Label RegisterMessagelabel;
    @FXML
    private TextField txt_username;
    @FXML
    private PasswordField txt_password;
    @FXML
    private TextField txt_fullname;
    @FXML
    private Button btn_signup;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RegisterView.class.getResource("register.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 700);

        stage.setTitle("Signup");
        stage.setScene(scene);
        stage.show();
    }


    public void registerButtonOnAction(ActionEvent event) throws SQLException {

        String fullname = txt_fullname.getText().trim();
        String username = txt_username.getText().trim();
        String password = txt_password.getText();
        if (username.isEmpty() && password.isEmpty() && fullname.isEmpty()) {
            RegisterMessagelabel.setText("Please enter your data");
        }
       /* else{ if (password.isEmpty()) {
            RegisterMessagelabel.setText("Empty Password Please fill in the password");

        } else if (username.isEmpty()) {
            RegisterMessagelabel.setText("Empty Username Please fill in the Username");

        } else if (fullname.isEmpty()) {
            RegisterMessagelabel.setText("Empty Fullname Please fill in the name");

        } */else {
            {
                User user = new User(fullname,username, password);

                if (RegisterController.validateRegister(user)) {
                    RegisterMessagelabel.setText("Welcome");
                } else {
                    RegisterMessagelabel.setText("operation echoué");
                }
            }


        }


    }


    public static void main(String[] args) {
        launch(args);

    }

}
