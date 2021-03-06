package com.example.inscription.Controllers;

import com.example.inscription.Classes.*;
import com.example.inscription.Controllers.RoutingClass;
import com.example.inscription.Daos.FormateurDao;
import com.example.inscription.Daos.FormationDao;
import com.example.inscription.Daos.ParticipantDao;
import com.example.inscription.Daos.ParticipationDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
    Button BtnDeleteFormateur, BtnDeleteFormation, BtnDeleteParticipant, BtnModifyFormation, BtnModifyParticipant, BtnModiyFormateur;
    private FormationDao formationDao = new FormationDao();
    //Gerer Formation
    ObservableList<Formation> list = FXCollections.observableArrayList(formationDao.findAll());
    private FormateurDao formateurDao = new FormateurDao();
    ObservableList<Formateur> list1 = FXCollections.observableArrayList(formateurDao.findAll());
    private ParticipantDao participantDao = new ParticipantDao();
    //Gerer participant
    ObservableList<Participant> list2 = FXCollections.observableArrayList(participantDao.findAll());
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
    private TextField TextfieldParticipant, TextfieldParticipation;
    @FXML
    private TableColumn<Formation, String> col_annee;
    @FXML
    private TableColumn<Formation, Integer> col_idFormation;
    @FXML
    private TableColumn<Formation, String> col_Intitule;
    @FXML
    private TableColumn<Formation, String> col_Nombre_participant;
    @FXML
    private TableColumn<Formation, String> col_Nombrejour;

//Gerer Formateur
    @FXML
    private TableColumn<Formation, Integer> col_DomaineFormation;
    @FXML
    private TableColumn<Formation, String> col_mois;
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
    @FXML
    private TableColumn<Participant, String> col_PrenomPar;
    @FXML
    private TableColumn<Participant, String> col_nomPar;
    @FXML
    private TableColumn<Participant, Integer> col_ProfilPar;

    @FXML
    private TableColumn<Formateur, Integer> col_numeroTelephoneFormateur;

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
        col_Intitule.setCellValueFactory(new PropertyValueFactory<Formation, String>("intitule"));
        col_Nombrejour.setCellValueFactory(new PropertyValueFactory<Formation, String>("nombre_jours"));
        col_annee.setCellValueFactory(new PropertyValueFactory<Formation, String>("annee"));
        col_mois.setCellValueFactory(new PropertyValueFactory<Formation, String>("mois"));
        col_Nombre_participant.setCellValueFactory(new PropertyValueFactory<Formation, String>("nombre_participants"));
        col_DomaineFormation.setCellValueFactory(new PropertyValueFactory<Formation, Integer>("code_domaine"));
        tableFormation.setItems(list);
        TabPane1.getSelectionModel().select(FormationHandlerTab);
        filtreFormation();


        //affiche table formateur

        col_IdFormateur.setCellValueFactory(new PropertyValueFactory<Formateur, Integer>("code_formateur"));
        col_NomFormateur.setCellValueFactory(new PropertyValueFactory<Formateur, String>("nom"));
        col_PrenomFormateur.setCellValueFactory(new PropertyValueFactory<Formateur, String>("prenom"));
        col_EmailFormateur.setCellValueFactory(new PropertyValueFactory<Formateur, String>("email"));
        col_numeroTelephoneFormateur.setCellValueFactory(new PropertyValueFactory<Formateur, Integer>("n_tel"));
        col_codeorganisme.setCellValueFactory(new PropertyValueFactory<Formateur, Integer>("Code_organisme"));
        col_codedomaine.setCellValueFactory(new PropertyValueFactory<Formateur, Integer>("code_domaine"));
        tableFormateur.setItems(list1);
        TabPane1.getSelectionModel().select(FormateurHandlerTab);
       filtreFormateur();

        //affiche table participant
        col_MatriculePar.setCellValueFactory(new PropertyValueFactory<Participant, Integer>("matricule"));
        col_ProfilPar.setCellValueFactory(new PropertyValueFactory<Participant, Integer>("Code_profil"));

        col_nomPar.setCellValueFactory(new PropertyValueFactory<Participant, String>("nom"));
        col_PrenomPar.setCellValueFactory(new PropertyValueFactory<Participant, String>("prenom"));
        col_Date_naissancePar.setCellValueFactory(new PropertyValueFactory<Participant, Date>("date_naissance"));
        tableParticipant.setItems(list2);
        TabPane1.getSelectionModel().select(ParticipantHandlerTab);

       filtreParticipant();


        //affiche table participation
        col_MatriculeParticipation.setCellValueFactory(new PropertyValueFactory<Participation, Integer>("matricule"));
        col_intituleParticipation.setCellValueFactory(new PropertyValueFactory<Participation, String>("intitule"));
        col_code_formation.setCellValueFactory(new PropertyValueFactory<Participation, Integer>("code_formation"));

        col_nomParticipation.setCellValueFactory(new PropertyValueFactory<Participation, String>("nom"));

        tableParticipation.setItems(list3);
        TabPane1.getSelectionModel().select(ParticipationHandlerTab);
        filtreParticipation();



        TabPane1.getSelectionModel().select(FormationHandlerTab);


    }

    //--------------Gerer_Formateur---------------------//

    @FXML
    void Ajouter_Formateur(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(FormateurHandlerTab);

        RoutingClass.goTo("Add_formateur.fxml", "Ajouter", 604, 251);
    }

    @FXML
    void Modifier_formateur(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(FormateurHandlerTab);
        if (tableFormateur.getSelectionModel().getSelectedIndex() > -1) {
            RoutingClass.goTo("Modify_formateur.fxml", "Modifier", 604, 418, tableFormateur.getSelectionModel().getSelectedItem());
        } else {
            RoutingClass.alert("S??lectionner une ligne ");
        }
    }
    @FXML
    void Supprimer_formateur(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(FormateurHandlerTab);

        if (tableFormateur.getSelectionModel().getSelectedIndex() > -1) {


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);


            alert.setTitle("Confirmation de supprition");
            alert.setHeaderText(null);
            alert.setContentText("??tes-vous s??r de vouloir supprimer?");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setUserData(tableFormateur.getSelectionModel().getSelectedItem());

                Formateur formateur = (Formateur) stage.getUserData();
                FormateurDao formateurDao = new FormateurDao();
                formateurDao.delete(formateur);
                loadFormateurDetails();
            }


        } else {
            RoutingClass.alert("S??lectionner une ligne ");
        }

    }
    public void refreshTableFormateur(ActionEvent event) {
        TabPane1.getSelectionModel().select(FormateurHandlerTab);
       loadFormateurDetails();
    }
    private void loadFormateurDetails() {
        list1.clear();
        list1.addAll(formateurDao.findAll());

        tableFormateur.setItems(list1);
        filtreFormateur();
    }
    private void filtreFormateur() {
        FilteredList<Formateur> filteredData = new FilteredList<>(list1, b -> true);

        TextfieldFormateur.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(formateur -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (formateur.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (formateur.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(formateur.getCode_formateur()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                }else if (String.valueOf(formateur.getN_tel()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else
                    return false;
            });
        });

        SortedList<Formateur> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableFormateur.comparatorProperty());
        tableFormateur.setItems(sortedData);

    }
    //--------------Gerer_Formation---------------------//


    @FXML
    void Ajouter_formation(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(FormationHandlerTab);

        RoutingClass.goTo("Add_formation.fxml", "Ajouter", 604, 310);

    }
    @FXML
    void Modifier_formation(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(FormationHandlerTab);
        if (tableFormation.getSelectionModel().getSelectedIndex() > -1) {
            RoutingClass.goTo("Modify_formation.fxml", "Modifier", 604, 418, tableFormation.getSelectionModel().getSelectedItem());
        } else {
            RoutingClass.alert("S??lectionner une ligne");

        }
    }

    @FXML
    void refreshTableFormation(ActionEvent event) {
        TabPane1.getSelectionModel().select(FormationHandlerTab);

        loadFormationDetails();

    }
    @FXML
    void Supprimer_formation(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(FormationHandlerTab);

        if (tableFormation.getSelectionModel().getSelectedIndex() > -1) {


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);


            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText(null);
            alert.setContentText("??tes-vous s??r de vouloir supprimer?");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setUserData(tableFormation.getSelectionModel().getSelectedItem());

                Formation formation = (Formation) stage.getUserData();
                FormationDao formationDao = new FormationDao();
                formationDao.delete(formation);
                loadFormationDetails();
            }


        } else {
            RoutingClass.alert("S??lectionner une ligne ");
        }

    }
    private void loadFormationDetails() {
        list.clear();
        list.addAll(formationDao.findAll());

        tableFormation.setItems(list);
       filtreFormation();
    }
    private void filtreFormation() {
        FilteredList<Formation> filteredData = new FilteredList<>(list, b -> true);

        TextFieldFormation.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(formation -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (formation.getIntitule().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;

                } else if (String.valueOf(formation.getCode_formation()).indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false;
            });
        });

        SortedList<Formation> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableFormation.comparatorProperty());
        tableFormation.setItems(sortedData);

    }

    //--------------Gerer_Participant---------------------//
    @FXML
    void Supprimer_participant(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(ParticipantHandlerTab);

        if (tableParticipant.getSelectionModel().getSelectedIndex() > -1) {


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);


            alert.setTitle("Confirmation de supprition");
            alert.setHeaderText(null);
            alert.setContentText("??tes-vous s??r de vouloir supprimer?");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setUserData(tableParticipant.getSelectionModel().getSelectedItem());

                Participant participant = (Participant) stage.getUserData();
                ParticipantDao participantDao = new ParticipantDao();
                participantDao.delete(participant);
                loadParticipantDetails();
            }


        } else {
            RoutingClass.alert("S??lectionner une ligne ");
        }

    }

    @FXML
    void Ajouter_participant(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(ParticipantHandlerTab);

        RoutingClass.goTo("Add_participant.fxml", "Ajouter", 604, 251);

    }
    @FXML
    void Modifier_participant(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(ParticipantHandlerTab);
        if (tableParticipant.getSelectionModel().getSelectedIndex() > -1) {

            RoutingClass.goTo("Modify_participant.fxml", "Modifier", 604, 418, tableParticipant.getSelectionModel().getSelectedItem());
        } else {
            RoutingClass.alert("S??lectionner une ligne ");

        }
    }

    public void refreshTableParticipant(ActionEvent event) {
        TabPane1.getSelectionModel().select(ParticipantHandlerTab);

        loadParticipantDetails();
    }
    private void loadParticipantDetails() {
        list2.clear();
        list2.addAll(participantDao.findAll());

        tableParticipant.setItems(list2);
        filtreParticipant();
    }
    private void filtreParticipant() {
        FilteredList<Participant> filteredData = new FilteredList<>(list2, b -> true);

        TextfieldParticipant.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(participant -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (participant.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (participant.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(participant.getDate_naissance()).indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false;
            });
        });

        SortedList<Participant> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableParticipant.comparatorProperty());
        tableParticipant.setItems(sortedData);

    }
    //--------------Gerer_Participation---------------------//



    @FXML
    void refreshTableParticipation(ActionEvent event) {
        TabPane1.getSelectionModel().select(ParticipationHandlerTab);

        loadParticipationDetails();
    }
    public void Ajouter_participation(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(ParticipationHandlerTab);
        if (tableFormation.getSelectionModel().getSelectedIndex() > -1) {
            RoutingClass.goTo("Add_participation.fxml", "Ajouter participation", 604, 251, tableFormation.getSelectionModel().getSelectedItem());
        } else {
            TabPane1.getSelectionModel().select(FormationHandlerTab);
            RoutingClass.alert("S??lectionner une ligne ");

        }

    }

    public void Supprimer_participation(ActionEvent event) throws Exception {
        TabPane1.getSelectionModel().select(ParticipationHandlerTab);
        if (tableParticipation.getSelectionModel().getSelectedIndex() > -1) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);


            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText(null);
            alert.setContentText("??tes-vous s??r de vouloir supprimer?");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setUserData(tableParticipation.getSelectionModel().getSelectedItem());

                Participation participation = (Participation) stage.getUserData();
                ParticipationDao participationDao = new ParticipationDao();
                participationDao.delete(participation);
                loadParticipationDetails();
            }
        } else {
            RoutingClass.alert("S??lectionner une ligne ");

        }

    }


    private void loadParticipationDetails() {
        list3.clear();
        list3.addAll(participationDao.findAll());

        tableParticipation.setItems(list3);
        filtreParticipation();
    }

    private void filtreParticipation() {
        FilteredList<Participation> filteredData = new FilteredList<>(list3, b -> true);

        TextfieldParticipation.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(participation -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (participation.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (participation.getIntitule().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(participation.getMatricule()).indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false;
            });
        });

        SortedList<Participation> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableParticipation.comparatorProperty());
        tableParticipation.setItems(sortedData);

    }


    //-------------------Sign_out-----------------------//
    @FXML
    void signOut(ActionEvent event) throws Exception {

        RoutingClass.goTo((Stage) signOutButton.getScene().getWindow(), "login.fxml", "login", 450, 550);
    }
}
