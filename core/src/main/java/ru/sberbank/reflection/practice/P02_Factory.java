package ru.sberbank.reflection.practice;

import java.util.PropertyResourceBundle;

import ru.sberbank.reflection.practice.factory.CarFactory;

public class P02_Factory {

    public static void main(String[] args) {
        CarFactory factory = CarFactoryFactory.createFactory();
        System.out.println(factory.create());
    }

    private static class CarFactoryFactory {
        private static final String FACTORY_CLASSNAME_PROPERTY = "factory.class";

        private static CarFactory createFactory() {
            PropertyResourceBundle properties = (PropertyResourceBundle)
                    PropertyResourceBundle.getBundle("ru.sberbank.reflection.practice.factory.factory");
            String className = properties.getString(FACTORY_CLASSNAME_PROPERTY);
            //Как-то надо создать новый класс
            return null;
        }
    }
}
