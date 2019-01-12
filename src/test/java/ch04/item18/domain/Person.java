package ch04.item18.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Person {
    private List<String> cars;

    public void addCar(String car){
        cars.add(car);
    }

    public void addCarAll(List<String> cars){
        this.cars.addAll(cars);
    }
}
