package innerclasses.ex6Base;

import innerclasses.ex6Interface.Ex6Interface;

/**
 * @author lh
 * and in a second package:
 **/
public class Ex6Base {
    protected class Ex6BaseInner implements Ex6Interface {
        // need public constructor to create one in Ex6Base child:
        public Ex6BaseInner() {
        }

        @Override
        public String say() {
            return "Hi";
        }
    }
}
