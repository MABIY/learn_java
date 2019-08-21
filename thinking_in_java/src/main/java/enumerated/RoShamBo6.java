package enumerated;

/**
 * @author lh
 * Enums using "tables" instead of multiple dispatch.
 */
public enum  RoShamBo6 implements Competitor<RoShamBo6>{
    PAPER,SCISSORS,ROCK;
    private static Outcome[][] table = {
            {Outcome.DRAW, Outcome.LOSE, Outcome.WIN}, // PAPER
            {Outcome.WIN, Outcome.DRAW, Outcome.LOSE}, // SCISSORS
            {Outcome.LOSE, Outcome.WIN, Outcome.DRAW}, // ROCK
    };

    public Outcome compete(RoShamBo6 other) {
        return table[this.ordinal()][other.ordinal()];
    }
}
