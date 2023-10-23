package com.example.stockpilesmanagementsystem.controller;

import com.example.stockpilesmanagementsystem.dto.order.request.OrderCreateRequest;
import com.example.stockpilesmanagementsystem.dto.order.response.OrderResponse;
import com.example.stockpilesmanagementsystem.entity.Order;
import com.example.stockpilesmanagementsystem.entity.Warehouse;
import com.example.stockpilesmanagementsystem.mapper.OrderMapper;
import com.example.stockpilesmanagementsystem.service.OrderService;
import com.example.stockpilesmanagementsystem.service.WarehouseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;
    private final WarehouseService warehouseService;
    private final OrderMapper orderMapper;

    @GetMapping
    public List<OrderResponse> getAll() {
        return orderService.getAll().stream().map(orderMapper::toDto).toList();
    }

    @GetMapping("/id={id}")
    public OrderResponse get(@PathVariable Long id) {
        return orderMapper.toDto(orderService.get(id));
    }

    @PostMapping
    public OrderResponse create(@RequestBody OrderCreateRequest orderDto) {
        Order order = orderMapper.fromDto(orderDto);
        Warehouse warehouse = warehouseService.get(orderDto.getWarehouseId());
        order.setWarehouse(warehouse);
        return orderMapper.toDto(orderService.create(order));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderService.delete(id);
    }
}
