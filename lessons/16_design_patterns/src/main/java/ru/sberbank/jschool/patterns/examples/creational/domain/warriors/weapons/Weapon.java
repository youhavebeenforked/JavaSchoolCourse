package ru.sberbank.jschool.patterns.examples.creational.domain.warriors.weapons;

public class Weapon {
    private String name;

    protected Weapon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
