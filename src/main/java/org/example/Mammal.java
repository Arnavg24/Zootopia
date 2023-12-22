package org.example;

public class Mammal extends Animal{
    public Mammal(String name,String sound , String history) {
        super(name,"Mammal",sound,history);
    }

    @Override
    public void makeSound() {
        System.out.println("Roar");
    }

    @Override
    public void getAnimalHistory() {
        System.out.println(this.getHistory());
    }
}