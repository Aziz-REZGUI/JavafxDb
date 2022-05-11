package com.example.inscription.Controllers;

import com.example.inscription.Classes.Domaine;
import com.example.inscription.Daos.DomainDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Delete_domaineController {

    @FXML
    private Button BtnDelete;

    @FXML
    private TextField CodedomaineTextField;

    @FXML
    void Supprimer_domaine(ActionEvent event) {

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Domaine domaine = (Domaine) stage.getUserData();
        DomainDao domainDao = new DomainDao();
        if (domainDao.exists(domaine)) {
            domainDao.delete(domaine);
        } else {
            RoutingClass.alert("This ID doesn't exist try again");


        }

    }

}

