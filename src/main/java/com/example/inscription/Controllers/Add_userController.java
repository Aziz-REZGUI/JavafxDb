package com.example.inscription.Controllers;

import com.example.inscription.Classes.User;
import com.example.inscription.Daos.UserDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Add_userController {
    @FXML
    ObservableList<String> list = FXCollections.observableArrayList("Admin", "User");
    @FXML
    Label successLabel;
    @FXML
    Button CancelButton;
    @FXML
    TextField emailTextField, passwordTextField;
    @FXML
    ChoiceBox roleChoiceBox;


    @FXML
    private void initialize() {
        roleChoiceBox.setItems(list);
        roleChoiceBox.setValue("Role");
        successLabel.setText("");
    }


    public void Ajouter_user(ActionEvent event) {

        //if((emailTextField.getText().matches("\\b[a-z0-9._-]+@[a-z0-9.-]+\\.[a-z]{2,}\\b"))&&(!passwordTextField.getText().isBlank())) {
        User user = new User(emailTextField.getText().trim(), passwordTextField.getText(), "test", roleChoiceBox.getValue().toString());
        UserDao userDao = new UserDao();
        if(!(userDao.exists(emailTextField.getText().trim()))){
            if (userDao.create(user)) {
                successLabel.setText("success");
                RoutingClass.alert("The user is successfully added!");
            } else {
                successLabel.setText("problem");

            }
        }
        else {
           // RoutingClass.alert("Username exists");
            successLabel.setText("username exists");
        }


        //successLabel.setText("User successfully added!");
        //MsgErreur();
        //} else {
        //   successLabel.setText("Enter a valid email address .");
        // MsgErreur();
        //}

    }

    /*private void MsgErreur() {
        FadeTransition ft = new FadeTransition(Duration.millis(1000), successLabel);
        ft.setFromValue(0.0);
        ft.setToValue(1);
        ft.play();
    }*/
}
