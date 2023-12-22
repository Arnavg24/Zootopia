package org.example;

import java.util.*;

public interface AdminInterface {

    public void viewAttractions(); // Displays all the attractions present in the zoo.
    public void addAttraction(String name, String description); // Adds a new attraction to the list if it doesn't already exist.
    public int checkAttractions(String name); // Checks if an attraction with the given name exists in the list.
    public void removeAttractions(String name); // Removes the specified attraction from the list if it exists.
    public void modifyAttractions(String name, String newName, String newDescription); // Modifies the details of the specified attraction.
    public void scheduleEvents(String name, boolean onOff, double price); // Updates the schedule details for the specified event.
    public int checkAnimals(String name); // Checks if an animal with the given name exists in the list.
    public void addAnimal(Animal animal); // Adds a new animal to the list.

    int checkAttracions(String attractionName); // Checks is an attraction by the given name exists
    public void removeAnimal(Animal animal); // Removes the specified animal from the list.
    public boolean isAnimalInList(String animalName); // Checks if the given animal exists in the list.
    public Animal getAnimalByName(String animalName);// Returns the animal with the specified name from the list.


}
