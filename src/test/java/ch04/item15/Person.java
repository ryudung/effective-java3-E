package ch04.item15;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Person {

    private static final Dog[] PRIVATE_DOG_ARRAY = new Dog[] {
            Dog.builder()
                    .id(0L)
                    .name("ryudung")
                    .build()
    };

    public static final Dog[] DOG_ARRAY = PRIVATE_DOG_ARRAY;

    public static final List<Dog> DOG_LIST = Arrays.asList(PRIVATE_DOG_ARRAY);

    public static final List<Dog> UNMODIFIABLE_LIST
            = Collections.unmodifiableList(Arrays.asList(PRIVATE_DOG_ARRAY));

    public static final Dog[] getDogs(){
        return PRIVATE_DOG_ARRAY.clone();
    }

    public static final Dog[] getCopyDogs(){
        return Arrays.stream(PRIVATE_DOG_ARRAY)
                .map(Dog::new)
                .toArray(Dog[]::new);
    }

    @Builder
    @Getter
    @AllArgsConstructor
    public static class Dog {
        private Long id;
        private String name;

        Dog(Dog dog){
            this.id = dog.id;
            this.name = dog.name;
        }

        public void changeName(String name){
            this.name = name;
        }
    }
}
