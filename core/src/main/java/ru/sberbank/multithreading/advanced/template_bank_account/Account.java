package ru.sberbank.multithreading.advanced.template_bank_account;

public class Account {
    private long balance;

    Account(long balance) {
        this.balance = balance;
    }

    public void withdraw(long amount) {
        balance -= amount;
        System.out.println(" - " + amount + " = " + balance);
    }

    public void deposit(long amount) {
        balance += amount;
        System.out.println(" + " + amount + " = " + balance);
    }

    public long getBalance() {
        return balance;
    }
}
