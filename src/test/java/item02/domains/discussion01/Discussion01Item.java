package item02.domains.discussion01;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class Discussion01Item {

    @NonNull
    private Long id; //required..

    private String name;

//    private builder() 메소드
    private static Discussion01ItemBuilder builder(){
        return new Discussion01ItemBuilder();
    }

//    public builder() 메소드
    public static Discussion01ItemBuilder builder(Long id){
        return builder().id(id);
    }
}
