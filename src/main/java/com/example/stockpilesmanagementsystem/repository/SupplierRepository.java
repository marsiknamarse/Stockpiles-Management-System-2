package com.example.stockpilesmanagementsystem.repository;

import com.example.stockpilesmanagementsystem.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Query(nativeQuery = true, value = "select * from Supplier where Supplier.name = :name")
    List<Supplier> findSuppliersByName(String name);

    @Query(nativeQuery = true, value = "select * from Supplier where Supplier.address = :address")
    List<Supplier> findSuppliersByAddress(String address);
}
