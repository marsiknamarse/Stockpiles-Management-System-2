package com.example.stockpilesmanagementsystem.dto.product.response;

import lombok.Data;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private double measure;
    private Long supplierId;
    private String supplierName;
}
