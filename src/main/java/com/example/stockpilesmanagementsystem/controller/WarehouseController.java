package com.example.stockpilesmanagementsystem.controller;

import com.example.stockpilesmanagementsystem.dto.warehouse.request.WarehouseCreateRequest;
import com.example.stockpilesmanagementsystem.dto.warehouse.request.WarehouseUpdateItemsRequest;
import com.example.stockpilesmanagementsystem.dto.warehouse.response.WarehouseResponse;
import com.example.stockpilesmanagementsystem.mapper.WarehouseMapper;
import com.example.stockpilesmanagementsystem.service.WarehouseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("warehouse")
public class WarehouseController {
    private final WarehouseService warehouseService;
    private final WarehouseMapper warehouseMapper;

    @GetMapping
    public List<WarehouseResponse> getAll() {
        return warehouseService.getAll().stream().map(warehouseMapper::toDto).toList();
    }

    @GetMapping("/id={id}")
    public WarehouseResponse get(@PathVariable Long id) {
        return warehouseMapper.toDto(warehouseService.get(id));
    }

    @PostMapping
    public WarehouseResponse create(@RequestBody WarehouseCreateRequest dto) {
        return warehouseMapper.toDto(warehouseService.create(warehouseMapper.fromCreateDto(dto)));
    }

    @PostMapping("/put-item")
    public void putItem(@RequestBody WarehouseUpdateItemsRequest dto) {
        warehouseService.putItem(dto);
    }

    @PostMapping("/delete-item")
    public void deleteItem(@RequestBody WarehouseUpdateItemsRequest dto) {
        warehouseService.deleteItem(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        warehouseService.delete(id);
    }

}
