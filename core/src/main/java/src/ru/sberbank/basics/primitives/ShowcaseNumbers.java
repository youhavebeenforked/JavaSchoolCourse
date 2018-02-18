package src.ru.sberbank.basics.primitives;

public class ShowcaseNumbers {
    public static void main(String[] args) {

        //Литералы, целочисленные значеия и операции
        char charExample = 'A';

        char ch = 'a'; // 97
        char ussr = '\u262d';

        System.out.println(ussr);

        byte a = 0b101;
        byte b = 0x00f;

        int c = a + b + ch; // byte и char приводятся к int

        long d = (c + 4_000L) / 100; // int приводится к long

        System.out.println(d);

        d /= 11; // целочисленное деление с присваиванием, дробная часть отбрасывется эквивалентная запись d = d / 11;

        System.out.println(d);

        try {
            System.out.println(d / 0); // Деление на 0
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        //Переполнение

        System.out.println("before: " + Integer.MAX_VALUE + " after: " + (Integer.MAX_VALUE + 1));

        // Преобразование целочисленных в числа с плавающей точкой

        System.out.println("int: "  + c + " double: " + (c * 1.0d) + " double cast to int: " + (int) 1.5d);

    }
}
