package com.example.inscription.Controllers;

import com.example.inscription.Classes.Formateur;
import com.example.inscription.Classes.Formation;
import com.example.inscription.Daos.FormateurDao;
import com.example.inscription.Daos.FormationDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Add_formateurController {

    @FXML
    private Button BtnAjouterFormateur;

    @FXML
    private ChoiceBox<?> CodedomaineChoiceBox;

    @FXML
    private ChoiceBox<?> CodeorganismeChoiceBox;

    @FXML
    private TextField EmailTextField;

    @FXML
    private TextField NomTextField;

    @FXML
    private TextField NumtelTextField;

    @FXML
    private TextField PrenomTextField;

    @FXML
    void Add_Formateur(ActionEvent event) {
        Formateur formateur = new Formateur(Integer.parseInt(NumtelTextField.getText()), NomTextField.getText(),
        PrenomTextField.getText(), EmailTextField.getText(),Integer.parseInt(CodeorganismeChoiceBox.getValue().toString()),
                Integer.parseInt(CodedomaineChoiceBox.getValue().toString()));
        FormateurDao formateurDao = new FormateurDao();
        if (formateurDao.create(formateur)) {
            RoutingClass.alert("Formateur is successfully added!");
        } else {
            RoutingClass.alert("problem");


        }



    }

}
