package ch03.item14;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class ComparatorTest {
    @Test
    public void comparator() {
        //given
        Dog dog1 = Dog.builder()
                .age(1)
                .legs(4)
                .build();

        Dog dog2 = Dog.builder()
                .age(2)
                .legs(4)
                .build();

        Dog dog3 = Dog.builder()
                .age(3)
                .legs(4)
                .build();

        List<Dog> dogs = Arrays.asList(dog1, dog2, dog3);


        //when
        dogs.sort(Dog.getReversedComparator());


        //then
        Assert.assertThat(dogs.get(0).getAge(), is(3));
        Assert.assertThat(dogs.get(1).getAge(), is(2));
        Assert.assertThat(dogs.get(2).getAge(), is(1));
    }
}
