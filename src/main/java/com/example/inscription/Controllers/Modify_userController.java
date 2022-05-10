package com.example.inscription.Controllers;

import com.example.inscription.Classes.Participant;
import com.example.inscription.Classes.User;
import com.example.inscription.Daos.UserDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.ZoneId;
import java.util.Date;

public class Modify_userController {

    @FXML
    ObservableList<String> list = FXCollections.observableArrayList("Admin", "User");
    @FXML
    ChoiceBox roleChoiceBox;
    @FXML
    TextField IDTextField, EmaillTextField, passwordTextField;

    @FXML
    Label successLabel;

    @FXML
    private void initialize() {
        roleChoiceBox.setItems(list);
        roleChoiceBox.setValue("Role");
        successLabel.setText("");
    }


    public void Update_user(ActionEvent event) {
        //TODO add fullname
        //User user = new User(Integer.parseInt(IDTextField.getText().trim()), EmaillTextField.getText(), passwordTextField.getText(), "test", roleChoiceBox.getValue().toString());
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        User user = (User) stage.getUserData();
        if (!EmaillTextField.getText().isEmpty()) {
            user.setLogin(EmaillTextField.getText().trim());
        }
        if (!passwordTextField.getText().isEmpty()) {
            user.setPassword(passwordTextField.getText().trim());
        }
        if (roleChoiceBox.getSelectionModel().getSelectedIndex() > -1) {
            user.setRole(roleChoiceBox.getSelectionModel().getSelectedItem().toString());
        }
        UserDao userDao = new UserDao();
        if (userDao.update(user)) {
            successLabel.setText("success");
        } else {
            successLabel.setText("problem");
        }

    }
}
