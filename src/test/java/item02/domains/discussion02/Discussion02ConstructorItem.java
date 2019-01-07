package item02.domains.discussion02;


import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class Discussion02ConstructorItem {

    @NonNull
    private Long id;
    private String name;

    public Discussion02ConstructorItem(Long id, String name) {

        //id 검증.
        if (id < 0) {
            throw new IllegalArgumentException();
        }

        //name 검증.
        if (name == null || name.isEmpty() || name.length() < 2) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.name = name;
    }
}
