package com.example.inscription.Controllers;

import com.example.inscription.Classes.Organisme;
import com.example.inscription.Daos.OrganismeDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Delete_OrganismeController {

    @FXML
    private Button BtnDelete;

    @FXML
    private TextField CodeOrganismeTextField;

    @FXML
    void Supprimer_organisme(ActionEvent event) {
        OrganismeDao organismeDao = new OrganismeDao();
        Organisme organisme = new Organisme(CodeOrganismeTextField.getText().trim());
        organismeDao.delete(organisme);
    }
}
