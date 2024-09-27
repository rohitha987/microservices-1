package com.example.customer_service.service;

import com.example.customer_service.dao.CustomerRepository;
import com.example.customer_service.dao.entity.CustomerEntity;
import com.example.customer_service.model.CustomerPojo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    CustomerRepository custRepo;

    @Autowired
    public CustomerService(CustomerRepository custRepo){
        this.custRepo = custRepo;
    }

    public List<CustomerPojo> getAllCustomers() {
        List<CustomerEntity> allCustEntity = custRepo.findAll();
        List<CustomerPojo> allCustPojo = new ArrayList<>();
        allCustEntity.stream().forEach((eachCustEntity) -> {
            CustomerPojo custPojo = new CustomerPojo();
            BeanUtils.copyProperties(eachCustEntity, custPojo);
            allCustPojo.add(custPojo);
        });

        return allCustPojo;
    }

    public CustomerPojo getACustomer(long custId) {
        Optional<CustomerEntity> fetchedCustEntity = custRepo.findById(custId);
        CustomerPojo custPojo = null;
        if(fetchedCustEntity.isPresent()) {
            custPojo = new CustomerPojo();
            BeanUtils.copyProperties(fetchedCustEntity.get(), custPojo);
        }
        return custPojo;
    }

    public CustomerPojo addCustomer(CustomerPojo newCustPojo) {
        CustomerEntity custEntity = new CustomerEntity();
        BeanUtils.copyProperties(newCustPojo, custEntity);
        custRepo.saveAndFlush(custEntity);
        return newCustPojo;
    }
}