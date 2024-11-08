package com.example.ZooApplication.Model;

import java.util.ArrayList;
import java.util.List;

public class Enclosure implements AnimalCollection {
    private String name;
    private final List<Animal> animals;

    public Enclosure(){
        animals =new ArrayList<>();
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addCollection(AnimalCollection collection) {

    }

    @Override
    public void removeCollection(AnimalCollection collection) {

    }

    @Override
    public Enclosure getEnclosureByName(String selectedEnclosureName) {
        return null;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);

    }

    public List<Animal> getAnimals(){
        return animals;
    }
}
