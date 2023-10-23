package com.example.stockpilesmanagementsystem.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orderInfo")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long ProductId;
    private int amount;

    @ManyToOne(fetch = FetchType.LAZY)
    private Warehouse warehouse;
}
