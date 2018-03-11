package ru.sberbank.multithreading.advanced.bank_account;

public class Account {
    private long balance;

    public Account(long balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(long amount) {
        balance -= amount;
        System.out.println(" - " + amount + " = " + balance);
    }

    public synchronized void deposit(long amount) {
        balance += amount;
        System.out.println(" + " + amount + " = " + balance);
    }

    public synchronized long getBalance() {
        return balance;
    }
}
