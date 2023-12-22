package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    private String name;
    private String type;

    private String sound;

    private String history;

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Animal(String name, String type, String history,String sound) {
        this.name = name;
        this.type = type;
        this.history = history;
        this.sound = sound;
    }

    public abstract void makeSound();

    public abstract void getAnimalHistory();


}
