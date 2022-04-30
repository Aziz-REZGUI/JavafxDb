package com.example.inscription.Controllers;

import com.example.inscription.Classes.User;
import com.example.inscription.Daos.UserDao;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class Add_userController {
    @FXML
    Label successLabel;
    @FXML
    Button CancelButton;
    @FXML
    TextField emailTextField,passwordTextField;



// raka7 ilcode mte3ek 3leha

    public void Ajouter_user(ActionEvent event) {

            if((emailTextField.getText().matches("\\b[a-z0-9._-]+@[a-z0-9.-]+\\.[a-z]{2,}\\b"))&&(!passwordTextField.getText().isBlank())) {
               //t3ayet aka ajouter user
               User user= new User(emailTextField.getText().trim(), passwordTextField.getText());
                UserDao userDao=new UserDao();
                userDao.create(user);
                //TODO verify with abir

                //emailTextField.setText(emailTextField.getText());

                successLabel.setText("User successfully added!");
                MsgErreur();
            } else {
                successLabel.setText("Enter a valid email address (example@example.com).");
                MsgErreur();
            }

    }
    public void cancelButton(ActionEvent event) throws Exception {
        //TODO add cancel

    }
    private void MsgErreur() {
        FadeTransition ft = new FadeTransition(Duration.millis(1000), successLabel);
        ft.setFromValue(0.0);
        ft.setToValue(1);
        ft.play();
    }
}
