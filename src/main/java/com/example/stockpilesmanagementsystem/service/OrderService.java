package com.example.stockpilesmanagementsystem.service;

import com.example.stockpilesmanagementsystem.common.exception.NotFoundException;
import com.example.stockpilesmanagementsystem.entity.Order;
import com.example.stockpilesmanagementsystem.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order get(Long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new NotFoundException("404 - Not found exception\nCouldn't find item with id:" + id)
        );
    }

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public void delete(Long id) {
        orderRepository.delete(get(id));
    }
}
