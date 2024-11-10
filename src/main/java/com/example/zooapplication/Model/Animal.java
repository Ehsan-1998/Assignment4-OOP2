package com.example.ZooApplication.Model;

import java.io.Serializable;

public class Animal implements Serializable {
    private String aName;
    private String aSex;
    private int aAge;
    public double aWeight;

    // No-argument constructor
    public Animal() {
    }

    // Constructor with all arguments
    public Animal(String pName, String pSex, int pAge, double pWeight) {
        this.aName = pName;
        this.aSex = pSex;
        this.aAge = pAge;
        this.aWeight = pWeight;
    }

    public String getName() { return aName; }
    public void setName(String pName) { this.aName = pName; }

    public String getSex() { return aSex; }
    public void setSex(String pSex) { this.aSex = pSex; }

    public int getAge() { return aAge; }
    public void setAge(int pAge) { this.aAge = pAge; }

    public double getWeight() { return aWeight; }
    public void setWeight(double pWeight) { this.aWeight = pWeight; }
}
