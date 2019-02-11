## ordinal 메서드 대신 인스턴스 필드를 사용하라.
---
### 요약
`
ordinal메서드를 사용하지 말자.
`
---
```
public final int ordinal()
Returns the ordinal of this enumeration constant (its position in its enum declaration, where the initial constant is assigned an ordinal of zero).

**Most programmers will have no use for this method. It is designed for use by sophisticated enum-based data structures, such as EnumSet and EnumMap.**
```