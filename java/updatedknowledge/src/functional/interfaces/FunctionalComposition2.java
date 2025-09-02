package functional.interfaces;

import java.util.function.Function;
import java.util.function.Predicate;

@SuppressWarnings({ "unused" })
public class FunctionalComposition2 {

	private void FunctionalCompositeTest() {
		Predicate<String> startsWithA = (text) -> text.startsWith("A");
		Predicate<String> endsWithX = (text) -> text.endsWith("x");

		Predicate<String> startsWithAAndEndsWithX = (text) -> startsWithA.test(text) && endsWithX.test(text);

		String input = "A hardworking person must relax";
		boolean result = startsWithAAndEndsWithX.test(input);
		System.out.println(result);
	}

	private void andTestPredicate() {
		Predicate<String> startsWithA = (text) -> text.startsWith("A");
		Predicate<String> endsWithX = (text) -> text.endsWith("x");

		Predicate<String> composed = startsWithA.and(endsWithX);

		String input = "A hardworking person must relax";
		boolean result = composed.test(input);
		System.out.println(result);
	}

	private void orTestPredicate() {
		Predicate<String> startsWithA = (text) -> text.startsWith("A");
		Predicate<String> endsWithX = (text) -> text.endsWith("x");

		Predicate<String> composed = startsWithA.or(endsWithX);

		String input = "A hardworking person must relax sometimes";
		boolean result = composed.test(input);
		System.out.println(result);
	}

	private void composeTestPredicate() {
		Function<Integer, Integer> multiply = (value) -> value * 2;
		Function<Integer, Integer> add = (value) -> value + 3;

		Function<Integer, Integer> addThenMultiply = multiply.compose(add);

		Integer result1 = addThenMultiply.apply(3);
		System.out.println(result1);
	}

	private void andThemPredicate() {
		Function<Integer, Integer> multiply = (value) -> value * 2;
		Function<Integer, Integer> add = (value) -> value + 3;

		Function<Integer, Integer> multiplyThenAdd = multiply.andThen(add);

		Integer result2 = multiplyThenAdd.apply(3);
		System.out.println(result2);
	}
}
