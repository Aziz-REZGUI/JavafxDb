package com.example.inscription.Controllers;

import com.example.inscription.Classes.Domaine;
import com.example.inscription.Classes.User;
import com.example.inscription.Daos.DomainDao;
import com.example.inscription.Daos.UserDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Add_domaineController {
        @FXML
        Button CancelButton;
        @FXML
        TextField LibelleTextField, FormationTextField;

    @FXML
    public void Add_domain(ActionEvent event) {

            Domaine domaine = new Domaine(LibelleTextField.getText().trim());
            DomainDao domainDao = new DomainDao();
            if (domainDao.create(domaine)) {
                RoutingClass.alert("Domain is successfully added!");
            } else {
                RoutingClass.alert("problem");

            }


        }

}
