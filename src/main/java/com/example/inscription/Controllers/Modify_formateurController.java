package com.example.inscription.Controllers;

import com.example.inscription.Classes.Domaine;
import com.example.inscription.Classes.Formateur;
import com.example.inscription.Classes.Organisme;
import com.example.inscription.Daos.DomainDao;
import com.example.inscription.Daos.FormateurDao;
import com.example.inscription.Daos.OrganismeDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Modify_formateurController {

    @FXML
    private Button BtnModifierFormateur;

    @FXML
    private ChoiceBox<Domaine> CodedomaineChoiceBox;

    @FXML
    private ChoiceBox<Organisme> CodeorganismeChoiceBox;

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
    ObservableList<Organisme> list = FXCollections.observableArrayList(organismeDao.findAll());
    @FXML
    ObservableList<Domaine> list1 = FXCollections.observableArrayList(domainDao.findAll());

    @FXML
    private void initialize() {
        CodeorganismeChoiceBox.setItems(list);
        CodedomaineChoiceBox.setItems(list1);

    }
//TODO mmake list changes in the updates

    @FXML
    void Modify_Formateur(ActionEvent event) {
       /* Formateur formateur = new Formateur(Integer.parseInt(IDTextField.getText()),Integer.parseInt(NumtelTextField.getText()), NomTextField.getText(),
                PrenomTextField.getText(), EmailTextField.getText(),Integer.parseInt(CodeorganismeChoiceBox.getValue().toString()),
                Integer.parseInt(CodedomaineChoiceBox.getValue().toString()));*/
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Formateur formateur = (Formateur) stage.getUserData();
        if (!NumtelTextField.getText().isEmpty()) {
            formateur.setN_tel(Integer.parseInt(NumtelTextField.getText().trim()));
        }
        if (!NomTextField.getText().isEmpty())
        {
            formateur.setNom(NomTextField.getText().trim());
        }
        if (!PrenomTextField.getText().isEmpty())
        {
            formateur.setNom(PrenomTextField.getText().trim());
        }
        if (!EmailTextField.getText().isEmpty())
        {
            formateur.setNom(EmailTextField.getText().trim());
        }
        if (CodeorganismeChoiceBox.getSelectionModel().getSelectedIndex()>-1) {
            formateur.setCode_organisme(CodeorganismeChoiceBox.getValue().getCode_organisme());
        }
        if (CodedomaineChoiceBox.getSelectionModel().getSelectedIndex()>-1) {
            formateur.setCode_domaine(CodedomaineChoiceBox.getValue().getCode_domaine());
        }

        FormateurDao formateurDao = new FormateurDao();
        if (formateurDao.update(formateur)) {
            RoutingClass.alert("success");
        } else {
            RoutingClass.alert("problem");

        }

    }

}
