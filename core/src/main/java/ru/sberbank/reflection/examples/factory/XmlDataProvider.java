package ru.sberbank.reflection.examples.factory;

public class XmlDataProvider implements DataProvider {

    @Override
    public String getData() {
        return "<?xml version=\"1.0\"?>\n<root>\n</root>";
    }
}
