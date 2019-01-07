##private 생성자나 열거 타입으로 싱글턴임을 보증하라.

---
###요약
`싱글턴이란 인스턴스가 오직 하나만 생성할 수 있는 클래스를 말한다.
싱글턴 객체를 만드는 다양할 방식을 설명한다.
`
---

###첫번째 방식
```java
public class Dog {
    public static final Dog INSTANCE = new Dog();
    
    private Dog(){}
}

Dog dog = Dog.INSTANCE;

```
##### 리플렉션으로 private 생성자를 호출할 수 있다.
ex) AccessibleObject.setAccessible..

아래와 같이 막을수도 있다.
```java
public class Dog {
    public static final Dog INSTANCE = new Dog();
    
    private Dog(){
        //두번째 호출 될 경우, 예외를 발생시킨다.
    }
}
```

###두번째 방식
```java
public class Dog{
    private static final Dog INSTANCE = new Dog();
    public static Dog getInstance(){
        return INSTANCE;
    }
    private Dog(){}
}
```
####리플렉션에 대한 예외처리는 첫번째와 동일하다.

#### - 첫번째, 두번째의 경우 단점
- 리플렉션에 대한 추가 처리가 필요하다.
- 역직렬화할 경우마다 새로운 인스턴스를 생성하게 된다.
- 직렬화, 역직렬화에 대한 추가 처리가 필요하다.



###세번째 방식(enum 타입 방식)
```java
public enum Dog{
    INSTANCE;
    
}
```
####장점
- 간결하고, 추가 노력없이 직렬화할수 있고, 리플렉션 공격에도 안전하다.
- 원소가 하나뿐인 enum 타입이 싱글턴을 만드는 가장 좋은 방법이다.

####단점
- 만들려는 싱글턴이 enum이외의 클래스를 상속해야 한다면 이 방법은
사용할 수 없다.