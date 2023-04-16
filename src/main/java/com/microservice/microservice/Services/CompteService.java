package com.microservice.microservice.Services;

import com.microservice.microservice.DTOs.CompteRequestDTO;
import com.microservice.microservice.DTOs.CompteResponceDTO;

public interface CompteService {
    public CompteResponceDTO addCompte(CompteRequestDTO compteDTO);
}
