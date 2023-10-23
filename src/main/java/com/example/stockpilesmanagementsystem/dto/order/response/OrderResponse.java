package com.example.stockpilesmanagementsystem.dto.order.response;

import lombok.Data;

@Data
public class OrderResponse {
    private Long id;
    private Long ProductId;
    private int amount;
    private Long warehouseId;
}
