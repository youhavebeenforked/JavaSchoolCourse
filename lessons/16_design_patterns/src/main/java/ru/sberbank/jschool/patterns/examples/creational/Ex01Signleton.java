package ru.sberbank.jschool.patterns.examples.creational;

import java.io.Serializable;

public class Ex01Signleton {
    public static void main(String[] args) {
        LoneWolf loneWolf = LoneWolf.INSTANCE;
        LoneWanderer loneWanderer = LoneWanderer.getInstance();
        ForeverAlone foreverAlone = ForeverAlone.INSTANCE;
        LazySingleton lazySingleton = LazySingleton.getInstance();
    }
}

class LoneWolf implements Serializable {
    public static final LoneWolf INSTANCE = new LoneWolf();

//    private transient int age;

    private LoneWolf() {
        throw new RuntimeException(new InstantiationException("cannot instantiate LoneWolf - it's a singleton"));
    }

    private Object readResolve() {
        return INSTANCE;
    }
}

class LoneWanderer {
    private static final LoneWanderer INSTANCE = new LoneWanderer();

    private LoneWanderer() {}

    public static LoneWanderer getInstance() {
        return INSTANCE;
    }
}

enum ForeverAlone {
    INSTANCE

    //fields and methods here
}

class LazySingleton {

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        static final LazySingleton INSTANCE = new LazySingleton();
    }
}
