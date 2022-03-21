module com.example.mini_projet_fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.mini_projet_fx to javafx.fxml;
    //exports com.example.mini_projet_fx;
    exports db;
    opens db to javafx.fxml;
}