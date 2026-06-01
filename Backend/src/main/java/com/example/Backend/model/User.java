package com.example.Backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Integer id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "Role", nullable = false)
    private UserRole role;

    @Column(name = "Email", unique = true, nullable = false)
    private String email;

    @Column(name = "Phone", unique = true)
    private String phone;

    @Column(name = "StoreID")
    private Integer storeId;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private UserStatus status = UserStatus.Active;
}