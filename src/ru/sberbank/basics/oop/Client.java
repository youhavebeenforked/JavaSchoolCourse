package ru.sberbank.basics.oop;

public interface Client {
    String getPersonName();

    default String getName() {
        return "ClientDefault";
    }
}
