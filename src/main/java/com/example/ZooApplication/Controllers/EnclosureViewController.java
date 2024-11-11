package com.example.ZooApplication.Controllers;

import com.example.ZooApplication.Model.Enclosure;
import com.example.ZooApplication.Model.Animal; // Ensure to import the Animal class
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
    private TextField aAnimalNameField;

    @FXML
    private Button aAddButton;

    @FXML
    private Button aBackButton;

    private Enclosure aEnclosure;

    public void setEnclosure(Enclosure pEnclosure) {
        this.aEnclosure = pEnclosure;
    }

    @FXML
    protected void onAddButtonClick() {
        String aAnimalName = aAnimalNameField.getText();
        if (aAnimalName != null && !aAnimalName.isEmpty() && aEnclosure != null) {
            Animal aNewAnimal = new Animal(aAnimalName);
            aEnclosure.addAnimal(aNewAnimal);
            Stage aStage = (Stage) aAddButton.getScene().getWindow();
            aStage.close();
        }
    }

    @FXML
    protected void onBackButtonClick() {
        Stage aStage = (Stage) aBackButton.getScene().getWindow();
        aStage.close();

        try {
            FXMLLoader aFxmlLoader = new FXMLLoader(getClass().getResource("/path/to/enclosure-view.fxml"));
            Parent aRoot = aFxmlLoader.load();
            EnclosureViewController aController = aFxmlLoader.getController();
            aController.setEnclosure(aEnclosure);

            Stage aMainStage = new Stage();
            aMainStage.setTitle(aEnclosure.getName());
            aMainStage.setScene(new Scene(aRoot));
            aMainStage.initModality(Modality.APPLICATION_MODAL);
            aMainStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}