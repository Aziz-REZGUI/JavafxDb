package com.example.inscription.Controllers;

import com.example.inscription.Classes.User;
import com.example.inscription.Daos.UserDao;
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

    @FXML
    public void sign_up(javafx.scene.input.MouseEvent mouseEvent) throws Exception {
        RoutingClass.goTo((Stage) sign_up.getScene().getWindow(),"register.fxml","Sign up");
        /*Parent signUp = FXMLLoader.load(this.getClass().getResource("/views/register.fxml"));
        Scene scene = new Scene(signUp, 1500, 870);
        scene.getStylesheets().add(this.getClass().getResource("/views/login.css").toExternalForm());

        //This line gets the stage information
        window = (Stage) sign_up.getScene().getWindow();
        window.setScene(scene);
        window.setTitle("Sign up");
        window.setMaximized(true);
        window.show();*/
    }

    public void loginButtonOnAction(ActionEvent event) throws IOException {
        if (username.getText().isBlank() || password.getText().isBlank()) {
            alert("Please enter your password and username");


        } else {
            user = new User(username.getText().trim(), password.getText());
            UserDao userDao = new UserDao();
            if (userDao.login(user)) {
                RoutingClass.goTo((Stage) sign_up.getScene().getWindow(),"MenuAdmin.fxml","Menuadmin ",778,563);
               /* Parent signUp = FXMLLoader.load(this.getClass().getResource("/views/MenuAdmin.fxml"));
                Scene scene = new Scene(signUp, 778, 563);
                //scene.getStylesheets().add(this.getClass().getResource("/views/login.css").toExternalForm());

                //This line gets the stage information
                window = (Stage) sign_up.getScene().getWindow();
                window.setScene(scene);
                window.setTitle("Menuadmin ");
                window.setMaximized(true);
                window.show();*/

            } else {
                alert("The entered password is wrong!");

            }

        }
    }


    public static Alert alert(String alertText) {
        Alert alert = new Alert(ERROR, alertText, OK);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(LoginController.class.getResource("/views/login.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");
        alert.show();
        return alert;
    }








}


