package ru.sberbank.jschool.patterns.examples.creational.domain.warriors;

import ru.sberbank.jschool.patterns.examples.creational.domain.warriors.weapons.Sword;
import ru.sberbank.jschool.patterns.examples.creational.domain.warriors.weapons.Weapon;

public class Legionarius extends Warrior {
    public Legionarius(SocialStatus socialStatus) {
        super(socialStatus);
    }

    @Override
    public void sayGreeting() {
        System.out.println("Ave!");
    }

    @Override
    public Weapon weapon() {
        if (weapon == null) {
            weapon = new Sword("Gladius");
        }
        return weapon;
    }
}
