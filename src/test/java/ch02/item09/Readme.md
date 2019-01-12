## try-finally 보다는 try-with-resources를 사용하라.

---

### 요약
`try-finally 보다는 try-with-resources를 사용하자,
 코드가 더 짧고, 분명해 진다.`

---

```java
public class File{
    static void copy(String src){
       try(BufferedReader br = new BufferedReader(new FileReader(path))){
           return br.readLine();
       } catch (IOException e){
           return defulat;
       }
    }   
}
```