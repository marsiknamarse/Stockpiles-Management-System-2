package com.example.stockpilesmanagementsystem.dto.warehouse.response;

import com.example.stockpilesmanagementsystem.entity.Product;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class WarehouseResponse {
    private Long id;
    private double quantity;
    private double capacity;
    private String supplyDate;
    private Set<String> products = new HashSet<>();

    public void addProduct(Product product) {
        products.add(product.getName());
    }
}
