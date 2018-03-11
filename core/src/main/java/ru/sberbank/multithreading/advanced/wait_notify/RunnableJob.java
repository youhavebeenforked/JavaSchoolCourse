package ru.sberbank.multithreading.advanced.wait_notify;

public class RunnableJob implements Runnable {
    private final int jobId;

    public RunnableJob(int jobId) {
        this.jobId = jobId;
    }

    public int getJobId() {
        return jobId;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("job with id (" + jobId + ") was interrupted!");
        }
    }
}
