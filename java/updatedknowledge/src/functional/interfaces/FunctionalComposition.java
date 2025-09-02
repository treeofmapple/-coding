package functional.interfaces;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@SuppressWarnings({ "removal", "unused" })
public class FunctionalComposition {

	private void InterfaceTest() {
		MyFunctionalInterface lambda = () -> {
			System.out.println("Executing...");
		};
		lambda.execute();
	}

	private void FuncionTestImplementation() {
		Function<Long, Long> adder = new AddThree();
		Long result = adder.apply((long) 4L);
		System.out.println("result = " + result);
	}

	private void FuncionTestImplementation2() {
		Function<Long, Long> adder = new AddThree();
		Long resultLambda = adder.apply((long) 8L);
		System.out.println("resultLambda = " + resultLambda);
	}
	
	public void UnaryOperatorTest() {
		UnaryOperator<Person> unaryOperator = (person) -> {
			person.name = "New Name";
			return person;
		};
	}

	/*
	
	public void BinaryOperatorTest() {
		BinaryOperator<MyValue> binaryOperator =
		        (value1, value2) -> { value1.add(value2); return value1; };
	}
	
	*/

	public void SupplierTest() {
		Supplier<Integer> supplier = () -> new Integer((int) (Math.random() * 1000D));
	}
	
	public void ConsumerTest() {
		Consumer<Integer> consumer = (value) -> System.out.println(value);
	}
}

class CheckForNull implements Predicate<Object> {
	@Override
	public boolean test(Object o) {
		return o != null;
	}
}