package com.example.inscription.Controllers;

import com.example.inscription.Classes.Formation;
import com.example.inscription.Classes.Participant;
import com.example.inscription.Daos.FormationDao;
import com.example.inscription.Daos.ParticipantDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Delete_participantController {

    @FXML
    private Button BtnDelete;

    @FXML
    private TextField CodeparticipantTextField;

    @FXML
    void Supprimer_participant(ActionEvent event) {
        Participant participant = new Participant(Integer.parseInt(CodeparticipantTextField.getText()));
        ParticipantDao participantDao = new ParticipantDao();
        if (participantDao.exists(participant)) {
            participantDao.delete(participant) ;
        } else {
            RoutingClass.alert("This ID doesn't exist try again");


        }



    }

}
