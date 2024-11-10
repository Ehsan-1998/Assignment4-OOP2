module com.example.ZooApplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;


    opens com.example.ZooApplication to javafx.fxml;
    exports com.example.ZooApplication;
    exports com.example.ZooApplication.Controllers;
    opens com.example.ZooApplication.Controllers to javafx.fxml;
    exports com.example.ZooApplication.Model;
    opens com.example.ZooApplication.Model to javafx.fxml;

}