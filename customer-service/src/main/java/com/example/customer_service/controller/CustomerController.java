package com.example.customer_service.controller;

import com.example.customer_service.model.CustomerPojo;
import com.example.customer_service.model.OrderPojo;
import com.example.customer_service.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    CustomerService custService;

    public static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    public CustomerController(CustomerService custService) {
        this.custService = custService;
    }

    @GetMapping("/customers")
    public List<CustomerPojo> getAllCustomers() {
        return custService.getAllCustomers();
    }

    @GetMapping("/customers/{cid}")
    public CustomerPojo getACustomer(@PathVariable("cid") long custId) {
        CustomerPojo custPojo = custService.getACustomer(custId);
        RestClient restClient = RestClient.create();
        List<OrderPojo> allOrders = restClient
                .get()
                .uri("http://localhost:8082/api/orders/customers/"+custId)
                .retrieve()
                .body(List.class);
        custPojo.setAllOrders(allOrders);
        return custPojo;
    }

    @PostMapping("/customers")
    public CustomerPojo addCustomer(@RequestBody CustomerPojo newCust){
        return custService.addCustomer(newCust);
    }


}