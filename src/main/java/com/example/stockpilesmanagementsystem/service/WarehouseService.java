package com.example.stockpilesmanagementsystem.service;

import com.example.stockpilesmanagementsystem.common.exception.BadRequestException;
import com.example.stockpilesmanagementsystem.common.exception.NotFoundException;
import com.example.stockpilesmanagementsystem.dto.warehouse.request.WarehouseUpdateItemsRequest;
import com.example.stockpilesmanagementsystem.entity.Warehouse;
import com.example.stockpilesmanagementsystem.repository.WarehouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class WarehouseService {
    private WarehouseRepository warehouseRepository;
    private ProductService productService;

    public List<Warehouse> getAll() {
        return warehouseRepository.findAll();
    }

    public Warehouse get(Long id) {
        return warehouseRepository.findById(id).orElseThrow(
                () -> new NotFoundException("404 - Not found exception\nCouldn't find item with id:" + id)
        );
    }

    public Warehouse create(Warehouse warehouse) {
        SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        warehouse.setSupplyDate(formatter.format(date));
        return warehouseRepository.save(warehouse);
    }

    public void delete(Long id) {
        warehouseRepository.delete(get(id));
    }

    public void putItem(WarehouseUpdateItemsRequest dto) {
        Warehouse warehouse = get(dto.getWarehouseId());
        if (!(warehouse.getCapacity() - warehouse.getQuantity() >= productService.get(dto.getProductId()).getMeasure())) {
            throw new BadRequestException("Warehouse is full");
        } else {
            warehouse.addProduct(productService.get(dto.getProductId()));
            warehouse.setQuantity(warehouse.getQuantity() + productService.get(dto.getProductId()).getMeasure());
            SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            warehouse.setSupplyDate(formatter.format(date));
            warehouseRepository.save(warehouse);
        }
    }

    public void deleteItem(WarehouseUpdateItemsRequest dto) {
        Warehouse warehouse = get(dto.getWarehouseId());
        boolean isInSWarehouse = false;
        int i = 0;
        while (!isInSWarehouse) {
            if (i < warehouse.getProducts().size()) {
                if (warehouse.getProducts().contains(productService.get(dto.getProductId()))) {
                    isInSWarehouse = true;
                    warehouse.deleteProduct(productService.get(dto.getProductId()));
                    warehouse.setQuantity(warehouse.getQuantity() - productService.get(dto.getProductId()).getMeasure());
                    warehouseRepository.save(warehouse);
                }
            } else {
                throw new BadRequestException("Not enough items");
            }
        }
    }
}
