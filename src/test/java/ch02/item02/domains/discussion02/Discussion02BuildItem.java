package ch02.item02.domains.discussion02;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Discussion02BuildItem {

    @NonNull
    private Long id;
    private String name;

    public static Discussion03BuilderItemBuilder builder() {
        return new Discussion03BuilderItemBuilder();
    }

    public static class Discussion03BuilderItemBuilder {
        private Long id;
        private String name;

        Discussion03BuilderItemBuilder() {
        }

        public Discussion03BuilderItemBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public Discussion03BuilderItemBuilder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * build()에서 검증.
         * */
        public Discussion02BuildItem build() {

            //id 검증.
            if (id < 0) {
                throw new IllegalArgumentException();
            }

            //name 검증.
            if (name == null || name.isEmpty() || name.length() < 2) {
                throw new IllegalArgumentException();
            }

            return new Discussion02BuildItem(id, name);
        }
    }
}
