package ch04.item18.domain;

import java.util.List;


public class InstrumentedPersonCar extends ForwardingPerson {
    private int carCount;

    public InstrumentedPersonCar(Person person) {
        super(person);
    }

    @Override
    public void addCar(String car) {
        carCount ++;
        super.addCar(car);
    }

    @Override
    public void addCarAll(List<String> cars) {
        carCount += cars.size();
        super.addCarAll(cars);
    }

    public int getCarCount() {
        return carCount;
    }
}
