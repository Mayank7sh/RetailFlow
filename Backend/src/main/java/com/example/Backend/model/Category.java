package com.example.Backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private Integer id;

    @Column(name = "CategoryName", nullable = false)
    private String categoryName;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ParentCategoryID")
    private Category parentCategory;


    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
    private List<Category> subCategories;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private ProductStatus status = ProductStatus.Active;
}