package com.example.ZooApplication.Controllers;

import com.example.ZooApplication.Model.Animal;
import com.example.ZooApplication.Model.Enclosure;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class EnclosureViewController {



    @FXML
    private ListView<String> animalListView;

    public void setEnclosure(Enclosure enclosure) {
        ObservableList<String> animalNames = FXCollections.observableArrayList();
        for (Animal animal : enclosure.getAnimals()) {
            animalNames.add(animal.getName());
        }
        animalListView.setItems(animalNames);
    }
    
}
