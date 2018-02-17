package ru.sberbank.basics.oop;

public class ClientImpl implements Client, Person {
    private final String name;
    private final boolean is_male;
    private static final String MALE_VOCATIVE = "Mr.";
    private static final String FEMALE_VOCATIVE = "Mrs."; // упростим немножко

    public ClientImpl(String name, boolean is_male) {
        this.name = name;
        this.is_male = is_male;
    }

    @Override
    public String getPersonName() {
        return (is_male ? MALE_VOCATIVE : FEMALE_VOCATIVE) + " " + name;
    }
}
