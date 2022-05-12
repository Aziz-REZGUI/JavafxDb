package com.example.inscription.Controllers;

import com.example.inscription.Classes.Domaine;
import com.example.inscription.Daos.DomainDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Modify_domaineController {


    @FXML
    private Button BtnUpdatedomaine;

    @FXML
    private TextField FormationTextField;

    @FXML
    private TextField IDTextField;

    @FXML
    private TextField LibelleTextField;

    @FXML
    public void Update_domaine(ActionEvent event) {
        // Domaine domaine = new Domaine(Integer.parseInt(IDTextField.getText().trim()), LibelleTextField.getText());
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Domaine domaine = (Domaine) stage.getUserData();
        if (!LibelleTextField.getText().isEmpty()) {
            domaine.setLibelle(LibelleTextField.getText().trim());
        }
        //TODO unicity for the updates
        //controle de saisie
        DomainDao domaineDao = new DomainDao();
        if (domaineDao.update(domaine)) {
            RoutingClass.alert("success");

        } else {
            RoutingClass.alert("problem");

        }

    }
}
