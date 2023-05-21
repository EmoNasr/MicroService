package com.microservice.microservice.Web;

import com.microservice.microservice.DTOs.CompteRequestDTO;
import com.microservice.microservice.DTOs.CompteResponceDTO;
import com.microservice.microservice.Respositorys.CompteRespository;
import com.microservice.microservice.Services.CompteService;
import com.microservice.microservice.entites.Compte;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class BankAccountGqlController {
    private CompteRespository compteRespository;
    private CompteService compteService;

    @QueryMapping
    List<Compte> accounts(){
        return compteRespository.findAll();
    }

    @QueryMapping
    Compte accountById(@Argument String id){
        return compteRespository.findById(id).orElseThrow(()->new RuntimeException(String.format("hehdehed")));
    }

    @MutationMapping
    public CompteResponceDTO addAccount(@Argument CompteRequestDTO compte){
        return compteService.addCompte(compte);
    }
}
