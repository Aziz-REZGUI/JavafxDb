package com.example.inscription.Controllers;

import com.example.inscription.Classes.User;
import com.example.inscription.Daos.UserDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

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


    public void Update_user(ActionEvent event) {
        User user= new User(IDTextField.getText().trim(),emailTextField.getText(),passwordTextField.getText());
        UserDao userDao=new UserDao();
        userDao.update(user);

    }
}
