package ru.sberbank.generics;

import java.util.ArrayList;
import java.util.List;

public class TypedClassExample {

    public static void main(String[] args) {
        Box<Shoes, Pencils> box = new Box<>(new Image());

        Shoes shoes = box.getStoredItem();

        Util.park(box, shoes);

        List<?> intList = new ArrayList<Integer>();
        //intList.add(1);
    }


    private interface Storable {

    }

    private static class Util {

        private static <T, R> T park(Box<T, R> box, T item) {
            box.setStoredItem(item);
            return item;
        }
    }

    private static class Box<T, S> {
        T storedItem;
        S additionalItem;
        Label label;


        public <L extends Label> Box(L label) {
            this.label = label;
        }

        public T getStoredItem() {
            return storedItem;
        }

        public void setStoredItem(T storedItem) {
            this.storedItem = storedItem;
        }

        public S getAdditionalItem() {
            return additionalItem;
        }

        public void setAdditionalItem(S additionalItem) {
            this.additionalItem = additionalItem;
        }
    }

    private static class Image extends Label {

    }

    private static class Text extends Label {

    }

    private static class Label {

    }


    private static class Bananas implements Storable {

    }


    private static class Shoes implements Storable {

    }

    private static class Pencils implements Storable {

    }
}
