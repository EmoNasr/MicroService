package com.microservice.microservice.mappers;

import com.microservice.microservice.DTOs.CompteRequestDTO;
import com.microservice.microservice.DTOs.CompteResponceDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CompteMapper {
    public CompteResponceDTO findCompte(CompteRequestDTO compte){
        CompteResponceDTO compteResponceDTO = new CompteResponceDTO();
        BeanUtils.copyProperties(compte,compteResponceDTO);
        return compteResponceDTO;
    }
}
