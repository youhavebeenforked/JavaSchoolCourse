package ru.sberbank.basics;

import java.util.Date;

public class ShowcaseConstructions {
    private int field = 10; // поле класса
    private Date startDate = new Date(); //  Ещё одно поле класса, инициализировано новым экземпляром класса Date
    private Date date; // Ещё одно поле класса, объявленное и инициализированное по-умолчанию значением null


    {   // Этот код вызывается при создании экземпляра класса
        field = 12;
    }

    public static void main(String[] args) {
        ShowcaseConstructions school = new ShowcaseConstructions(); // Создание экземпляра класса.

        school.visibility();
        // Условие, ветвление. if
        boolean a = false;
        boolean b = true;
        if (a) {  // основное условие
            System.out.println("Condition a is true");
        } else if (b || school.field > 10) {
            // дополнительное условие, выполняется если проверка основного условия не прошла. Необязательный блок
            System.out.println("Condition b is true");
        } else { // дополнительный блок без условий, необязательный.
            System.out.println("Everything else");
        }

        // Условие, ветвление. switch
        Cases chooseMe = Cases.FIRST;
        switch (chooseMe) { // принимает объекты типа Enum, Строки (c 7 java), а также целые числа: сhar, byte, short, integer
            case FIRST: {
                System.out.println("Выполнится этот код и перейдем к следующему case-statement");
            }
            case SECOND: {
                System.out.println("Выполнится этот код. Дальнейшее выполнение кода быдет прервано командой break.");
                break;
            }
            default: {
                System.out.println("Этот блок кода выполнится если не найдено ни одного подходящего условия.");
            }
        }

        // Циклы
        for (int i = 0; i < 5; i++) {
            System.out.println("Classic 'for'-loop " + i);
        }
        int j = 2;
        for (; ; j--) {
            if (j > 0) {
                continue;
            }
            System.out.println("Strange, but valid 'for'-loop " + j);
            break;
        }

        boolean condition = true;
        while (condition) { // цикл с пред-условием
            System.out.println("Pre-condition loop");
            condition = false;
        }

        do { //цикл с пост-условием
            System.out.println("Post-condition loop");
        } while (condition);
    }

    /**
     * Область видимости переменных.
     * Всё просто - каждый вложенный блок кода (обозначенный "{" и "}" )
     * имеет доступ к переменным внешних блоков кода.
     */
    private void visibility() {
        System.out.println(this.startDate); // в методах класса есть доступ к полям класса.
        int i = 1;
        Date date = new Date();
        System.out.println(date); // обращение к локально объявленной переменной.
        System.out.println(this.date); // обращение к полю класса.
        if (i == 1) {
            //int i = 2; // ошибка компиляции, повторное объявление переменной.
            int j = 2;
        }
        for (int j = 0; j < 10; j++) {
            int k = j; // переменная k будет инициализироваться каждую итерацию цикла.
        }

        {
            int j = 4;
            {
                int k = 5;
            }
            int k = 6;
        }

        LABEL_A:
        // обычно является признаком smelly-кода
        if (i == 1) {
            LABEL_B:
            for (int j = 0; j < 10; j++) {
                i++;
                int k = j; // переменная k будет инициализироваться каждую итерацию цикла.
                for (int a = 0; a < 10; a++) {
                    if (i < 3) {
                        continue LABEL_B;
                    } else {
                        break LABEL_A;
                    }
                }
            }
        }
        System.out.println("OK");

        //System.out.println(" j = " + j + " k = " + k); // - ошибка компиляции, переменная j не видна.
    }

    private enum Cases {
        FIRST, SECOND, THIRD;
    }
}
