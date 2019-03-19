package ch04.item18;

import ch04.item18.domain.InstrumentedPersonCar;
import ch04.item18.domain.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item18Test {
    @Test
    public void carCount_테스트() {
        //given
        List<String> cars = Arrays.asList("람보르니기", "bmw", "그랜져", "트럭", "펠리세이드");
        String car = "뉴 모닝";
        InstrumentedPersonCar instrumentedPersonCar = new InstrumentedPersonCar(Person.builder()
                .cars(new ArrayList<>())
                .build());

        //when
        instrumentedPersonCar.addCar(car);
        instrumentedPersonCar.addCarAll(cars);

        //then
        Assert.assertEquals(6, instrumentedPersonCar.getCarCount());
    }
}
