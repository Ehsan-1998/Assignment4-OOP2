package com.example.ZooApplication.Model;

public class Tiger extends  BigCat {
    private final int aWeight;

    public Tiger(String pName, int pAge, int pWeight) {
        super(pName, pAge);
        this.aWeight = pWeight;
    }

    // Getter for weight
    public int getaWeight() {
        return aWeight;
    }
}
