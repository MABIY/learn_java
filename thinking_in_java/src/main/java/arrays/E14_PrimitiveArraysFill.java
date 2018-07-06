package arrays;

import lh.com.util.CountingGenerator;
import net.mindview.util.Generator;
import org.omg.CORBA.ARG_IN;
import org.omg.CORBA.INITIALIZE;

import java.lang.reflect.Array;
import java.util.Arrays;

class Fill{
    public static void primitive(Object array, Generator<?> gen) {
        int size = Array.getLength(array);
        Class<?> type = array.getClass().getComponentType();
        for (int i = 0; i < size; i++) {
            if (type == Boolean.TYPE) {
                Array.setBoolean(array, i, (Boolean) gen.next());
            } else if (type == Byte.TYPE) {
                Array.setByte(array,i,(Byte)gen.next());
            } else if (type == Short.TYPE) {
                Array.setShort(array, i, (Short) gen.next());
            } else if (type == Integer.TYPE) {
                Array.setInt(array, i, (Integer) gen.next());
            } else if (type == Character.TYPE) {
                Array.setChar(array, i, (Character) gen.next());
            } else if (type == Float.TYPE) {
                Array.setFloat(array, i, (Float) gen.next());
            } else if (type == Double.TYPE) {
                Array.setDouble(array, i, (Double) gen.next());
            } else if (type == Long.TYPE) {
                Array.setLong(array, i, (Long) gen.next());
            }
        }
    }
}
public class E14_PrimitiveArraysFill {
    public static void main(String[] args) {
        int size = 6;
        // First create all primitive arrays
        boolean[] a1 = new boolean[size];
        byte[] a2 = new byte[size];
        char[] a3 = new char[size];
        short[] a4 = new short[size];
        int[] a5 = new int[size];
        long[] a6 = new long[size];
        float[] a7 = new float[size];
        double[] a8 = new double[size];
        // Now fill them using a matching generator
    }
}
