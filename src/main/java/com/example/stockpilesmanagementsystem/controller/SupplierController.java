package com.example.stockpilesmanagementsystem.controller;

import com.example.stockpilesmanagementsystem.dto.supplier.request.SupplierCreateRequest;
import com.example.stockpilesmanagementsystem.dto.supplier.request.SupplierUpdateRequest;
import com.example.stockpilesmanagementsystem.dto.supplier.response.SupplierResponse;
import com.example.stockpilesmanagementsystem.mapper.SupplierMapper;
import com.example.stockpilesmanagementsystem.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("supplier")
@AllArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;
    private final SupplierMapper supplierMapper;

    @GetMapping
    public List<SupplierResponse> getAll() {
        return supplierService.getAll().stream().map(supplierMapper::toDto).toList();
    }

    @GetMapping("/id={id}")
    public SupplierResponse get(@PathVariable Long id) {
        return supplierMapper.toDto(supplierService.get(id));
    }

    @GetMapping("/name={name}")
    public List<SupplierResponse> getByName(@PathVariable String name) {
        return supplierService.getByName(name).stream().map(supplierMapper::toDto).toList();
    }

    @GetMapping("/address={address}")
    public List<SupplierResponse> getByAddress(@PathVariable String address) {
        return supplierService.getByAddress(address).stream().map(supplierMapper::toDto).toList();
    }

    @PostMapping
    public SupplierResponse create(@RequestBody SupplierCreateRequest supplierDto) {
        return supplierMapper.toDto(supplierService.create(supplierMapper.fromCreateDto(supplierDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        supplierService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody SupplierUpdateRequest supplierDto) {
        supplierService.update(supplierMapper.fromUpdateDto(supplierDto));
    }
}
