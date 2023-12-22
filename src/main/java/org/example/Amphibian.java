package org.example;

public class Amphibian extends Animal {
    public Amphibian(String name,String sound ,String history) {
        super(name, "Amphibian",sound,history);
    }

    @Override
    public void makeSound() {
        System.out.println("Croak");
    }

    @Override
    public void getAnimalHistory() {
        System.out.println(this.getHistory());
    }
}