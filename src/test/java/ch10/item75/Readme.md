
## 예외의 상세 메시지에 실패 관련 정보를 담으라.

---

예외를 잡지 못해 프로그램이 실패하면 그 예외의 스택 추적정보를 자동으로 출력한다.
이 정보를 보다 상세하게 해준다면, 실패한 순간의 상황을 정확히 포착할 수 있다. 

#### 실패원인을 쉽게 분석하려면 발생한 예외의 관여된 모든 매개변수와 필드의 값을 실패 메시지에 담아야 한다.

#### IndexOutOfBoundsException에 상세한 정보를 담을 수 있도록 변경한 코드

```java
public IndexOutOfBoundsException(int lowerBound, int upperBound, int index) {
    super(String.format("최소값: %d, 최댓값: %d, 인덱스: %d", lowerBound, upperBound, index))
    
    this.lowerBound = lowerBound;
    this.uppperBound = upperBound;
    this.index = index;
}
```
