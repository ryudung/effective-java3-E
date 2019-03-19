## 가변인수는 신중히 사용하라.
---

 가변인수는 인수 개수가 정해지지 않았을 때 아주 유용하다.
그런데 성능에 민감한 상황이라면 가변인수가 걸림돌이 될 수 있다.
가변인수 메서드는 호출 될 때마다 배열을 새로 하나 할당하고 초기화하기 때문이다.

#### 가변인수의 95%가 4개 이하이고, 나머지가 5%일 경우 아래와 같이 다중정의하면 된다.

```java
public void foo(int a){}
public void foo(int a, int b){}
public void foo(int a, int b, int c){}
public void foo(int a, int b ,int c, int d){}
public void foo(){int... a}
```
---
### 요약
`
 인수 개수가 일정하지 않은 메서드를 정의해야 한다면 가변인수가 반드시 필요하다.
 가변인수를 사용할 때는 성능 문제까지 고려하자.
`