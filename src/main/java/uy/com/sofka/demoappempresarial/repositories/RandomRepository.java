package uy.com.sofka.demoappempresarial.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import uy.com.sofka.demoappempresarial.models.Random;

public interface RandomRepository extends ReactiveCrudRepository<Random, String> {
    
}