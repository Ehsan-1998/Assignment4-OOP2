package com.example.zooapplication.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AnimalViewController {
   @FXML
   private TextField nameTextField;
   @FXML
   private TextField ageTextField;
   @FXML
   private TextField sexTextField;
   @FXML
   private TextField weightTextField;

    public String name;
    public String age;
    public String sex;
    public String weight;


    @FXML
    public void onNameTextField(ActionEvent actionEvent) {
        setName(nameTextField.getText());
    }
    @FXML
    public void onSexTextField(ActionEvent actionEvent) {
        setSex(ageTextField.getText());
    }
    @FXML
    public void onAgeTextField(ActionEvent actionEvent) {
        setAge(ageTextField.getText());
    }
    @FXML
    public void onWeightTextField(ActionEvent actionEvent) {
        setWeight(weightTextField.getText());
    }
    @FXML
    public void onSaveButtonClick(ActionEvent actionEvent) {
    setName(nameTextField.getText());
    setAge(ageTextField.getText());
    setSex(sexTextField.getText());
    setWeight(weightTextField.getText());

    }
    @FXML
    public void onCloseButtonClick(ActionEvent actionEvent) {

    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
        nameTextField.setText(name);
    }

    public String getAge(){
        return age;

    }
    public void setAge(String age){
        this.age = age;

    }

    public String getSex(){
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWeight(){
        return weight;
}
public void setWeight(String weight){
        this.weight = weight;
}

}

