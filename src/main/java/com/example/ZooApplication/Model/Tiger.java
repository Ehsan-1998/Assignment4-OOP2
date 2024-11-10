package com.example.ZooApplication.Model;

public class Tiger extends  BigCat {
    private final int aWeight;

    // Constructor for Tiger with name, age, sex, and weight
    public Tiger(String pName, int pAge, String pSex, double pWeight) {
        super(pName, pAge, pSex, pWeight); // Pass all parameters to BigCat constructor
        this.aWeight = (int) pWeight;  // Store the weight for the Tiger
    }

    // Getter for weight
    public int getaWeight() {
        return aWeight;
    }
}
