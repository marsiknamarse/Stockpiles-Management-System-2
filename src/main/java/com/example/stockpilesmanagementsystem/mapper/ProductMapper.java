package com.example.stockpilesmanagementsystem.mapper;

import com.example.stockpilesmanagementsystem.dto.product.request.ProductCreateRequest;
import com.example.stockpilesmanagementsystem.dto.product.request.ProductUpdateRequest;
import com.example.stockpilesmanagementsystem.dto.product.response.ProductResponse;
import com.example.stockpilesmanagementsystem.entity.Product;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductMapper {

    public Pair<Product, Long> fromCreateDto(ProductCreateRequest dto) {
        if (Objects.isNull(dto)) return null;

        Product product = new Product();
        product.setName(dto.getName());
        product.setMeasure(dto.getMeasure());

        return Pair.of(product, dto.getSupplierId());
    }

    public Pair<Product, Long> fromUpdateDto(ProductUpdateRequest dto) {
        if (Objects.isNull(dto)) return null;

        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setMeasure(dto.getMeasure());

        return Pair.of(product, dto.getSupplierId());
    }

    public ProductResponse toDto(Product product) {
        if (Objects.isNull(product)) return null;

        ProductResponse dto = new ProductResponse();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setMeasure(product.getMeasure());
        dto.setSupplierId(product.getSupplier().getId());
        dto.setSupplierName(product.getSupplier().getName());

        return dto;
    }

}
