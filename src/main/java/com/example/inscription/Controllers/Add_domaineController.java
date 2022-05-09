package com.example.inscription.Controllers;

import com.example.inscription.Classes.Domaine;
import com.example.inscription.Daos.DomainDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
        if (!domainDao.exists(LibelleTextField.getText().trim())) {
            if (domainDao.create(domaine)) {
                RoutingClass.alert("Domain is successfully added!");
            } else {
                RoutingClass.alert("problem");

            }
        } else {
            RoutingClass.alert("domain already exists");
        }


    }

}
