package com.example.inscription.Controllers;

import com.example.inscription.Classes.Domaine;
import com.example.inscription.Classes.Organisme;
import com.example.inscription.Classes.User;
import com.example.inscription.Daos.DomainDao;
import com.example.inscription.Daos.OrganismeDao;
import com.example.inscription.Daos.UserDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuAdminController implements Initializable {
    private Stage stage;
    private Stage window;
    private UserDao userDao = new UserDao();
    private DomainDao domainDao = new DomainDao();
    private OrganismeDao organismeDao = new OrganismeDao();
    @FXML
    TabPane TabPane;
    @FXML
    private Button BtnAddDomaine;

    @FXML
    private Button BtnAddOrg;



    @FXML
    private Button BtnDeleteDomaine;

    @FXML
    private Button BtnDeleteOrg;

    @FXML
    private Button BtnDeleteUser;

    @FXML
    private Button BtnModifyOrg;

    @FXML
    private Button BtnModifyUser;

    @FXML
    private Button BtnModiyDomaine;

    @FXML
    private Button BtnSearchDomaine;

    @FXML
    private Button BtnSearchOrg;

    @FXML
    private Button BtnSearchUser;



    @FXML
    private Tab OrhanismeHandlerTab;

    @FXML
    private TextField TextFieldUSer;

    @FXML
    private TextField TextfieldOrg;

    @FXML
    private TextField Textfielddomaine;



    @FXML
    Tab DomaineHandlerTab;
    @FXML
    Tab OrganismeHandlerTab;
    @FXML
    private Button btnRefresh, btnControl_utilisateur, BtnAdduser, btnControl_domaine, signOutButton;
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

    ObservableList<User> list = FXCollections.observableArrayList(userDao.findAll());

    //Table view Domaine

    @FXML
    private TableView<Domaine> tableDomaine;
    @FXML
    private TableColumn<Domaine, Integer> col_iddomaine;

    @FXML
    private TableColumn<Domaine, String> col_libelledomaine;
    ObservableList<Domaine> list1 = FXCollections.observableArrayList(domainDao.findAll());


// Table View organisme

    @FXML
    private TableView<Organisme> tableOrganisme;
    @FXML
    private TableColumn<Organisme, Integer> col_idorg;
    @FXML
    private TableColumn<Organisme, String> col_lielleorg;

    ObservableList<Organisme> list2 = FXCollections.observableArrayList(organismeDao.findAll());




    @Override
    public void initialize(URL url, ResourceBundle rb) {


        // Affiche table user

        col_id.setCellValueFactory(new PropertyValueFactory<User, Integer>("codeutilisateur"));
        col_login.setCellValueFactory(new PropertyValueFactory<User, String>("Login"));
        col_password.setCellValueFactory(new PropertyValueFactory<User, String>("Password"));
        col_role.setCellValueFactory(new PropertyValueFactory<User, String>("Role"));
        tableUser.setItems(list);
        TabPane.getSelectionModel().select(UserHandlerTab);



        //affiche table Domaine

        col_iddomaine.setCellValueFactory(new PropertyValueFactory<Domaine, Integer>("code_domaine"));
        col_libelledomaine.setCellValueFactory(new PropertyValueFactory<Domaine, String>("libelle"));
        tableDomaine.setItems(list1);
        TabPane.getSelectionModel().select(DomaineHandlerTab);



        //affiche table Organisme
        col_idorg.setCellValueFactory(new PropertyValueFactory<Organisme, Integer>("code_organisme"));
        col_lielleorg.setCellValueFactory(new PropertyValueFactory<Organisme, String>("libelle"));
        tableOrganisme.setItems(list2);
        TabPane.getSelectionModel().select(OrganismeHandlerTab);


    }

    @FXML
    void signOut(ActionEvent event) throws IOException {

        //AdminDao.cleanUserSession();
        RoutingClass.goTo((Stage)signOutButton.getScene().getWindow(),"login.fxml","login");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/views/login.fxml"));
        LoginController controller = new LoginController();
        loader.setController(controller);


    }
    //Gerer User

    @FXML
    private void Ajouter_user(ActionEvent event) throws Exception {
        TabPane.getSelectionModel().select(UserHandlerTab);

        RoutingClass.goTo("Add_user.fxml", "Ajouter", 604, 251);
        /* Stage SecondStage = new Stage();
        Pane root = FXMLLoader.load(this.getClass().getResource("/views/Add_user.fxml"));
        Scene sceneX = new Scene(root, 604, 251);
        //SecondStage.setMaximized(true);
        SecondStage.setScene(sceneX);
        SecondStage.setTitle("Ajouter");
        SecondStage.show();*/

    }

    @FXML
    private void Modifier_user(ActionEvent event) throws Exception {
        TabPane.getSelectionModel().select(UserHandlerTab);

        RoutingClass.goTo("Modify_user.fxml", "Modifier", 604, 251);
        /*Stage SecondStage = new Stage();
        Pane root = FXMLLoader.load(this.getClass().getResource("/views/Modify_user.fxml"));
        Scene sceneX = new Scene(root, 604, 251);
        //SecondStage.setMaximized(true);
        SecondStage.setScene(sceneX);
        SecondStage.setTitle("Modifier");
        SecondStage.show();*/

    }


    @FXML
    private void Supprimer_user(ActionEvent event) throws Exception {
        TabPane.getSelectionModel().select(UserHandlerTab);

        RoutingClass.goTo("Delete_user.fxml", "Supprimer", 604, 251);

        /*Stage SecondStage = new Stage();
        Pane root = FXMLLoader.load(this.getClass().getResource("/views/Delete_user.fxml"));
        Scene sceneX = new Scene(root, 604, 251);
        //SecondStage.setMaximized(true);
        SecondStage.setScene(sceneX);
        SecondStage.setTitle("Supprimer");
        SecondStage.show();*/
    }

    @FXML
    public void refreshTableUtilisateur(ActionEvent Action) {
        TabPane.getSelectionModel().select(UserHandlerTab);

        tableUser.getItems().clear();
        tableUser.getItems().addAll(userDao.findAll());

    }
//Gerer Domaine


    @FXML
    public void refreshTableDomaine(ActionEvent Action) {
        TabPane.getSelectionModel().select(DomaineHandlerTab);

        tableDomaine.getItems().clear();
        tableDomaine.getItems().addAll(domainDao.findAll());

    }


    @FXML
    void Ajouter_Domaine(ActionEvent event) throws Exception {
        TabPane.getSelectionModel().select(DomaineHandlerTab);


        RoutingClass.goTo("Add_Domaine.fxml", "Ajouter", 604, 251);


    }



    @FXML
    void Modifier_domaine(ActionEvent event) throws Exception {
        TabPane.getSelectionModel().select(DomaineHandlerTab);

        RoutingClass.goTo("Modify_Domaine.fxml", "Modifier", 604, 251);

    }

    @FXML
    void Supprimer_domaine(ActionEvent event) throws Exception {
        TabPane.getSelectionModel().select(DomaineHandlerTab);

        RoutingClass.goTo("Delete_Domain.fxml", "Supprimer", 604, 251);

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
    void Modifier_org(ActionEvent event) throws Exception{
        TabPane.getSelectionModel().select(OrganismeHandlerTab);
        RoutingClass.goTo("Modify_Organisme.fxml", "Supprimer organisme", 604, 251);
    }




    @FXML
    void Supprimer_org(ActionEvent event) throws Exception{
        TabPane.getSelectionModel().select(OrganismeHandlerTab);
        RoutingClass.goTo("Delete_Organisme.fxml", "Supprimer organisme", 604, 251);



    }
    @FXML
    public void refreshTableOrganisme(ActionEvent Action) {
        TabPane.getSelectionModel().select(OrganismeHandlerTab);

        tableOrganisme.getItems().clear();
        tableOrganisme.getItems().addAll(organismeDao.findAll());

    }


}

