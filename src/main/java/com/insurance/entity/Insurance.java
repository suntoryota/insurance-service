package com.insurance.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "insurances")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyNumber;
    private String customerName;
    private String type;
    private Double premium;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    // Constructors, getters, and setters
}
