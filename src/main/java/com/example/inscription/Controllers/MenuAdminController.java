package com.example.inscription.Controllers;

import com.example.inscription.Classes.Domaine;
import com.example.inscription.Classes.Organisme;
import com.example.inscription.Classes.User;
import com.example.inscription.Daos.UserDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuAdminController implements Initializable {
    private Stage stage;
    private Stage window;
    private UserDao userDao = new UserDao();


    @FXML
    private Button btnRefresh, btnControl_utilisateur, BtnAdduser, btnControl_domaine, signOutButton;
    //Les Tables View
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
    @FXML
    private TableView<Domaine> tableDomaine;
    @FXML
    private TableView<Organisme> tableOrganisme;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO add the rest
        col_id.setCellValueFactory(new PropertyValueFactory<User, Integer>("codeutilisateur"));
        col_login.setCellValueFactory(new PropertyValueFactory<User, String>("Login"));
        col_password.setCellValueFactory(new PropertyValueFactory<User, String>("Password"));
        col_role.setCellValueFactory(new PropertyValueFactory<User, String>("Role"));
        tableUser.setItems(list);
    }

    @FXML
    void signOut(ActionEvent event) throws IOException {
        //AdminDao.cleanUserSession();
//TODO check with abir
        RoutingClass.goTo((Stage)signOutButton.getScene().getWindow(),"login.fxml","login");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/views/login.fxml"));
        LoginController controller = new LoginController();
        loader.setController(controller);


    }

    @FXML
    private void Ajouter_user(ActionEvent event) throws Exception {
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
    public void refreshTable(ActionEvent Action) {
        tableUser.getItems().clear();
        tableUser.getItems().addAll(userDao.findAll());
    }


}