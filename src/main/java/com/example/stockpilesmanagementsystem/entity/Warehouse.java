package com.example.stockpilesmanagementsystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double quantity;
    private double capacity;
    private String supplyDate;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "warehouse_product",
            joinColumns = { @JoinColumn(name = "warehouse_fk") },
            inverseJoinColumns = { @JoinColumn(name = "product_fk") }
    )
    private Set<Product> products;

    @OneToMany(mappedBy = "warehouse", fetch = FetchType.LAZY)
    private Set<Order> orders;

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(Product product) {
        products.remove(product);
    }
}
