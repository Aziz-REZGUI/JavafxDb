package com.example.inscription.Controllers;

import com.example.inscription.Classes.Participation;
import com.example.inscription.Daos.ParticipationDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Add_participationController {
    ParticipationDao participationDao = new ParticipationDao();
    @FXML
    private Button BtnAjouterParticipation;
    @FXML
    private ChoiceBox<Integer> listIdParticipant;
    @FXML
    private ChoiceBox<Integer> listIdFormation;

    @FXML
    private TextField CodeFormationTextField;
    @FXML
    ObservableList<Integer> list = FXCollections.observableArrayList(participationDao.findformationIds());
   // @FXML
    ObservableList<Integer> list1 = FXCollections.observableArrayList(participationDao.findparticipantIds());

    @FXML
    private TextField IntituleTextField;

    @FXML
    private TextField MatriculeTextField;

    @FXML
    private TextField nomTextField;


    @FXML
    private void initialize() {
        nomTextField=new TextField();
        IntituleTextField=new TextField();
        listIdFormation.setItems(list);
        listIdParticipant.setItems(list1);

    }
    @FXML
    void show_participant(ActionEvent event) {
        nomTextField.setText(participationDao.find_nom(listIdParticipant.getValue()));
    }
    @FXML
    void show_formation(ActionEvent event){
        IntituleTextField.setText(participationDao.find_intitule(listIdFormation.getValue()));
    }



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
