package interfaces.filters;

/**
 * @author lh
 **/
public class HighPass extends Filter {
    double cusoff;

    public HighPass(double cusoff) {
        this.cusoff = cusoff;
    }

    public Waveform process(Waveform input) {
        return input;
    }
}
