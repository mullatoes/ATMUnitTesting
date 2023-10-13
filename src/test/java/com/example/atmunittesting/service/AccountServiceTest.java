package com.example.atmunittesting.service;

import com.example.atmunittesting.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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
    }

    @Test
    void updateAccount() {
    }

    @Test
    void deleteAccount() {
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
    }

    @Test
    void withdraw() {

    }

    @Test
    void getAllAccounts() {
    }
}