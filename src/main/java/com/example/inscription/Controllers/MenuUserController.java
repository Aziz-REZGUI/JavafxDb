package com.example.inscription.Controllers;

import com.example.inscription.Classes.*;
import com.example.inscription.Daos.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;


public class MenuUserController implements Initializable {

    @FXML
    private Button BtnAddFormateur,

    BtnAddFormation, BtnAddParticipant;
    @FXML
    Button BtnDeleteFormateur, BtnDeleteFormation,

    BtnDeleteParticipant, BtnModifyFormation, BtnModifyParticipant, BtnModiyFormateur, BtnSearchFormateur, BtnSearchFormation, BtnSearchParticipant;
    private FormationDao formationDao = new FormationDao();
    private FormateurDao formateurDao = new FormateurDao();
    private ParticipantDao participantDao = new ParticipantDao();
    @FXML
    private Tab FormateurHandlerTab;

    @FXML
    private Tab FormationHandlerTab;

    @FXML
    private Tab ParticipantHandlerTab;


    @FXML
    private TabPane TabPane1;

    @FXML
    private TextField TextFieldFormation;

    @FXML
    private TextField TextfieldFormateur;

    @FXML
    private TextField TextfieldParticipant;

    @FXML
    private Button btnRefresh;
    //Gerer Formation
    ObservableList<Formation> list = FXCollections.observableArrayList(formationDao.findAll());

    @FXML
    private TableColumn<Formation, String> col_annee;

    @FXML
    private TableColumn<Formation, Integer> col_idFormation;
    @FXML
    private TableColumn<Formation, String> col_Nombre_participant;

    @FXML
    private TableColumn<Formation, String> col_Nombrejour;
    @FXML
    private TableColumn<Formation, Integer> col_DomaineFormation;

    @FXML
    private TableColumn<Formation, String> col_mois;

//Gerer Formateur

    ObservableList<Formateur> list1 = FXCollections.observableArrayList(formateurDao.findAll());


    @FXML
    private TableColumn<Formateur, String> col_EmailFormateur;

    @FXML
    private TableColumn<Formateur, Integer> col_IdFormateur;


    @FXML
    private TableColumn<Formateur, String> col_NomFormateur;


    @FXML
    private TableColumn<Formateur, String> col_PrenomFormateur;


    @FXML
    private TableColumn<Formateur, Integer> col_codedomaine;
    @FXML
    private TableColumn<Formateur, Integer> col_codeorganisme;

    //Gerer participant
    ObservableList<Participant> list2 = FXCollections.observableArrayList(participantDao.findAll());

    @FXML
    private TableColumn<Participant, String> col_PrenomPar;
    @FXML
    private TableColumn<Participant, String> col_nomPar;
    @FXML
    private TableColumn<Participant, Integer> col_ProfilPar;

    @FXML
    private TableColumn<Formateur, Integer> col_numéroTelephoneFormateur;

    @FXML
    private TableColumn<Participant, Integer> col_MatriculePar;
    @FXML
    private TableColumn<Participant, Date> col_Date_naissancePar;

    @FXML
    private Button signOutButton;

    @FXML
    private TableView<Formateur> tableFormateur;

    @FXML
    private TableView<Formation> tableFormation;

    @FXML
    private TableView<Participant> tableParticipant;
    //Gerer participation
    @FXML
    private Tab ParticipationHandlerTab;

    private ParticipationDao participationDao = new ParticipationDao();
    ObservableList<Participation> list3 = FXCollections.observableArrayList(participationDao.findAll());


    @FXML
    private TableView<Participation> tableParticipation;
    @FXML
    private TableColumn<Participation, Integer> col_MatriculeParticipation;
    @FXML
    private TableColumn<Participation, String> col_nomParticipation;
    @FXML
    private TableColumn<Participation, Integer> col_code_formation;
    @FXML
    private TableColumn<Participation, String> col_intituleParticipation;
    ;

    @Override
    public void initialize(URL url, ResourceBundle rb) {


        // Affiche table Formation

        col_idFormation.setCellValueFactory(new PropertyValueFactory<Formation, Integer>("code_formation"));
        col_Nombrejour.setCellValueFactory(new PropertyValueFactory<Formation, String>("nombre_jours"));
        col_annee.setCellValueFactory(new PropertyValueFactory<Formation, String>("annee"));
        col_mois.setCellValueFactory(new PropertyValueFactory<Formation, String>("mois"));
        col_Nombre_participant.setCellValueFactory(new PropertyValueFactory<Formation, String>("nombre_participants"));
        col_DomaineFormation.setCellValueFactory(new PropertyValueFactory<Formation, Integer>("code_domaine"));
        tableFormation.setItems(list);
        TabPane1.getSelectionModel().select(FormationHandlerTab);


        //affiche table formateur

        col_IdFormateur.setCellValueFactory(new PropertyValueFactory<Formateur, Integer>("code_formateur"));
        col_NomFormateur.setCellValueFactory(new PropertyValueFactory<Formateur, String>("nom"));
        col_PrenomFormateur.setCellValueFactory(new PropertyValueFactory<Formateur, String>("prenom"));
        col_EmailFormateur.setCellValueFactory(new PropertyValueFactory<Formateur, String>("email"));
        col_numéroTelephoneFormateur.setCellValueFactory(new PropertyValueFactory<Formateur, Integer>("n_tel"));
        col_codeorganisme.setCellValueFactory(new PropertyValueFactory<Formateur, Integer>("Code_organisme"));
        col_codedomaine.setCellValueFactory(new PropertyValueFactory<Formateur, Integer>("code_domaine"));
        tableFormateur.setItems(list1);
        TabPane1.getSelectionModel().select(FormateurHandlerTab);


        //affiche table participant
        col_MatriculePar.setCellValueFactory(new PropertyValueFactory<Participant, Integer>("matricule"));
        col_ProfilPar.setCellValueFactory(new PropertyValueFactory<Participant, Integer>("Code_profil"));

        col_nomPar.setCellValueFactory(new PropertyValueFactory<Participant, String>("nom"));
        col_PrenomPar.setCellValueFactory(new PropertyValueFactory<Participant, String>("prenom"));
        col_Date_naissancePar.setCellValueFactory(new PropertyValueFactory<Participant, Date>("date_naissance"));
        tableParticipant.setItems(list2);
        TabPane1.getSelectionModel().select(ParticipantHandlerTab);
        //affiche table participation
        col_MatriculeParticipation.setCellValueFactory(new PropertyValueFactory<Participation, Integer>("matricule"));
        col_intituleParticipation.setCellValueFactory(new PropertyValueFactory<Participation, String>("intitule"));
        col_code_formation.setCellValueFactory(new PropertyValueFactory<Participation, Integer>("code_formation"));

        col_nomParticipation.setCellValueFactory(new PropertyValueFactory<Participation, String>("nom"));

        tableParticipation.setItems(list3);
        TabPane1.getSelectionModel().select(ParticipationHandlerTab);

    }

    @FXML
    void Ajouter_Formateur(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(FormateurHandlerTab);

        RoutingClass.goTo("Add_formateur.fxml", "Ajouter", 604, 251);
    }

    @FXML
    void Ajouter_formation(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(FormationHandlerTab);

        RoutingClass.goTo("Add_formation.fxml", "Ajouter", 604, 251);

    }

    @FXML
    void Ajouter_participant(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(ParticipantHandlerTab);

        RoutingClass.goTo("Add_participant.fxml", "Ajouter", 604, 251);

    }

    @FXML
    void Chercher_Formation(ActionEvent event) throws Exception {

    }

    @FXML
    void Chercher_Participant(ActionEvent event) throws Exception {

    }

    @FXML
    void Chercher_formateur(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(FormateurHandlerTab);

        RoutingClass.goTo("Find_formateur.fxml", "Modifier", 604, 418);

    }

    @FXML
    void Modifier_formateur(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(FormateurHandlerTab);
        if (tableFormateur.getSelectionModel().getSelectedIndex() > -1) {
            RoutingClass.goTo("Modify_formateur.fxml", "Modifier", 604, 418, tableFormateur.getSelectionModel().getSelectedItem());
        } else {
            RoutingClass.alert("please select a line ");
        }
    }

    //TODO complete send to the other classes
    @FXML
    void Modifier_formation(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(FormationHandlerTab);
        if (tableFormation.getSelectionModel().getSelectedIndex() > -1) {
            RoutingClass.goTo("Modify_formation.fxml", "Modifier", 604, 418, tableFormation.getSelectionModel().getSelectedItem());
        } else {
            RoutingClass.alert("please select a line ");

        }
    }

    @FXML
    void Modifier_participant(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(ParticipantHandlerTab);
        if (tableParticipant.getSelectionModel().getSelectedIndex() > -1) {

            RoutingClass.goTo("Modify_participant.fxml", "Modifier", 604, 418, tableParticipant.getSelectionModel().getSelectedItem());
        } else {
            RoutingClass.alert("please select a line ");

        }
    }

    @FXML
    void Supprimer_formateur(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(FormateurHandlerTab);

        if (tableFormateur.getSelectionModel().getSelectedIndex() > -1) {


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);


            alert.setTitle("Confirmation de supprition");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer?");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setUserData(tableFormateur.getSelectionModel().getSelectedItem());

                Formateur formateur = (Formateur) stage.getUserData();
                FormateurDao formateurDao = new FormateurDao();
                formateurDao.delete(formateur);
            }


        } else {
            RoutingClass.alert("Sélectionner une ligne ");
        }

    }

    @FXML
    void Supprimer_formation(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(FormationHandlerTab);

        if (tableFormation.getSelectionModel().getSelectedIndex() > -1) {


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);


            alert.setTitle("Confirmation de supprition");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer?");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setUserData(tableFormation.getSelectionModel().getSelectedItem());

                Formation formation = (Formation) stage.getUserData();
                FormationDao formationDao = new FormationDao();
                formationDao.delete(formation);
            }


        } else {
            RoutingClass.alert("Sélectionner une ligne ");
        }

    }

    @FXML
    void Supprimer_participant(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(ParticipantHandlerTab);

        if (tableParticipant.getSelectionModel().getSelectedIndex() > -1) {


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);


            alert.setTitle("Confirmation de supprition");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer?");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setUserData(tableParticipant.getSelectionModel().getSelectedItem());

                Participant participant = (Participant) stage.getUserData();
                ParticipantDao participantDao = new ParticipantDao();
                participantDao.delete(participant);
            }


        } else {
            RoutingClass.alert("Sélectionner une ligne ");
        }

    }

    @FXML
    void refreshTableFormation(ActionEvent event) {
        TabPane1.getSelectionModel().select(FormationHandlerTab);

        tableFormation.getItems().clear();
        tableFormation.getItems().addAll(formationDao.findAll());

    }

    @FXML
    void refreshTableParticipation(ActionEvent event) {
        TabPane1.getSelectionModel().select(ParticipationHandlerTab);
        tableParticipation.getItems().clear();
        tableParticipation.getItems().addAll(participationDao.findAll());
    }

    @FXML
    void signOut(ActionEvent event) throws Exception {

        //AdminDao.cleanUserSession();
        RoutingClass.goTo((Stage) signOutButton.getScene().getWindow(), "login.fxml", "login", 450, 650);
    }

    public void refreshTableFormateur(ActionEvent event) {
        TabPane1.getSelectionModel().select(FormateurHandlerTab);
        tableFormateur.getItems().clear();
        tableFormateur.getItems().addAll(formateurDao.findAll());
    }

    public void refreshTableParticipant(ActionEvent event) {
        TabPane1.getSelectionModel().select(ParticipantHandlerTab);

        tableParticipant.getItems().clear();
        tableParticipant.getItems().addAll(participantDao.findAll());
    }


    public void Ajouter_participation(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(ParticipationHandlerTab);

        RoutingClass.goTo("Add_participation.fxml", "Ajouter participation", 604, 251);

    }

    public void Supprimer_participation(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(ParticipationHandlerTab);
        if (tableParticipation.getSelectionModel().getSelectedIndex() > -1) {
            RoutingClass.goTo("Delete_participation.fxml", "Supprimer participation", 604, 251,tableParticipation.getSelectionModel().getSelectedItem());
        } else {
            RoutingClass.alert("please select a line ");

        }

    }

    public void Modifier_participation(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(ParticipationHandlerTab);
        if (tableParticipation.getSelectionModel().getSelectedIndex() > -1) {
            RoutingClass.goTo("Modify_participation.fxml", "Modifier participation", 604, 251, tableParticipation.getSelectionModel().getSelectedItem());
        } else {
            RoutingClass.alert("please select a line ");
        }
    }
}
