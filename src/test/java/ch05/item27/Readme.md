## 비검사 경고를 제거하라.

---

- 제네릭을 사용하기 시작하면 수많은 컴파일러 경고를 보게 될 것이다. 

- 할 수 있는 한 모든 비검사 경고를 제거하자!

- 경고를 제거할 수는 없지만 타입 안전하다고 확신할 수 있다면 @SuppressWarnings("unchecked)를 달아 경고를 숨기자. 단, 주석으로 반드시 설명해 놓자.

- @SuppressWarnings은 가능한 한 좁은 범위에 적용하자.
```java

   public <T> T[] toArray(T[] a){
        
        @SuppressWarnings("unchecked") T[] result = (T[]) Arrays.copyOf(a, a.length, a.getClass());
        
        ...
    }
    
```
---

### 요약
`
 
`
