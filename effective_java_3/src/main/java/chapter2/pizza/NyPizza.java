package chapter2.pizza;

/**
 * @author lh
 */
public class NyPizza extends Pizza {
    public enum Size {SMALL,MEDIUM, LARGE,};

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder>{
        private final Size size;
        @Override
        NyPizza build() {
            return new NyPizza(self());
        }

        public Builder(Size size) {
            this.size = size;
        }

        @Override
        protected Builder self() {
            return this;
        }
    }


    NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}
