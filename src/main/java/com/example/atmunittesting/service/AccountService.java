package com.example.atmunittesting.service;

import com.example.atmunittesting.model.Account;
import com.example.atmunittesting.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {


    @Autowired
    private AccountServiceRepository accountServiceRepository;


    public AccountService() {
    }

    public void createAccount(Account account) {
        accountServiceRepository.save(account);
    }

    public Account getAccountByAccountNumber(String accountNumber) {
        return accountServiceRepository.findById(accountNumber);
    }


    public void updateAccount(Account account) {
        accountServiceRepository.save(account);
    }

    public void deleteAccount(String accountNumber) {
        accountServiceRepository.deleteById(accountNumber);
    }

    public boolean verifyPin(String accountNumber, int pin) {
        Account account = getAccountByAccountNumber(accountNumber);
        return account != null && account.getPin() == pin;
    }


    public boolean deposit(String accountNumber, double amount) {
        Account account = accountServiceRepository.findById(accountNumber);
        if (account != null && amount > 0) {
            account.setBalance(account.getBalance() + amount);
            accountServiceRepository.save(account);
            return true;
        }
        return false;
    }


    public boolean withdraw(String accountNumber, double amount) {
        Account account = accountServiceRepository.findById(accountNumber);
        if (account != null && amount > 0 && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            accountServiceRepository.save(account);
            return true;
        }
        return false;
    }

    public List<Account> getAllAccounts() {
        return accountServiceRepository.findAll();
    }

}
