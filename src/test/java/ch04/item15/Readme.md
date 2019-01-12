## 클래스와 멤버의 권한을 최소화하라

---
### 요약

`프로그램 요소의 접근성은 가능한 한 최소한으로 하라. 꼭 필요한 것만 골라 최소한의
public API를 설계하자. 그 외에는 클래스, 인터페이스, 멤버가 의도치 않게 API로 공개
되는 일이 없도록 해야 한다. public 클래스는 상수용 public static final 필드 외에는
어떠한 public 필드도 가져서는 안된다. public static final 필드가 참조하는 객체가
불변인지 확인하라.`


---
### 기본 원칙은 간단하다. **모든 클래스와 맴버의 접근성을 가능한 한 좁혀야 한다.**

접근제한자에 대한 추가적인 설명 생략. ([java 접근 제한자](https://wikidocs.net/232))

#### public static final 사용시 주의할 점
```java
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

}
```

#### 객체 copy를_통한_방어적_복사

```java
public class Item15Test {
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
```

#### API의 좋은 설계
> 잘 설계된 컴포넌트는 모든 내부 구현을 완벽히 숨겨, 구현과 API를 깔끔히
분리한다. 오직 API를 통해서만 다른 컴포넌트와 소통하며 서로의 내부 동작 방식
에는 전혀 개의치 않는다. 정보 은닉, 혹은 캡슐화라고 하는 이 개념은 소프트
웨어 설계의 근간이 되는 원리다.


#### [자바 9의 모듈 시스템](https://www.popit.kr/%EB%82%98%EB%A7%8C-%EB%AA%A8%EB%A5%B4%EA%B3%A0-%EC%9E%88%EB%8D%98-java9-%EB%B9%A0%EB%A5%B4%EA%B2%8C-%EB%B3%B4%EA%B8%B0/)
java 9의 모듈 시스템 내용을 보면, 모듈 방식의 개발을 지향하고,
module방식의 개발에 있어서 새로운 접근제한 형식을 추가하였다.

#### 자바 9의 모듈 방식에 대한 책 서술 내용.
> jdk이 외에도 모듈 개념이 아직 널리 받아들여질지 예측하기 어렵기 때문에
아직 이른감이 있고 당분간은 사용하지 않는게 좋을거 같다.
