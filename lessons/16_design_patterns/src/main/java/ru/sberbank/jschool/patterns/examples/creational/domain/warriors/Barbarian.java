package ru.sberbank.jschool.patterns.examples.creational.domain.warriors;

import ru.sberbank.jschool.patterns.examples.creational.domain.warriors.weapons.Axe;
import ru.sberbank.jschool.patterns.examples.creational.domain.warriors.weapons.Weapon;

public class Barbarian extends Warrior {

    public Barbarian() {
        super(SocialStatus.COMMONER);
    }

    @Override
    public void sayGreeting() {
        System.out.println("Waaaagh!");
    }

    @Override
    public Weapon weapon() {
        if (weapon == null) {
            weapon = new Axe();
        }
        return weapon;
    }
}
