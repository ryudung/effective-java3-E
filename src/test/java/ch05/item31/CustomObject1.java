package ch05.item31;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CustomObject1<E> {

    private List<E> items;


    public void customAddAll(List<E> items) {
        this.items.addAll(items);
    }
}
