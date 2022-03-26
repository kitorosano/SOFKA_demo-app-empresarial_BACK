package uy.com.sofka.demoappempresarial.services;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.demoappempresarial.models.Random;
import uy.com.sofka.demoappempresarial.models.RequestDTO;
import uy.com.sofka.demoappempresarial.repositories.RandomRepository;

@Service
public class RandomService {
  private RandomRepository randomRepository;

  @Autowired
  public RandomService(RandomRepository randomRepository) {
    this.randomRepository = randomRepository;
  }

  public Mono<Random> saveRandom(RequestDTO request) {
    return Mono.just(new Random()).map(entity -> {
      entity.setDate(LocalDateTime.now());
      entity.setGenerateMany(request.getGenerateMany());
      entity.setGenerateAfter(stringToTime(request.getGenerateAfter()));
      entity.setGenerateBefore(stringToTime(request.getGenerateBefore()));
      entity.setMinuteIntervals(request.getMinuteIntervals());
      return entity;
    }).map(entity -> {
      var startRandom = entity.getGenerateAfter().toSecondOfDay();
      var endRandom = entity.getGenerateBefore().toSecondOfDay();
      
      var availbleRange = (endRandom - startRandom);
      int intervalDistance = LocalTime.of(0, entity.getMinuteIntervals()).toSecondOfDay();
      if(availbleRange < intervalDistance) 
        throw new IllegalArgumentException("No se puede generar con ese intervalo, cambielo o ajuste los horarios.");


      var maxRandomBetweenRange = availbleRange / intervalDistance;
      if(maxRandomBetweenRange < entity.getGenerateMany()) 
        throw new IllegalArgumentException("No se puede generar toda esa cantidad, reduzcala.");

      List<LocalTime> randomClockList = IntStream.range(0, maxRandomBetweenRange)
                                                .boxed()
                                                .map(i -> {
                                                  var randomTime = startRandom + (i * intervalDistance);
                                                  return LocalTime.ofSecondOfDay(randomTime);
                                                })
                                                .collect(Collectors.toList());
                                      
      Collections.shuffle(randomClockList);
      randomClockList.subList(entity.getGenerateMany(), randomClockList.size()).clear();
      randomClockList.sort(LocalTime::compareTo);
      
      entity.setRandomClockList(randomClockList);
      return entity;
    }).flatMap(randomRepository::save);
  }

  public Flux<Random> getRandoms() {
    return randomRepository.findAll();
  }

  public LocalTime stringToTime(String str) {
    return LocalTime.of(Integer.parseInt(str.split(":")[0]), Integer.parseInt(str.split(":")[1]));
  }
}
