package com.example.stockpilesmanagementsystem.dto.supplier.request;

import lombok.Data;

@Data
public class SupplierUpdateRequest {
    private Long id;
    private String name;
    private String address;
}

