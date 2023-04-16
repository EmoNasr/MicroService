package com.microservice.microservice.mappers;

import com.microservice.microservice.DTOs.CompteRequestDTO;
import com.microservice.microservice.DTOs.CompteResponceDTO;
import com.microservice.microservice.entites.Compte;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CompteMapper {
    public CompteResponceDTO findCompte(Compte compte){
        CompteResponceDTO compteResponceDTO = new CompteResponceDTO();
        BeanUtils.copyProperties(compte,compteResponceDTO);
        return compteResponceDTO;
    }
}
