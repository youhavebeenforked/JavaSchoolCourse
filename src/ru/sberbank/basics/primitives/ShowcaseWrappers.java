package ru.sberbank.basics.primitives;

public class ShowcaseWrappers {

    public static void main(String[] args) {
        Integer i = Integer.parseInt("1000");
        System.out.println(i.doubleValue());
        i = i + Integer.parseInt("10", 2);
        if (i < Integer.MAX_VALUE)
            System.out.println(i);

        Boolean bool = Boolean.FALSE;
    }
}
