package ru.sberbank.multithreading.advanced.bank_account;

public class AccountService {
    private AccountDao dao;

    public AccountService(AccountDao dao) {
        this.dao = dao;
    }

    public void createAccount(String accountId, long initialBalance) {
        dao.createAccount(accountId, initialBalance);
    }

    public long displayBalance(String accountId) {
        return dao.getAccount(accountId).getBalance();
    }

    public void depositMoney(String accountId, long amount) {
        Account account = dao.getAccount(accountId);
        account.deposit(amount);
    }


    public boolean withdrawMoney(String accountId, long amount) {
        Account account = dao.getAccount(accountId);
        long newBalance = account.getBalance() - amount;
        if (newBalance < 0) { // Пример ошибки работы с общим ресурсом!
            return false;     // Эта логика должжны быть под монитором!
        }
        account.withdraw(amount);
        return true;
    }


}
