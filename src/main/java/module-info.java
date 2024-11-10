module com.example.zooapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.zooapplication to javafx.fxml;
    exports com.example.zooapplication;
    exports com.example.zooapplication.Controllers;
    opens com.example.zooapplication.Controllers to javafx.fxml;
}