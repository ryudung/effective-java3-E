
## 리플렉션보다는 인터페이스를 사용하라.

---

#### 리플렉션을 이용하면 컴파일 당시에 존재하지 않던 클래스도 이용할 수 있다. 하지만, 아래와 같은 단점이 있다.

- 컴파일타임 타입 검사가 주는 이점을 하나도 누릴 수 없다.
- 리플렉션을 이용하면 코드가 지저분하고 장황해진다.
- 성능이 떨어진다.

리플렉션이 필요한지 확신할 수 없다면, 아마도 필요 없을 것이다.
```java
    /**
     * 리플렉션은 인스턴스 생성에만 쓰고, 이렇게 만든 인스턴스는 인터페이스나 상위 클래스로 참조해 사용하자.
     * */
    @Test
    public void test() {
        Class<?> cl = null;

        try {
            cl = Class.forName("java.util.HashMap");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Map<String, String> map = null;

        try {
            map = (Map<String, String>) cl.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        map.put("이름", "hashMap");

        System.out.println(map.get("이름"));
    }
```

---

### 요약

`
리플렉션은 복잡한 특수 시스템을 개발할 때 필요한 강력한 기능이지만,
단점도 많다. 컴파일 타임에는 알 수 없는 클래스를 사용하는 프로그램을 작성한다면
리플렉션을 사용해야 할 것이다. 단, 되도록 객체 생성에만 사용하고, 생성한 객체를 이용할
때는 적절한 인터페이스나 컴파일타임에 알 수 있는 상위 클래스로 형변환해 사용해야한다.
`