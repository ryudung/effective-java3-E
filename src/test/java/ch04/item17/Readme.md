## 변경 가능성을 최소화하라.

---

#### 불변 클래스를 작성하는 5가지 원칙
 
 1. 객체의 상태를 변경하는 메서드를 제공하지 않는다.
    ex) setter...
    
 2. 클래스를 확장할 수 없도록 한다.
    - final 클래스
    - private 필드, private 생성자, [정적 팩토리(item01) 사용](https://github.com/ryudung/effective-java3-E/tree/master/src/test/java/ch02/item01)
 
 3. 모든 필드를 final로 선언한다.
 
 4. 모든 필드를 private으로 선언한다.
 
 5. 자신 외에는 내부의 가변 컴포넌트에 접근할 수 없도록 한다.
 
---
