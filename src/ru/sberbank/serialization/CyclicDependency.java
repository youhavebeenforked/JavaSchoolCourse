package ru.sberbank.serialization;

import java.io.*;

public class CyclicDependency {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        A a = new A(" A ");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("CyclicA.dat"));
        objectOutputStream.writeObject(a);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("CyclicA.dat"));
        A a2 = (A) ois.readObject();
        System.out.println(a2);
    }


    private static class A implements Serializable {
        public B b;
        private String name;

        public A(String name) {
            this.name = name;
            b = new B(this);
        }


        @Override
        public String toString() {
            return "A{" +
                    "name='" + name + '\'' +
                    ", b=" + b +
                    '}';
        }
    }

    private static class B implements Serializable {
        public A a;
        private String nameB;

        public B(A a) {
            this.a = a;
            this.nameB = "b" + a.name;
        }

        @Override
        public String toString() {
            return "B{" +
                    ", nameB='" + nameB + '\'' +
                    '}';
        }
    }
}
