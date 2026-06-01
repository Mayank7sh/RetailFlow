package com.example.maven_demo.model; // Ensure package matches your app folder structure

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal; // 1. Must have this import
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "retail_reports")
public class RetailReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @Enumerated(EnumType.STRING)
    private Scope scope;

    @Embedded
    private ReportMetrics metrics;

    private LocalDateTime generatedDate;

    @PrePersist
    protected void onGenerate() {
        this.generatedDate = LocalDateTime.now();
    }

    public enum Scope {
        STORE, CHANNEL, CATEGORY, PERIOD
    }

    @Data
    @Embeddable
    public static class ReportMetrics {
        @Column(name = "order_count")
        private Integer orderCount;


        @Column(name = "revenue", precision = 12, scale = 2)
        private BigDecimal revenue;

        @Column(name = "avg_order_value", precision = 10, scale = 2)
        private BigDecimal avgOrderValue;

        @Column(name = "stock_turnover", precision = 5, scale = 2)
        private BigDecimal stockTurnover;

        @Column(name = "return_rate", precision = 5, scale = 2)
        private BigDecimal returnRate;
    }
}