## 공개된 API 요소에는 항상 문서화 주석을 작성하라.
---
1. 공개된 모든 클래스, 인터페이스, 메서드, 필드 선언에 문서화 주석을 달아야한다.
2. 메서드용 문서화 주석에는 해당 메서드와 클라이언트 사이의 규약을 명료하게 기술해야한다.

#### 주석에 대한 샘플
```java
/**
* 두개의 수를 더해서 반환한다.
* 
* @param a 정수값         //마침표를 붙이지 않는다
* @param b 정수값         //마침표를 붙이지 않는다
* @return a와 b를 더한 값 //마침표를 붙이지 않는다
*/
public int sum(int a, int b) {
    return a + b;
} 
```

```java
/**
* 활성화 유/무를 나타내는 상태.
*/
public enum Status {
    
    /** 활성화된 상태. */
    ACTIVE,
    
    /** 비 활성화된 상태. */
    UNACTIVE
    ;
} 
```

```java
/**
* 이 어노테이션이 달린 클래스는 restDoc과 webMvc테스트를 위한,
* 클래스임을 나타낸다.
* */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@AutoConfigureRestDocs//restDoc
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})//boot, junit5, restDoc
public @interface WebMvcRestDocTest {

} 
```

 - @throws exception에 대한 설명을 나타내는 주석
 - [그 밖에 javaDoc 어노테이션](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html)

---
### 요약
`
문서화 주석은 여러분 API를 문서화하는 가장 훌륭하고 효과적인 방법이다.
`