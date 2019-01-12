package ch02.item02.domains.discussion01;

import lombok.*;

//@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class ManyRequiredItem {

    @NonNull
    private Long id;
    @NonNull
    private String name1;
    @NonNull
    private String name2;
    @NonNull
    private String name3;
    @NonNull
    private String name4;
    @NonNull
    private String name5;
    @NonNull
    private String name6;
    @NonNull
    private String name7;

    private static ManyRequiredItemBuilder builder(){
        return new ManyRequiredItemBuilder();
    }

    public static ManyRequiredItemBuilder builder(Long id,
                                                  String name1,
                                                  String name2,
                                                  String name3,
                                                  String name4,
                                                  String name5,
                                                  String name6,
                                                  String name7) {
       return builder()
               .id(id)
               .name1(name1)
               .name2(name2)
               .name3(name3)
               .name4(name4)
               .name5(name5)
               .name6(name6)
               .name7(name7);
    }
}
