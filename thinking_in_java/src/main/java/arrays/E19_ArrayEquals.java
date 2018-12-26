package arrays;

import java.util.Arrays;

/**
 * @author: liuHua
 * @create: 2018-12-26 15:44
 **/
class DataHolder{
	protected int data;
	
	public DataHolder(int data) {
		this.data = data;
	}
}

class DataHolderWithEquals extends DataHolder{
	public DataHolderWithEquals(int data) {
		super(data);
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof DataHolderWithEquals &&
				data == ((DataHolder) obj).data;
	}
}
public class E19_ArrayEquals {
	public static void main(String[] args) {
		DataHolder[] a1 = new DataHolder[5];
		DataHolder[] a2 = new DataHolder[5];
		Arrays.fill(a1, new DataHolder(1));
		Arrays.fill(a2, new DataHolder(2));
		System.out.println(Arrays.equals(a1,a2));
		Arrays.fill(a1,new DataHolderWithEquals(1));
		Arrays.fill(a2,new DataHolderWithEquals(1));
		System.out.println(Arrays.equals(a1, a2));
	}
}
