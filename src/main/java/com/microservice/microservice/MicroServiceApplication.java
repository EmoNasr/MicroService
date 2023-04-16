package com.microservice.microservice;

import com.microservice.microservice.Respositorys.CompteRespository;
import com.microservice.microservice.entites.Compte;
import com.microservice.microservice.enums.AccountType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class MicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRespository bankAccount){
        return args -> {
            for (int i=0;i<10;i++){
               Compte compte = Compte.builder()
                       .id(UUID.randomUUID().toString())
                       .type(Math.random() > 0.5? AccountType.SAVING_ACCOUNT:AccountType.CURRENTS_ACCOUNT)
                       .balance(1000+Math.random()*90000)
                       .createAt(new Date(0+i,i+i*2,20+i+i))
                       .currency("MAD")
                       .build();

               bankAccount.save(compte);
            }
        };
    }

}
