## 배열보다는 리스트를 사용하라.

---

배열과 리스트의 차이

1. `상위타입의 배열은 하위타입도 받을 수 있어, 데이터 삽입에 대한 에러를 런타임시 확인 가능하다.
하지만, 리스트는 컴파일 에러가 발생해서 쉽게 찾을수 있다.`

- 공변: 상위타입으로 하위 타입을 받을 수 있다.

- 불공변: 상위타입으로 하위 타입을 받을 수 없다.

```java

    @Test(expected = ArrayStoreException.class)
    public void 배열_에러_런타임() {
        Object[] objects = new Long[1];
        objects[0] = "런타임시 에러";
    }

    @Test
    public void 리스트는_컴파일에서_에러() {
        List<Object> list = new ArrayList<Long>(); //컴파일 에러

        list.add("컴파일 에러");
    }
    
```
2. `배열은 실체화되고(런타임에도 원소의 타입을 알고있다), 리스트는 컴파일 이후 타입정보가 소거 된다.`


### 배열 대신 리스트를 통해 타입 안정성을 확보하자.
```java
//배열을 사용할 경우
public void chooser(Collection<T> choices) {
    T[] array = (T[]) choices.toArray();
    ...
}

//배열을 리스트로 변경
public void chooser(Collection<T> choices) {
    List<T> list = new ArrayList<>(choices);
    ...
}
```

---

### 요약
`
 배열은 공변이고 실체화되는 반면, 리스트는 불공변이고 타입정보가 소거된다. 그래서 둘을 섞어 쓰기란 쉽지 않다.
 섞어 쓰다가 컴파일 오류나 경고를 만나면, 가장 먼저 배열을 리스트로 대체하는 방법을 생각해 보자.
`
