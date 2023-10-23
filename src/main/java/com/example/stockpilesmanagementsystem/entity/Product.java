package com.example.stockpilesmanagementsystem.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double measure;

    @ManyToOne(fetch = FetchType.LAZY)
    private Supplier supplier;

    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
    private Set<Warehouse> warehouses;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMeasure(double measure) {
        this.measure = measure;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMeasure() {
        return measure;
    }

    public Supplier getSupplier() {
        return supplier;
    }
}
