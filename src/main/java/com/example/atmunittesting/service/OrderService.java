package com.example.atmunittesting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired //@Bean @EJBBean
    private ProductService productService;


    public OrderService(ProductService service){
        this.productService = service;
    }

    public String getProductName(){
        return productService.getProductName();
    }
}
