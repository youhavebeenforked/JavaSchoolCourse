package ru.sberbank.jschool.patterns.examples.creational.domain.warriors;

import ru.sberbank.jschool.patterns.examples.creational.domain.warriors.weapons.Sword;
import ru.sberbank.jschool.patterns.examples.creational.domain.warriors.weapons.Weapon;

public class Knight extends Warrior {

    public Knight() {
        super(SocialStatus.NOBLE);
    }

    @Override
    public void sayGreeting() {
        System.out.println("My Lord!");
    }

    @Override
    public Weapon weapon() {
        if (weapon == null) {
            weapon = new Sword("Longsword");
        }
        return weapon;
    }
}
