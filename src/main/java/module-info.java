module com.example.ZooApplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ZooApplication to javafx.fxml;
    exports com.example.ZooApplication;
    exports com.example.ZooApplication.Controllers;
    opens com.example.ZooApplication.Controllers to javafx.fxml;
}