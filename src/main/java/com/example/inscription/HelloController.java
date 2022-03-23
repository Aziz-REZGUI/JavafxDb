package com.example.inscription;;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
        @FXML
        private Label welcomeText;

        @FXML
        protected void onHelloButtonClick() {
                welcomeText.setText("Welcome to JavaFX Application!");
        }
}
/*
        @FXML
        private VBox vbox;

        @FXML
        private JFXButton close_signin;

        @FXML
        private JFXButton close_signup;

        @FXML
        private Label lbl_time;

        @FXML
        private Label lbl_time2;

        @FXML
        private Pane pane;
        @FXML
        private Parent fxml;
        double x, y = 0;

        @FXML
        private void openSignUp(ActionEvent event) {
            TranslateTransition t = new TranslateTransition(Duration.seconds(2), vbox);
            t.setToX(10);
            t.play();
            close_signup.setVisible(false);
            close_signin.setVisible(true);
            t.setOnFinished((e) -> {
                try {
                    fxml = FXMLLoader.load(getClass().getResource("Signup.fxml"));
                    vbox.getChildren().removeAll();
                    vbox.getChildren().setAll(fxml);

                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }

        @FXML
        private void close(ActionEvent event) {
            Stage stage = (Stage) vbox.getScene().getWindow();
            stage.close();
        }

        @FXML
        private void openSIgnIn(ActionEvent event) {
            TranslateTransition t = new TranslateTransition(Duration.seconds(2), vbox);
            t.setToX(vbox.getLayoutX() * 32);
            t.play();
            close_signup.setVisible(true);
            close_signin.setVisible(false);
            t.setOnFinished((e) -> {
                try {
                    fxml = FXMLLoader.load(getClass().getResource("Signin.fxml"));
                    vbox.getChildren().removeAll();
                    vbox.getChildren().setAll(fxml);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }

        public void updateTime() {
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Calendar time = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    lbl_time.setText(sdf.format(time.getTime()));
                    lbl_time2.setText(sdf.format(time.getTime()));
                }
            }),new KeyFrame(Duration.seconds(1))
            );
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }

        @Override
        public void initialize(URL url, ResourceBundle rb) {
            updateTime();
            TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
            t.setToX(vbox.getLayoutX() * 32);
            t.play();
            close_signin.setVisible(false);
            t.setOnFinished((e) -> {
                try {
                    fxml = FXMLLoader.load(getClass().getResource("Signin.fxml"));
                    vbox.getChildren().removeAll();
                    vbox.getChildren().setAll(fxml);

                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            makeDraggable();
        }

        public void makeDraggable() {
            pane.setOnMousePressed((event) -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
            pane.setOnMouseDragged((event) -> {
                Stage stage = (Stage) vbox.getScene().getWindow();
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
                stage.setOpacity(0.8f);
            });
            pane.setOnDragDone((event) -> {
                Stage stage = (Stage) vbox.getScene().getWindow();
                stage.setOpacity(1f);
            });
            pane.setOnMouseReleased((event) -> {
                Stage stage = (Stage) vbox.getScene().getWindow();
                stage.setOpacity(1f);
            });
        }
*/
