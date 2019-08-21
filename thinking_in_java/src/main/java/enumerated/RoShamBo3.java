package enumerated;

import static enumerated.Outcome.*;

/**
 * @author lh
 * Using constatn-specific methods
 */
public enum  RoShamBo3 implements Competitor<RoShamBo3> {
    PAPER{
        @Override
        public Outcome compete(RoShamBo3 it) {
            switch (it) {
                default: // To placate the compiler
                case PAPER:
                    return Outcome.DRAW;
                case SCISSORS:
                    return LOSE;
                case ROCK:
                    return Outcome.WIN;
            }
        }
    },
    SCISSORS{
        @Override
        public Outcome compete(RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER:
                    return Outcome.WIN;
                case SCISSORS:
                    return Outcome.DRAW;
                case ROCK:
                    return LOSE;
            }
        }
    },
    ROCK{
        @Override
        public Outcome compete(RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER:
                    return LOSE;
                case SCISSORS:
                    return WIN;
                case ROCK:
                    return DRAW;
            }
        }
    }
    ;

    public abstract Outcome compete(RoShamBo3 it);

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo3.class, 20);
    }
}
