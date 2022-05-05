package com.example.inscription.Controllers;

import com.example.inscription.Classes.Domaine;
import com.example.inscription.Classes.Formation;
import com.example.inscription.Daos.DomainDao;
import com.example.inscription.Daos.FormateurDao;
import com.example.inscription.Daos.FormationDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Add_formationController {
    FormateurDao formateurDao = new FormateurDao();
    DomainDao domainDao = new DomainDao();

    @FXML
    ObservableList<Integer> list = FXCollections.observableArrayList(formateurDao.findIds());
    @FXML
    ObservableList<Integer> list1 = FXCollections.observableArrayList(domainDao.findIds());

    @FXML
    private Button BtnAjouterFormation;

    @FXML
    private TextField Code_formateurTextField;

    @FXML
    private ChoiceBox<Integer> CodedomaineChoiceBox;

    @FXML
    private ChoiceBox<Integer> CodeformateurChoiceBox;

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
    @FXML
    private void initialize() {
        CodeformateurChoiceBox.setItems(list);
        CodedomaineChoiceBox.setItems(list1);

    }
    @FXML
    void Add_Formation(ActionEvent event) {
        Formation formation = new Formation(Integer.parseInt(NbjourTextField.getText()), Integer.parseInt(anneeTextField.getText()),
                Integer.parseInt(moisTextField.getText()), Integer.parseInt(NbParticipantTextField.getText()),
                intituleTextField.getText(),
                Integer.parseInt(CodeformateurChoiceBox.getValue().toString()),
                Integer.parseInt(CodedomaineChoiceBox.getValue().toString()));
        FormationDao formationDao = new FormationDao();
        if (formationDao.create(formation)) {
            RoutingClass.alert("Formation is successfully added!");
        } else {
            RoutingClass.alert("problem");


        }

    }
}
