package uy.com.sofka.demoappempresarial.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import uy.com.sofka.demoappempresarial.models.Random;
import uy.com.sofka.demoappempresarial.models.RequestDTO;
import uy.com.sofka.demoappempresarial.services.RandomService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/r")
public class RandomController {

  private RandomService randomService;

  @Autowired
  public RandomController(RandomService randomService) {
    this.randomService = randomService;
  }

  @PostMapping("")
  public Mono<ResponseEntity> post(@RequestBody RequestDTO request) {
    return randomService.saveRandom(request)
            .map(random -> new ResponseEntity<Random>(random, HttpStatus.CREATED))
            .cast(ResponseEntity.class)
            .onErrorResume(e -> Mono.just(new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED)));
  }

  @GetMapping("")
  public Mono<ResponseEntity> get() {
    return randomService.getRandoms()
            .collectList()
            .map(listOfRandoms -> new ResponseEntity<List<Random>>(listOfRandoms, HttpStatus.OK))
            .cast(ResponseEntity.class)
            .onErrorResume(e -> Mono.just(new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED)));
  }
}