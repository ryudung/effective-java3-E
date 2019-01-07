package item02.domains.pizza;

import lombok.Getter;

@Getter
public class Calzone extends Pizza {

    private final boolean sauceInside;

    public static CalzoneBuilder CalzoneBuilder(){
        return new CalzoneBuilder();
    }

    public static class CalzoneBuilder extends Pizza.Builder<CalzoneBuilder> {
        private boolean sauceInside = false;

        public CalzoneBuilder sauceInside(){
            sauceInside = true;
            return this;
        }

        @Override
        public Pizza build() {
            return new Calzone(this);
        }

        @Override
        protected CalzoneBuilder self() {
            return this;
        }
    }

    private Calzone(CalzoneBuilder calzoneBuilder) {
        super(calzoneBuilder);
        this.sauceInside = calzoneBuilder.sauceInside;
    }
}
