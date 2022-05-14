package com.example.inscription.Controllers;

import com.example.inscription.Classes.Domaine;
import com.example.inscription.Classes.Organisme;
import com.example.inscription.Classes.Profil;
import com.example.inscription.Classes.User;
import com.example.inscription.Daos.DomainDao;
import com.example.inscription.Daos.OrganismeDao;
import com.example.inscription.Daos.ProfileDao;
import com.example.inscription.Daos.UserDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MenuAdminController implements Initializable {

    private UserDao userDao = new UserDao();
    private DomainDao domainDao = new DomainDao();
    private OrganismeDao organismeDao = new OrganismeDao();
    private ProfileDao profileDao = new ProfileDao();
    @FXML
    TabPane TabPane;


    @FXML
    private TextField TextFieldUSer;

    @FXML
    private TextField TextfieldOrg;

    @FXML
    private TextField Textfielddomaine;
    @FXML
    private Button signOutButton;
    @FXML
    Tab ProfilHandlerTab;
    @FXML
    Tab DomaineHandlerTab;
    @FXML
    Tab OrganismeHandlerTab;

    //Tab User
    @FXML
    Tab UserHandlerTab;

    //Tables View  User
    @FXML
    public TableView<User> tableUser;


    //Les columns user
    @FXML
    private TableColumn<User, Integer> col_id;
    @FXML
    private TableColumn<User, String> col_login;

    @FXML
    private TableColumn<User, String> col_password;

    @FXML
    private TableColumn<User, String> col_role;


    //Table view Domaine

    @FXML
    private TableView<Domaine> tableDomaine;
    @FXML
    private TableColumn<Domaine, Integer> col_iddomaine;


    @FXML
    private TableColumn<Domaine, String> col_libelledomaine;

    public TableView<Domaine> getTableDomaine() {
        return tableDomaine;
    }
// Table View organisme

    @FXML
    private TableView<Organisme> tableOrganisme;
    @FXML
    private TableColumn<Organisme, Integer> col_idorg;
    @FXML
    private TableColumn<Organisme, String> col_lielleorg;

    ObservableList<User> list = FXCollections.observableArrayList(userDao.findAll());
    ObservableList<Organisme> list2 = FXCollections.observableArrayList(organismeDao.findAll());
    ObservableList<Domaine> list1 = FXCollections.observableArrayList(domainDao.findAll());
    ObservableList<Profil> list3 = FXCollections.observableArrayList(profileDao.findAll());


    //Table view Profil
    @FXML
    private TableView<Profil> tableProfil;
    @FXML
    private TableColumn<Profil, Integer> col_idprofil;
    @FXML
    private TableColumn<Profil, String> col_libelleprofil;


    @FXML
    private Button btnRefresh2;
    boolean is_selected = false;


    @Override
    public void initialize(URL url, ResourceBundle rb) {


        // Affiche table user

        col_id.setCellValueFactory(new PropertyValueFactory<User, Integer>("codeutilisateur"));
        col_login.setCellValueFactory(new PropertyValueFactory<User, String>("Login"));
        col_password.setCellValueFactory(new PropertyValueFactory<User, String>("Password"));
        col_role.setCellValueFactory(new PropertyValueFactory<User, String>("Role"));
        tableUser.setItems(list);
        TabPane.getSelectionModel().select(UserHandlerTab);
        //Chercher dans table user
        FilteredList<User> filteredData = new FilteredList<>(list, b -> true);

        TextFieldUSer.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(user -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (user.getLogin().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (user.getPassword().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(user.getCodeutilisateur()).indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false;
            });
        });

        SortedList<User> sortedData = new SortedList<>(filteredData);


        sortedData.comparatorProperty().bind(tableUser.comparatorProperty());

        tableUser.setItems(sortedData);
        refresh();

        //affiche table Domaine

        col_iddomaine.setCellValueFactory(new PropertyValueFactory<Domaine, Integer>("code_domaine"));
        col_libelledomaine.setCellValueFactory(new PropertyValueFactory<Domaine, String>("libelle"));
        list1.addAll();
        if (!is_selected) {
            //chercher dans table domaine
            FilteredList<Domaine> filteredData1 = new FilteredList<>(list1, b -> true);
            Textfielddomaine.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData1.setPredicate(domaine -> {

                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();

                    if (domaine.getLibelle().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true;
                    } else if (String.valueOf(domaine.getCode_domaine()).indexOf(lowerCaseFilter) != -1)
                        return true;
                    else
                        return false;
                });
            });

            SortedList<Domaine> sortedData1 = new SortedList<>(filteredData1);
            sortedData1.comparatorProperty().bind(tableDomaine.comparatorProperty());
            tableDomaine.setItems(sortedData1);
            tableDomaine.refresh();

        }

        //affiche table Organisme


        col_idorg.setCellValueFactory(new PropertyValueFactory<Organisme, Integer>("code_organisme"));
        col_lielleorg.setCellValueFactory(new PropertyValueFactory<Organisme, String>("libelle"));
        tableOrganisme.setItems(list2);
        TabPane.getSelectionModel().select(OrganismeHandlerTab);


        //affiche table Profil
        col_idprofil.setCellValueFactory(new PropertyValueFactory<Profil, Integer>("code_profil"));
        col_libelleprofil.setCellValueFactory(new PropertyValueFactory<Profil, String>("libelle"));
        tableProfil.setItems(list3);
        TabPane.getSelectionModel().select(ProfilHandlerTab);

    }

    @FXML
    void signOut(ActionEvent event) throws IOException {

        //AdminDao.cleanUserSession();
        RoutingClass.goTo((Stage) signOutButton.getScene().getWindow(), "login.fxml", "login", 450, 650);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/views/login.fxml"));
        LoginController controller = new LoginController();
        loader.setController(controller);


    }
    //Gerer User

    @FXML
    private void Ajouter_user(ActionEvent event) throws Exception {
        TabPane.getSelectionModel().select(UserHandlerTab);

        RoutingClass.goTo("Add_user.fxml", "Ajouter", 450, 650);


    }

    @FXML
    private void Modifier_user(ActionEvent event) throws Exception {
        TabPane.getSelectionModel().select(UserHandlerTab);
        if (tableUser.getSelectionModel().getSelectedIndex() > -1) {
            RoutingClass.goTo("Modify_user.fxml", "Modifier", 604, 251, tableUser.getSelectionModel().getSelectedItem());
        } else {
            RoutingClass.alert("please select a line ");
        }

    }


    @FXML
    private void Supprimer_user(ActionEvent event) throws Exception {
        TabPane.getSelectionModel().select(UserHandlerTab);

        if (tableUser.getSelectionModel().getSelectedIndex() > -1) {


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);


            alert.setTitle("Confirmation de supprition");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer?");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setUserData(tableUser.getSelectionModel().getSelectedItem());

                User user = (User) stage.getUserData();
                UserDao userDao = new UserDao();
                userDao.delete(user);
            }


        } else {
            RoutingClass.alert("Sélectionner une ligne ");
        }

    }

    @FXML
    public void refreshTableUtilisateur(ActionEvent Action) {
        TabPane.getSelectionModel().select(UserHandlerTab);
        tableUser.refresh();
        tableUser.getItems().addAll(userDao.findAll());

    }
//Gerer Domaine


    @FXML
    public void refreshTableDomaine(ActionEvent Action) {
        refresh();
    }


    void refresh() {
        is_selected = true;
        TabPane.getSelectionModel().select(DomaineHandlerTab);

        tableDomaine.setItems(list1);
        tableDomaine.refresh();
        col_iddomaine.setCellValueFactory(new PropertyValueFactory<Domaine, Integer>("code_domaine"));
        col_libelledomaine.setCellValueFactory(new PropertyValueFactory<Domaine, String>("libelle"));
        list1.addAll();
        if (!is_selected) {
            //chercher dans table domaine
            FilteredList<Domaine> filteredData1 = new FilteredList<>(list1, b -> true);
            Textfielddomaine.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData1.setPredicate(domaine -> {

                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();

                    if (domaine.getLibelle().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true;
                    } else if (String.valueOf(domaine.getCode_domaine()).indexOf(lowerCaseFilter) != -1)
                        return true;
                    else
                        return false;
                });
            });

            SortedList<Domaine> sortedData1 = new SortedList<>(filteredData1);
            sortedData1.comparatorProperty().bind(tableDomaine.comparatorProperty());
            tableDomaine.setItems(sortedData1);
            tableDomaine.refresh();
        }

        is_selected = false;
    }

    @FXML
    void Ajouter_Domaine(ActionEvent event) throws Exception {
        TabPane.getSelectionModel().select(DomaineHandlerTab);


        RoutingClass.goTo("Add_Domaine.fxml", "Ajouter", 604, 251);


    }


    @FXML
    void Modifier_domaine(ActionEvent event) throws Exception {
        TabPane.getSelectionModel().select(DomaineHandlerTab);
        if (tableDomaine.getSelectionModel().getSelectedIndex() > -1) {
            RoutingClass.goTo("Modify_Domaine.fxml", "Modifier", 604, 251, tableDomaine.getSelectionModel().getSelectedItem());
        } else {
            RoutingClass.alert("please select a line ");
        }
    }

    @FXML
    void Supprimer_domaine(ActionEvent event) throws Exception {
        TabPane.getSelectionModel().select(DomaineHandlerTab);

        if (tableDomaine.getSelectionModel().getSelectedIndex() > -1) {


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);


            alert.setTitle("Confirmation de supprition");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer?");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setUserData(tableDomaine.getSelectionModel().getSelectedItem());

                Domaine domaine = (Domaine) stage.getUserData();
                DomainDao domaineDao = new DomainDao();
                domaineDao.delete(domaine);
            }


        } else {
            RoutingClass.alert("please select a line ");
        }

    }

    //Gerer Organisme
    @FXML
    void Ajouter_org(ActionEvent event) throws IOException {
        TabPane.getSelectionModel().select(OrganismeHandlerTab);
        RoutingClass.goTo("Add_Organisme.fxml", "Supprimer", 604, 251);


    }


    @FXML
    void Chercher_org(ActionEvent event) {
        TabPane.getSelectionModel().select(OrganismeHandlerTab);


    }


    @FXML
    void Modifier_org(ActionEvent event) throws Exception {
        TabPane.getSelectionModel().select(OrganismeHandlerTab);
        if (tableOrganisme.getSelectionModel().getSelectedIndex() > -1) {
            RoutingClass.goTo("Modify_Organisme.fxml", "Supprimer organisme", 604, 251, tableOrganisme.getSelectionModel().getSelectedItem());
        } else {
            RoutingClass.alert("please select a line ");
        }
    }


    @FXML
    void Supprimer_org(ActionEvent event) throws Exception {

        TabPane.getSelectionModel().select(OrganismeHandlerTab);

        if (tableOrganisme.getSelectionModel().getSelectedIndex() > -1) {


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);


            alert.setTitle("Confirmation de supprition");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer?");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setUserData(tableOrganisme.getSelectionModel().getSelectedItem());

                Organisme organisme = (Organisme) stage.getUserData();
                OrganismeDao organismeDao = new OrganismeDao();
                organismeDao.delete(organisme);
            }


        } else {
            RoutingClass.alert("Sélectionnez une ligne ");
        }

    }


    @FXML
    public void refreshTableOrganisme(ActionEvent Action) {
        is_selected = true;
        TabPane.getSelectionModel().select(OrganismeHandlerTab);
        ObservableList<Organisme> list1 = FXCollections.observableArrayList(organismeDao.findAll());
        tableOrganisme.setItems(list1);
        tableOrganisme.refresh();
        is_selected = false;


    }

    //Gerer profil


    @FXML
    void refreshTableProfile(ActionEvent event) {
        TabPane.getSelectionModel().select(ProfilHandlerTab);
        tableProfil.getItems().clear();
        tableProfil.getItems().addAll(profileDao.findAll());
    }

    @FXML
    void Modifier_profile(ActionEvent event) throws Exception {
        TabPane.getSelectionModel().select(ProfilHandlerTab);
        if (tableProfil.getSelectionModel().getSelectedIndex() > -1) {

            RoutingClass.goTo("Modify_profil.fxml", "Modifier", 604, 251, tableProfil.getSelectionModel().getSelectedItem());

        } else {
            RoutingClass.alert("please select a line ");
        }
    }

    @FXML
    void Ajouter_profile(ActionEvent event) throws Exception {
        TabPane.getSelectionModel().select(ProfilHandlerTab);
        RoutingClass.goTo("Add_profil.fxml", "Modifier", 604, 251);

    }

    @FXML
    void Supprimer_profile(ActionEvent event) throws Exception {
        TabPane.getSelectionModel().select(ProfilHandlerTab);

        if (tableProfil.getSelectionModel().getSelectedIndex() > -1) {


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);


            alert.setTitle("Confirmation de supprition");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer?");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setUserData(tableProfil.getSelectionModel().getSelectedItem());

                Profil profil = (Profil) stage.getUserData();
                ProfileDao profileDao = new ProfileDao();
                profileDao.delete(profil);
            }


        } else {
            RoutingClass.alert("Sélectionner une ligne ");
        }

    }
}
