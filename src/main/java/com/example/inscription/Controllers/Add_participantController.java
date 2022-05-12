package com.example.inscription.Controllers;

import com.example.inscription.Classes.Participant;
import com.example.inscription.Classes.Profil;
import com.example.inscription.Daos.ParticipantDao;
import com.example.inscription.Daos.ProfileDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.ZoneId;
import java.util.Date;

public class Add_participantController {
    ProfileDao profileDao = new ProfileDao();

    @FXML
    ObservableList<Profil> list = FXCollections.observableArrayList(profileDao.findAll());

    @FXML
    private Button BtnAjouterParticipant;

    @FXML
    private ChoiceBox<Profil> CodeprofileChoiceBox;

    @FXML
    private DatePicker DatePicker;

    @FXML
    private TextField NomTextField;

    @FXML
    private TextField PrenomTextField;

    @FXML
    private void initialize() {
        CodeprofileChoiceBox.setItems(list);

    }

    @FXML
    void Add_participant(ActionEvent event) {
        ParticipantDao participantDao = new ParticipantDao();
        Participant participant = new Participant(NomTextField.getText(),
                PrenomTextField.getText(), Date.from(DatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                CodeprofileChoiceBox.getValue().getCode_profil());

        if (participantDao.create(participant)) {
            RoutingClass.alert("Participant is successfully added!");
        } else {
            RoutingClass.alert("problem");


        }


    }


}
