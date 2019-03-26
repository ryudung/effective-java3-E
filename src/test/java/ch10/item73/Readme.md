
## 추상화 수준에 맞는 예외를 던져라.

---

`
수행하려는 일과 관련 없어 보이는 예외가 튀어나오면 당황스러울 것이다.
이문제를 피하려면 상위 계층에서는 저수준의 예외를 잡아 자신의 추상화 수준에
맞는 예외로 바꿔 던져야 한다.
`

##### 예외번역
```java
try{
    
} catch(LowerLevelException e){
    throw new HigherLevelException();
}
```

##### 예외를 번역할 때, 저수준의 예외가 디버깅에 도움이 된다면 예외 연쇄를 사용하는 것이 좋다.

```java
try{
    
} catch(LowerLevelException e){
    throw new HigherLevelException(e);
}

class HigherLevelException extends Exception {
    HigherLevelException(Throwable throwable){
        super(throwable);
    }
}
```

---

### 요약

`
아래 계층의 예외를 예방하거나 스스로 처리할 수 없고, 그 예외를 상위 계층에 그대로 노출하기
곤란하다면 예외 번역을 사용하자.
이때 예외 연쇄를 이용하면 상위 계층에는 맥락에 어울리는 고수준 예외를 던지면서 근본 원인도
함께 알려주어 오류를 분석하기에 좋다.
`