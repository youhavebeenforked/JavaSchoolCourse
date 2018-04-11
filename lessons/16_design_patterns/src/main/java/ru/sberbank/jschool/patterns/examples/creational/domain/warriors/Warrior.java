package ru.sberbank.jschool.patterns.examples.creational.domain.warriors;

import ru.sberbank.jschool.patterns.examples.creational.domain.warriors.weapons.Weapon;

public abstract class Warrior {

    protected final SocialStatus socialStatus;
    protected Weapon weapon;

    protected Warrior(SocialStatus socialStatus) {
        this.socialStatus = socialStatus;
    }

    public abstract void sayGreeting();

    public abstract Weapon weapon();

    protected void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public enum SocialStatus {
        NOBLE, COMMONER
    }
}
