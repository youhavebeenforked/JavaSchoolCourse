package ru.sberbank.basics.primitives;

public class ShowcaseString {
    public static void main(String[] args) {

        String stringA = "Да!";
        String stringB = "Да!";
        String stringC = stringA;
        String stringD = new String("Да!".getBytes()); // создадим новую строку из массива байт
        String stringE = "да!"; // Буквы те же, но первый символ в нижнем регистре

        //Неправильное сравнение строк!
        if (stringA == stringB) {
            System.out.println("stringA == stringB");
        }

        if (stringA == stringC) {
            System.out.println("stringA == stringC");
        }

        if (stringA == stringD) {
            System.out.println("stringA == stringD");
        }

        //правильное сравнение строк
        if (stringA.equals(stringD)) {
            System.out.println("stringA.equals(stringD) = true");
        }

        if (stringA.equals(stringE)) {
            System.out.println("stringA.equals(stringE)  = true");
        }

        if (stringA.equalsIgnoreCase(stringE)) {
            System.out.println("stringA.equalsIgnoreCase(stringE)  = true");
        }

        //Конкатенация. Объединение строк

        String sorryNoMultiLineStrings = "К сожалению, нет поддержки многострочности." +
                " Но можно разбивать литералы так!";

        String concatStr = "Значит можно и так? " + stringA + " но не всегда хорошо.";
        System.out.println(concatStr);

        concatStr = "Так эффективнее? ".concat(stringA).concat(" Но код становится менее читабельным.");
        System.out.println(concatStr);

        concatStr = "Это какой-то хитрый метод?" + concatStr + " " + concatStr; //+ " Но не стоит на него полагаться!";

        // Smelly...
        // String cycleString = "Start ";
        // for (int i = 0; i < 10; i++) {
        //     cycleString += stringA;
        // }

        StringBuilder stringBuilder = new StringBuilder("Start ");
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(stringA);
        }

        System.out.println(stringBuilder.toString());


    }
}
