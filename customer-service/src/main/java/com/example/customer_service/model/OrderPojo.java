package com.example.customer_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderPojo {
    private Long orderId;
    private String orderName;
    private Long custId;
}