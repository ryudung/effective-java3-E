## 타입 안전 이종 컨테이너를 고려하라.

---

일반적인 제네릭의 타입 매개변수의 개수는 고정되어 있는데, 더 유연한 수단이 필요할 때가 있다.
이럴 경우, 타입 안전 이종 컨테이너를 고려해보자.

### Class.cast()를 사용해 타입 안정성을 보장하는 컨테이너 사용법

```java
public class Favorites {

    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        //cast 메서드를 사용해 타입 안정성을 보장한다!
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        //cast 메서드를 사용해 타입 안정성을 보장한다!
        return type.cast(favorites.get(type));
    }
}

@Test
public void 이종_타입_컨테이너() {
    Favorites f = new Favorites();

    f.putFavorite(String.class, "스트링");
    f.putFavorite(Integer.class, 1);
    f.putFavorite(Long.class, 1L);

    assertEquals(f.getFavorite(String.class), "스트링");
    assertEquals(f.getFavorite(Integer.class), new Integer(1));
    assertEquals(f.getFavorite(Long.class), new Long(1L));

}
```

### 이종 타입 컨테이너는 실체화가 불가능한 타입에 대해서는 사용할 수가 없다.

````java
    @Test
    public void 이종_타입_컨테이너_실체화_불가_타입_문제() {
        Favorites f = new Favorites();

        f.putFavorite(String[].class, new String[1]);

        //컴파일 에러 발생! 지원하지 않는 타입
//        f.putFavorite(List<String>.class, new ArrayList<>());

    }
````

### 이러한 경우에 슈퍼타입을 사용하여 타입안정성을 보장할 수 있다.

Class<T>를 얻기 위한 2가지 방법

1. ParameterizedType를 사용
2. TypeFactory를 사용

```java
    //슈퍼타입을 사용하여 타입안정성을 보장한다!
    public <T> void putFavorite(TypeReference<T> valueTypeRef, T instance) {

        // ParameterizedType로 캐스팅하여 Class<T>를 얻는다!
        Class<T> tClass = ((Class<T>) ((ParameterizedType) valueTypeRef.getType()).getRawType());

        favorites.put(Objects.requireNonNull(tClass), Objects.requireNonNull(instance));
    }

    //슈퍼타입을 사용하여 타입안정성을 보장한다!
    public <T> T getFavorite(TypeReference<T> valueTypeRef) {

        // TypeFactory를 이용해서 Class<T>를 얻는다!
        Class<T> rawClass = (Class<T>) TypeFactory.type(valueTypeRef.getType()).getRawClass();

        return rawClass.cast(favorites.get(rawClass));
    }
    
    
    @Test
    public void 이종_타입_컨테이너_실체화_불가_타입_슈퍼타입_토큰() {
        //given
        Favorites f = new Favorites();

        // 슈퍼타입으로 넣는다!
        f.putFavorite(new TypeReference<List<String>>() {}, Collections.singletonList("슈퍼 타입 토큰"));

        // 슈퍼타입으로 꺼낸다!
        List<String> strings = f.getFavorite(new TypeReference<List<String>>() {});

        //then
        assertEquals("슈퍼 타입 토큰", strings.get(0));
    }
```

### 스프링에서 구현한 슈퍼타입 [ParameterizedTypeReference](https://github.com/spring-projects/spring-framework/blob/master/spring-core/src/main/java/org/springframework/core/ParameterizedTypeReference.java)

ParameterizedTypeReference의 생성자를 잠깐 살펴보자.
```java
protected ParameterizedTypeReference() {
		Class<?> parameterizedTypeReferenceSubclass = findParameterizedTypeReferenceSubclass(getClass());
		Type type = parameterizedTypeReferenceSubclass.getGenericSuperclass();
		Assert.isInstanceOf(ParameterizedType.class, type, "Type must be a parameterized type"); 
		ParameterizedType parameterizedType = (ParameterizedType) type; //ParameterizedType로 캐스팅한다!
		Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
		Assert.isTrue(actualTypeArguments.length == 1, "Number of type arguments must be 1");
		this.type = actualTypeArguments[0];
	}

```

>[Neal Gafter의 글](http://gafter.blogspot.com/2006/12/super-type-tokens.html)

>[슈퍼타입 토큰에 대한 잘 정리된 HomoEfficio님의 글](https://homoefficio.github.io/2016/11/30/%ED%81%B4%EB%9E%98%EC%8A%A4-%EB%A6%AC%ED%84%B0%EB%9F%B4-%ED%83%80%EC%9E%85-%ED%86%A0%ED%81%B0-%EC%88%98%ED%8D%BC-%ED%83%80%EC%9E%85-%ED%86%A0%ED%81%B0/)

>[토비님의 슈퍼타입 관련 동영상1](https://www.youtube.com/watch?v=01sdXvZSjcI)

>[토비님의 슈퍼타입 관련 동영상2](https://www.youtube.com/watch?v=y_uGSqpE4So)

>[토비님의 영상을 보며 정리하신 BSIDESOFT 글](https://www.bsidesoft.com/?p=2903)

### 요약
`
일반적인 제네릭 형태에서는 한 컨테이너가 다룰 수 있는 타입 매개변수의 수가 고정되어 있다.
하지만, 컨테이너 자체가 아닌 키를 타입 매개변수로 바꾸면 이런 제약이 없는 타입 안전 이종
컨테이너를 만들 수 있다. 타입 안전 이종 컨테이너는 Class를 키로 쓰며, 이런 식으로 쓰이는 
Class 객체를 타입 토큰이라 한다. 또한, 직접 구현한 키 타입도 쓸 수 있다.
`

>컨테이너: 타입을 담을 수 있는 형태의 객체 (Set<E>, Map<K, v>, List<E> ..등)