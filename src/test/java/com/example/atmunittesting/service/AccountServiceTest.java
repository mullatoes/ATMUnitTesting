package com.example.atmunittesting.service;

import com.example.atmunittesting.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    @Mock
    private AccountServiceRepository accountServiceRepository;

    @InjectMocks
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createAccount() {


        //ARRANGE
        Account account = new Account("123456", "John Doe", 1000.0, 1234);

        //ACTION
        accountService.createAccount(account);

        //ASSERT //VERIFY
        Mockito.verify(accountServiceRepository, Mockito.times(1)).save(account);
    }

    @Test
    void getAccountByAccountNumber() {
        // prepare
        Account account = new Account("123456", "John Doe", 1000.0, 1234);

        Mockito.when(accountServiceRepository.findById("123456")).thenReturn(account);

        // Call
        Account result = accountService.getAccountByAccountNumber("123456");

        // Verify
        assertNotNull(result);
        assertEquals("123456", result.getAccountNumber());
        assertEquals("John Doe", result.getAccountHolderName());
        assertEquals(1000.0, result.getBalance(), 0.01);
        assertEquals(1234, result.getPin());


    }

    @Test
    void updateAccount() {
        //prepare
        Account account = new Account("123456", "John Doe", 1000.0, 1234);

        //action
        accountService.updateAccount(account);

        //assert
        Mockito.verify(accountServiceRepository, Mockito.times(1)).save(account);

    }

    @Test
    void deleteAccount() {

        Mockito.doNothing().when(accountServiceRepository).deleteById("123456");

        accountService.deleteAccount("123456");

        // Verify that the deleteById method of the repository is called once with the provided account number
        Mockito.verify(accountServiceRepository, Mockito.times(1)).deleteById("123456");

    }

    @Test
    void verifyPin() {

        //prepare
        Account account = new Account("123456", "John Doe", 1000.0, 1234);

        //action -- finding by id
        Mockito.when(accountServiceRepository.findById("123456")).thenReturn(account);


        //assert
        assertFalse(accountService.verifyPin("123456",1334)); //false

        assertTrue(accountService.verifyPin("123456",1234)); //true
    }

    @Test
    void deposit() {

        //prepare
        Account account = new Account("123456", "John Doe", 1000.0, 1234);


        Mockito.when(accountServiceRepository.findById("123456")).thenReturn(account);

        // action
        boolean result = accountService.deposit("123456", 500.0);

        // Verify or assert
        assertTrue(result);
        assertEquals(1500.0, account.getBalance(), 0.01);

    }

    @Test
    void withdraw() {
        //prepare
        Account account = new Account("123456", "John Doe", 1000.0, 1234);


        Mockito.when(accountServiceRepository.findById("123456")).thenReturn(account);

        // action
        boolean result = accountService.withdraw("123456", 500.0);

        // Verify or Assert
        assertTrue(result);
        assertEquals(500.0, account.getBalance(), 0.01);


    }

    @Test
    void getAllAccounts() {

        //PREPARE
        Account account1 = new Account("123456", "John Doe", 1000.0, 1234);
        Account account2 = new Account("789012", "Jane Smith", 500.0, 5678);


        Mockito.when(accountServiceRepository.findAll()).thenReturn(List.of(account1, account2));

       //ACTION
        List<Account> accountList = accountService.getAllAccounts();

        // Verify
        assertNotNull(accountList);
        assertEquals(2, accountList.size());

        // Verify
        Account firstAccount = accountList.get(0);
        assertEquals("123456", firstAccount.getAccountNumber());
        assertEquals("John Doe", firstAccount.getAccountHolderName());
        assertEquals(1000.0, firstAccount.getBalance(), 0.01);
        assertEquals(1234, firstAccount.getPin());

        // Verify
        Account secondAccount = accountList.get(1);
        assertEquals("789012", secondAccount.getAccountNumber());
        assertEquals("Jane Smith", secondAccount.getAccountHolderName());
        assertEquals(500.0, secondAccount.getBalance(), 0.01);
        assertEquals(5678, secondAccount.getPin());

    }
}