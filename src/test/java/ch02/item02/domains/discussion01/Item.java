package ch02.item02.domains.discussion01;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Item {

    @NonNull
    private Long id; //required 필드.

    private String name;//optional 필드.

    public static ItemBuilder builder() {
        return new ItemBuilder();
    }

    public static class ItemBuilder {
        private Long id;
        private String name;

        ItemBuilder() {
        }

        public ItemBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ItemBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Item build() {
            return new Item(id, name);
        }

        public String toString() {
            return "Item.ItemBuilder(id=" + this.id + ", name=" + this.name + ")";
        }
    }
}
