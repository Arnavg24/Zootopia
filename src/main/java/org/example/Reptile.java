package org.example;

public class Reptile extends Animal {

    public Reptile(String name , String sound , String history) {
        super(name, "Reptile",sound,history);
    }

    @Override
    public void makeSound() {
        System.out.println(this.getSound());
    }

    @Override
    public void getAnimalHistory() {
        System.out.println(this.getHistory());
    }
}