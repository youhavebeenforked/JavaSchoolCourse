package src.ru.sberbank.reflection.examples.annotation;

public class SimpleBean {
    public static final String CONSTANT = "DEFAULT";
    private String myPrivateField = "default";
    @Hide
    private String annotated = "annotated";

}
