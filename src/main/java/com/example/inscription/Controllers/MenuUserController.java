package com.example.inscription.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import com.example.inscription.Classes.*;
import com.example.inscription.Daos.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;


public class MenuUserController  implements Initializable {

    @FXML
    private Button BtnAddFormateur,

    BtnAddFormation,BtnAddParticipant;
@FXML
Button BtnDeleteFormateur, BtnDeleteFormation,

     BtnDeleteParticipant, BtnModifyFormation, BtnModifyParticipant, BtnModiyFormateur, BtnSearchFormateur,BtnSearchFormation, BtnSearchParticipant;
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


    }
    @FXML
    void Ajouter_Formateur(ActionEvent event) throws Exception{
        TabPane1.getSelectionModel().select(FormateurHandlerTab);

        RoutingClass.goTo("Add_formateur.fxml", "Ajouter", 604, 251);
    }

    @FXML
    void Ajouter_formation(ActionEvent event)  throws Exception {
        TabPane1.getSelectionModel().select(FormationHandlerTab);

        RoutingClass.goTo("Add_formation.fxml", "Ajouter", 604, 251);

    }

    @FXML
    void Ajouter_participant(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(ParticipantHandlerTab);

        RoutingClass.goTo("Add_participant.fxml", "Ajouter", 604, 251);

    }

    @FXML
    void Chercher_Formation(ActionEvent event)  throws Exception{

    }

    @FXML
    void Chercher_Participant(ActionEvent event)  throws Exception{

    }

    @FXML
    void Chercher_formateur(ActionEvent event) {

    }

    @FXML
    void Modifier_formateur(ActionEvent event)  throws Exception{
        TabPane1.getSelectionModel().select(FormateurHandlerTab);

        RoutingClass.goTo("Modify_formateur.fxml", "Modifier", 604, 251);

    }

    @FXML
    void Modifier_formation(ActionEvent event)  throws Exception{
        TabPane1.getSelectionModel().select(FormationHandlerTab);

        RoutingClass.goTo("Modify_formation.fxml", "Modifier", 604, 251);

    }

    @FXML
    void Modifier_participant(ActionEvent event)  throws Exception{
        TabPane1.getSelectionModel().select(ParticipantHandlerTab);

        RoutingClass.goTo("Modify_participant.fxml", "Modifier", 604, 251);

    }

    @FXML
    void Supprimer_formateur(ActionEvent event)  throws Exception{

    }

    @FXML
    void Supprimer_formation(ActionEvent event)  throws Exception{

    }

    @FXML
    void Supprimer_participant(ActionEvent event)  throws Exception{

    }

    @FXML
    void refreshTableFormation(ActionEvent event) {

    }

    @FXML
    void signOut(ActionEvent event) throws Exception {


            //AdminDao.cleanUserSession();
            RoutingClass.goTo((Stage)signOutButton.getScene().getWindow(),"login.fxml","login");
    }

}
