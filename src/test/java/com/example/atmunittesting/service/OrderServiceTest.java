package com.example.atmunittesting.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private OrderService orderService;

    @Mock
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderService(productService);
    }

    @Test
    void getProductName() {

        //Arrange //get your data from db and get it ready
        Mockito.when(productService.getProductName()).thenReturn("FIFA");

        //Action -- Act
        String productName = orderService.getProductName(); //FIFA

        //Assert
        assertEquals("FIFA",productName);
    }
}