package interfaces.interfaceProcessor;

/**
 * @author lh
 **/
public interface Processor {
    String name();

    Object process(Object input);
}
