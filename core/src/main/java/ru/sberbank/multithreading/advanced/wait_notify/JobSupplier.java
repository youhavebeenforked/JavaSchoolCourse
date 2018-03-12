package ru.sberbank.multithreading.advanced.wait_notify;

import java.util.LinkedList;
import java.util.List;

public class JobSupplier {
    private List<RunnableJob> tasks = new LinkedList<>();

    public synchronized void put(RunnableJob task) {
        tasks.add(task);
        System.out.println("\t\tAdded new task " + task.getJobId() + "! Already in: " + tasks.size());
        this.notifyAll();
    }

    public synchronized RunnableJob get() {
        while (tasks.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                return null;
            }
        }
        // System.out.println("\t\tBefore removing task! Jobs queue: " + tasks.size());
        return tasks.remove(0);
    }
}
