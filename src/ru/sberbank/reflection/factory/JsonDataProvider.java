package ru.sberbank.reflection.factory;

public class JsonDataProvider implements DataProvider {
    @Override
    public String getData() {
        return "{field:'string'}";
    }
}
