package com.example.inscription.Controllers;

import com.example.inscription.Classes.Domaine;
import com.example.inscription.Daos.DomainDao;
import javafx.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Modify_domaineController {




        @FXML
        private Button BtnUpdatedomaine;

        @FXML
        private TextField FormationTextField;

        @FXML
        private TextField IDTextField;

        @FXML
        private TextField LibelleTextField;

        @FXML
    public void Update_domaine(ActionEvent event) {
            Domaine domaine = new Domaine(Integer.parseInt(IDTextField.getText().trim()), LibelleTextField.getText());
            DomainDao domaineDao = new DomainDao();
            if (domaineDao.update(domaine)) {
                RoutingClass.alert("success");

            } else {
                RoutingClass.alert("problem");

            }

        }
    }
