## 메서드, 생성자의 다중정의는 신중하게 해야 한다.
---

1. 다중정의는 혼동과 실수를 일으킬 수 있다.
```java
public String name(Set<?> s){
    return "Set";
}

public String name(List<?> s){
    return "List";
}

public String name(Collection<?> s){
    return "Collection";
}

public void main(){
    //"뭘까??"
    String name = name(Collection collection = new ArrayList<>());
    
    
    
    
    
    //답:"Collection"
}


```
2. 다중정의 대신 메서드 이름을 다르게 지어주는 방법도 있다.
    - writeBoolean()
    - writeLong()
    - writeString()
  
---
### 요약
`
 일반적으로 매개변수 수가 같을 때는 다중정의를 피하는게 좋다.
`