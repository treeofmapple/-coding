package functional.interfaces;

import java.io.IOException;
import java.io.PrintWriter;

public class FunctionalExample {

}

interface MyFunctionalInterface {
	public void execute();
}

interface MyFunctionalInterface2 {
	public void execute();

	public default void print(String text) {
		System.out.println(text);
	}

	public static void print(String text, PrintWriter writer) throws IOException {
		writer.write(text);
	}
}

class AddThree implements Function<Long, Long> {

	@Override
	public Long apply(Long aLong) {
		return aLong + 3;
	}
}

interface Function<T, R> {
	R apply(T parameter);
}

interface Predicate<T> {
	boolean test(T t);
}

class Person {
	String name;

	Person(String name) {
		this.name = name;
	}
}