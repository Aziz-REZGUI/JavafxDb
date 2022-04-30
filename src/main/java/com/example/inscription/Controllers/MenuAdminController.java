package com.example.inscription.Controllers;

import com.example.inscription.Controllers.LoginController;
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
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuAdminController implements Initializable  {

    private Stage stage;


    @FXML
    private Button btnControl_utilisateur;
    @FXML
    private Button btnControl_profil;
    @FXML
    private Font x1;
    @FXML
    private Color x2;
    @FXML
    private Button btnControl_domaine;
    @FXML
    private Font x3;
    @FXML
    private Button signOutButton;
    private Stage window;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnControl_utilisateur(ActionEvent event) throws Exception {

        Parent signUp = FXMLLoader.load(getClass().getResource("/views/Gerer_utilisateur.fxml"));
        Scene scene = new Scene(signUp, 1500, 870);
        scene.getStylesheets().add(this.getClass().getResource("/views/login.css").toExternalForm());

        //This line gets the stage information
        stage = (Stage)  btnControl_utilisateur.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Sign up");
        stage.setMaximized(true);
        stage.show();
        }
    @FXML
    void signOut(ActionEvent event) {
       // he4i tetzed ken najmou User.cleanUserSession();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/views/login.fxml"));
        LoginController controller = new LoginController();
        loader.setController(controller);

        Stage currentStage = (Stage) signOutButton.getScene().getWindow();
        Stage newStage = new Stage();
        try {
            Parent root = loader.load();
            Scene registerScene = new Scene(root);

            newStage.setScene(registerScene);
            newStage.setTitle("Login Page");

            currentStage.close();
            newStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Add_user(ActionEvent event) throws IOException {


        Parent Add_user = FXMLLoader.load(getClass().getResource("/views/Add_user.fxml"));
        Scene scene = new Scene(Add_user, 1500, 870);
        scene.getStylesheets().add(this.getClass().getResource("/views/login.css").toExternalForm());

        //This line gets the stage information
        window = (Stage) Add_user.getScene().getWindow();
        window.setScene(scene);
        window.setTitle("Get");
        window.setMaximized(true);
        window.show();
    }




   // he4iya il faza nal9a feha fi log out ama mesh fehma exactly shniya hiya so hawahi lenna taw @SuppressWarnings("unchecked")



}