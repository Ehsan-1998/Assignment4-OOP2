package com.example.ZooApplication.Helpers;


import com.example.ZooApplication.Model.*;

/**
 * @author Matthias Harte
 */
public class ImportHelper {

    public static CompositeAnimalCollection createAnimals() {
        // Create the lions enclosure
        Enclosure lions = new Enclosure();
        lions.setName("Lions");
        lions.addAnimal(new Lion("Simba", 3, 36, 5));
        lions.addAnimal(new Lion("Mufasa", 8, 41, 3));
        lions.addAnimal(new Lion("Nala", 3, 30, 3));

        // Create the tiger habitat enclosure
        Enclosure tigerHabitat = new Enclosure();
        tigerHabitat.setName("Tigers Habitat");
        tigerHabitat.addAnimal(new Tiger("Shere Kahn", 3, 25));
        tigerHabitat.addAnimal(new Tiger("Rajah", 3, 23));

        // Create the tiger cubs enclosure
        Enclosure cubs = new Enclosure();
        cubs.setName("Tiger Cubs");
        cubs.addAnimal(new Tiger("Tala", 5, 30));
        cubs.addAnimal(new Tiger("Ravi", 0, 2));
        cubs.addAnimal(new Tiger("Kali", 0, 2));
        cubs.addAnimal(new Tiger("Indra", 0, 2));

        // Create composite for tigers
        CompositeAnimalCollection tigers = new CompositeAnimalCollection();
        tigers.setName("Tigers");
        tigers.addCollection(tigerHabitat);
        tigers.addCollection(cubs);

        // Create the cougars enclosure
        Enclosure cougarsEnclosure = new Enclosure();
        cougarsEnclosure.setName("Cougars");
        cougarsEnclosure.addAnimal(new Cougar("Sierra", 3, 25)); // Add Sierra
        cougarsEnclosure.addAnimal(new Cougar("Rocky", 3, 18)); // Add Rocky
        cougarsEnclosure.addAnimal(new Cougar("Luna", 2, 23));  // Add Luna
        cougarsEnclosure.addAnimal(new Cougar("Lenny", 1, 26));  // Add Lenny

        // Create the big cats composite
        CompositeAnimalCollection bigCats = new CompositeAnimalCollection();
        bigCats.setName("Big Cats");
        bigCats.addCollection(lions);
        bigCats.addCollection(tigers);
        bigCats.addCollection(cougarsEnclosure);

        return bigCats;
    }
}