## 스트림에서는 부작용 없는 함수를 사용하라.
---

[Collectors class 참고](https://docs.oracle.com/javase/10/docs/api/java/util/stream/Collectors.html)

---
### 요약
`
스트림 파이프라인 프로그래밍의 핵심은 부작용 없는 함수 객체에 있다. 스트림뿐 아니라 스트림 관련 객체에 건네지는 모든 함수 객체가 부작용이 없어야 한다.
스트림을 올바로 사용하려면 수집기를 잘 알아둬야 한다. 가장 중요한 수집기 팩터리는
toList, toSet, toMap, groupingBy, joining이다.
`