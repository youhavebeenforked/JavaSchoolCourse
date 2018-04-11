package ru.sberbank.javaschool.async;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        long startTime = System.nanoTime();

        Future<Long> someValueFuture = executor.submit(() -> {
            TimeUnit.SECONDS.sleep(5);
            return 1L;
        });

        // Doing something while value is calculated
        TimeUnit.SECONDS.sleep(3);

        Long someValue = someValueFuture.get();
        long endTime = System.nanoTime();

        System.out.println("It took " + TimeUnit.NANOSECONDS.toSeconds(endTime - startTime) + " seconds");
    }

}
