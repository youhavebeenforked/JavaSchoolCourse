package ru.sberbank.jschool.patterns.examples.creational.domain.warriors;

import ru.sberbank.jschool.patterns.examples.creational.domain.warriors.weapons.Spear;
import ru.sberbank.jschool.patterns.examples.creational.domain.warriors.weapons.Sword;
import ru.sberbank.jschool.patterns.examples.creational.domain.warriors.weapons.Weapon;

public class SpartanHoplite extends Warrior {
    public SpartanHoplite() {
        super(SocialStatus.COMMONER);
    }

    @Override
    public void sayGreeting() {
        System.out.println("Khaire");
    }

    @Override
    public Weapon weapon() {
        if (weapon == null) {
            weapon = new Spear();
        }
        return weapon;
    }
}
