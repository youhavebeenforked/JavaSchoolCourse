package src.ru.sberbank.reflection.examples.factory;

public class ShowcaseFactory {
    public static void main(String[] args) {
        DataProvider dp = DataProviderFactory.createProvider();
        if (dp != null) {
            System.out.println(dp.getClass().getCanonicalName());
            System.out.println(dp.getData());
        }

    }
}
