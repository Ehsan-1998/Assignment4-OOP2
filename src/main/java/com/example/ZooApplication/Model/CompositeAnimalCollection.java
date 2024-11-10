package com.example.ZooApplication.Model;

import java.util.ArrayList;
import java.util.List;

public class CompositeAnimalCollection implements AnimalCollection {
    private final List<AnimalCollection> aCollections;
    private String aName;

    public CompositeAnimalCollection() {
        aCollections = new ArrayList<>();
    }

    @Override
    public String getName() {
        return aName;
    }

    @Override
    public void setName(String pName) {
        this.aName = pName;
    }

    @Override
    public void addCollection(AnimalCollection pCollection) {
        aCollections.add(pCollection);
    }



    @Override
    public Enclosure getEnclosureByName(String pSelectedEnclosureName) {
        for (AnimalCollection aCollection : aCollections) {
            if (aCollection instanceof Enclosure aEnclosure) {
                if (aEnclosure.getName().equals(pSelectedEnclosureName)) {
                    return aEnclosure;
                }
            } else if (aCollection instanceof CompositeAnimalCollection) {
                Enclosure aEnclosure = ((CompositeAnimalCollection) aCollection).getEnclosureByName(pSelectedEnclosureName);
                if (aEnclosure != null) {
                    return aEnclosure;
                }
            }
        }
        return null;
    }

    public List<AnimalCollection> getaCollections() {
        return aCollections;


    }

    public CompositeAnimalCollection getCompositeByName(String pName) {
        if (this.aName.equals(pName)) {
            return this;
        }
        for (AnimalCollection aCollection : this.getaCollections()) {
            if (aCollection instanceof CompositeAnimalCollection aComposite) {
                CompositeAnimalCollection aFound = aComposite.getCompositeByName(pName);
                if (aFound != null) {
                    return aFound;
                }
            }
        }
        return null;
    }
}
