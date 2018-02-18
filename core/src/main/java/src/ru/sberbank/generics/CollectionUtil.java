package src.ru.sberbank.generics;

import java.util.List;

public class CollectionUtil {

    public static void notCoolFill(List list, Object obj) {
        for (int i= 0; i < list.size(); i++) {
            list.set(0, obj);
        }
    }

    public static <T> void fill(List<T> list, T obj) {
        for (int i= 0; i < list.size(); i++) {
            list.set(0, obj);
        }
    }

    public static <T, R> T getLast(List<T> list, List<R> list1) {
        return list.get(list.size()-1);
    }

}
