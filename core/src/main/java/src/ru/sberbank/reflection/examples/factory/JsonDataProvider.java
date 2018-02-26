package src.ru.sberbank.reflection.examples.factory;

public class JsonDataProvider implements DataProvider {
    @Override
    public String getData() {
        return "{field:'string'}";
    }
}
