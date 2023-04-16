package com.microservice.microservice.entites;

import com.microservice.microservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "CompteP1",types = Compte.class)
public interface CompteProjection {
    public String getId();
    public AccountType getType();

}
