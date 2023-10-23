package com.example.stockpilesmanagementsystem.mapper;

import com.example.stockpilesmanagementsystem.dto.warehouse.request.WarehouseCreateRequest;
import com.example.stockpilesmanagementsystem.dto.warehouse.response.WarehouseResponse;
import com.example.stockpilesmanagementsystem.entity.Product;
import com.example.stockpilesmanagementsystem.entity.Warehouse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class WarehouseMapper {

    public Warehouse fromCreateDto(WarehouseCreateRequest dto){
        if (Objects.isNull(dto)) return null;

        Warehouse warehouse = new Warehouse();
        warehouse.setCapacity(dto.getCapacity());

        return warehouse;
    }

    public WarehouseResponse toDto(Warehouse warehouse){
        if (Objects.isNull(warehouse)) return null;

        WarehouseResponse dto = new WarehouseResponse();
        dto.setId(warehouse.getId());
        dto.setQuantity(warehouse.getQuantity());
        dto.setCapacity(warehouse.getCapacity());
        dto.setSupplyDate(warehouse.getSupplyDate());
        List<Product> products;

        if (warehouse.getProducts() != null && !warehouse.getProducts().isEmpty()) {
            products = warehouse.getProducts().stream().toList();
            for (int i = 0; i < products.size(); i++) {
                dto.addProduct(products.get(i));
            }
        }

        return dto;
    }

}
