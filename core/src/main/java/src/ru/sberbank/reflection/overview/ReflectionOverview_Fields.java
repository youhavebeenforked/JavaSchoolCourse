package src.ru.sberbank.reflection.overview;

import java.lang.reflect.Field;

public class ReflectionOverview_Fields {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person("Ivan");
        Class<? extends Person> personClass = person.getClass();
        Field f = personClass.getDeclaredField("name");
        f.setAccessible(true);
        f.set(person, "Ivanka");
        System.out.println(person.getName());
    }
}
