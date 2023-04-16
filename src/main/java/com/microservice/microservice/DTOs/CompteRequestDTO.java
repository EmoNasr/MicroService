package com.microservice.microservice.DTOs;

import com.microservice.microservice.enums.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class  CompteRequestDTO {
    private Double balance;
    private String currency;
    private AccountType type;
}