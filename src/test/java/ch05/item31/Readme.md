## 한정적 와일드카드를 사용해 API 유연성을 높이라.

`매개변수화 타(parameterized type)은 불공변이다.
결국 하나의 타입 밖에 받을 수 없다. 이럴 경우 사용할 수 있는것이 한정적 와일드 카드이다.`

> [매개변수화 타입](https://stackoverflow.com/questions/12551674/what-is-meant-by-parameterized-type)


> 상속관계: Object  <-  Number  <-  Integer, Long....

### 1.
#### 불공변인 경우, 제네릭으로 하위 타입을 받을 수 없는 문제

```java
@Getter
@AllArgsConstructor
public class CustomObject1<E> {

    private List<E> items;


    public void customAddAll(List<E> items) {
        this.items.addAll(items);
    }
}

```

```java
    @Test
    public void 한정적_와일드카드_미적용() {

        CustomObject1<Number> numberCustomObject = new CustomObject1<>(new ArrayList<>());
        CustomObject1<Integer> integerCustomObject = new CustomObject1<>(new ArrayList<>());

        numberCustomObject.customAddAll(integerCustomObject.getItems()); // 불공변이라 컴파일 에러

    }
```

#### 불공변이지만, 한정적 와일드 카드를 사용하여 하위타입을 받음!
```java
@Getter
@AllArgsConstructor
public class CustomObject2<E> {

    private List<E> items;

    //한정적 와이들카드 사용!
    public void customAddAll(List<? extends E> items) {
        this.items.addAll(items);
    }
}

```

```java
@Test
public void 한정적_와일드카드_적용() {

    List<Number> numbers = new ArrayList<>();

    List<Integer> integers = new ArrayList<>();
    integers.add(1);

    List<Long> longs = new ArrayList<>();
    longs.add(2L);

    CustomObject2<Number> numberCustomObject = new CustomObject2<>(numbers);

    CustomObject2<Integer> integerCustomObject = new CustomObject2<>(integers);
    CustomObject2<Long> longCustomObject = new CustomObject2<>(longs);

    // 불공변이지만, 한정적 와일드 카드로 받을 수 있음!
    numberCustomObject.customAddAll(integerCustomObject.getItems());
    numberCustomObject.customAddAll(longCustomObject.getItems());

}
```

### 2.

> 펙스(PESC): producer-extends, consumer-super
:매개변수화 타입 T가 생산자라면 <? extends T>를 사용하고, 소비자라면 <? super T>를 사용하라.

#### 추가내용
`펙스(PESC)는 어떤 경우에 어떤 와일드카드 타입(extends, super)을 써야하는지 기억하는데 도움이 된다고
하지만, 생산자(T를 생산한다는 건 추가한다는 건가?), 소비자(T를 소비한다는 건, 삭제 한다는건가?)라는 단어
가 언제 어떤 와일드카드 타입을 써야하는지에 대한 판단을 헷갈리게 만든다.
`    

`
customAddAll, customRemoveAll 처럼 추가하고, 더하는 것과 같은 작업에서는 extends를 써야하고,
copy처럼 E(제네릭) 인스턴스를 복사하여 담는 작업에서는 super를 써야한다.
`

> ***CRUD extends, Copy super*** 라고 이해하는게 더 좋은 공식이 될수도 있겠다.
> 추가적으로 Comparator, Comparable은 항상 super를 사용해야 한다.

```java
@Getter
@AllArgsConstructor
public class CustomObject2<E> {

    private List<E> items;

    //E를 더한다.
    public void customAddAll(List<? extends E> items) {
        this.items.addAll(items);
    }

    //E를 복사한다.
    public void copy(List<? super E> items){
        items.addAll(this.items);
    }

    //E를 제거한다.
    public void customRemoveAll(List<? extends E> items){
        this.items.removeAll(items);
    }
}
```

```java
    @Test
    public void 한정적_와일드카드_적용() {

        List<Number> numbers = new ArrayList<>();

        List<Integer> integers = new ArrayList<>();
        integers.add(1);

        List<Long> longs = new ArrayList<>();
        longs.add(2L);

        CustomObject2<Number> numberCustomObject = new CustomObject2<>(numbers);

        CustomObject2<Integer> integerCustomObject = new CustomObject2<>(integers);
        CustomObject2<Long> longCustomObject = new CustomObject2<>(longs);

        
        // 한정적 <? extends E> 를 사용해 하위 타입을 추가 한다!
        numberCustomObject.customAddAll(integerCustomObject.getItems());
        numberCustomObject.customAddAll(longCustomObject.getItems());
        
        
        //numberCustomObject의 items에는 [Integer:1, Long:2L] 이 들어 있다!

        
        // 한정적 <? extends E> 를 사용해 하위 타입을 제거한다! : Integer:1을 제거한다.
        numberCustomObject.customRemoveAll(integers);
        
        
        CustomObject2<Object> objectCustomObject = new CustomObject2<>(new ArrayList<Object>());

        
        // 한정적 <? super E> 를 사용해 상위 타입으로 복사한다.
        numberCustomObject.copy(objectCustomObject.getItems());
    }
```
### 3.

`반환 타입에는 한정적 와일드카드 타입을 사용하면 안 된다.
유연성을 높이기 보다 클라이언트 코드에서도 와일드 카드를 써야하기 때문인다.
` 

### 4. 
 `와일드카드와 제네릭은 공통되는 부분이 있어서, 메서드를 정의할 때 둘중 어느것을 사용해도
 괜찮을 때가 많다. 이런 경우, 메서드 선언에 타입 매개변수가 한 번만 나오면 와일드 카드로 대체하라.
 비 한정적 타입 매개변수라면 비한정적 와일드카드로 바꾸고, 한정적 타입 매개변수라면 한정적 와일드 카드로
 바꾸면 된다.`
 
 
```java
//제네릭 메서드
public static <E> void swap(List<E> list, int i, int j);
//와일드카드 메서드
public static void swap(List<?> list, int i, int j);
```
 
`두번째 와일드카드 메서드의 구현에서는 컴파일 에러가 난다.` 
 
```java
//와일드카드 메서드
public static void swap(List<?> list, int i, int j){
    list.set(i, list.set(j, list.get(i)));//컴파일 에러 발생.
};
``` 

`와일드 카드 타입의 list에는 null만 들어 갈 수 있기 때문에 컴파일에러가 난다!` 

```java
    @Test
    public void 와일드카드() {
        List<?> list = new ArrayList<>();
        
//        list.add(1);      //컴파일 에러!
//        list.add(2L);     //컴파일 에러!
//        list.add("");     //컴파일 에러!
//        list.add(new Object());   //컴파일 에러!
        
        list.add(null); //알수 없는 타입에는 null만 들어 갈수 있다.
        
//        list.set(1, 1);   //컴파일 에러!
        list.set(1, null);
        
    }
```
 
`제네릭 도우미 메서드를 추가하여 해결!` 
```java
private static <E> void swapHelper(List<E> list, int i, int j){
    list.set(i, list.set(j, list.get(i)));//컴파일 에러 발생.
}


//와일드카드 메서드
public static void swap(List<?> list, int i, int j){
    swapHelper(list, i, j);
};
```
 
---

### 요약
`
조금 복잡하더라도 와일드카드 타입을 적용하면 API가 훨씬 유연해진다.
`
