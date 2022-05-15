package com.example.inscription.Controllers;

import com.example.inscription.Classes.Profil;
import com.example.inscription.Daos.ProfileDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Add_profilController {

    @FXML
    private TextField LibelleTextField;

    @FXML
    void Add_profile(ActionEvent event) {
        ProfileDao profileDao = new ProfileDao();

        if (LibelleTextField.getText().isEmpty()) {
            RoutingClass.alert("Veillez remplir tous les champs ");

        } else {
            Profil profil = new Profil(LibelleTextField.getText());
            if (!profileDao.exists(profil)) {
                if (profileDao.create(profil)) {
                    RoutingClass.alert("Profil is successfully added!");
                } else {
                    RoutingClass.alert("problem");

                }
            } else {
                RoutingClass.alert("profile alrady exists");
            }
        }


    }

}
