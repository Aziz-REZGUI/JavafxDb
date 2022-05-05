package com.example.inscription.Controllers;

import com.example.inscription.Classes.Formateur;
import com.example.inscription.Classes.Formation;
import com.example.inscription.Daos.FormateurDao;
import com.example.inscription.Daos.FormationDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Delete_formationController {

    @FXML
    private Button BtnDelete;

    @FXML
    private TextField CodeformationTextField;

    @FXML
    void Supprimer_formation(ActionEvent event) {
        Formation formation = new Formation(Integer.parseInt(CodeformationTextField.getText()));
        FormationDao formationDao = new FormationDao();
        if (formationDao.exists(formation)) {
            formationDao.delete(formation) ;
            RoutingClass.alert("Success");

        } else {
            RoutingClass.alert("This ID doesn't exist try again");


        }

    }

}
