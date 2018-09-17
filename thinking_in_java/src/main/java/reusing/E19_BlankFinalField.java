package reusing;

class WithBlankFinalField{
    private final Integer i;
    //Without this constructor, you'll get a compiler error:
    //"variable i might not have been initialized"

    public WithBlankFinalField(int i) {
        this.i = i;
    }

    public Integer geti() {
        //This won't compile. The error is:
        //"cannot assign a value to final variable i"
        //if(i == null)
            //i = new Integer(47);

        return i;
    }
}
public class E19_BlankFinalField {
    public static void main(String[] args) {
        WithBlankFinalField wbff =new WithBlankFinalField(10);
        System.out.println(wbff.geti());
    }
}
