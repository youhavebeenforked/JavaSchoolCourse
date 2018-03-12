package ru.sberbank.multithreading.advanced.volatility;

public class ThreadRace {
    private static int counter;
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = startNewThread();
        Thread thread2 = startNewThread();
        thread1.join();
        thread2.join();
        System.out.println(counter + " " + (counter - 200_000_000));
    }
    private static Thread startNewThread() {
        Thread thread = new Thread(ThreadRace::increment);
        thread.start();
        return thread;
    }
    private static void increment() {
        for (int i = 0; i < 100_000_000; i++) {
            ThreadRace.counter++;
        }
    }
}
