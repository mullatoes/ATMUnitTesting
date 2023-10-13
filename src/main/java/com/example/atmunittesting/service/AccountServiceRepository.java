package com.example.atmunittesting.service;

import com.example.atmunittesting.model.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class AccountServiceRepository {

    private List<Account> accountList;

    public AccountServiceRepository(){
        accountList = new ArrayList<>();
        accountList.add(new Account("123456", "John Doe", 1000.0, 1234));
        accountList.add(new Account("789012", "Jane Smith", 500.0, 5678));
    }

    public Account findById(String accountNo) {
        if (accountNo != null) {
            for (Account account : accountList) {
                if (account.getAccountNumber().equals(accountNo)) {
                    return account;
                }
            }
        }

        return null;
    }

    public void save(Account account) {
         accountList.add(account);
    }

    public void deleteById(String accountNumber) {
       /* Iterator<Account> iterator = accountList.iterator();
        while (iterator.hasNext()){
            Account account = iterator.next();
            if (account.getAccountNumber().equals(accountNumber)){
                iterator.remove();
            }
        }*/
        accountList.removeIf(account -> account.getAccountNumber().equals(accountNumber));
    }

    public List<Account> findAll() {
        return accountList;
    }
}
