package com.example.inscription.Controllers;

import com.example.inscription.Classes.User;
import com.example.inscription.Daos.UserDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Modify_userController {
    @FXML
    ObservableList<String> list= FXCollections.observableArrayList("Admin", "User");
    @FXML
    ChoiceBox roleChoiceBox;
@FXML
    TextField IDTextField,emailTextField,passwordTextField;


    @FXML
    private void initialize()
    {   roleChoiceBox.setItems(list);
        roleChoiceBox.setValue("Role");
    }


// lezem ya3rfou by ID
    public void Update_user(ActionEvent event) {
        User user= new User(emailTextField.getText().trim(), passwordTextField.getText());
        UserDao userDao=new UserDao();
        userDao.update(user);

    }
}
