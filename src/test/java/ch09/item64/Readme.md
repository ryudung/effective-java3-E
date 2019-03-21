
## 객체는 인터페이스를 사용해 참조하라.

---

```java

//좋은 예. 인터페이스를 타입으로 사용했다
Set<Dog> dogSet = new LinkedHashSet<>();

//나쁜 예. 클래스를 타입으로 사용했다!!
LinkedHashSet<Dog> dogSet = new LinkedHashSet<>();

```
---

### 요약

`
인터페이스를 타입으로 사용하는 습관을 길러두면 프로그램(프로그램을 수정할 때, 변결 될 경우)이
 훨씬 유연해질 것이다.
`