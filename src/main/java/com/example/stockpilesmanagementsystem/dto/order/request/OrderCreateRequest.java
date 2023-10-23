package com.example.stockpilesmanagementsystem.dto.order.request;

import lombok.Data;

@Data
public class OrderCreateRequest {
    private Long ProductId;
    private int amount;
    private Long warehouseId;
}
