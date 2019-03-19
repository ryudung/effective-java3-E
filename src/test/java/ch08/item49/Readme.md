## 매개변수가 유효한지 검사하라.
---
 매개변수에 대한 검증을 하지 않으면, Runtime시 변수가 사용 되기 전에는
잘못된 실행을 알 수 없다.

1. Null 검증

아래와 같이 검증할 수 있다.  
```java
public int append(String a, String b){
    if(a!= null){
        throw new NullPointException();
    }
    
    if(b!= null){
        throw new NullPointException();
    }
   
    
    ...
}
```

java.util.Objects.requireNonNull 메서드를 사용하면, 위의 코드보다 가독성이 높고 편리하다.
```java
public int append(String a, String b){
    Obejcts.requireNonNull(a, "a 값은 null일 수 없습니다.");
    Obejcts.requireNonNull(b, "b 값은 null일 수 없습니다.");
    
    ...
}
```

2. assert 를 활용

assert를 사용하지 않은 경우
```java
public int sum(int a, int b, String operator){
   if(a > 0){
       
   }
   
   if(b > 0){
          
  }
    
}
```

assert 사용시 좀 더 가독성이 높다.(AssertionError를 던진다.)
```java
public int sum(int a, int b, String operator){
    assert a > 0;
    assert b > 0;
    assert operator != 0;
    
}
```

---
### 요약
`
메서드나 생성자를 작성할 때면, 그 매개변수들에 어떤 제약이 있을지 생각해야한다.
그 노력은 유효성 검사가 실제 오류를 처음 걸러낼 때 충분히 보상받을 것이다.
`