package com.example.inscription.Controllers;

import com.example.inscription.Classes.Domaine;
import com.example.inscription.Classes.Formateur;
import com.example.inscription.Classes.Formation;
import com.example.inscription.Daos.DomainDao;
import com.example.inscription.Daos.FormateurDao;
import com.example.inscription.Daos.FormationDao;
import com.mysql.cj.util.StringUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Modify_formationController {

    FormateurDao formateurDao = new FormateurDao();
    DomainDao domainDao = new DomainDao();
    @FXML
    ObservableList<Formateur> list = FXCollections.observableArrayList(formateurDao.findAll());
    @FXML
    ObservableList<Domaine> list1 = FXCollections.observableArrayList(domainDao.findAll());
    @FXML
    private Button BtnmodifierFormation;
    @FXML
    private TextField Code_formateurTextField;
    @FXML
    private ChoiceBox<Domaine> CodedomaineChoiceBox;
    @FXML
    private ChoiceBox<Formateur> CodeformateurChoiceBox;
    @FXML
    private TextField IDTextField;
    @FXML
    private TextField NbParticipantTextField;
    @FXML
    private TextField NbjourTextField;
    @FXML
    private TextField anneeTextField;
    @FXML
    private TextField intituleTextField;
    @FXML
    private TextField moisTextField;

    @FXML
    private void initialize() {
        CodeformateurChoiceBox.setItems(list);
        CodedomaineChoiceBox.setItems(list1);

    }

    @FXML
    void Modify_Formation(ActionEvent event) {
        boolean test = true;
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Formation formationr = (Formation) stage.getUserData();
      /*  Formation formation = new Formation(Integer.parseInt(IDTextField.getText()),Integer.parseInt(NbjourTextField.getText()), Integer.parseInt(anneeTextField.getText()),
                Integer.parseInt(moisTextField.getText()), Integer.parseInt(NbParticipantTextField.getText()),
                intituleTextField.getText(),
                CodeformateurChoiceBox.getValue().getCode_formateur(),
                CodedomaineChoiceBox.getValue().getCode_domaine());*/
        /*if (!NbjourTextField.getText().isEmpty()) {

            if (!StringUtils.isStrictlyNumeric(NbjourTextField.getText())) {
                RoutingClass.alert("le nombre des jours doit etre un numero ");
                test = false;
            } else {
                formation.setNombre_jours(Integer.parseInt(NbjourTextField.getText()));
            }
        }


        if (!anneeTextField.getText().isEmpty()) {
            if ((!StringUtils.isStrictlyNumeric(anneeTextField.getText())) || (anneeTextField.getText().length() != 4)) {
                RoutingClass.alert("l'annee  doit etre un numero de taille 4 ");
                test = false;
            } else {
                formation.setAnnee(Integer.parseInt(anneeTextField.getText()));
            }


        }
        if (!moisTextField.getText().isEmpty()) {
            if ((!StringUtils.isStrictlyNumeric(moisTextField.getText())) || (Integer.parseInt(moisTextField.getText()) > 12) || (Integer.parseInt(moisTextField.getText()) < 1)) {
                RoutingClass.alert("le mois doit etre un numero entre 1 et 12");
                test = false;
            } else {
                formation.setMois(Integer.parseInt(moisTextField.getText()));
            }
        }


        if (!NbParticipantTextField.getText().isEmpty()) {
            if ((!StringUtils.isStrictlyNumeric(NbParticipantTextField.getText())) || (Integer.parseInt(NbParticipantTextField.getText()) > 12) || (Integer.parseInt(NbParticipantTextField.getText()) < 4)) {
                RoutingClass.alert("le nombre de participant doit etre superuieur a 4 ");
                test = false;
            } else {
                formation.setNombre_participants(Integer.parseInt(NbParticipantTextField.getText()));

            }

        }
        if (CodeformateurChoiceBox.getSelectionModel().getSelectedIndex() > -1) {
            formation.setCode_formation(CodeformateurChoiceBox.getSelectionModel().getSelectedItem().getCode_formateur());
        }
        if (CodedomaineChoiceBox.getSelectionModel().getSelectedIndex() > -1) {
            formation.setCode_domaine(CodedomaineChoiceBox.getSelectionModel().getSelectedItem().getCode_domaine());

        }*/
        String nbjours = NbjourTextField.getText();
        String annee = anneeTextField.getText();
        String mois = moisTextField.getText();
        String nbpart = NbParticipantTextField.getText();
        String intitule = intituleTextField.getText();
        Formateur codeF = CodeformateurChoiceBox.getValue();
        Domaine codeD = CodedomaineChoiceBox.getValue();
        if ((nbjours.isEmpty()) || (annee.isEmpty()) || (mois.isEmpty()) || (nbpart.isEmpty()) || (intitule.isEmpty())) {
            RoutingClass.alert("veillez remplir toutes les champs ");


        } else {
            if ((!StringUtils.isStrictlyNumeric(nbjours)) || (!StringUtils.isStrictlyNumeric(annee)) || (!StringUtils.isStrictlyNumeric(mois)) || (!StringUtils.isStrictlyNumeric(nbpart)) || (CodedomaineChoiceBox.getValue() == null) || (CodeformateurChoiceBox.getValue() == null)) {
                RoutingClass.alert("le nombre jours/annee/mois/nombre participants doit strictement contient un nombre ");

            } else {
                if (annee.length() != 4) {
                    RoutingClass.alert("le champs annee de etre de taille 4");
                } else {
                    if ((Integer.parseInt(mois) > 12) || (Integer.parseInt(mois) < 1)) {
                        RoutingClass.alert("le mois doit entre entre 1 et 12 ");
                    } else {
                        if (Integer.parseInt(nbpart) < 4) {
                            RoutingClass.alert("la formation doit contenir au minimum 4 participant ");
                        } else {

                            Formation formation = new Formation(formationr.getCode_formation(), Integer.parseInt(nbjours), Integer.parseInt(annee), Integer.parseInt(mois), Integer.parseInt(nbpart), intitule, codeF.getCode_formateur(), codeD.getCode_domaine());
                            FormationDao formationDao = new FormationDao();
                            // if(!formationDao.exists(formation)) {
                            if (formationDao.update(formation)) {
                                RoutingClass.alert("success");
                            } else {
                                RoutingClass.alert("problem");

                            }

       /* }
       else {
           RoutingClass.alert("formation deja existante ");
       }*/


                        }
                    }
                }
            }

        }


    }
}
