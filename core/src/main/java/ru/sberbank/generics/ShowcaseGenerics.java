package ru.sberbank.generics;

import java.util.ArrayList;
import java.util.List;

public class ShowcaseGenerics {
    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(1, "Hello");

        Integer first = pair.getFirst();
        System.out.println(first + " " + pair.getSecond());

        // ExampleClass clss = new ExampleClass<>() {}; // compile error
        ExampleClass clss = new ExampleClass<>();

        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("last");

        CollectionUtil.fill(list, "filler");
        CollectionUtil.getLast(list, new ArrayList<>());
    }

    private enum Example//<T> {
    {
        TEST1, TEST2;
    }

    private static class ExampleClass<T> {
        T field;
    }
}
