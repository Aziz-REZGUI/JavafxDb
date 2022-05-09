package com.example.inscription.Controllers;

import com.example.inscription.Classes.Profil;
import com.example.inscription.Daos.ProfileDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Modify_profilController {

    @FXML
    private Button BtnUpdateprofil;

    @FXML
    private TextField LibelleTextField;

    @FXML
    void Update_domaine(ActionEvent event) {

        Profil profil = new Profil(LibelleTextField.getText());
        ProfileDao profileDao = new ProfileDao();
        if (profileDao.update(profil)) {
            RoutingClass.alert("success");
        } else {
            RoutingClass.alert("problem");

        }

    }

    }











