package com.example.ZooApplication.Model;

import java.util.ArrayList;
import java.util.List;

public class Enclosure implements AnimalCollection {
    private String aName;
    private final List<Animal> aAnimals;

    public Enclosure(){
        aAnimals =new ArrayList<>();
    }

    @Override
    public void setName(String pName) {
        this.aName = pName;
    }

    @Override
    public String getName() {
        return aName;
    }

    @Override
    public void addCollection(AnimalCollection pCollection) {

    }



    @Override
    public Enclosure getEnclosureByName(String pSelectedEnclosureName) {
        return null;
    }

    public void addAnimal(Animal pAnimal) {
        aAnimals.add(pAnimal);

    }

    public List<Animal> getAnimals(){
        return aAnimals;
    }
}
