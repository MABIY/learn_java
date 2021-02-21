package chapter2.pizza;

/**
 * @author lh
 */
public class Calzone extends Pizza {
    private final boolean sauceInside;

    Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false; // Default

        @Override
        Calzone build() {
            return new Calzone(this);
        }

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
