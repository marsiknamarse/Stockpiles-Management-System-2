package com.example.stockpilesmanagementsystem.service;

import com.example.stockpilesmanagementsystem.common.exception.NotFoundException;
import com.example.stockpilesmanagementsystem.entity.Supplier;
import com.example.stockpilesmanagementsystem.repository.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupplierService {
    private SupplierRepository supplierRepository;

    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    public Supplier get(Long id) {
        return supplierRepository.findById(id).orElseThrow(
                () -> new NotFoundException("404 - Not found exception\nCouldn't find item with id:" + id)
        );
    }

    public List<Supplier> getByName(String name) {
        return supplierRepository.findSuppliersByName(name);
    }

    public List<Supplier> getByAddress(String address) {
        return supplierRepository.findSuppliersByAddress(address);
    }

    public Supplier create(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public void delete(Long id) {
        supplierRepository.delete(get(id));
    }

    public void update(Supplier supplier) {
        Supplier supplierTemp = get(supplier.getId());
        supplierTemp.setName(supplier.getName());
        supplierTemp.setAddress(supplier.getAddress());
        supplierRepository.save(supplierTemp);
    }
}
