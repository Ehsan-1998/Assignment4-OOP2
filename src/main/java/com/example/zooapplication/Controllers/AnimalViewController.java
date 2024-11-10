package com.example.zooapplication.Controllers;

import com.example.zooapplication.Model.Animal;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class AnimalViewController{
   @FXML
   private TextField nameTextField;
   @FXML
   private TextField ageTextField;
   @FXML
   private TextField sexTextField;
   @FXML
   private TextField weightTextField;

   private List<Animal> animals;
   private Animal selectedAnimal;

   public AnimalViewController(){
       this.animals = loadAnimals();
   }

    public void setAnimal(Animal animal) {
        this.selectedAnimal = animal;
        if (animal != null) {
            nameTextField.setText(animal.getName());
            sexTextField.setText(animal.getSex());
            ageTextField.setText(String.valueOf(animal.getAge()));
            weightTextField.setText(String.valueOf(animal.getWeight()));
        }
    }

    @FXML
    private void onSaveButtonClick() {
        try {
            String name = nameTextField.getText();
            String sex = sexTextField.getText();
            int age = Integer.parseInt(ageTextField.getText());
            double weight = Double.parseDouble(weightTextField.getText());

            if (selectedAnimal == null) {
                // Adding a new animal
                Animal newAnimal = new Animal(name, sex, age, weight);
                animals.add(newAnimal);
            } else {
                // Modifying an existing animal
                selectedAnimal.setName(name);
                selectedAnimal.setSex(sex);
                selectedAnimal.setAge(age);
                selectedAnimal.setWeight(weight);
            }

            saveAnimals();
            showConfirmation("Animal Saved", "Animal information has been saved successfully.");
            onClearButtonClick();

        } catch (NumberFormatException e) {
            showError("Invalid input", "Please enter valid numbers for age and weight.");
        }
    }

    @FXML
    private void onCloseButtonClick() {
       Stage stage = (Stage) nameTextField.getScene().getWindow();
       stage.close();
    }
    @FXML
    private void onClearButtonClick() {
        nameTextField.clear();
        sexTextField.clear();
        ageTextField.clear();
        weightTextField.clear();
    }

    private void saveAnimals() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("animals.ser"))) {
            oos.writeObject(animals);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private List<Animal> loadAnimals() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("animals.ser"))) {
            return (List<Animal>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }



    private void showError(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
   }
    private void showConfirmation(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}


