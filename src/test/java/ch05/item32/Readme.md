## 제네릭과 가변인수를 함께 쓸 때는 신중하라.

---

`제네릭 varargs 배열 매개변수에 값을 저장하는 것은 안전하지 않다.`

```java
static void dangerous(List<String>... stringLists) {
    List<Integer> intList = List.of(42); //java 9
    Object[] objects = stringList;
    objects[0] = intList; // 힙 오염 발생
    String s = stringList[0].get(0); // ClassCastException
}
```

`제네릭 varargs가 안전하다면 @SafeVarargs를 붙인다. varargs 배열은 메서드가 호출될 때 생성되며
넘겨진 배열에 어떤 값을 저장하거나, 배열을 외부에 노출하지 않을 경우 안전하다.`

### varargs가 리턴되어 노출된 경우 문제
```java
@Test(expected = ClassCastException.class)
    public void test2() {
        String[] strArray = twoPick("하나", "둘", "셋");// ClassCastException 발생!
        System.out.println(strArray[0]);
    }

    private <T> T[] twoPick(T a, T b, T c){
        System.out.println("twoPick: " + a.getClass().getName());
        return toArray(a, b);
    }

    // T의 타입은 컴파일타임에 결정된다.
    // 컴파일 시점에 T의 타입을 알수 없기 때문에 Object가 선택된다.
    private <T> T[] toArray(T... args) {
        System.out.println("toArray: "+ args.getClass().getName());
        return args;
    }

```

```
출력 내용
twoPick: java.lang.String
toArray: [Ljava.lang.Object;
``` 

---
### 요약
`
가변인수와 제네릭은 궁합이 좋지 않다. 가변인수 기능은 배열을 노출하여 추상화가 완벽하지 못하고
배열과 제네릭의 타입 규칙이 서로 다르기 때문이다. varargs 매개변수는 타입 안전하지는 않지만, 허용된다.
메서드에 제네릭(혹은 매개변수화된) varargs 매개변수를 사용하고자 한다면, 먼저 그 메서드가 타입 안전한지
확인한 다음 @SafeVarargs 애너테이션을 달아 사용하는 데 불편함이 없게끔 하자.
`
