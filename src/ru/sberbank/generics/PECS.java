package ru.sberbank.generics;

import java.util.ArrayList;
import java.util.List;

public class PECS {
    public static void main(String[] args) {
        //Consumer - super. Указываем НИЖНЮЮ границу
        // Для записи в параметризованный тип используем маску <? super T>
        List<? super MiddleClass> consumer = new ArrayList<>();
        consumer.add(new ChildClass());
        consumer.add(new MiddleClass());
        //consumer.add(new RootClass()); // непременимо
        // При получении возникают проблемы...
        //ChildClass childClass = consumer.get(0);
        //MiddleClass middleClass = consumer.get(0);
        //RootClass rootClass = consumer.get(0);

        // Можно решить старым добрым кастованием...
        ChildClass childClass = (ChildClass) consumer.get(0);
        // Но так же можно словить ClassCastException
        childClass = (ChildClass) consumer.get(1);

        // Producer - extends - указание ВЕРХНЕЙ границы
        List<? extends MiddleClass> producer = new ArrayList<>();
        // Это Producer - ни одно из нижеследующих добавлений не будет скомпилировано.
        //producer.add(new RootClass());
        //producer.add(new MiddleClass());
        //producer.add(new ChildClass());

        // Зато без проблем можно достать
        MiddleClass mClass = producer.get(0);
        RootClass cClass = producer.get(0);
    }

    static class RootClass {

    }

    static class MiddleClass extends RootClass {

    }

    static class ChildClass extends MiddleClass {

    }
}
