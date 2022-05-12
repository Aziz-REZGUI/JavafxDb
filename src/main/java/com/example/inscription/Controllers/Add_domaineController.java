package com.example.inscription.Controllers;

import com.example.inscription.Classes.Domaine;
import com.example.inscription.Daos.DomainDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Add_domaineController {
    @FXML
    Button CancelButton;
    @FXML
    TextField LibelleTextField, FormationTextField;

    @FXML
    public void Add_domain(ActionEvent event) {

        Domaine domaine = new Domaine(LibelleTextField.getText().trim());
        DomainDao domainDao = new DomainDao();
        if (!domainDao.exists(LibelleTextField.getText().trim())) {
            if (domainDao.create(domaine)) {
                RoutingClass.alert("Domain is successfully added!");
              /*  MenuAdminController menuAdminController=new MenuAdminController();
                ObservableList<Domaine> list1 = FXCollections.observableArrayList(domainDao.findAll());

                menuAdminController.getTableDomaine().getItems().clear();

                menuAdminController.getTableDomaine().setItems(list1);

                menuAdminController.getTableDomaine().refresh();*/
            } else {
                RoutingClass.alert("problem");

            }
        } else {
            RoutingClass.alert("domain already exists");
        }


    }

}
