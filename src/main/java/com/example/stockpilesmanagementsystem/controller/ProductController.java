package com.example.stockpilesmanagementsystem.controller;

import com.example.stockpilesmanagementsystem.dto.product.request.ProductCreateRequest;
import com.example.stockpilesmanagementsystem.dto.product.request.ProductUpdateRequest;
import com.example.stockpilesmanagementsystem.dto.product.response.ProductResponse;
import com.example.stockpilesmanagementsystem.entity.Product;
import com.example.stockpilesmanagementsystem.entity.Supplier;
import com.example.stockpilesmanagementsystem.mapper.ProductMapper;
import com.example.stockpilesmanagementsystem.service.ProductService;
import com.example.stockpilesmanagementsystem.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;
    private final SupplierService supplierService;
    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductResponse> getAll() {
        return productService.getAll().stream().map(productMapper::toDto).toList();
    }

    @GetMapping("/id={id}")
    public ProductResponse get(@PathVariable Long id) {
        return productMapper.toDto(productService.get(id));
    }

    @GetMapping("/name={name}")
    public List<ProductResponse> getByName(@PathVariable String name) {
        return productService.getByName(name).stream().map(productMapper::toDto).toList();
    }

    @PostMapping
    public ProductResponse create(@RequestBody ProductCreateRequest productDto) {
        Product product = productMapper.fromCreateDto(productDto).getFirst();
        Supplier supplier = supplierService.get(productMapper.fromCreateDto(productDto).getSecond());
        product.setSupplier(supplier);
        return productMapper.toDto(productService.create(product));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody ProductUpdateRequest productDto) {
        Product product = productMapper.fromUpdateDto(productDto).getFirst();
        Supplier supplier = supplierService.get(productDto.getSupplierId());
        product.setSupplier(supplier);
        productService.update(product);
    }
}
