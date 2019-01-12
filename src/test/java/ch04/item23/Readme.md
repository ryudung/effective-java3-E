## 태그 달린 클래스보다는 클래스 계층구조를 활용하라

---

### 요약
`태그 달린 클래스를 써야 하는 상황은 거의 없다. 새로운 클래스를 작성하는
데 태그 필드가 등장한다면 태그를 없애고 계층구조로 대체하는 방법을 생각
해보자. 기존 클래스가 태그 필드를 사용하고 있다면 계층구조로 리펙토링
하는 걸 고민해보자.`

---

### 태그 달린 클래스 예

 ```java
public class Animal {
    enum Type{ DOG, CAT}
    
    final Type type;
    
    //dog에서만 쓰는 필드
    final String name;
    
    //cat에서만 쓰는 필드
    final int age;
    
    //dog용 생성자
    public Animal(String name){
        this.name = name;
    }
    
    //cat용 생성자
    public Animal(int age){
        this.age = age;
    }
    
}
```