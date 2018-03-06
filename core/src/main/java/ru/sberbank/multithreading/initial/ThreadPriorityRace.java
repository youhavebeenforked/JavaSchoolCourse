package ru.sberbank.multithreading.initial;

import static java.lang.String.format;

public class ThreadPriorityRace {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            Thread t = new Thread(new PriorityTest());
            t.setPriority(i % 2 == 0
                    ? Thread.MAX_PRIORITY
                    : Thread.MIN_PRIORITY);
            t.start();
        }
    }

}

class PriorityTest implements Runnable {
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(format("#%s(%d)",
                    Thread.currentThread().getName(), Thread.currentThread().getPriority()));
            Thread.yield();
        }
    }
}
