package ch05.item31;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@Getter
@AllArgsConstructor
public class CustomObject2<E> {

    private List<E> items;

    public void customAddAll(List<? extends E> items) {
        this.items.addAll(items);
    }

    public void copy(List<? super E> items){
        items.addAll(this.items);
    }

    public void customRemoveAll(List<? extends E> items){
        this.items.removeAll(items);
    }
}
