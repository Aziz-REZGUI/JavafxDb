package com.example.inscription.Controllers;

import com.example.inscription.Classes.Formation;
import com.example.inscription.Classes.Participant;
import com.example.inscription.Classes.Participation;
import com.example.inscription.Daos.FormationDao;
import com.example.inscription.Daos.ParticipantDao;
import com.example.inscription.Daos.ParticipationDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Add_participationController {
    ParticipationDao participationDao = new ParticipationDao();
    FormationDao formationDao = new FormationDao();
    ParticipantDao participantDao = new ParticipantDao();
    @FXML
    private Button BtnAjouterParticipation;
    @FXML
    private ChoiceBox<Participant> listIdParticipant;
    @FXML
    private ChoiceBox<Formation> listIdFormation;

    @FXML
    private TextField CodeFormationTextField;
    @FXML
    ObservableList<Formation> list = FXCollections.observableArrayList(formationDao.findAll());
    @FXML
    ObservableList<Participant> list1 = FXCollections.observableArrayList(participantDao.findAll());

    @FXML
    private TextField IntituleTextField;

    @FXML
    private TextField MatriculeTextField;

    @FXML
    private TextField nomTextField;

    //TODO add colonne intitulé ya abir
    @FXML
    private void initialize() {
        nomTextField = new TextField();
        IntituleTextField = new TextField();
        listIdFormation.setItems(list);
        listIdParticipant.setItems(list1);

    }

    @FXML
    void show_participant(ActionEvent event) {
        nomTextField.setText(listIdParticipant.getValue().getNom());
    }

    @FXML
    void show_formation(ActionEvent event) {
        IntituleTextField.setText(listIdFormation.getValue().getIntitule());
    }


    @FXML
    void Add_participation(ActionEvent event) {
        Participation participation = new Participation(listIdParticipant.getValue().getMatricule(), listIdParticipant.getValue().getNom(),
              listIdFormation.getValue().getCode_formateur(), listIdFormation.getValue().getIntitule());
        ParticipationDao participationDao = new ParticipationDao();

        if (participationDao.create(participation)) {
            RoutingClass.alert("The participation is successfully added!");
        } else {
            RoutingClass.alert("Problem!");

        }
    }

}
