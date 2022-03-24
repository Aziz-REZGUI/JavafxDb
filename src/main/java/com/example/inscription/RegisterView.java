package com.example.inscription;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

import static javafx.scene.control.Alert.AlertType.INFORMATION;
import static javafx.scene.control.ButtonType.OK;

public class RegisterView {
    private Stage stage;

    @FXML
    private Label sign_in;
    @FXML
    private TextField text_username;
    @FXML
    private PasswordField txt_password;
    @FXML
    private TextField txt_fullname;
    @FXML
    private Button Btn_signin;

    @FXML
    public void RegisterButtonOnAction(ActionEvent event) throws SQLException {

        String fullname = txt_fullname.getText().trim();
        String username = text_username.getText().trim();
        String password = txt_password.getText();
        if (username.isEmpty() || password.isEmpty() || fullname.isEmpty()) {
            alert("Please enter your data");
        } else {
            User user = new User(fullname, username, password);

            if (RegisterController.validateRegister(user)) {
                alert("Welcome");
                // TODO check exisatance
            } else {
                alert("operation echoué");
            }
        }


    }


    private Alert alert(String alertText) {
        Alert alert = new Alert(INFORMATION, alertText, OK);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");
        alert.show();
        return alert;
    }


    // To go to the login page
    @FXML
    public void sign_in(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent signUp = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(signUp, 1500, 870);
        scene.getStylesheets().add(this.getClass().getResource("login.css").toExternalForm());

        //This line gets the stage information
        stage = (Stage) sign_in.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Sign up");
        stage.setMaximized(true);
        stage.show();
    }


}
