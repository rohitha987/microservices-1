package com.example.order_service.controller;

import com.example.order_service.dao.OrderRepository;
import com.example.order_service.dao.entity.OrderEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    public static final Logger LOG= LoggerFactory.getLogger(OrderController.class);
    OrderRepository ordRepo;

    @Autowired
    public OrderController(OrderRepository ordRepo){
        this.ordRepo=ordRepo;
    }

    @GetMapping("/orders")
    public List<OrderEntity> getAllOrders(){
        return ordRepo.findAll();
    }

    @GetMapping("/orders/customers/{did}")
    public List<OrderEntity> getAllOrdersByCustomer(@PathVariable long did){
        return ordRepo.findByCustId(did);
    }

    @PostMapping("/orders")
    public OrderEntity addOrder(@RequestBody OrderEntity newOrd) {
        return ordRepo.saveAndFlush(newOrd);
    }
}
