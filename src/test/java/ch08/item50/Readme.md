## 적시에 방어적 복사본을 만들라.
---
```java
public class Dog {
    private Date createDate;
    private Date endDate;
    
    public Dog(Date createDate, Date endDate){
        this.createDate = createDate;
        this.endDate = new Date(endDate.getTime());//방어적 복사
    }
    
    public Date getCreateDate(){
        return createDate;
    }
    
    public Date getEndDate(){
        return new Date(endDate.getTime());//방어적 복사!
    }
}

public void main(){
    
Dog dog = new Dog(new Date(), new Date());

dog.getCreateDate().setYear(2002); // dog의 createDate를 변경 가능하다.

dog.getEndDate().setYear(2002);    // 복사본을 변경했다!

Date createDate = new Date();
Date endDate = new Date();

Dog suna = new Dog(createDate, endDate);

createDate.setYear(2002); // suna의 createDate를 변경 가능하다.

endDate.setYear(2002);    // suna의 endDate를 변경 할 수 없다.

}

```


---
### 요약
`
클래스가 클라이언트로부터 혹은 클라이언트로 반환하는 구성요소가 가변이라면 그 요소는
반드시 방어적으로 복사해야 한다. 복사 비용이 너무 크거나 클라이언트가 그 요소를 잘못
수정할 일이 없음을 신뢰한다면 방어적 복사를 수행하는 대신 해당 구성요소를 수정했을 때의 책임이
 클라이언트에 있음을 문서에 명시하도록 하자.
`

### 추가적인 생각의견
 방어적 복사를 무조건적으로 지키면 좋겠지만, 일회성으로 사용되고, 공유되지 않는 객체일 경우가
대부분이다. 이럴 경우는 방어적 복사를 작성하는 것이 성능을 더 떨어 트릴수 있다고 생각한다.
무조건 적으로 사용하기 보다는 반드시 필요한 때에 사용하자.
  