package ru.sberbank.multithreading.advanced.wait_notify;

public class JobExecutor extends Thread {

    private JobSupplier supplier;

    public JobExecutor(JobSupplier supplier, String executorName) {
        this.supplier = supplier;
        setName(executorName);
    }

    @Override
    public void run() {
        while(!isInterrupted()) {
            RunnableJob job = supplier.get();
            job.run();
            System.out.println(getName() + " finished task with id " + job.getJobId());
        }
    }
}
