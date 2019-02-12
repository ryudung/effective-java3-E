## (함수형 인터페이스를 만들기 보다) 표준 함수형 인터페이스를 사용하라.
---
java.util.function 43개의 표준의 함수형 인터페이스가 존재한다.

43개를 모두 알 필요는 없다. 아래 6개의 기본 인터페이스만 알면 나머지 인터페이스를 유추할 수 있다.

기본 인터페이스 | 함수 시그니처 | 예
---- | ---- | ---- 
UnaryOperator<T> | T apply(T t)| String::toLowerCase
BinaryOperator<T> | T apply(T t1, T t2) | BigInteger::add
Predicate<T> | boolean test(T t) | Collection::isEmpty
Function<T,R> | R apply(T t) | Arrays::asList
Supplier<T> | T get() | Instant::now
Consumer<T> | void accept(T t) | System.out::println

- UnaryOperator : 인수가 1개, 리턴값과 인수 타입이 같은 함수 인터페이스. 
- BinaryOperator : 인수가 2개, 리턴값과 인수 타입이 같은 함수 인터페이스.
- Predicate : 인수하나를 받아서, boolean을 리턴하는 함수 인터페이스.
- Function : 인수와 리턴 타입이 다른 함수 인터페이스.
- Supplier : 인수를 받지 않고 값을 리턴하는 함수 인터페이스.
- Consumer : 인수를 1개 받고, 반환값이 없는 함수 인터페이스.

---
### 요약
`
입력값과 반환값에 함수형 인터페이스를 사용하는 것이 가장 좋은 선택이다.
흔치는 않지만 직접 새로운 함수형 인터페이스를 만들어 쓰는 편이 나을 수도 있다.
이럴경우, 직접 만든 함수형 인터페이스에는 항상 @FunctionalInterface 애너테이션을 사용하자.
`