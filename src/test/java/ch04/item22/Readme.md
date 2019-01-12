## 인터페이스는 타입을 정의하는 용도로만 사용하라.

---

### 요약

` 인터페이스는 타입을 정의하는 용도로만 사용해야 한다. 상수 공개용 수단으로
사용하지 말자.`

### 안티 패턴 : 상수 인터페이스

```java
public interface Constants {
    static final double AVG = 6.2345235123;
    static final double AVG = 9.11111115222;
    static final double AVG = 1.3542345235;
}
```

`클래스 내부에서 사용하는 상수는 외부 인터페이스가 아니라 내부 구현에 해당한다.
따라서 상수 인터페이스가 구현하는 것은 내부 구현을 클래스의 API로 노출하는 행위
이다. 이보다는 상수 유틸클래스를 사용하자.`

```java
//유틸 클래스
public class Constants {
    private Constants(){}
    
    public static final double AVG = 6.2345235123;
    public static final double AVG = 9.11111115222;
    public static final double AVG = 1.3542345235;
}
```


 