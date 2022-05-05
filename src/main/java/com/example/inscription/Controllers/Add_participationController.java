package com.example.inscription.Controllers;

import com.example.inscription.Classes.Participation;
import com.example.inscription.Classes.User;
import com.example.inscription.Daos.ParticipationDao;
import com.example.inscription.Daos.UserDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Add_participationController {

    @FXML
    private Button BtnAjouterParticipation;

    @FXML
    private TextField CodeFormationTextField;

    @FXML
    private TextField IntituleTextField;

    @FXML
    private TextField MatriculeTextField;

    @FXML
    private TextField nomTextField;

    @FXML
    void Add_participation(ActionEvent event) {
        Participation participation = new Participation(Integer.parseInt(MatriculeTextField.getText().trim()), nomTextField.toString(),
                Integer.parseInt(CodeFormationTextField.toString()), IntituleTextField.getText());
        ParticipationDao participationDao = new ParticipationDao();

        if (participationDao.create(participation)) {
            RoutingClass.alert("The participation is successfully added!");
        } else {
            RoutingClass.alert("Problem!");

        }
    }

}
