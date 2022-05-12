package com.example.inscription.Controllers;

import com.example.inscription.Classes.Profil;
import com.example.inscription.Daos.ProfileDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Add_profilController {

    @FXML
    private Button BtnAjouterProfile;

    @FXML
    private TextField LibelleTextField;

    @FXML
    void Add_profile(ActionEvent event) {
        Profil profil = new Profil(LibelleTextField.getText());
        ProfileDao profileDao = new ProfileDao();
        if (profileDao.create(profil)) {
            RoutingClass.alert("Profil is successfully added!");
        } else {
            RoutingClass.alert("Profil already exists");

        }


    }

}
