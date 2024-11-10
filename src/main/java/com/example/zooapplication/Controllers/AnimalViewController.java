package com.example.ZooApplication.Controllers;
import com.example.ZooApplication.Model.Animal;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.example.ZooApplication.Model.Lion;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class AnimalViewController{
   @FXML
   private TextField aNameTextField;
   @FXML
   private TextField aAgeTextField;
   @FXML
   private TextField aSexTextField;
   @FXML
   private TextField aWeightTextField;
   @FXML
   private TextField aManeSizeTextField;

   private List<Animal> aAnimals;
   private Animal aSelectedAnimal;

   public AnimalViewController(){
       this.aAnimals = loadAnimals();
   }

    public void setAnimal(Animal aAnimal) {
        this.aSelectedAnimal = aAnimal;
        if (aAnimal != null) {
            aNameTextField.setText(aAnimal.getName());
            aSexTextField.setText(aAnimal.getSex());
            aAgeTextField.setText(String.valueOf(aAnimal.getAge()));
            aWeightTextField.setText(String.valueOf(aAnimal.getWeight()));

            if (aAnimal instanceof Lion) {
                aManeSizeTextField.setVisible(true);
                aManeSizeTextField.setText(String.valueOf(((Lion) aAnimal).getManeSize())); // Load mane size for Lion
            } else {
                aManeSizeTextField.setVisible(false);
            }
        }
    }


    @FXML
    private void onSaveButtonClick() {
        try {
            String aName = aNameTextField.getText();
            String aSex = aSexTextField.getText();
            int aAge = Integer.parseInt(aAgeTextField.getText());
            double aWeight = Double.parseDouble(aWeightTextField.getText());

            if (aSelectedAnimal == null) {
                // Adding a new animal
                Animal aNewAnimal = new Animal(aName, aSex, aAge, aWeight);

                // If the animal is a Lion, set the mane size
                if (aSelectedAnimal instanceof Lion) {
                    int maneSize = Integer.parseInt(aManeSizeTextField.getText());  // Mane size for Lions
                    aNewAnimal = new Lion(aName, aAge, aSex, aWeight, maneSize);
                }

                aAnimals.add(aNewAnimal);
            } else {
                // Modifying an existing animal
                aSelectedAnimal.setName(aName);
                aSelectedAnimal.setSex(aSex);
                aSelectedAnimal.setAge(aAge);
                aSelectedAnimal.setWeight(aWeight);

                // If the animal is a Lion, update the mane size
                if (aSelectedAnimal instanceof Lion) {
                    int maneSize = Integer.parseInt(aManeSizeTextField.getText());
                    ((Lion) aSelectedAnimal).setManeSize(maneSize);
                }
            }

            saveAnimals();
            showConfirmation("Animal Saved", "Animal information has been saved successfully.");
            onClearButtonClick();

        } catch (NumberFormatException aE) {
            showError("Invalid input", "Please enter valid numbers for age and weight.");
        }
    }

    @FXML
    private void onCloseButtonClick() {
        Stage aStage = (Stage) aNameTextField.getScene().getWindow();
        aStage.close();
    }
    @FXML
    private void onClearButtonClick() {
        aNameTextField.clear();
        aSexTextField.clear();
        aAgeTextField.clear();
        aWeightTextField.clear();
        aManeSizeTextField.clear();
    }

    private void saveAnimals() {
        try (ObjectOutputStream aOos = new ObjectOutputStream(new FileOutputStream("animals.ser"))) {
            aOos.writeObject(aAnimals);
        } catch (IOException aE) {
            aE.printStackTrace();
        }
    }
    private List<Animal> loadAnimals() {
        try (ObjectInputStream aOis = new ObjectInputStream(new FileInputStream("animals.ser"))) {
            return (List<Animal>) aOis.readObject();
        } catch (IOException | ClassNotFoundException aE) {
            return new ArrayList<>();
            }
    }



    private void showError(String aTitle, String aMessage) {
        Alert aAlert = new Alert(AlertType.ERROR);
        aAlert.setTitle(aTitle);
        aAlert.setContentText(aMessage);
        aAlert.showAndWait();

    }
    private void showConfirmation(String aTitle, String aMessage) {
        Alert aAlert = new Alert(AlertType.INFORMATION);
        aAlert.setTitle(aTitle);
        aAlert.setContentText(aMessage);
        aAlert.showAndWait();
    }
}


