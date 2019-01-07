package item02.domains.discussion02;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Discussion02BuildPerMethodItem {

    private Long id;
    private String name;

    public static Discussion02BuildPerMethodItemBuilder builder() {
        return new Discussion02BuildPerMethodItemBuilder();
    }

    public static class Discussion02BuildPerMethodItemBuilder {
        private Long id;
        private String name;

        Discussion02BuildPerMethodItemBuilder() {
        }


        /**
         * 각 파라미터 빌드메서드에서 검증.
         * */
        public Discussion02BuildPerMethodItemBuilder id(Long id) {

            //id 검증.
            if (id < 0) {
                throw new IllegalArgumentException();
            }

            this.id = id;
            return this;
        }


        /**
         * 각 파라미터 빌드메서드에서 검증.
         * */
        public Discussion02BuildPerMethodItemBuilder name(String name) {

            //name 검증.
            if (name == null || name.isEmpty() || name.length() < 2) {
                throw new IllegalArgumentException();
            }

            this.name = name;
            return this;
        }

        public Discussion02BuildPerMethodItem build() {
            return new Discussion02BuildPerMethodItem(id, name);
        }
    }
}
