package com.example.inscription.Controllers;

import com.example.inscription.Classes.Organisme;
import com.example.inscription.Classes.Profil;
import com.example.inscription.Daos.ProfileDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Modify_profilController {

    @FXML
    private Button BtnUpdateprofil;

    @FXML
    private TextField LibelleTextField;

    @FXML
    void Update_domaine(ActionEvent event) {

//        Profil profil = new Profil(LibelleTextField.getText());
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Profil profil = (Profil) stage.getUserData();
        if (!LibelleTextField.getText().isEmpty())
        {
            profil.setLibelle(LibelleTextField.getText().trim());
        }
        ProfileDao profileDao = new ProfileDao();
        if (profileDao.update(profil)) {
            RoutingClass.alert("success");
        } else {
            RoutingClass.alert("problem");

        }

    }

    }











