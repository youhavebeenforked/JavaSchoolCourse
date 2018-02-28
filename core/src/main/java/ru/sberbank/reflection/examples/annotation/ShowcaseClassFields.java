package ru.sberbank.reflection.examples.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ShowcaseClassFields {
    public static void main(String[] args) throws IllegalAccessException {
        SimpleBean sb = new SimpleBean();
        System.out.println(inspectObjectFields(sb));
    }

    private static String inspectObjectFields(Object obj) throws IllegalAccessException {
        if (obj == null) {
            return null;
        }
        Class<?> aClass = obj.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        StringBuilder sb = new StringBuilder("{");
        for (Field field : declaredFields) {
            if (checkAnnotation(field)) continue;
            boolean reset = false;
            if (!field.isAccessible()) {
                reset = true;
                field.setAccessible(true);
            }
            sb.append(field.getName()).append(": '").append(field.get(obj)).append("',");
            if (reset) {
                field.setAccessible(false);
            }
        }
        sb.deleteCharAt(sb.length() - 1).append("}");
        return sb.toString();
    }

    private static boolean checkAnnotation(Field field) {
        Annotation[] annotations = field.getDeclaredAnnotations();
        boolean hide = false;
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(Hide.class)) {
                hide = true;
                break;
            }
        }
        return hide;
    }
}
