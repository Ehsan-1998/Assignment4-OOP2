package com.example.ZooApplication.Controllers;

import com.example.ZooApplication.Model.Animal;
import com.example.ZooApplication.Model.Enclosure;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class EnclosureViewController {



    @FXML
    private ListView<String> aAnimalListView;

    public void setEnclosure(Enclosure pEnclosure) {
        ObservableList<String> animalNames = FXCollections.observableArrayList();
        for (Animal animal : pEnclosure.getAnimals()) {
            animalNames.add(animal.getName());
        }
        aAnimalListView.setItems(animalNames);
    }
    
}
