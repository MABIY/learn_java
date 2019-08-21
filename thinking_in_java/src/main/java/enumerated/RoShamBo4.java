package enumerated;

/**
 * @author lh
 */
public enum  RoShamBo4 implements Competitor<RoShamBo4>{

    ROCK{
        @Override
        public Outcome compete(RoShamBo4 competitor) {
            return compete(SCISSOR, competitor);
        }
    },
    SCISSOR{
        @Override
        public Outcome compete(RoShamBo4 competitor) {
            return compete(PAPER, competitor);
        }
    },
    PAPER{
        @Override
        public Outcome compete(RoShamBo4 competitor) {
            return compete(ROCK, competitor);
        }
    } ;
    Outcome compete(RoShamBo4 loser, RoShamBo4 opponent) {
        return ((opponent == this)) ? Outcome.DRAW
                : ((opponent == loser) ? Outcome.WIN : Outcome.LOSE);
    }
}
