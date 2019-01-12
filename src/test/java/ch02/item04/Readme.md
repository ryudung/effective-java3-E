## 인스턴스화를 막으려거든 private 생성자를 사용하라

---

### 요약
` 추상클래스로 만드는 것은 인스턴스화를 막을 수 없다, private 생성자를 이용하자`

---

```java
public class Dog {
    //기본 생성자를 막아 인스턴스를 사용하지 않는다.
    private Dog(){
        throw new AssertionError();
    }    
}
```