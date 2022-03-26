package uy.com.sofka.demoappempresarial.models;

public class RequestDTO {
  private Integer generateMany;
  private String generateAfter;
  private String generateBefore;
  private Integer minuteIntervals;

  
  public Integer getGenerateMany() {
    return this.generateMany;
  }

  public void setGenerateMany(Integer generateMany) {
    this.generateMany = generateMany;
  }

  public String getGenerateAfter() {
    return this.generateAfter;
  }

  public void setGenerateAfter(String generateAfter) {
    this.generateAfter = generateAfter;
  }

  public String getGenerateBefore() {
    return this.generateBefore;
  }

  public void setGenerateBefore(String generateBefore) {
    this.generateBefore = generateBefore;
  }

  public Integer getMinuteIntervals() {
    return this.minuteIntervals;
  }

  public void setMinuteIntervals(Integer minuteIntervals) {
    this.minuteIntervals = minuteIntervals;
  }

}