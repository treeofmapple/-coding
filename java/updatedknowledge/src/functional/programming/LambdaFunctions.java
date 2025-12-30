package functional.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@SuppressWarnings("unused")
public class LambdaFunctions {

	private void sortingData() {
		List<String> names = Arrays.asList("Zoe", "Anna", "Peter");

		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return a.compareTo(b);
			}
		});

		System.out.println(names);
	}

	private void sortingDataWithLambda() {
		List<String> names = Arrays.asList("Zoe", "Anna", "Peter");
		Collections.sort(names, (String a, String b) -> a.compareTo(b));
		System.out.println(names);
	}

	private void functionalInterfaceReferences() {
		List<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Banana", "Apricot", "Cherry"));
		Predicate<String> startsWithA = s -> s.startsWith("A");
		fruits.removeIf(startsWithA);
		System.out.println(fruits);

	}

	private void functionalInterfaceLambda() {
		List<String> animals = Arrays.asList("cat", "dog", "mouse");
		animals.forEach(s -> System.out.println(s));
		animals.forEach(System.out::println);
	}

	// or using stream api

	// or using optional api

}
