package com.example.inscription.Controllers;

import com.example.inscription.Classes.User;
import com.example.inscription.Daos.UserDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginController {
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
    User user;

    /*@Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(this.getClass().getResource("/views/login.fxml"));
        Scene sceneX = new Scene(root, 1500, 870);
        sceneX.getStylesheets().addAll(this.getClass().getResource("/views/login.css").toExternalForm());
        primaryStage.setMaximized(true);
        primaryStage.setScene(sceneX);
        primaryStage.setTitle("Sign in");
        primaryStage.show();
    }*/

    /*@FXML
    public void sign_up(javafx.scene.input.MouseEvent mouseEvent) throws Exception {
        RoutingClass.goTo((Stage) sign_up.getScene().getWindow(), "register.fxml", "Sign up");

    }*/

    public void loginButtonOnAction(ActionEvent event) throws IOException {
        if (username.getText().isBlank() || password.getText().isBlank()) {
            RoutingClass.alert("Please enter your password and username");


        } else {
            user = new User(username.getText().trim(), password.getText());
            UserDao userDao = new UserDao();
            if (userDao.login(user)) {
                if (userDao.isAdmin(user)) {
                    RoutingClass.goTo((Stage) sign_up.getScene().getWindow(), "MenuAdmin.fxml", "Menuadmin ", 778, 569);
                } else {
                    RoutingClass.goTo((Stage) sign_up.getScene().getWindow(), "MenuUser.fxml", "MenuUser ", 778, 569);
                }

            } else {
                RoutingClass.alert("The entered password is wrong!");

            }

        }
    }




}


