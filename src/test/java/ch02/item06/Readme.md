## 불필요한 객체 생성을 피하라

---

```java
public class Dog {
    private static final String s = "계속해서 재사용 가능";
    
    String s = new String("매번 새로운 string을 생성");
    String s = "이와 똑같은 문자열 리터럴을 사용할 경우, 재사용 보장";
    Boolean b = Boolean.valueOf("true"); //객체 재사용
    
    //박싱된 기본 타입보다는 기본 타입을 사용하고, 의도치 않은
    //오토박싱이 숨어들지 않도록 하면, 불필요한 객체 생성을 피할수 있다.
    Long sum = 0L;
    long num = 10;
    sum = sum + num; 
}
```