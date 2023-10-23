package com.example.stockpilesmanagementsystem.service;

import com.example.stockpilesmanagementsystem.common.exception.NotFoundException;
import com.example.stockpilesmanagementsystem.entity.Product;
import com.example.stockpilesmanagementsystem.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product get(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new NotFoundException("404 - Not found exception\nCouldn't find item with id:" + id)
        );
    }

    public List<Product> getByName(String name) {
        return productRepository.findProductsByName(name);
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.delete(get(id));
    }

    public void update(Product product) {
        Product productTemp = get(product.getId());
        productTemp.setName(product.getName());
        productTemp.setMeasure(product.getMeasure());
        productTemp.setSupplier(product.getSupplier());
        productRepository.save(productTemp);
    }
}
