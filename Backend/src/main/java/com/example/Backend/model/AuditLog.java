package com.example.Backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "audit_logs")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AuditID")
    private Integer id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @Column(name = "Action", nullable = false)
    private String action;
    @Column(name = "EntityType", nullable = false)
    private String entityType;

    @Column(name = "Timestamp", nullable = false, updatable = false)
    private LocalDateTime timestamp;


    @PrePersist
    protected void onCreate() {
        this.timestamp = LocalDateTime.now();
    }
}