package com.example.stockpilesmanagementsystem.repository;

import com.example.stockpilesmanagementsystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true, value = "select * from Product where Product.name = :name")
    List<Product> findProductsByName(String name);
}
