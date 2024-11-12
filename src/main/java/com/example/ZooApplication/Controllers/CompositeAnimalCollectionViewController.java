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
    private ListView<String> aEnclosureListView;

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
        ObservableList<String> aEnclosureNames = FXCollections.observableArrayList();
        addEnclosureNames(aCompositeAnimalCollection, aEnclosureNames);
        aEnclosureListView.setItems(aEnclosureNames);
    }

    // Recursively add the names of enclosures and composite collections to the list
    private void addEnclosureNames(CompositeAnimalCollection pCollection, ObservableList<String> enclosureNames) {
        for (AnimalCollection aSubCollection : pCollection.getaCollections()) {
            if (aSubCollection instanceof Enclosure) {
                // Add only the top-level enclosures
                enclosureNames.add(((Enclosure) aSubCollection).getName());
            } else if (aSubCollection instanceof CompositeAnimalCollection aComposite) {
                // Add only the top-level composite collections (without their nested enclosures)
                enclosureNames.add(aComposite.getName());
                // Avoid recursion to nested enclosures
            }
        }
    }


    @FXML
    protected void onDisplayButtonClick(ActionEvent pEvent) throws IOException {
        String aSelectedEnclosureName = aEnclosureListView.getSelectionModel().getSelectedItem();

        // Check if the selected item is an enclosure
        Enclosure aSelectedEnclosure = aCompositeAnimalCollection.getEnclosureByName(aSelectedEnclosureName);

        if (aSelectedEnclosure != null) {
            // If it's an enclosure, display its animals
            FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("enclosure-view.fxml"));
            Parent view = fxmlLoader.load();
            EnclosureViewController newEnclosureViewController = fxmlLoader.getController();
            newEnclosureViewController.setEnclosure(aSelectedEnclosure);
            Scene nextScene = new Scene(view, 500, 500);
            Stage nextStage = new Stage();
            nextStage.setScene(nextScene);
            nextStage.setTitle(aSelectedEnclosure.getName());
            nextStage.initModality(Modality.WINDOW_MODAL);
            nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
            nextStage.showAndWait();
        } else {
            // If it's not an enclosure, check if it's a composite animal collection
            CompositeAnimalCollection aSelectedCompositeCollection = aCompositeAnimalCollection.getCompositeByName(aSelectedEnclosureName);

            if (aSelectedCompositeCollection != null) {
                // If it's a composite collection (e.g., Tigers), display the composite collection view
                FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("composite-animal-collection-view.fxml"));
                Parent view = fxmlLoader.load();
                CompositeAnimalCollectionViewController compositeViewController = fxmlLoader.getController();
                compositeViewController.setCompositeAnimalCollection(aSelectedCompositeCollection);
                Scene nextScene = new Scene(view, 500, 500);
                Stage nextStage = new Stage();
                nextStage.setScene(nextScene);
                nextStage.setTitle(aSelectedCompositeCollection.getName());
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

    private void setCompositeAnimalCollection(CompositeAnimalCollection pSelectedCompositeCollection) {
        ObservableList<String> aSubEnclosures = FXCollections.observableArrayList();

        // Add sub-enclosures to the list
        for (AnimalCollection aCollection : pSelectedCompositeCollection.getaCollections()) {
            if (aCollection instanceof Enclosure aEnclosure) {
                aSubEnclosures.add(aEnclosure.getName());
            }
        }

        // a ListView to display the sub-enclosures of the composite collection
        aEnclosureListView.setItems(aSubEnclosures);
    }


    @FXML
    protected void onBackButtonClick(ActionEvent pEvent) {
        Stage stage = (Stage) ((Node) pEvent.getSource()).getScene().getWindow();
        stage.close();
    }

}