package ru.sberbank.basics.primitives;

public class ShowcaseBoolean {

    public static void main(String[] args) {
        int a = 2;
        int b = 5;

        boolean c = false; // пример булева литерала

        // тернарный оператор ? :
        String output = a == 2 ? "Истина" : "Ложь";

        System.out.println("тернарный оператор " + output);

        // Пример "ленивого" И
        if (a == 3 && b > 5) {
            System.out.println("first!");
        }

        if (a == 3 & b++ > 5) {
            System.out.println("second!");
        } else if (b == 6) {
            System.out.println("b == 6");
        }
    }
}
