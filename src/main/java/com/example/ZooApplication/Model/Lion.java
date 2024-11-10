package com.example.ZooApplication.Model;

public class Lion extends BigCat{
    private final int aWeight;
    private final int aManeSize;

    public Lion(String pName, int pAge, int pWeight, int pManeSize) {
        super(pName, pAge); 
        this.aWeight = pWeight;
        this.aManeSize = pManeSize;
    }

    // Getters for weight and maneSize
    public int getWeight() {
        return aWeight;
    }

    public int getManeSize() {
        return aManeSize;
    }
}
