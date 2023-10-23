package com.example.stockpilesmanagementsystem.mapper;

import com.example.stockpilesmanagementsystem.dto.order.request.OrderCreateRequest;
import com.example.stockpilesmanagementsystem.dto.order.response.OrderResponse;
import com.example.stockpilesmanagementsystem.entity.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class OrderMapper {

    public Order fromDto(OrderCreateRequest dto) {
        if (Objects.isNull(dto)) return null;

        Order order = new Order();
        order.setAmount(dto.getAmount());
        order.setProductId(dto.getProductId());

        return order;
    }

    public OrderResponse toDto(Order order){
        if (Objects.isNull(order)) return null;

        OrderResponse dto = new OrderResponse();
        dto.setId(order.getId());
        dto.setProductId(order.getProductId());
        dto.setAmount(order.getAmount());
        dto.setWarehouseId(order.getWarehouse().getId());

        return dto;
    }
}

