package org.example;

import java.util.*;
import java.util.HashMap;

public class Admin implements AdminInterface,Feedback{
    private List<Attractions> attractions;
    private List<Animal> animals;

    public Admin() {
        this.attractions = new ArrayList<>();
        this.animals = new ArrayList<>();

        Animal reptile1 = new Reptile("Anaconda" ,"hissing","he Green Anaconda is one of the largest snakes in the world, found in South America's tropical rainforests, swamps, and marshes.");
        Animal reptile2 = new Reptile("Komodo Dragon", "Dragon sound", "Komodo Dragons are the largest living lizards and are found in the Indonesian islands. They are known for their powerful bites and venomous saliva.");


        Animal mammal1 = new Mammal("Lion", "roar", "Lions are large carnivorous mammals known for their majestic manes and social structures.");
        Animal mammal2 = new Mammal("Dolphin", "whistle", "Dolphins are highly intelligent marine mammals known for their playful behavior and communication skills.");

        Animal amphibian1 = new Amphibian("Frog", "ribbit", "Frogs are amphibians known for their jumping abilities and unique life cycles.");
        Animal amphibian2 = new Amphibian("Salamander", "hissing", "Salamanders are amphibians characterized by their lizard-like appearance and long tails.");


        animals.add(reptile1);
        animals.add(reptile2);
        animals.add(mammal1);
        animals.add(mammal2);
        animals.add(amphibian1);
        animals.add(amphibian2);
    }

    public List<Animal> getAnimals() {
        return animals;
    }


    public void setAnimal(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Attractions> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attractions> attractions) {
        this.attractions = attractions;
    }

//    int count=1; // to give a unique id to every attraction
    @Override
    public void addAttraction(String name, String description){
        if(checkAttracions(name)==-1) {
            Attractions attractions1 = new Attractions(name, description);
//            attractions1.setUniqueid(count);
//            count++;
            attractions.add(attractions1);
            System.out.println("The attraction has been added successfully");

        }
        else{
            System.out.println("Attraction with given name already exists please try again with a different name");
        }
    }




    @Override
    public int checkAttracions(String name){
        for(Attractions attraction : attractions){
            if(attraction.getName().equalsIgnoreCase(name)){
                return 1;
            }
        }
        return -1;
    }

    public int getIndexByName(String name) {
        for (int i = 0; i < attractions.size(); i++) {
            Attractions attractions1 = attractions.get(i);
            if (attractions1.getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void viewAttractions(){
        System.out.println("The attractions in the zoo are:");
        for(int i = 0; attractions.size() > i; i++){
            System.out.println(i+1 + ".");
            System.out.println(attractions.get(i));
        }
    }

    @Override
    public void removeAttractions(String name){
        if(checkAttracions(name)==1){
            int index = getIndexByName(name);
            attractions.remove(index);
            System.out.println("The event named " + name + " is removed ");
        }
        else{
            System.out.println("No such attraction exists");
        }
    }

    @Override
    public int checkAttractions(String name) {
        return 0;
    }

    // if you modify an attraction its unique id gets changed
    @Override
    public void modifyAttractions(String name,String newName,String newDescription){

            int index = getIndexByName(name);
            Attractions attractions1 = attractions.get(index);
            attractions1.setName(newName);
            attractions1.setDescription(newDescription);
            // have the old attraction removed and then add the new attraction
    }


    @Override
    public void scheduleEvents(String name,boolean onOff,double price){
        if(checkAttracions(name)==-1){
            System.out.println("No such attraction exists");
        }
        else{
            int index = getIndexByName(name);
            Attractions attractions1 = attractions.get(index);
            attractions1.setOpenClose(onOff);
            attractions1.setTickPrice(price);
            System.out.println("The event schedule was updated");
        }
    }


    public int checkAnimals(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return 1;
            }
        }
        return -1;
    }

    public int getIndexByAnimal(String name) {
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            if (animal.getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal){
        animals.remove(animal);
    }

    @Override
    public boolean isAnimalInList(String animalName) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(animalName)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Animal getAnimalByName(String animalName) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(animalName)) {
                return animal;
            }
        }
        return null;
    }

    public void updateAnimal(Animal animal,String name,String type){
        if(checkAnimals(animal.getName())==-1){
            System.out.println("No such animal exists");
            return;
        }
        else{
            animal.setName(name);
            animal.setType(type);
        }
    }

    public String findMostFamousAttraction() {
        if (attractions.isEmpty()) {
            return null;
        }

        Attractions mostFamous = attractions.get(0);

        for (Attractions attraction : attractions) {
            if (attraction.getVisitCount() > mostFamous.getVisitCount()) {
                mostFamous = attraction;
            }
        }

        return mostFamous.getName();
    }

    @Override
    public void printFeedback(Visitor visitor) {
        System.out.println("Feedback:");
        if(visitor.getFeedback().isEmpty()){
            System.out.println("No feedback given till now");
        }else {
            int count = 1;
            for (String message : visitor.getFeedback()) {
                System.out.println(count + ". " + message);
                count++;
            }
        }

    }


//    @Override
//    public List<String> getMostVisitedAttractionNames() {
//        if (attractions.isEmpty()) {
//            return new ArrayList<>();
//        }
//
//        List<String> mostVisitedAttractionNames = new ArrayList<>();
//        int maxVisitCount = -1;
//
//        for (Attractions attraction : attractions) {
//            if (attraction.getVisitCount() > maxVisitCount) {
//                mostVisitedAttractionNames.clear();
//                maxVisitCount = attraction.getVisitCount();
//                mostVisitedAttractionNames.add(attraction.getName());
//            } else if (attraction.getVisitCount() == maxVisitCount) {
//                mostVisitedAttractionNames.add(attraction.getName());
//            } else{
//                attraction.getVisitCount();
//            }
//        }
//
//        return mostVisitedAttractionNames.size() > 0 ? mostVisitedAttractionNames : new ArrayList<>();
//    }




}
