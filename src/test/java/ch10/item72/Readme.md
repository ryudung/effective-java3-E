
## 표준 예외를 사용하라.

---

#### 예외도 재사용하는 것이 좋으며, 자바 라이브러리는 대부분 API에서 쓰기에 충분한 예외를 제공한다.

- 표준 예외를 사용하면 다른 사람이 익히고 사용하기 쉽다.

- 표준 예외

예외 | 주요 쓰임
---- | ---- 
IllegalArgumentException | 허용하지 않는 값이 인수로 전달 됬을 때
IllegalStateException | 객체가 메서드를 수행하기 적절하지 않을 때
NullPointerException | null을 허용하지 않는 메서드에 null을 건넸을 때
IndexOutOfBoundsException | 인덱스가 범위를 넘었을 때
ConcurrentModificationException | 허용하지 않는 동시 수정이 발견됬을 때
UnsupportedOperationException | 호출한 메서드를 지원하지 않을때 

- 표준 예외는 예외가 던져지는 맥락도 부합할 때만 재사용한다.

---
