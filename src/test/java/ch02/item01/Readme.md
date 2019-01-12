## 생성자 대신 정적 팩터리 메서드를 고려하라

---
### 요약
`정적 팩터리 메서드와 public 생성자는 각자의 쓰임새가 있으니 상대적인
장단점을 이해하고 사용하는 것이 좋다. 그렇다 하더라도 정적 팩터리를 사용하는게
유리한 경우가 더 많으므로 무작정 public 생성자를 제공하던 습관이 있다면 고치자.
`
---

### 흔히 사용되는 정적 팩토리 메서드 명명 방식.
```java
public class Main{
    public void main(){
        //from: 매개변수가 1개일 경우,
        Dog dog = Dog.from(name);
        
        //of: 여러 매개변수를 사용할 경우,
        Dog dog = Dog.of(name, age);
        
        //valueOf: from, of 보다 자세한 버전.
        Dog dog = Dog.valueOf(name, age);
        
        //getInstance: 인스턴스를 반환하지만, 같은 인스턴스임을 보장하지 않음.
        Dog dog = getInstance(age);
        
        //newInstance: 매번 새로운 인스턴스를 반환.
        Dog dog = Dog.newIncetance(name, age);
        
        //getType: 다른 클래스의 팩터리 메서드를 사용할 경우.
        Dog dog = Animal.getDog(name);
        
        //newType: 다른 클래스의 팩터리 메서드를 사용, 매번 새로운 인스턴스를 반환.
        Dog dog = Animal.newDog(name);
        
        //getType, newType의 간결한 버전.
        Dog dog = Animal.dog(age);
    }
}

```
`*참고: 위의 명명방식은 반드시 그렇다는 것은 아니다. 또한, 라이브러리나
 다른사람의 코드를 쉽게 이해할 수 있기도 하지만, 생성방식에 대한 확인은 필요하다.
 `
 
### 장점
 - 이름을 가질 수 있다.
 - 호출될 때마다 인스턴스를 새로 생성하지 않을 수도 있다.
 - 반환 타입의 하위 타입 객체를 반환할 수도 있다.
 - 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수도 있다.
 - 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.
 
### 단점
 - 상속을 하려면 public이나 protected 생성자가 필요하니 정적 팩터리 메서드만 제공하면 하위 클래스를 만들수 없다.
   (불변 타입으로 만들경우 오히려 장점이 될수 있다)
 - 정적 팩터리 메서드는 프로그래머가 확인작업이 필요하다.(주석을 달자)
 
