package uy.com.sofka.demoappempresarial;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

public class RandomTest {
  
  @Test
  public void gettingDate() {
    var date = LocalTime.of(0,0).toSecondOfDay();
    var date2 = LocalTime.now().toSecondOfDay();
    var date3 = LocalTime.ofSecondOfDay(date);
    System.out.println(date);
    System.out.println(date2);
    System.out.println(date3);
  };

  @Test
  public void StringToLocalTime() {
    var hora = "03:23";

    System.out.println(stringToTime(hora));
  };

  public LocalTime stringToTime(String str) {
    return LocalTime.of(Integer.parseInt(str.split(":")[0]), Integer.parseInt(str.split(":")[1]));
  }
}
