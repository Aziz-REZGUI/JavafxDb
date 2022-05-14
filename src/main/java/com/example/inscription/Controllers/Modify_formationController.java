package com.example.inscription.Controllers;

import com.example.inscription.Classes.Domaine;
import com.example.inscription.Classes.Formateur;
import com.example.inscription.Classes.Formation;
import com.example.inscription.Daos.DomainDao;
import com.example.inscription.Daos.FormateurDao;
import com.example.inscription.Daos.FormationDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Modify_formationController {

    @FXML
    private Button BtnmodifierFormation;

    @FXML
    private TextField Code_formateurTextField;

    @FXML
    private ChoiceBox<Domaine> CodedomaineChoiceBox;

    @FXML
    private ChoiceBox<Formateur> CodeformateurChoiceBox;

    @FXML
    private TextField IDTextField;

    @FXML
    private TextField NbParticipantTextField;

    @FXML
    private TextField NbjourTextField;

    @FXML
    private TextField anneeTextField;

    @FXML
    private TextField intituleTextField;

    @FXML
    private TextField moisTextField;
    FormateurDao formateurDao = new FormateurDao();
    DomainDao domainDao = new DomainDao();
    @FXML
    ObservableList<Formateur> list = FXCollections.observableArrayList(formateurDao.findAll());
    @FXML
    ObservableList<Domaine> list1 = FXCollections.observableArrayList(domainDao.findAll());

    @FXML
    private void initialize() {
        CodeformateurChoiceBox.setItems(list);
        CodedomaineChoiceBox.setItems(list1);

    }

    @FXML
    void Modify_Formation(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Formation formation = (Formation) stage.getUserData();
      /*  Formation formation = new Formation(Integer.parseInt(IDTextField.getText()),Integer.parseInt(NbjourTextField.getText()), Integer.parseInt(anneeTextField.getText()),
                Integer.parseInt(moisTextField.getText()), Integer.parseInt(NbParticipantTextField.getText()),
                intituleTextField.getText(),
                CodeformateurChoiceBox.getValue().getCode_formateur(),
                CodedomaineChoiceBox.getValue().getCode_domaine());*/
        if (!NbjourTextField.getText().isEmpty()) {
            formation.setNombre_jours(Integer.parseInt(NbjourTextField.getText()));
        }
        if (!anneeTextField.getText().isEmpty()) {
            formation.setAnnee(Integer.parseInt(anneeTextField.getText()));
        }
        if (!moisTextField.getText().isEmpty()) {
            formation.setMois(Integer.parseInt(moisTextField.getText()));
        }
        if (!NbParticipantTextField.getText().isEmpty()) {
            formation.setNombre_participants(Integer.parseInt(NbParticipantTextField.getText()));

        }
        if (CodeformateurChoiceBox.getSelectionModel().getSelectedIndex() > -1) {
            formation.setCode_formation(CodeformateurChoiceBox.getSelectionModel().getSelectedItem().getCode_formateur());
        }
        if (CodedomaineChoiceBox.getSelectionModel().getSelectedIndex() > -1) {
            formation.setCode_domaine(CodedomaineChoiceBox.getSelectionModel().getSelectedItem().getCode_domaine());

        }
        FormationDao formationDao = new FormationDao();
      // if(!formationDao.exists(formation)) {
            if (formationDao.update(formation)) {
                RoutingClass.alert("success");
            } else {
                RoutingClass.alert("problem");

            }
       /* }
       else {
           RoutingClass.alert("formation deja existante ");
       }*/


    }

}
