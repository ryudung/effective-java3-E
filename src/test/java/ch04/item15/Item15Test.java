package ch04.item15;

import org.junit.FixMethodOrder;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;


@FixMethodOrder(value = NAME_ASCENDING)
public class Item15Test {

    @Test
    public void public_static_final_가변_테스트() {

        //when
        Person.DOG_ARRAY[0].changeName("super_dog");
        Person.DOG_LIST.get(0).changeName("super_dog");
        Person.UNMODIFIABLE_LIST.get(0).changeName("super_dog");
        Person.Dog[] dogs = Person.getDogs();

        //then
        /**
         * public static final을 통해 불변 선언을 할 때
         * array나 list 등 참조값을 가지는 객체는 다음과 같이
         * 내부 필드 값을 변경할 수 있는 가변상태를 가질 수 있음에 주의 해야한다.
         * */
        assertThat(Person.DOG_ARRAY[0].getName(), is("super_dog"));
        assertThat(Person.DOG_LIST.get(0).getName(), is("super_dog"));

        //unmodifiable 사용.
        assertThat(Person.UNMODIFIABLE_LIST.get(0).getName(), is("super_dog"));

        //array clone() 사용. array의 내부 레퍼런스 타입 객체는 참조값이 같다.
        assertThat(dogs[0], is(Person.getDogs()[0]));

        assertNotSame(dogs, Person.getDogs());
    }


    @Test
    public void copy를_통한_방어적_복사() {
        //when
        Person.Dog[] dogs= Person.getCopyDogs();
        dogs[0].changeName("super_dog");

        //then
        assertNotEquals(dogs, Person.getCopyDogs());
        assertThat(Person.getCopyDogs()[0].getName(), is("ryudung"));
    }
}
