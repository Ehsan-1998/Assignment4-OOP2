package com.example.ZooApplication.Model;

import java.util.ArrayList;
import java.util.List;

public class CompositeAnimalCollection implements AnimalCollection {
    private final List<AnimalCollection> collections;
    private String name;

    public CompositeAnimalCollection() {
        collections = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addCollection(AnimalCollection collection) {
        collections.add(collection);
    }

    @Override
    public void removeCollection(AnimalCollection collection) {
        collections.remove(collection);
    }


    @Override
    public Enclosure getEnclosureByName(String selectedEnclosureName) {
        for (AnimalCollection collection : collections) {
            if (collection instanceof Enclosure enclosure) {
                if (enclosure.getName().equals(selectedEnclosureName)) {
                    return enclosure;
                }
            } else if (collection instanceof CompositeAnimalCollection) {
                Enclosure enclosure = ((CompositeAnimalCollection) collection).getEnclosureByName(selectedEnclosureName);
                if (enclosure != null) {
                    return enclosure;
                }
            }
        }
        return null;
    }

    public List<AnimalCollection> getCollections() {
        return collections;


    }

    public CompositeAnimalCollection getCompositeByName(String name) {
        if (this.name.equals(name)) {
            return this;
        }
        for (AnimalCollection collection : this.getCollections()) {
            if (collection instanceof CompositeAnimalCollection composite) {
                CompositeAnimalCollection found = composite.getCompositeByName(name);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }
}
