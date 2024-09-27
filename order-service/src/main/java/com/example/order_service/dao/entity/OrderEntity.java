package com.example.order_service.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class OrderEntity {

    @Id
    private long orderId;
    private String orderName;
    private long custId;
}
