
## 복구할 수 있는 상황에는 검사 예외를, 프로그래밍 오류에는 런타임 예외를 사용하라.

---

자바는 문제 상황을 알리는 타입으로(throwable) 검사 예외, 런타임 예외, 에러 이렇게
세 가지를 제공한다.

##### [참고] java Exception, ERROR 상속 구조
```java
Object
 +--- Throwable
       +--- Exception
       |     +--- RuntimeException
       |     +--- ...
       |
       +--- Error
             +--- ...

```
> 검사 예외(Checked exception): public void mustRecover() throws IOException{} 와 같이 선언하여 Compile과정에서 확인 가능.
> 비 검사 예외(Unchecked exception): 특별히 에러상황에 대해서 명시하지 않아 Runtime에 발생

3가지 타입을 언제 사용해야 하는지에 대한 지침

1. 호출하는 쪽에서 복구해야 한다면 검사 예외를 사용하라.

2. 프로그래밍 오류를 나타낼 때는 런타임 예외를 사용하자.
    - 비 검사 throwable은 모두 RuntimeException의 하위 클래스여야 한다.
    - Error는 상속하지 말아야 하며, throw문으로 던지지도 말아야한다.
    - Exception, RuntimeException, Error를 상속하지 않는 throwable을 만들수 있지만, 사용자를 헷갈리게 할 여지가 크다.

---

### 요약

`
복구할 수 있는 상황이면 검사 예외를, 프로그래밍 오류라면 비검사 예외를 던지자.
`