package ch04.item18.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ForwardingPerson {

    private Person person;

    public void addCar(String car) {
        person.addCar(car);
    }

    public void addCarAll(List<String> cars) {
        person.addCarAll(cars);
    }
}
