package com.example.stockpilesmanagementsystem.dto.product.request;

import lombok.Data;

@Data
public class ProductUpdateRequest {
    private Long id;
    private String name;
    private double measure;
    private Long supplierId;
}
