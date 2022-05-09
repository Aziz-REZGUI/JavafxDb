package com.example.inscription.Controllers;

import com.example.inscription.Classes.Domaine;
import com.example.inscription.Classes.Organisme;
import com.example.inscription.Daos.DomainDao;
import com.example.inscription.Daos.OrganismeDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Add_OrganismeController {

        @FXML
        private Button BtnAjouterOrganisme;

        @FXML
        private TextField LibelleTextField;

        @FXML
        void Add_organisme(ActionEvent event) {
                Organisme organisme = new Organisme(LibelleTextField.getText().trim());
                OrganismeDao organismeDao = new OrganismeDao();

           if(!organismeDao.exists(LibelleTextField.getText().trim())) {
                if (organismeDao.create(organisme)) {
                    RoutingClass.alert("Organisme is successfully added!");
                } else {
                    RoutingClass.alert("problem");


                }

            }
           else
           {
               RoutingClass.alert("organisme already exists");
           }
            }

        }



