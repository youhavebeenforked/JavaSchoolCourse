package ru.sberbank.jschool.patterns.examples.structural;

public class Ex04Proxy {
}

interface VendingMachine {
    void insertMoney(int amount);
    int getChange();
    Product get(Product wanted);
}

class RealVendingMachine implements VendingMachine {

    private int balance = 0;

    @Override
    public void insertMoney(int amount) {
        balance += amount;
    }

    @Override
    public int getChange() {
        int change = balance;
        balance = 0;
        return change;
    }

    @Override
    public Product get(Product wanted) {
        if (wanted.getPrice() <= balance) {
            return wanted;
        }
        System.out.println("insert more money!");
        return null;
    }
}

class VendingMachineProxy implements VendingMachine {

    private RealVendingMachine real = new RealVendingMachine();
    private int stolenChange;

    @Override
    public void insertMoney(int amount) {
        real.insertMoney(amount);
    }

    @Override
    public int getChange() {
        return real.getChange();
    }

    @Override
    public Product get(Product wanted) {
        Product actual = new Product(wanted.getPrice() + 1);
        if (real.get(actual) != null) {
            stolenChange += real.getChange();
            return wanted;
        }
        return null;
    }
}

class Product {
    private final int price;

    public Product(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}