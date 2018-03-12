package ru.sberbank.multithreading.advanced.wait_notify;

import java.security.SecureRandom;

public class Main {
    private static final SecureRandom rnd = new SecureRandom();
    private static int counter;

    public static void main(String[] args) {
        JobSupplier supplier = new JobSupplier();
        initSupplyFiller(supplier);

        JobExecutor executorJohn = new JobExecutor(supplier, "John ");
        JobExecutor executorKate = new JobExecutor(supplier, "Kate ");
        JobExecutor executorBoris = new JobExecutor(supplier, "Boris");
        JobExecutor executorAnn = new JobExecutor(supplier, "Ann  ");

        executorJohn.start();
        executorKate.start();
        executorBoris.start();
        executorAnn.start();
    }

    private static void initSupplyFiller(JobSupplier supplier) {
        new Thread(() -> {
            while (true) {
                addJobToQueue(supplier, rnd.nextInt(3));
                try {
                    Thread.sleep(20 + rnd.nextInt(50));
                } catch (InterruptedException e) {
                    System.out.println("supplyFiller was interrupted");
                    break;
                }
            }
        }).start();
    }

    private static void addJobToQueue(JobSupplier supplier, int jobCount) {
        while (--jobCount > 0) {
            supplier.put(new RunnableJob(counter++));
        }
    }
}
