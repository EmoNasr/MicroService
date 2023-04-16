package com.microservice.microservice.DTOs;

import com.microservice.microservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CompteResponceDTO {
    private String id;
    private Date createAt;
    private Double balance;
    private String currency;
    private AccountType type;
}
