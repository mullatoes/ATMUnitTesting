package com.example.atmunittesting.controller;

import com.example.atmunittesting.model.Account;
import com.example.atmunittesting.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis")
public class ATMController {

    private final AccountService accountService;

    public ATMController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountNumber}")
    public Account getAccountByAccountNumber(@PathVariable String accountNumber) {
        return accountService.getAccountByAccountNumber(accountNumber);
    }

    @PostMapping("/create")
    public void createAccount(@RequestBody Account account) {
         accountService.createAccount(account);
    }

    @PutMapping("/update")
    public void updateAccount(@RequestBody Account account) {
         accountService.updateAccount(account);
    }

    @DeleteMapping("/delete/{accountNumber}")
    public void deleteAccount(@PathVariable String accountNumber) {
        accountService.deleteAccount(accountNumber);
    }

    @PostMapping("/verify-pin")
    public boolean verifyPin(@RequestParam String accountNumber, @RequestParam int pin) {
        return accountService.verifyPin(accountNumber, pin);
    }

    @PostMapping("/deposit")
    public boolean deposit(@RequestParam String accountNumber, @RequestParam double amount) {
        return accountService.deposit(accountNumber, amount);
    }

    @PostMapping("/withdraw")
    public boolean withdraw(@RequestParam String accountNumber, @RequestParam double amount) {
        return accountService.withdraw(accountNumber, amount);
    }

    @GetMapping("/list")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }
}
