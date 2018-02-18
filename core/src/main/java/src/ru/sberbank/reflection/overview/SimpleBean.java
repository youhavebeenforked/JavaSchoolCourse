package src.ru.sberbank.reflection.overview;

public class SimpleBean {
    private String myPrivateField = "default";
    @Hide
    private String annotated = "annotated";

    public static final String CONSTANT = "DEFAULT";

}
