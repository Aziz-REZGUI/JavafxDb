package com.example.inscription.Controllers;

import com.example.inscription.Classes.Formateur;
import com.example.inscription.Classes.Organisme;
import com.example.inscription.Daos.FormateurDao;
import com.example.inscription.Daos.OrganismeDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Modify_OrganismeController {

    @FXML
    private Button BtnModifierOrganisme;

    @FXML
    private TextField CodeOrganismeTextField;

    @FXML
    private TextField LibelleTextField;

    @FXML
    void Modify_organisme(ActionEvent event) {
        Organisme organisme = new Organisme(LibelleTextField.getText().trim());
        OrganismeDao organismeDao = new OrganismeDao();
        if (organismeDao.update(organisme)){
            RoutingClass.alert("success");
        } else {
            RoutingClass.alert("problem");

        }


    }

}
