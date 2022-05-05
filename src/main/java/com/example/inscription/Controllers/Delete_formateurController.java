package com.example.inscription.Controllers;

import com.example.inscription.Classes.Formateur;
import com.example.inscription.Classes.User;
import com.example.inscription.Daos.FormateurDao;
import com.example.inscription.Daos.UserDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Delete_formateurController {

    @FXML
    private Button BtnDelete;

    @FXML
    private TextField CodeformateurTextField;

    @FXML
    void Supprimer_formateur(ActionEvent event) {
        Formateur formateur = new Formateur(Integer.parseInt(CodeformateurTextField.getText()));
        FormateurDao formateurDao = new FormateurDao();
        if (formateurDao.exists(formateur)) {
            formateurDao.delete(formateur) ;
            RoutingClass.alert("Success");

        } else {
            RoutingClass.alert("This ID doesn't exist try again");


        }

    }

}
