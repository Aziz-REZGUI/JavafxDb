package com.example.inscription.Controllers;

import com.example.inscription.Classes.Domaine;
import com.example.inscription.Classes.Organisme;
import com.example.inscription.Classes.User;
import com.example.inscription.Controllers.LoginController;
import com.example.inscription.Daos.AdminDao;
import com.example.inscription.Daos.UserDao;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuAdminController implements Initializable  {
    private Stage stage;
    private Stage window;
    private UserDao UserDao = new UserDao();


    @FXML
    private Button btnControl_utilisateur, BtnAdduser,btnControl_domaine,signOutButton;
    //Les Tables View
    @FXML
    private TableView<User> tableUser ;


    //Les columns user
    @FXML
    private TableColumn<User, Integer> col_id;
    @FXML
    private TableColumn<User, String> col_login;

    @FXML
    private TableColumn<User, String> col_password;

    @FXML
    private TableColumn<User, String> col_role;

    ObservableList<User> list = FXCollections.observableArrayList(
            UserDao.findAll()
    );

    @FXML
    private TableView<Domaine> tableDomaine ;
    @FXML
    private TableView<Organisme> tableOrganisme ;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO add the rest
        col_id.setCellValueFactory(new PropertyValueFactory<User ,Integer>("codeutilisateur"));
        col_login.setCellValueFactory(new PropertyValueFactory<User ,String>("Login"));
        col_password.setCellValueFactory(new PropertyValueFactory<User ,String>("Password"));
        col_role.setCellValueFactory(new PropertyValueFactory<User ,String>("Role"));
        tableUser.setItems(list);

    }
    @FXML
    void signOut(ActionEvent event) {
        //AdminDao.cleanUserSession();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/views/login.fxml"));
        LoginController controller = new LoginController();
        loader.setController(controller);


    }

    @FXML
    private void Ajouter_user(ActionEvent event) throws Exception {
        Stage SecondStage = new Stage();
        Pane root = FXMLLoader.load(this.getClass().getResource("/views/Add_user.fxml"));
        Scene sceneX = new Scene(root, 604, 251);
        //SecondStage.setMaximized(true);
        SecondStage.setScene(sceneX);
        SecondStage.setTitle("Ajouter");
        SecondStage.show();
    }

    @FXML
    private void Modifier_user(ActionEvent event) throws Exception {
        Stage SecondStage = new Stage();
        Pane root = FXMLLoader.load(this.getClass().getResource("/views/Modify_user.fxml"));
        Scene sceneX = new Scene(root, 604, 251);
        //SecondStage.setMaximized(true);
        SecondStage.setScene(sceneX);
        SecondStage.setTitle("Modifier");
        SecondStage.show();
    }
    @FXML
    private void Supprimer_user(ActionEvent event) throws Exception {
        Stage SecondStage = new Stage();
        Pane root = FXMLLoader.load(this.getClass().getResource("/views/Delete_user.fxml"));
        Scene sceneX = new Scene(root, 604, 251);
        //SecondStage.setMaximized(true);
        SecondStage.setScene(sceneX);
        SecondStage.setTitle("Supprimer");
        SecondStage.show();
    }







}