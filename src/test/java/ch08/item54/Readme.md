## null이 아닌, 빈 컬렉션이나 배열을 반환하라
---
#### null을 반환하는 경우, 메서드를 사용하는 쪽에서 항상 null체크를 해야한다.
```java
public List<String> foo(int a){
    if(a == 0){
        return null;
    }
    
    
    ...
    
    return list; 
}

public void main(){
    List<String> list = foo();
    
    if(list == null){ // null처리 로직 추가
        ...
    }
    
    list.stream
        .map(...)
        .collect(Collectors.toList());
}

```

#### 빈 컬렉션을 반환하고, null처리 로직을 제거한다.
```java
public List<String> foo(int a){
    if(a == 0){
        return Collections.emptyList(); //빈 컬렉션을 매번 생성하지 않았다!
    }
    
    
    ...
    
    return list; 
}

public void main(){
    List<String> list = foo();
   
    
    list.stream
        .map(...)
        .collect(Collectors.toList());
}
```


---
### 요약
`
 null을 반환하는 API는 사용하기 어렵고 오류 처리 코드도 늘어난다. 그렇다고 성능이 좋은것도 아니다.
`