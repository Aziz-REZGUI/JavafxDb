package com.example.inscription.Controllers;

import com.example.inscription.Classes.User;
import com.example.inscription.Daos.UserDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Delete_userController {

    @FXML
    private Button BtnDelete;

    @FXML
    private TextField CodeutilisateurTextField;


    @FXML
    public void Supprimer_user(ActionEvent event) {


        User user = new User(CodeutilisateurTextField.getText());

        UserDao userDao = new UserDao();
        if (userDao.exists(user)) {
            userDao.delete(user);
        } else {
            RoutingClass.alert("This ID doesn't exist try again");


        }
    }
       /* private void MsgErreur() {
            FadeTransition ft = new FadeTransition(Duration.millis(1000), ErreurLabel);
            ft.setFromValue(0.0);
            ft.setToValue(1);
            ft.play();
        }

        */
}
