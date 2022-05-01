package com.example.inscription.Controllers;

import com.example.inscription.Controllers.LoginController;
import com.example.inscription.Daos.AdminDao;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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


    @FXML
    private Button btnControl_utilisateur;
    @FXML
    private Button BtnAdduser;

    @FXML
    private Button btnControl_domaine;

    @FXML
    private Button signOutButton;
    private Stage window;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        Pane root = FXMLLoader.load(this.getClass().getResource("/views/Delete.fxml"));
        Scene sceneX = new Scene(root, 604, 251);
        //SecondStage.setMaximized(true);
        SecondStage.setScene(sceneX);
        SecondStage.setTitle("Supprimer");
        SecondStage.show();
    }






}