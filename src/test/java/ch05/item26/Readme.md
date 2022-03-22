## 로 타입??(로 = raw)은 사용하지 말라.

---

### 제네릭 (한글/영문) 용어 정리 


한글 용어 | 영문 용어 | 예
------------ | -------------| -------------|
매개변수화 타입         | parameterized type           |List<String>
실제 타입 매개변수      | actual type parameter        |String
제네릭 타입             | generic type                 |List<E>
정규 타입 매개변수      | formal type parameter        |E
비한정적 와이들카드 타입|unbounded wildcard type       |List<?>
로(raw) 타입            | raw type                     | List
한정적 타입 매개변수    | bounded type type parameter  | <E extends Number>
재귀적 타입 한정        | recursive type bound         | <T extends Comparable<T>>
한정적 와일드 카드 타입 | bounded wildcard type        | List<? extends Number>
제네릭 메서드           | generic method               |static <E> List<E>, asList<E[] a>
타입 토큰               | type token                   |String.class


---

### 요약
`로 타입을 사용하면 런타임에 예외가 일어날 수 있으니 사용하면 안된다.
로 타입은 제네릭이 도입되기 이전 코드와의 호환성을 위해 제공될 뿐이다.
Set<Object>는 어떤 타입의 객체도 저장할 수 있는 매개변수화 타입이고,
Set<?>는 모종의 타입 객체만 저장할 수 있는 와일드카드 타입니다.
raw 타입인 Set은 제네릭 타입 시스템에 속하지 않는다.
Set<Object>, Set<?>는 안전하지만, raw 타입인 Set은 안전하지 않다. 
`
