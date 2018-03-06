package ru.sberbank.multithreading.initial;

import java.util.concurrent.TimeUnit;

public class ThreadRace {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 3; j++) {
                    System.out.println("#" + j + " - " + Thread.currentThread().getName());
                    Thread.yield();
                   // try {
                   //     TimeUnit.NANOSECONDS.sleep(0);
                   // } catch (InterruptedException e) {
                   //     e.printStackTrace();
                   //     // тема следующего занятия
                   // }
                }
            });
            t.start();
        }
    }

}
