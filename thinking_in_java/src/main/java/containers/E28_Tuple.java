package containers;

import operators.Bool;

import java.util.Objects;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2019-01-20 14:00
 * Modify net/mindview/util/Tuple.java to make it
 * a general-purpose class by adding hashCode(),
 * equals(), and implementing Comparable for each
 * type of Tuple.
 **/
class Tuple{
	public static class T2<A, B> implements Comparable<T2<A, B>> {
		private final A first;
		private final B second;
		
		public T2(A first, B second) {
			this.first = first;
			this.second = second;
		}
		
		@Override
		public String toString() {
			return "(" + first + ", " + second + ")";
		}
		
		@Override
		public int hashCode() {
			int result = 17;
			if (first != null) {
				result = result * 37 + first.hashCode();
			}
			if (second != null) {
				result = result * 37 + second.hashCode();
			}
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof T2) {
				@SuppressWarnings("unchecked")
				T2<A, B> o = (T2<A, B>) obj;
				return (first == null ? o.first == null : first.equals(o.first) &&
						(second == null ? o.second == null : second.equals(o.second)));
			}
			return false;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public int compareTo(T2<A, B> o) {
			int res = ((Comparable<A>) first).compareTo(o.first);
			if(res!=0){
				return res;
			}
			return ((Comparable<B>) second).compareTo(o.second);
		}
		
		public A getFirst() {
			return first;
		}
		
		public B getSecond() {
			return second;
		}
	}
	
	public static class T3<A, B, C> implements Comparable<T3<A, B, C>> {
		private final T2<A, B> tuple;
		
		public T3(A a,B b ,C third) {
			tuple = new T2<A, B>(a, b);
			this.third = third;
		}
		
		@Override
		public String toString() {
			return "(" + tuple.getFirst() + ", " + tuple.getSecond() + ", " + third + ")";
		}
		
		@Override
		public int hashCode() {
			int result = tuple.hashCode();
			if (third != null) {
				result = result * 37 + third.hashCode();
			}
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof T3) {
				@SuppressWarnings("unchecked")
				T3<A, B, C> o = (T3<A, B, C>) obj;
				return (third == null ? o.third == null : third.equals(o.third) &&
						tuple.equals(o.tuple));
			}
			return false;
		}
		
		private final C third;
		@SuppressWarnings("unchecked")
		@Override
		public int compareTo(T3<A, B, C> o) {
			int res = tuple.compareTo(o.tuple);
			if (res != 0) {
				return res;
			}
			return ((Comparable<C>) third).compareTo(o.third);
		}
		
		public A getFirst() {
			return tuple.getFirst();
		}
		
		public B getSecond() {
			return tuple.getSecond();
		}
		
		public C getThird() {
			return third;
		}
	}
	
	public static class T4<A, B, C, D> implements Comparable<T4<A, B, C, D>> {
		private final T3<A, B, C> tuple;
		private final D fourth;
		
		public T4(A a,B b, C c, D fourth) {
			tuple = new T3<>(a, b, c);
			this.fourth = fourth;
		}
		
		@Override
		public String toString() {
			return "(" + tuple.getFirst() + ", " +
					tuple.getSecond() + ", " + tuple.getThird() + ", " +
					fourth + ")";
		}
		
		@Override
		public int hashCode() {
			int result = tuple.hashCode();
			if (fourth != null) {
				result = result * 37 + fourth.hashCode();
			}
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof T4) {
				@SuppressWarnings("unchecked")
				T4<A, B, C, D> o = (T4) obj;
				return (fourth == null ? o.fourth == null : fourth.equals(o.fourth) &&
						tuple.equals(o.tuple));
			}
				return false;
		}
		
		
		@Override
		public int compareTo(T4<A, B, C, D> o) {
			int res = tuple.compareTo(o.tuple);
			if (res != 0) {
				return res;
			}
			return ((Comparable<D>) fourth).compareTo(o.fourth);
		}
		
		public A getFirst() {
			return tuple.getFirst();
		}
		
		public B getSecond() {
			return tuple.getSecond();
		}
		
		public C getThird() {
			return tuple.third;
		}
		
		public D getFourth() {
			return fourth;
		}
	}
	
	public static class T5<A, B, C, D, E> implements Comparable<T5<A, B, C, D, E>> {
		private final T4<A,B,C,D> tuple;
		private final E fifth;
		
		public T5(A a,B b, C c,D d,E fifth) {
			tuple = new T4<>(a, b, c, d);
			this.fifth = fifth;
		}
		
		@Override
		public String toString() {
			return "(" + tuple.getFirst() + ", " + tuple.getSecond() + ", " + tuple.getThird() + ", " + tuple.getFourth() + ", " + fifth + ")";
		}
		
		@Override
		public int hashCode() {
			int result = tuple.hashCode();
			if (fifth != null) {
				result = result * 37 + fifth.hashCode();
			}
			return result;
		}
		
		@Override
		public boolean equals(Object o) {
			if (o instanceof T5) {
				T5<A, B, C, D, E> obj = (T5) o;
				return (fifth == null ? obj.fifth == null : fifth.equals(obj.fifth) &&
						tuple.equals(obj.tuple));
			}
			return false;
		}
		
		@Override
		public int compareTo(T5<A, B, C, D, E> o) {
			int res = tuple.compareTo(o.tuple);
			if (res != 0) {
				return res;
			}
			return ((Comparable<E>) fifth).compareTo(o.fifth);
		}
		public A getFirst() {
			return tuple.getFirst();
		}
		
		public B getSecond() {
			return tuple.getSecond();
		}
		
		public C getThird() {
			return tuple.getThird();
		}
		
		public D getFourth() {
			return tuple.getFourth();
		}
		
		public E getFifth() {
			return fifth;
		}
	}
	
	public static <A, B> T2<A, B> tuple(A a, B b) {
		return new T2<>(a, b);
	}
	
	public static <A, B, C> T3<A, B, C> tuple(A a, B b, C c) {
		return new T3<>(a, b, c);
	}
	
	public static <A, B, C, D> T4<A, B, C, D> tuple(A a, B b, C c, D d) {
		return new T4<>(a, b, c, d);
	}
	
	public static <A, B, C, D, E> T5<A, B, C, D, E> tuple(A a, B b, C c, D d, E e) {
		return new T5<>(a, b, c, d, e);
	}
}

public class E28_Tuple {
	public static void main(String[] args) {
		Tuple.T5<String, Integer, Boolean, Short, Long> t5_1 = Tuple.tuple("a", 1, false, (short) 2, 3L),
				t5_2 = Tuple.tuple("b", 2, true, (short) 3, 4L);
		print("t5_1 = " + t5_1);
		print("t5_2 = " + t5_2);
		print("t5_1.equals(t5_1) = " + t5_1.equals(t5_1));
		print("t5_1.equals(t5_2) = " + t5_1.equals(t5_2));
		print("t5_1.compareTo(t5_1) = "+ t5_1.compareTo(t5_1));
		print("t5_1.compareTo(t5_2) = "+ t5_1.compareTo(t5_2));
	}
}
