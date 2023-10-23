package com.example.stockpilesmanagementsystem.mapper;

import com.example.stockpilesmanagementsystem.dto.supplier.request.SupplierCreateRequest;
import com.example.stockpilesmanagementsystem.dto.supplier.request.SupplierUpdateRequest;
import com.example.stockpilesmanagementsystem.dto.supplier.response.SupplierResponse;
import com.example.stockpilesmanagementsystem.entity.Supplier;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SupplierMapper {
    public Supplier fromCreateDto(SupplierCreateRequest dto) {
        if (Objects.isNull(dto)) return null;

        Supplier supplier = new Supplier();
        supplier.setName(dto.getName());
        supplier.setAddress(dto.getAddress());

        return supplier;
    }

    public Supplier fromUpdateDto(SupplierUpdateRequest dto) {
        if (Objects.isNull(dto)) return null;

        Supplier supplier = new Supplier();
        supplier.setId(dto.getId());
        supplier.setName(dto.getName());
        supplier.setAddress(dto.getAddress());

        return supplier;
    }

    public SupplierResponse toDto(Supplier supplier) {
        if (Objects.isNull(supplier)) return null;

        SupplierResponse dto = new SupplierResponse();
        dto.setId(supplier.getId());
        dto.setName(supplier.getName());
        dto.setAddress(supplier.getAddress());

        return dto;
    }
}
