package com.example.customer_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class CustomerPojo {
    private long custId;
    private String custName;
    private List<OrderPojo> allOrders;

    public CustomerPojo(long custId, String custName, List<OrderPojo> allOrders) {
        this.custId = custId;
        this.custName = custName;
        this.allOrders = allOrders;
    }

    public CustomerPojo() {
    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public List<OrderPojo> getAllOrders() {
        return allOrders;
    }

    public void setAllOrders(List<OrderPojo> allOrders) {
        this.allOrders = allOrders;
    }
}
