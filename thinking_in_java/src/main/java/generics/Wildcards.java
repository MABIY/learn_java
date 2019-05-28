package generics;

/**
 * @author lh
 **/
public class Wildcards {
    // Raw argument
    static void rawArgs(Holder holder, Object arg) {
        // holder.set(arg); // Warning
        // Unchecked call to set(T) as a
        // member of the raw type Holder
        // holder.set(new Wildcards()); // Same warning

        // Can't do this: don't have any 'T'
        // T t = holder.get()

        // Ok, but type information has been lost:
        Object obj = holder.get();
    }

    // Similar to rawArgs(), but errors instead of warnings:
    static void unboundedArg(Holder<?> holder, Object arg) {
        // holder.set(arg); // Error
        // set(capture of ?) in HOlder<capture of ?>
        // holder.set(new Wildcards()); // Same error

        // Can't do this: don't have any 'T'
        // T t = holder.get()

        // Ok, but type information has been lost:
        Object obj = holder.get();
        //lhtd

    }
}
