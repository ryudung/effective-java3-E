## 옵셔널 반환은 신중히 하라.
---

### 옵셔널은 성능상 민감한 메서드라면 신중히 생각해보자. 하지만, 옵셔널을 사용하면 가독성이 높아지고, null처리를 쉽게 할 수 있다.

### 값이 존재 하지 않을 경우에 대한 처리
```java
public Optional<Dog> foo(int someInt){
    
    if(someInt <0){
        return Optional.empty();
    }
    
    Dog dog = new Dog();
    
    ...
    
    
    return Optional.of(dog);
}

public void main(){
    int someInt = 1;
    
    Optional<Dog> optDog = foo(someInt);
    
    //값이 존재 하지 않을 경우 처리
    if(!optDog.isPresent()){
        ...
    }
}
```

### 값이 존재 하지 않을 경우에 디폴트 값으로 처리
```java
public Optional<Dog> foo(int someInt){
    
    if(someInt <0){
        return Optional.empty();
    }
    
    Dog dog = new Dog();
    
    ...
    
    
    return Optional.of(dog);
}

public void main(){
    int someInt = 1;
    
    Optional<Dog> optDog = foo(someInt);
    
    //옵셔널 값이 없을 경우, 디폴트로 Dog 객체를 생성해서 사용한다!
    Dog dog = optDog.orElase(new Dog());
    
    ...
}
```
---
### 요약
`
 - 값을 반환하지 못할 가능성이 있고, 호출할 때마다 반환값이 없을 가능성을 염두에 둬야하는
 메서드라면 옵셔널을 반환해야 할 상황일 수 있다. 하지만 옵셔널 반환에는 성능저하가 뒤따르니
 (정말 많이)성능에 민감한 메서드라면 null을 반환하거나 예외를 던지는 편이 나을 수 있다.
 - 옵셔널을 반환값 이외의 용도로 사용하지 말자.
`