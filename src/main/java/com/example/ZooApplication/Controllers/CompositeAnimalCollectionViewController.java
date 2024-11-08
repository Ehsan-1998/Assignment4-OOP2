package com.example.ZooApplication.Controllers;

import com.example.ZooApplication.Helpers.ImportHelper;
import com.example.ZooApplication.Model.AnimalCollection;
import com.example.ZooApplication.Model.CompositeAnimalCollection;
import com.example.ZooApplication.Model.Enclosure;
import com.example.ZooApplication.ZooApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class CompositeAnimalCollectionViewController  {

    @FXML
    private ListView<String> enclosureListView;

    private final CompositeAnimalCollection aCompositeAnimalCollection = ImportHelper.createAnimals();

    @FXML
    private Button backButton;

    @FXML
    private Button displayButton;

    @FXML
    private void initialize() {
        populateEnclosureListView();
    }



    private void populateEnclosureListView() {
        ObservableList<String> enclosureNames = FXCollections.observableArrayList();
        addEnclosureNames(aCompositeAnimalCollection, enclosureNames);
        enclosureListView.setItems(enclosureNames);
    }

    // Recursively add the names of enclosures and composite collections to the list
    private void addEnclosureNames(CompositeAnimalCollection collection, ObservableList<String> enclosureNames) {
        for (AnimalCollection subCollection : collection.getCollections()) {
            if (subCollection instanceof Enclosure) {
                // Add only the top-level enclosures
                enclosureNames.add(((Enclosure) subCollection).getName());
            } else if (subCollection instanceof CompositeAnimalCollection composite) {
                // Add only the top-level composite collections (without their nested enclosures)
                enclosureNames.add(composite.getName());
                // Avoid recursion to nested enclosures
            }
        }
    }


    @FXML
    protected void onDisplayButtonClick(ActionEvent pEvent) throws IOException {
        String selectedEnclosureName = enclosureListView.getSelectionModel().getSelectedItem();

        // Check if the selected item is an enclosure
        Enclosure selectedEnclosure = aCompositeAnimalCollection.getEnclosureByName(selectedEnclosureName);

        if (selectedEnclosure != null) {
            // If it's an enclosure, display its animals
            FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("enclosure-view.fxml"));
            Parent view = fxmlLoader.load();
            EnclosureViewController newEnclosureViewController = fxmlLoader.getController();
            newEnclosureViewController.setEnclosure(selectedEnclosure);
            Scene nextScene = new Scene(view, 500, 500);
            Stage nextStage = new Stage();
            nextStage.setScene(nextScene);
            nextStage.setTitle(selectedEnclosure.getName());
            nextStage.initModality(Modality.WINDOW_MODAL);
            nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
            nextStage.showAndWait();
        } else {
            // If it's not an enclosure, check if it's a composite animal collection
            CompositeAnimalCollection selectedCompositeCollection = aCompositeAnimalCollection.getCompositeByName(selectedEnclosureName);

            if (selectedCompositeCollection != null) {
                // If it's a composite collection (e.g., Tigers), display the composite collection view
                FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("composite-animal-collection-view.fxml"));
                Parent view = fxmlLoader.load();
                CompositeAnimalCollectionViewController compositeViewController = fxmlLoader.getController();
                compositeViewController.setCompositeAnimalCollection(selectedCompositeCollection);
                Scene nextScene = new Scene(view, 500, 500);
                Stage nextStage = new Stage();
                nextStage.setScene(nextScene);
                nextStage.setTitle(selectedCompositeCollection.getName());
                nextStage.initModality(Modality.WINDOW_MODAL);
                nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
                nextStage.showAndWait();
            } else {
                // Handle error if no enclosure or composite collection is selected
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No selection");

                alert.setContentText("Please select an enclosure or composite collection from the list.");
                alert.showAndWait();
            }
        }
    }

    private void setCompositeAnimalCollection(CompositeAnimalCollection selectedCompositeCollection) {
        ObservableList<String> subEnclosures = FXCollections.observableArrayList();

        // Add sub-enclosures to the list
        for (AnimalCollection collection : selectedCompositeCollection.getCollections()) {
            if (collection instanceof Enclosure enclosure) {
                subEnclosures.add(enclosure.getName());
            }
        }

        // Assuming you have a ListView to display the sub-enclosures of the composite collection
        enclosureListView.setItems(subEnclosures);
    }


    @FXML
    protected void onBackButtonClick(ActionEvent pEvent) {
        Stage stage = (Stage) ((Node) pEvent.getSource()).getScene().getWindow();
        stage.close();
    }

}