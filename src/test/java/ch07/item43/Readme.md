## 람다보다는 메서드 참조를 사용하라
---

예 | 메서드 참조 | 람다
---- | ---- | ---- 
정적 | Integer:parseInt| str -> Integer.parseInt(str)
한정적 | Instant.now()::isAfter | Instant then = Instant.now(); t-> then.isAfter(t);
비한정적 | String::toLowerCase | str -> str.toLowerCase()
클래스 | TreeMap<K,V>::new | () -> new TreeMap<K,V>
배열 | int[]::new | len -> new int[len]

---
### 요약
`
메서드 참조는 람다의 간단명료한 대안이 될 수 있다. 메서드 참조 쪽이 짧고 명확하다면 메서드 참조를 쓰고,
그렇지 않을 때만 람다를 사용하라.
`