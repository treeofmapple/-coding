package generic_methods;

import java.util.ArrayList;
import java.util.List;

public class GenericWildcards {

	static List<A> listA = new ArrayList<>();
	static List<B> listB = new ArrayList<>();
	static List<C> listC = new ArrayList<>();
	static List<?> listUnknown1 = new ArrayList<>();
	static List<? extends A> listUnknown2 = new ArrayList<>();
	static List<? super A> listUnknown3 = new ArrayList<>();

	public static void main(String[] args) {

		listA.add(new A());
		listA.add(new B());
		listB.add(new B());
		listC.add(new C());

		insertElements(listUnknown3);

	}

	public void processElements(List<A> elements) {
		for (A o : elements) {
			System.out.println(o);
			System.out.println(o.getValue());
		}
	}

	public void processElementsObject(List<?> elements) {
		for (Object o : elements) {
			System.out.println(o);
		}
	}

	public void processElementsExtends(List<? extends A> elements) {
		for (A o : elements) {
			System.out.println(o);
		}
	}

	public static void insertElements(List<? super A> list) {
		list.add(new A());
		list.add(new B());
		list.add(new C());
	}

}

class A {

	public char[] getValue() {
		return null;
	}

}

class B extends A {
}

class C extends A {
}