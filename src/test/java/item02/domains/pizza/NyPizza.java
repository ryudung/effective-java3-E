package item02.domains.pizza;

import lombok.Getter;

import java.util.Objects;

@Getter
public class NyPizza extends Pizza {
    public enum Size{SMALL, MEDIUM, LARGE}
    private final Size size;

    private NyPizza(NYBuilder builder) {
        super(builder);
        size = builder.size;
    }

    public static NYBuilder NYBuilder(Size size){
        return new NYBuilder(size);
    }

    public static class NYBuilder extends Pizza.Builder<NYBuilder> {
        private Size size;

        public NYBuilder(Size size){
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public Pizza build() {
            return new NyPizza(this);
        }

        @Override
        protected NYBuilder self() {
            return this;
        }
    }
}
