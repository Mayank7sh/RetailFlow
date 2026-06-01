package com.example.Backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product_variants")
public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VariantID")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductID", nullable = false)
    private Product product;

    @Enumerated(EnumType.STRING)
    @Column(name = "Attribute", nullable = false)
    private VariantAttribute attribute;

    @Column(name = "AttributeValue", nullable = false)
    private String attributeValue;

    @Column(name = "Price", nullable = false)
    private BigDecimal price;

    @Column(name = "SKU", unique = true, nullable = false)
    private String sku;

    @Column(name = "StockQuantity", nullable = false)
    private Integer stockQuantity; // Stock count ke liye Integer sahi hai
}