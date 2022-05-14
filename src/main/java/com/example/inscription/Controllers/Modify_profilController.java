package com.example.inscription.Controllers;

import com.example.inscription.Classes.Profil;
import com.example.inscription.Controllers.RoutingClass;
import com.example.inscription.Daos.ProfileDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Modify_profilController {

    @FXML
    private Button BtnUpdateprofil;

    @FXML
    private TextField LibelleTextField;

    boolean updated=false;
    @FXML
    void Update_domaine(ActionEvent event) {

//        Profil profil = new Profil(LibelleTextField.getText());
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Profil profil = (Profil) stage.getUserData();
        if (!LibelleTextField.getText().isEmpty()) {
            profil.setLibelle(LibelleTextField.getText().trim());
            updated=true;
        }
        ProfileDao profileDao = new ProfileDao();
      if(updated)  {
            if (!profileDao.exists(profil)) {
                if (profileDao.update(profil)) {
                    RoutingClass.alert("success");
                } else {
                    RoutingClass.alert("problem");

                }
            } else {
                RoutingClass.alert("profil deja existant ");
            }
        }
      else
      {
          RoutingClass.alert("no change detected");
      }

    }

}











