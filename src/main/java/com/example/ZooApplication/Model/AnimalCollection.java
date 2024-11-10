package com.example.ZooApplication.Model;

public interface AnimalCollection {


    void setName(String pName);

    String getName();


    void addCollection(AnimalCollection pCollection);


    Enclosure getEnclosureByName(String pSelectedEnclosureName);
}
