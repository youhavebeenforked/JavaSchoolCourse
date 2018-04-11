package ru.sberbank.jschool.patterns.examples.creational;

import ru.sberbank.jschool.patterns.examples.creational.domain.warriors.*;
import java.util.Arrays;
import java.util.List;

import static ru.sberbank.jschool.patterns.examples.creational.domain.warriors.Warrior.SocialStatus.*;

public class Ex02SimpleFactory {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(-600, -450, -210, 200, 600, 1500, 1710);
        ls.forEach((num) ->
            System.out.println(
                    "year is " + num + ", warrior is " +
                            Warriors.newWarrior(num).getClass().getSimpleName())
        );
    }
}

//factory method v1 - factory
class Warriors {

    private static final int FLOOR = -500;
    private static final int SPARTAN_DECLINE = -380;
    private static final int MARIAN_REFORMS = -107;
    private static final int ROMAN_DECLINE = 400;
    private static final int HIGH_MIDDLE_AGES = 1000;
    private static final int RENAISSANCE = 1600;

    public static Warrior newWarrior(int year) {
        //violates ocp!
        Warrior warrior;
        if (isKnownPeriod(year) && !isSpartaInDecline(year)) {
            warrior = new SpartanHoplite();
        } else if(isAfterMarius(year) && year < ROMAN_DECLINE) {
            warrior = new Legionarius(COMMONER);
        } else if (year > HIGH_MIDDLE_AGES && year < RENAISSANCE) {
            warrior = new Knight();
        } else {
            warrior = new Barbarian();
        }
        return warrior;
    }

    private static boolean isKnownPeriod(int year) {
        return year > FLOOR;
    }

    private static boolean isSpartaInDecline(int year) {
        return year > SPARTAN_DECLINE;
    }

    private static boolean isAfterMarius(int year) {
        return year > MARIAN_REFORMS;
    }
}


