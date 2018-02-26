package src.ru.sberbank.reflection.examples.overview;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionOverview_Generics {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        Runtime<Double> runtime = new Runtime<>();
        Class<? extends Runtime> c = runtime.getClass();
        Field f = c.getDeclaredField("integers");
        System.out.println(((ParameterizedTypeImpl)f.getGenericType()).getActualTypeArguments()[0]);

        Method m = c.getDeclaredMethod("numbers");
        System.out.println(m.getGenericReturnType());
        m = c.getDeclaredMethod("strings");
        System.out.println(m.getGenericReturnType());
    }
}
