package com.example.ZooApplication.Controllers;

import com.example.ZooApplication.Model.Enclosure;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class AddAnimalController {

    @FXML
    private TextField animalNameField;

    @FXML
    private Button addButton;

    @FXML
    private Button backButton;

    private Enclosure enclosure;

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    @FXML
    protected void onAddButtonClick() {
        String animalName = animalNameField.getText();
        if (animalName != null && !animalName.isEmpty() && enclosure != null) {
            Animal newAnimal = new Animal(animalName);
            enclosure.addAnimal(newAnimal);
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    protected void onBackButtonClick() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/path/to/enclosure-view.fxml"));
            Parent root = fxmlLoader.load();
            EnclosureViewController controller = fxmlLoader.getController();
            controller.setEnclosure(enclosure);

            Stage mainStage = new Stage();
            mainStage.setTitle(enclosure.getName());
            mainStage.setScene(new Scene(root));
            mainStage.initModality(Modality.APPLICATION_MODAL);
            mainStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
