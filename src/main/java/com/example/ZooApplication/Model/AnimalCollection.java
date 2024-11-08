package com.example.ZooApplication.Model;

public interface AnimalCollection {


    void setName(String pName);

    String getName();


    void addCollection(AnimalCollection collection);


    void removeCollection(AnimalCollection collection);

    Enclosure getEnclosureByName(String selectedEnclosureName);
}
