package com.microservice.microservice.Web;

import com.microservice.microservice.Respositorys.CompteRespository;
import com.microservice.microservice.entites.Compte;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //rest return a JSON file
@RequestMapping("/api") //changing the endpoint
public class CompteRestControler {

    private CompteRespository compteRespository;


    public CompteRestControler(CompteRespository compteRespository) {
        this.compteRespository = compteRespository;
    }

    @GetMapping("/accounts")
    public List<Compte> accounts() {
        return compteRespository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Compte account(@PathVariable String id) {
        return compteRespository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account not found", id)));
    }

    @PostMapping("/accounts")
    public Compte save(@RequestBody Compte account) {
        return compteRespository.save(account);
    }

    @PutMapping("/accounts/{id}")
    public Compte update(@PathVariable String id, @RequestBody Compte account) {

        Compte compte = compteRespository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account not found", id)));

        compte.setBalance(account.getBalance());
        compte.setType(account.getType());
        compte.setCurrency(account.getCurrency());
        compte.setCreateAt(account.getCreateAt());

        return compteRespository.save(compte);
    }

    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(@PathVariable String id) {
        compteRespository.deleteById(id);
    }
}