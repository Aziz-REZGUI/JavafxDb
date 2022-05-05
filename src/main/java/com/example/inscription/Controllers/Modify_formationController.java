package com.example.inscription.Controllers;

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

public class Modify_formationController {

    @FXML
    private Button BtnmodifierFormation;

    @FXML
    private TextField Code_formateurTextField;

    @FXML
    private ChoiceBox<Integer> CodedomaineChoiceBox;

    @FXML
    private ChoiceBox<Integer> CodeformateurChoiceBox;

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
    ObservableList<Integer> list = FXCollections.observableArrayList(formateurDao.findIds());
    @FXML
    ObservableList<Integer> list1 = FXCollections.observableArrayList(domainDao.findIds());
    private void initialize() {
        CodeformateurChoiceBox.setItems(list);
        CodeformateurChoiceBox.setItems(list1);

    }
    @FXML
    void Modify_Formation(ActionEvent event) {
        Formation formation = new Formation(Integer.parseInt(NbjourTextField.getText()), Integer.parseInt(anneeTextField.getText()),
                Integer.parseInt(moisTextField.getText()), Integer.parseInt(NbParticipantTextField.getText()),
                intituleTextField.getText(),
                Integer.parseInt(CodeformateurChoiceBox.getValue().toString()),
                Integer.parseInt(CodedomaineChoiceBox.getValue().toString()));
        FormationDao formationDao = new FormationDao();
        if (formationDao.update(formation)){
            RoutingClass.alert("success");
        } else {
            RoutingClass.alert("problem");

        }



    }

}
