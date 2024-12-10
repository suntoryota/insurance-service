package com.insurance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceResponse {
    private Long id;

    private String policyNumber;

    private String customerName;

    private String type;

    private Double premium;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String status;
}
