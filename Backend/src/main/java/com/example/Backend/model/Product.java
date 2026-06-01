package com.example.Backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private Integer id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "CategoryID")
    private Integer categoryId;

    @Column(name = "Brand")
    private String brand;

    @Column(name = "BasePrice")
    private BigDecimal basePrice;

    @Column(name = "SKU", unique = true)
    private String sku;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private ProductStatus status = ProductStatus.Active;
}