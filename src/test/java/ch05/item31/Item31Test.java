package ch05.item31;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Item31Test {

//    @Test
//    public void 한정적_와일드카드_미적용() {
//
//        CustomObject1<Number> numberCustomObject = new CustomObject1<>(new ArrayList<>());
//        CustomObject1<Integer> integerCustomObject = new CustomObject1<>(new ArrayList<>());
//
//        numberCustomObject.customAddAll(integerCustomObject.getItems()); // 불공변이라 컴파일 에러
//
//    }


    @Test
    public void 한정적_와일드카드_적용() {

        List<Number> numbers = new ArrayList<>();

        List<Integer> integers = new ArrayList<>();
        integers.add(1);

        List<Long> longs = new ArrayList<>();
        longs.add(2L);

        CustomObject2<Number> numberCustomObject = new CustomObject2<>(numbers);

        CustomObject2<Integer> integerCustomObject = new CustomObject2<>(integers);
        CustomObject2<Long> longCustomObject = new CustomObject2<>(longs);


        // 한정적 <? extends E> 를 사용해 하위 타입을 추가 한다!
        numberCustomObject.customAddAll(integerCustomObject.getItems());
        numberCustomObject.customAddAll(longCustomObject.getItems());

        // 한정적 <? extends E> 를 사용해 하위 타입을 제거한다!

        numberCustomObject.customRemoveAll(integers);


        CustomObject2<Object> objectCustomObject = new CustomObject2<>(new ArrayList<Object>());


        // 한정적 <? super E> 를 사용해 상위 타입으로 복사한다.
        numberCustomObject.copy(objectCustomObject.getItems());
    }

    @Test
    public void 와일드카드() {
        List<?> list = new ArrayList<>();

//        list.add(1);      //컴파일 에러!
//        list.add(2L);     //컴파일 에러!
//        list.add("");     //컴파일 에러!
//        list.add(new Object());   //컴파일 에러!

        list.add(null); //알수 없는 타입에는 null만 들어 갈수 있다.

//        list.set(1, 1);   //컴파일 에러!
        list.set(1, null);

    }
}
