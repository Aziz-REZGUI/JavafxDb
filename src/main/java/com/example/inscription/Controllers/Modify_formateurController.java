package com.example.inscription.Controllers;

import com.example.inscription.Classes.Formateur;
import com.example.inscription.Daos.DomainDao;
import com.example.inscription.Daos.FormateurDao;
import com.example.inscription.Daos.OrganismeDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Modify_formateurController {

    @FXML
    private Button BtnModifierFormateur;

    @FXML
    private ChoiceBox<Integer> CodedomaineChoiceBox;

    @FXML
    private ChoiceBox<Integer> CodeorganismeChoiceBox;

    @FXML
    private TextField EmailTextField;

    @FXML
    private TextField IDTextField;

    @FXML
    private TextField NomTextField;

    @FXML
    private TextField NumtelTextField;

    @FXML
    private TextField PrenomTextField;

    OrganismeDao organismeDao = new OrganismeDao();
    DomainDao domainDao = new DomainDao();
    @FXML
    ObservableList<Integer> list = FXCollections.observableArrayList(organismeDao.findIds());
    @FXML
    ObservableList<Integer> list1 = FXCollections.observableArrayList(domainDao.findIds());
    @FXML
    private void initialize() {
        CodeorganismeChoiceBox.setItems(list);
        CodedomaineChoiceBox.setItems(list1);

    }

    @FXML
    void Modify_Formateur(ActionEvent event) {
        Formateur formateur = new Formateur(Integer.parseInt(IDTextField.getText()),Integer.parseInt(NumtelTextField.getText()), NomTextField.getText(),
                PrenomTextField.getText(), EmailTextField.getText(),Integer.parseInt(CodeorganismeChoiceBox.getValue().toString()),
                Integer.parseInt(CodedomaineChoiceBox.getValue().toString()));
        FormateurDao formateurDao = new FormateurDao();
        if (formateurDao.update(formateur)){
            RoutingClass.alert("success");
        } else {
            RoutingClass.alert("problem");

        }

    }

}
