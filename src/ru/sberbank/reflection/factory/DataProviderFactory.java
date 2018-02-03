package ru.sberbank.reflection.factory;

import java.util.Properties;
import java.util.PropertyResourceBundle;

public class DataProviderFactory {
    private static final String PROVIDER_CLASSNAME_PROPERTY = "provider.class";

    public static DataProvider createProvider() {
        PropertyResourceBundle properties = (PropertyResourceBundle)
                PropertyResourceBundle.getBundle("ru.sberbank.reflection.factory.factory");
        String className = properties.getString(PROVIDER_CLASSNAME_PROPERTY);
        try {
            Class cl = Class.forName(className);
            DataProvider provider = (DataProvider)cl.newInstance();
            return provider;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
