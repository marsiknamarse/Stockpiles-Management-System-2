package com.example.stockpilesmanagementsystem.dto.warehouse.request;

import lombok.Data;

@Data
public class WarehouseUpdateItemsRequest {
    private Long productId;
    private Long warehouseId;
}
