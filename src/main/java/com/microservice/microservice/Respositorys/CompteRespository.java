package com.microservice.microservice.Respositorys;

import com.microservice.microservice.entites.Compte;
import com.microservice.microservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource //To create REST Methodes without crate them manually
public interface CompteRespository extends JpaRepository<Compte,String> {
    @RestResource(path="/byType")
    List<Compte> findByType(@Param(("t")) AccountType type);
}
