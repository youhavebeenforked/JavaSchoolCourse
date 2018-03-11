package ru.sberbank.multithreading.advanced.bank_account;

import java.util.HashMap;
import java.util.Map;

public class AccountDao {
    private Map<String, Account> accounts = new HashMap<>();

    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }

    public void createAccount(String accountId, long initialBalance) {
        accounts.put(accountId, new Account(initialBalance));
    }
}
