package com.microservice.microservice.Services;

import com.microservice.microservice.DTOs.CompteRequestDTO;
import com.microservice.microservice.DTOs.CompteResponceDTO;
import com.microservice.microservice.Respositorys.CompteRespository;
import com.microservice.microservice.entites.Compte;
import com.microservice.microservice.mappers.CompteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class CompteServiceImp implements CompteService{

    @Autowired
    private CompteRespository compteRespository;
    @Autowired
    private CompteMapper compteMapper;
    @Override
    public CompteResponceDTO addCompte(CompteRequestDTO compteDTO) {
        Compte account = Compte.builder()
                .id(UUID.randomUUID().toString())
                .type(compteDTO.getType())
                .currency(compteDTO.getCurrency())
                .createAt(new Date())
                .balance(compteDTO.getBalance())
                .build();

        Compte savedCompte = compteRespository.save(account);

//        CompteResponceDTO compteResponceDTO = CompteResponceDTO.builder()
//                .id(savedCompte.getId())
//                .type(savedCompte.getType())
//                .currency(savedCompte.getCurrency())
//                .createAt(savedCompte.getCreateAt())
//                .balance(savedCompte.getBalance())
//                .build();

//        remplacer par

        CompteResponceDTO compteResponceDTO = compteMapper.findCompte(savedCompte);


        return compteResponceDTO;
    }
}
