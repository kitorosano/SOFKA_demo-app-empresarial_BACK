package uy.com.sofka.demoappempresarial.models;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Random {
  @Id
  private String id;
  private LocalDateTime date;
  private Integer generateMany;
  private LocalTime generateAfter;
  private LocalTime generateBefore;
  private Integer minuteIntervals;
  private List<LocalTime> randomClockList;


  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LocalDateTime getDate() {
    return this.date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public Integer getGenerateMany() {
    return this.generateMany;
  }

  public void setGenerateMany(Integer generateMany) {
    this.generateMany = generateMany;
  }

  public LocalTime getGenerateAfter() {
    return this.generateAfter;
  }

  public void setGenerateAfter(LocalTime generateAfter) {
    this.generateAfter = generateAfter;
  }

  public LocalTime getGenerateBefore() {
    return this.generateBefore;
  }

  public void setGenerateBefore(LocalTime generateBefore) {
    this.generateBefore = generateBefore;
  }

  public Integer getMinuteIntervals() {
    return this.minuteIntervals;
  }

  public void setMinuteIntervals(Integer minuteIntervals) {
    this.minuteIntervals = minuteIntervals;
  }

  public List<LocalTime> getRandomClockList() {
    return this.randomClockList;
  }

  public void setRandomClockList(List<LocalTime> randomClockList) {
    this.randomClockList = randomClockList;
  }


  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Random)) {
            return false;
        }
        Random random = (Random) o;
        return Objects.equals(id, random.id) && Objects.equals(date, random.date) && Objects.equals(generateMany, random.generateMany) && Objects.equals(generateAfter, random.generateAfter) && Objects.equals(generateBefore, random.generateBefore) && Objects.equals(minuteIntervals, random.minuteIntervals) && Objects.equals(randomClockList, random.randomClockList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, date, generateMany, generateAfter, generateBefore, minuteIntervals, randomClockList);
  }


  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", date='" + getDate() + "'" +
      ", generateMany='" + getGenerateMany() + "'" +
      ", generateAfter='" + getGenerateAfter() + "'" +
      ", generateBefore='" + getGenerateBefore() + "'" +
      ", minuteIntervals='" + getMinuteIntervals() + "'" +
      ", randomClockList='" + getRandomClockList() + "'" +
      "}";
  }
  
}