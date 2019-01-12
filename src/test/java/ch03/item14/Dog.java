package ch03.item14;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Comparator;

@ToString
@Builder
@Getter
public class Dog {

    private final static Comparator<Dog> reversedComparator =
            Comparator.comparingInt(Dog::getAge)
                    .thenComparingInt(Dog::getLegs)
                    .reversed();

    public static Comparator<Dog> getReversedComparator() {
        return reversedComparator;
    }

    private int age;
    private int legs;
}
