package interfaces.interfaceProcessor;

/**
 * @author lh
 **/
class StringMixerAdapter implements Processor {
    @Override
    public String name() {
        return "StringMixerAdapter";
    }

    public StringMixerAdapter(StringMixer stringMixer) {
        this.stringMixer = stringMixer;
    }

    StringMixer stringMixer;

    @Override
    public Object process(Object input) {
        return stringMixer.process((String) input);
    }
}

public class StringMixerProcessor {
    public static void main(String[] args) {
        String s = "1234567890";
        Apply.process(new StringMixerAdapter(new StringMixer()),s);
    }
}
