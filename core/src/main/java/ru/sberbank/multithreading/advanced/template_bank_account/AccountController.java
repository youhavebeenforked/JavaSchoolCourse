package ru.sberbank.multithreading.advanced.template_bank_account;

import java.util.ArrayList;
import java.util.List;

public class AccountController {
    private static final String ACC_ID = "1000_1337_8008_5443";
    private AccountService service;
    private List<Thread> runningThreads = new ArrayList<>();

    public static void main(String[] args) {
        AccountController controller = new AccountController();
        controller.imitate();
    }

    private void imitate() {
        service = new AccountService(new AccountDao());
        service.createAccount(ACC_ID, 10_000_00);
        startIncome();
        startWithdrawal();

        runningThreads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        long totalWithdrawal = 5000_00 * 10 + 200_00 * 100 + 20_00 * 50;
        long totalIncome = 10_000_00 + 50_000_00 * 10 + 5_00 * 100;
        long expectedBalance = totalIncome - totalWithdrawal;
        long currentBalance = service.displayBalance(ACC_ID);
        System.out.println("expected : " + expectedBalance/100d + " actual: " + currentBalance/100d + " delta money: " + (currentBalance - expectedBalance)/100d);
    }

    private void startWithdrawal() {
        startThread(() -> withdraw(5000_00, 30, 10)); // rent
        startThread(() -> withdraw(200_00, 1, 100)); // dinner
        startThread(() -> withdraw(20_00, 2, 50)); // mobile
    }

    private void startIncome() {
        startThread(() -> deposit(50_000_00, 30, 10)); // salary
        startThread(() -> deposit(5_00, 1, 100)); // pet project ad money
    }

    private void startThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        runningThreads.add(thread);
        thread.start();
    }

    private void withdraw(long amount, long interval, int runTimes) {
        while (!Thread.interrupted()) {
            if (!service.withdrawMoney(ACC_ID, amount)) {
                throw new RuntimeException("NOT ENOUGH MONEY!");
            }
            if (interval == 0) {
                continue;
            }
            if(--runTimes == 0) {
                break;
            }
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
                break;
            }
        }
    }

    private void deposit(long amount, long interval, int runTimes) {
        while (!Thread.interrupted()) {
            service.depositMoney(ACC_ID, amount);
            if (interval == 0) {
                continue;
            }
            if(--runTimes == 0) {
                break;
            }
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
                break;
            }
        }
    }
}
