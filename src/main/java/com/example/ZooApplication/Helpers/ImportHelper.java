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
        lions.addAnimal(new Lion("Simba", 3, "Male",36, 10 ));
        lions.addAnimal(new Lion("Mufasa", 8, "Male", 41, 15 ));
        lions.addAnimal(new Lion("Nala", 3, "Female", 30,0 ));

        // Create the tiger habitat enclosure
        Enclosure tigerHabitat = new Enclosure();
        tigerHabitat.setName("Tigers Habitat");
        tigerHabitat.addAnimal(new Tiger("Shere Kahn", 3, "Male",33));
        tigerHabitat.addAnimal(new Tiger("Rajah", 3, "Male",34));

        // Create the tiger cubs enclosure
        Enclosure cubs = new Enclosure();
        cubs.setName("Tiger Cubs");
        cubs.addAnimal(new Tiger("Tala", 5, "Female",34));
        cubs.addAnimal(new Tiger("Ravi", 0, "Male",12));
        cubs.addAnimal(new Tiger("Kali", 0, "Female",10));
        cubs.addAnimal(new Tiger("Indra", 0, "Male",11));

        // Create composite for tigers
        CompositeAnimalCollection tigers = new CompositeAnimalCollection();
        tigers.setName("Tigers");
        tigers.addCollection(tigerHabitat);
        tigers.addCollection(cubs);

        // Create the cougars enclosure
        Enclosure cougarsEnclosure = new Enclosure();
        cougarsEnclosure.setName("Cougars");
        cougarsEnclosure.addAnimal(new Cougar("Sierra", 3, 25, "Female")); // Add Sierra
        cougarsEnclosure.addAnimal(new Cougar("Rocky", 3, 18, "Male")); // Add Rocky
        cougarsEnclosure.addAnimal(new Cougar("Luna", 2, 23,"Female"));  // Add Luna
        cougarsEnclosure.addAnimal(new Cougar("Lenny", 1, 26,"Male"));  // Add Lenny

        // Create the big cats composite
        CompositeAnimalCollection bigCats = new CompositeAnimalCollection();
        bigCats.setName("Big Cats");
        bigCats.addCollection(lions);
        bigCats.addCollection(tigers);
        bigCats.addCollection(cougarsEnclosure);

        return bigCats;
    }
}